/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.health;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmware.eam.sample.solution.health.VimHealthProvider.VimHealth;

/**
 * <code>HealthStatusServlet</code> generates the XML document that describe the
 * health of a solution. Queries the set of HealthProviders for status and
 * returns an aggregated status.  If no providers is installed, it always returns
 * green.
 *
 *  The XML schema for health documents is this:
 *
 * <pre>
 * {@code
 * <?xml version="1.0" encoding="utf-8"?>
 * <xs:schema targetNamespace="http://www.vmware.com/vi/healthservice"
 *            elementFormDefault="qualified"
 *            xmlns="http://www.vmware.com/vi/healthservice"
 *            xmlns:xs="http://www.w3.org/2001/XMLSchema"
 *            version="1.0">
 *
 *   <xs:complexType name="healthType">
 *     <xs:sequence>
 *       <xs:element name="name" type="xs:string" minOccurs="0" maxOccurs="1"/>
 *       <xs:element name="status" minOccurs="1" maxOccurs="1">
 *         <xs:simpleType>
 *           <xs:restriction base="xs:string">
 *             <xs:enumeration value="green" />
 *             <xs:enumeration value="yellow" />
 *             <xs:enumeration value="red" />
 *           </xs:restriction>
 *         </xs:simpleType>
 *       </xs:element>
 *       <xs:element name="message" minOccurs="0" maxOccurs="unbounded">
 *         <xs:complexType mixed="true">
 *           <xs:sequence>
 *             <xs:element name="param" type="xs:string" minOccurs="0" maxOccurs="unbounded"/>
 *           </xs:sequence>
 *           <xs:attribute name="id" type="xs:string" use="required"/>
 *           <xs:attribute name="level" use="required">
 *             <xs:simpleType>
 *               <xs:restriction base="xs:string">
 *                 <xs:enumeration value="info" />
 *                 <xs:enumeration value="warning" />
 *                 <xs:enumeration value="alert" />
 *               </xs:restriction>
 *             </xs:simpleType>
 *           </xs:attribute>
 *           <xs:attribute name="time" type="xs:dateTime" use="required"/>
 *         </xs:complexType>
 *       </xs:element>
 *       <xs:element name="health" type="healthType" minOccurs="0" maxOccurs="unbounded"/>
 *     </xs:sequence>
 *     <xs:attribute name="id" type="xs:string" use="required"/>
 *   </xs:complexType>
 *
 *   <xs:element name="vimhealth">
 *     <xs:complexType>
 *       <xs:sequence>
 *         <xs:element name="health" type="healthType" minOccurs="0" maxOccurs="unbounded"/>
 *       </xs:sequence>
 *       <xs:attribute name="schemaVersion" type="xs:decimal" use="required"/>
 *     </xs:complexType>
 *   </xs:element>
 * </xs:schema>
 * }
 * </pre>
 */
public class HealthStatusServlet extends HttpServlet {

   private final String STATUS_RED    = "red";
   private final String STATUS_YELLOW = "yellow";
   private final String STATUS_GREEN  = "green";


   private final SimpleDateFormat _dateFormatter;
   private final SimpleDateFormat _timeFormatter;

   private String _id;   // Extension id
   private String _name; // Extension name
   private ArrayList<VimHealthProvider> _healthProviders;

   /**
    * Creates a HealthStatusServlet
    */
   public HealthStatusServlet() {
      _dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
      _timeFormatter = new SimpleDateFormat("HH:mm:ss");
      _healthProviders = new ArrayList<VimHealthProvider>();
   }

   /**
    * @return the id
    */
   public String getId() {
      return _id;
   }

   /**
    * @param id the id to set
    */
   public void setId(String id) {
      _id = id;
   }

   /**
    * @return the name
    */
   public String getName() {
      return _name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      _name = name;
   }

   /**
    * @return the healthProviders
    */
   public ArrayList<VimHealthProvider> getHealthProviders() {
      return _healthProviders;
   }

   /**
    * @param healthProviders the healthProviders to set
    */
   public void setHealthProviders(ArrayList<VimHealthProvider> healthProviders) {
      _healthProviders = healthProviders;
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

      StringBuilder sb = new StringBuilder(1024);
      sb.append(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<vimhealth\n" +
            "   xmlns=\"http://www.vmware.com/vi/healthservice\"\n" +
            "   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "   schemaVersion=\"1.0\">\n");

      VimHealth health = getOverallHealth();
      printHealthStart(sb, _id, _name, convertLevelToStatus(health.getLevel()));
      printMessage(sb, _id, health.getLevel(), health.getMessage());
      printHealthStop(sb);

      sb.append("</vimhealth>\n");

      // Write output.
      PrintWriter writer = resp.getWriter();
      writer.write(sb.toString());
      resp.setStatus(200);
      resp.setContentLength(sb.length());
      resp.setContentType("text/xml");
   }

   /**
    * @return the overall health of the solution. This is defined as
    * the item with the worst level.
    */
   public VimHealth getOverallHealth() {
      // We always return 'running'. If we are not running, our status will show
      // up as not responding which is what we want.
      VimHealth health = new VimHealth();

      for(VimHealthProvider p: _healthProviders) {
         if (health.getLevel().equals(VimHealthProvider.LEVEL_ALERT)) {
            break;
         }
         VimHealth vh = p.getVimHealth();
         if (vh == null)  {
            continue;
         }

         if (vh.getLevel().equals(VimHealthProvider.LEVEL_INFO)) {
            continue;
         }
         // New level is either ALERT or WARNING. Current level must
         // be either WARNING or INFO.
         health = vh;
      }
      return health;
   }

   private String convertLevelToStatus(String level) {
      if (level.equals(VimHealthProvider.LEVEL_ALERT)) {
         return STATUS_RED;
      } else if (level.equals(VimHealthProvider.LEVEL_WARNING)) {
         return STATUS_YELLOW;
      }
      return STATUS_GREEN;
   }

   /**
    * Prints the start of a health element.
    *
    * @param sb where to append the result
    * @param id id for solution
    * @param name display name for solution
    * @param status current status (red, yellow, green)
    */
   private void printHealthStart(StringBuilder sb, String id, String name,
         String status) {
      sb.append("<health id=\"").append(id).append("\">").append("<name>")
            .append(name).append("</name>").append("<status>").append(status)
            .append("</status>\n");
   }

   /**
    * Prints the end of a health element.
    *
    * @param sb where to append the result
    */
   private void printHealthStop(StringBuilder sb) {
      sb.append("</health>\n");
   }

   /**
    * Prints a message element.
    *
    * @param sb  where to append result
    * @param id  id for message
    * @param level message level (alert, warning, info)
    * @param message display message
    *
    */
   private void printMessage(StringBuilder sb, String id, String level, String message) {
      Date now = new Date();
      sb.append("<message id=\"").append(id).append("\" ").append("level=\"")
            .append(level).append("\" ").append("time=\"").append(
                  _dateFormatter.format(now)).append("T").append(
                  _timeFormatter.format(now)).append("\">").append(message)
            .append("</message>\n");
   }
}
