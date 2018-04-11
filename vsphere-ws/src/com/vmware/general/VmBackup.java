package com.vmware.general;

import javax.net.ssl.*;
import javax.swing.*;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vmware.vim25.*;
import com.vmware.vim25.VirtualMachineConfigInfo;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by Tanwei on 2016/11/25.
 */
public class VmBackup {

    private static class TrustAllTrustManager implements TrustManager, X509TrustManager {

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }
    }

    private static final ManagedObjectReference SVC_INST_REF =
            new ManagedObjectReference();
    private static ManagedObjectReference propCollectorRef;
    private static ManagedObjectReference rootRef;
    private static final String SVC_INST_NAME = "ServiceInstance";
    private static VimService vimService;
    private static VimPortType vimPort;
    private static ServiceContent serviceContent;
    private static String localPath = "E:\\vmbackup\\backup-chain8\\";
    private static Map<String, String> downloadedDir =
            new HashMap<String, String>();
    private static Map headers = new HashMap();
    private static String cookieValue = "";
    private static String url;
    private static String userName;
    private static String password;
    private static String virtualMachineName;
    private static String snapshotname;
    private static String description;
    private static String removechild = "0";
    private static boolean help = false;
    private static boolean isConnected = false;
    private static ArrayList<GuestDiskInfo> diskList;

    private static void trustAllHttpsCertificates() {
        try {
            //Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[1];
            TrustManager tm = new TrustAllTrustManager();
            trustAllCerts[0] = tm;
            SSLContext sc = SSLContext.getInstance("SSL");
            SSLSessionContext sslsc = sc.getServerSessionContext();
            sslsc.setSessionTimeout(0);
            sc.init(null,trustAllCerts,null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getConnectionParameters(String[] args)
        throws IllegalArgumentException {
        int ai = 0;
        String param = "";
        String val = "";
        while (ai < args.length) {
            param = args[ai].trim();
            if (ai + 1 < args.length) {
                val = args[ai + 1].trim();
            }
            if (param.equalsIgnoreCase("--help")) {
                help = true;
                break;
            } else if (param.equalsIgnoreCase("--url") && !val.startsWith("--")
                    && !val.isEmpty()) {
                url = val;
            } else if (param.equalsIgnoreCase("--username") && !val.startsWith("--")
                    && !val.isEmpty()) {
                userName = val;
            } else if (param.equalsIgnoreCase("--password") && !val.startsWith("--")
                    && !val.isEmpty()) {
                password = val;
            }
            val = "";
            ai += 2;
        }
        if (url == null || userName == null || password == null) {
            throw new IllegalArgumentException(
                    "Expected --url, --username, --password arguments.");
        }
    }

    /**
     * Establishes session with the vCenter server.
     *
     * @throws RuntimeFaultFaultMsg
     * @throws InvalidLocaleFaultMsg
     * @throws InvalidLoginFaultMsg
     */
    private static void connect() throws RuntimeFaultFaultMsg,
            InvalidLocaleFaultMsg, InvalidLoginFaultMsg {

        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        SVC_INST_REF.setType(SVC_INST_NAME);
        SVC_INST_REF.setValue(SVC_INST_NAME);

        vimService = new VimService();
        vimPort = vimService.getVimPort();
        Map<String, Object> ctxt = ((BindingProvider)vimPort).getRequestContext();

        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,url);
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);

        serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
        headers =
                (Map)((BindingProvider) vimPort).getResponseContext().get(MessageContext.HTTP_RESPONSE_HEADERS);
        vimPort.login(serviceContent.getSessionManager(),userName,password,null);
        isConnected = true;
        propCollectorRef = serviceContent.getPropertyCollector();
        rootRef = serviceContent.getRootFolder();
    }

    /**
     * Disconnects the user session.
     *
     * @throws RuntimeFaultFaultMsg
     */
    private static void disconnect() throws RuntimeFaultFaultMsg {
        if (isConnected) {
            vimPort.logout(serviceContent.getSessionManager());
        }
        isConnected = false;
    }

    private static void printSoapFaultException(SOAPFaultException sfe) {
        System.out.println("SOAP Fault -");
        if (sfe.getFault().hasDetail()) {
            System.out.println(sfe.getFault().getDetail().getFirstChild()
            .getLocalName());
        }
        if (sfe.getFault().getFaultString() != null) {
            System.out.println("\n Message: "+sfe.getFault().getFaultString());
        }
    }

    private static void printUsage() {
        System.out.println("This sample simply connects "
                + "to an ESX server or to vCenter server");
        System.out.println("\nParameters:");
        System.out.println("url         [required] : url of the web service");
        System.out
                .println("username    [required] : username for the authentication");
        System.out
                .println("password    [required] : password for the authentication");
        System.out.println("\nCommand:");
        System.out
                .println("run.bat com.vmware.general.Connect --url [webserviceurl] "
                        + "--username [username] --password [password]");
    }

    public static void main(String[] args) {
        try {
            getConnectionParameters(args);
            if (help) {
                printUsage();
                return;
            }
            connect();
            getVmNames();
/*            System.out.println("Please input the vmName: ");
            Scanner sc = new Scanner(System.in);
            virtualMachineName = sc.next();
            System.out.println("Please input the snapshotname: ");
            snapshotname = sc.next();
            System.out.println("Please input the description: ");
            description = sc.next();*/
            virtualMachineName = "ubuntu";
            snapshotname = "backup";
            description = "backup-test";
//            doHotFullBackup();
            doIncrementBackup();
/*            if (vmRef != null) {
                boolean res = false;
                res = createSnapshot(vmRef);

                if (res) {
                    System.out.println("create snapshot completed successfully");
                }
            } else {
                System.out.println("Virtual Machine " + virtualMachineName + " not found.");
            }*/
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printUsage();
        } catch (SOAPFaultException e) {
            System.out.println(e.getMessage());
            printUsage();
        } catch (InvalidPropertyFaultMsg e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Connect Failed");
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SOAPFaultException sfe) {
                printSoapFaultException(sfe);
            } catch (Exception e) {
                System.out.println("Failed to disconnect - " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void getVmNames() throws Exception {
        TraversalSpec folderTraversalSpec = getVmTraversalSpec();
        PropertySpec props = new PropertySpec();
        props.setAll(Boolean.FALSE);
        props.getPathSet().add("name");
        props.setType("VirtualMachine");
        List<PropertySpec> propspecary = new ArrayList<PropertySpec>();
        propspecary.add(props);

        PropertyFilterSpec spec = new PropertyFilterSpec();
        spec.getPropSet().addAll(propspecary);

        spec.getObjectSet().add(new ObjectSpec());
        spec.getObjectSet().get(0).setObj(rootRef);
        spec.getObjectSet().get(0).setSkip(Boolean.FALSE);
        spec.getObjectSet().get(0).getSelectSet().add(folderTraversalSpec);

        List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
        listpfs.add(spec);
        List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);

        if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
                String vmName = null;
                List<DynamicProperty> dps = oc.getPropSet();
                if (dps != null) {
                    for (DynamicProperty dp : dps) {
                        vmName = (String)dp.getVal();
                        if (vmName != null) {
                            System.out.println(vmName);
                        }
                    }
                }
            }
        }
    }

    private static TraversalSpec getVmTraversalSpec() {
        TraversalSpec resourcePoolTraversalSpec = new TraversalSpec();
        resourcePoolTraversalSpec.setName("resourcePoolTraversalSpec");
        resourcePoolTraversalSpec.setType("ResourcePool");
        resourcePoolTraversalSpec.setPath("resourcePool");
        resourcePoolTraversalSpec.setSkip(Boolean.FALSE);
        SelectionSpec rpts = new SelectionSpec();
        rpts.setName("resourcePoolTraversalSpec");
        resourcePoolTraversalSpec.getSelectSet().add(rpts);

        TraversalSpec computeResourceRpTraversalSpec = new TraversalSpec();
        computeResourceRpTraversalSpec.setName("computeResourceRpTraversalSpec");
        computeResourceRpTraversalSpec.setType("ComputeResource");
        computeResourceRpTraversalSpec.setPath("resourcePool");
        computeResourceRpTraversalSpec.setSkip(Boolean.FALSE);
        SelectionSpec rptss = new SelectionSpec();
        rptss.setName("resourcePoolTraversalSpec");
        computeResourceRpTraversalSpec.getSelectSet().add(rptss);

        TraversalSpec computeResourceHostTraversalSpec = new TraversalSpec();
        computeResourceHostTraversalSpec
                .setName("computeResourceHostTraversalSpec");
        computeResourceHostTraversalSpec.setType("ComputeResource");
        computeResourceHostTraversalSpec.setPath("host");
        computeResourceHostTraversalSpec.setSkip(Boolean.FALSE);

        TraversalSpec datacenterHostTraversalSpec = new TraversalSpec();
        datacenterHostTraversalSpec.setName("datacenterHostTraversalSpec");
        datacenterHostTraversalSpec.setType("Datacenter");
        datacenterHostTraversalSpec.setPath("hostFolder");
        datacenterHostTraversalSpec.setSkip(Boolean.FALSE);
        SelectionSpec ftspec = new SelectionSpec();
        ftspec.setName("folderTraversalSpec");
        datacenterHostTraversalSpec.getSelectSet().add(ftspec);

        TraversalSpec datacenterVmTraversalSpec = new TraversalSpec();
        datacenterVmTraversalSpec.setName("datacenterVmTraversalSpec");
        datacenterVmTraversalSpec.setType("Datacenter");
        datacenterVmTraversalSpec.setPath("vmFolder");
        datacenterVmTraversalSpec.setSkip(Boolean.FALSE);
        SelectionSpec ftspecs = new SelectionSpec();
        ftspecs.setName("folderTraversalSpec");
        datacenterVmTraversalSpec.getSelectSet().add(ftspecs);

        TraversalSpec folderTraversalSpec = new TraversalSpec();
        folderTraversalSpec.setName("folderTraversalSpec");
        folderTraversalSpec.setType("Folder");
        folderTraversalSpec.setPath("childEntity");
        folderTraversalSpec.setSkip(Boolean.FALSE);
        SelectionSpec ftrspec = new SelectionSpec();
        ftrspec.setName("folderTraversalSpec");
        List<SelectionSpec> ssarray = new ArrayList<SelectionSpec>();
        ssarray.add(ftrspec);
        ssarray.add(datacenterHostTraversalSpec);
        ssarray.add(datacenterVmTraversalSpec);
        ssarray.add(computeResourceRpTraversalSpec);
        ssarray.add(computeResourceHostTraversalSpec);
        ssarray.add(resourcePoolTraversalSpec);

        folderTraversalSpec.getSelectSet().addAll(ssarray);
        return folderTraversalSpec;
    }

    /**
     * Uses the new RetrievePropertiesEx method to emulate the now deprecated
     * RetrieveProperties method
     *
     * @param listpfs
     * @return list of object content
     * @throws Exception
     */
    private static List<ObjectContent> retrievePropertiesAllObjects(
            List<PropertyFilterSpec> listpfs) throws Exception {

        RetrieveOptions propObjectRetrieveOpts = new RetrieveOptions();

        List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();

        try {
            RetrieveResult rslts =
                    vimPort.retrievePropertiesEx(propCollectorRef, listpfs,
                            propObjectRetrieveOpts);
            if (rslts != null && rslts.getObjects() != null
                    && !rslts.getObjects().isEmpty()) {
                listobjcontent.addAll(rslts.getObjects());
            }
            String token = null;
            if (rslts != null && rslts.getToken() != null) {
                token = rslts.getToken();
            }
            while (token != null && !token.isEmpty()) {
                rslts =
                        vimPort.continueRetrievePropertiesEx(propCollectorRef, token);
                token = null;
                if (rslts != null) {
                    token = rslts.getToken();
                    if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                        listobjcontent.addAll(rslts.getObjects());
                    }
                }
            }
        } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
        } catch (Exception e) {
            System.out.println(" : Failed Getting Contents");
            e.printStackTrace();
        }
        return listobjcontent;
    }

    /**
     * Returns all the MOREFs of the specified type that are present under the
     * container
     *
     * @param folder
     *           {@link ManagedObjectReference} of the container to begin the
     *           search from
     * @param morefType
     *           Type of the managed entity that needs to be searched
     *
     * @return Map of name and MOREF of the managed objects present. If none
     *         exist then empty Map is returned
     *
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static Map<String, ManagedObjectReference> getMOREFsInContainerByType(
            ManagedObjectReference folder, String morefType)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        String PROP_ME_NAME = "name";
        ManagedObjectReference viewManager = serviceContent.getViewManager();
        ManagedObjectReference containerView =
                vimPort.createContainerView(viewManager, folder,
                        Arrays.asList(morefType), true);

        Map<String, ManagedObjectReference> tgtMoref =
                new HashMap<String, ManagedObjectReference>();

        //create Property Spec
        PropertySpec propertySpec = new PropertySpec();
        propertySpec.setAll(false);
        propertySpec.setType(morefType);
        propertySpec.getPathSet().add(PROP_ME_NAME);

        TraversalSpec ts = new TraversalSpec();
        ts.setName("view");
        ts.setPath("view");
        ts.setSkip(false);
        ts.setType("ContainerView");

        //Now create Object Spec
        ObjectSpec objectSpec = new ObjectSpec();
        objectSpec.setObj(containerView);
        objectSpec.setSkip(true);
        objectSpec.getSelectSet().add(ts);

        //Create PropertyFilerSpec using the PropertySpec and ObjectPec
        //created above
        PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
        propertyFilterSpec.getPropSet().add(propertySpec);
        propertyFilterSpec.getObjectSet().add(objectSpec);

        List<PropertyFilterSpec> propertyFilterSpecs =
                new ArrayList<PropertyFilterSpec>();
        propertyFilterSpecs.add(propertyFilterSpec);

        RetrieveResult rslts =
                vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                        propertyFilterSpecs, new RetrieveOptions());
        List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
        if (rslts != null && rslts.getObjects() != null
                && !rslts.getObjects().isEmpty()) {
            listobjcontent.addAll(rslts.getObjects());
        }
        String token = null;
        if (rslts != null && rslts.getToken() != null) {
            token = rslts.getToken();
        }
        while (token != null && !token.isEmpty()) {
            rslts = vimPort.continueRetrievePropertiesEx(
                    serviceContent.getPropertyCollector(), token);
            token = null;
            if (rslts != null) {
                token = rslts.getToken();
                if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                    listobjcontent.addAll(rslts.getObjects());
                }
            }
        }
        for (ObjectContent oc : listobjcontent) {
            ManagedObjectReference mr = oc.getObj();
            String entityNm = null;
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
                for (DynamicProperty dp : dps) {
                    entityNm = (String) dp.getVal();
                }
            }
            tgtMoref.put(entityNm, mr);
        }
        return tgtMoref;
    }

    private static boolean createSnapshot(ManagedObjectReference vmMor)
        throws FileFaultFaultMsg, InvalidNameFaultMsg, InvalidStateFaultMsg,
        RuntimeFaultFaultMsg, SnapshotFaultFaultMsg, TaskInProgressFaultMsg,
        VmConfigFaultFaultMsg, InvalidPropertyFaultMsg,
        InvalidCollectorVersionFaultMsg {
        ManagedObjectReference taskMor =
                vimPort.createSnapshotTask(vmMor, snapshotname, description, true,
                        true);
        if (getTaskResultAfterDone(taskMor)) {
            System.out.printf(" Creating Snapshot - [ %s ] Succssful %n",
                    snapshotname);
            return true;
        } else {
            System.out.printf(" Creating Snapshot - [ %s ] Failure %n",
                    snapshotname);
            return false;
        }
    }

    private static boolean removeSnapshot(ManagedObjectReference vmMor)
        throws Exception {
        int rem = Integer.parseInt(removechild);
        boolean flag = true;
        if (rem == 0) {
            flag = false;
        }
        ManagedObjectReference snapmor =
                getSnapshotReference(vmMor, virtualMachineName, snapshotname);
        if (snapmor != null) {
            ManagedObjectReference  taskMor =
                    vimPort.removeSnapshotTask(snapmor, flag, true);
            if (taskMor != null) {
                String[] opts =
                        new String[] { "info.state", "info.error", "info.progress" };
                String[] opt = new String[] { "state" };
                Object[] results =
                        waitForValues(taskMor, opts, opt,
                                new Object[][] { new Object[] { TaskInfoState.SUCCESS,
                                TaskInfoState.ERROR } });

                //Wait till the task completes.
                if (results[0].equals(TaskInfoState.SUCCESS)) {
                    System.out.printf(" Removing Snapshot - [ %s ] Successful %n",
                            snapshotname);
                    return true;
                } else {
                    System.out.printf(" Removing Snapshot -[ %s ] Failure %n",
                            snapshotname);
                    return false;
                }
            }
        } else {
            System.out.println("Snapshot not found");
        }
        return false;
    }

    private static boolean getTaskResultAfterDone(ManagedObjectReference task)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
        InvalidCollectorVersionFaultMsg {

        boolean retVal = false;

        //info has a property - state for state of the task
        Object[] result =
                waitForValues(task, new String[] { "info.state", "info.error" },
                        new String[] { "state" }, new Object[][] {new Object[] {
                        TaskInfoState.SUCCESS, TaskInfoState.ERROR}});

        if (result[0].equals(TaskInfoState.SUCCESS)) {
            retVal = true;
        }
        if (result[1] instanceof LocalizedMethodFault) {
            throw new RuntimeException(
                    ((LocalizedMethodFault) result[1]).getLocalizedMessage()
            );
        }
        return retVal;
    }

    private static Object[] waitForValues(ManagedObjectReference objmor,
                                          String[] filterPros, String[] endWaitProps, Object[][] expectedVals)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
        InvalidCollectorVersionFaultMsg {
        //version string is initially null
        String version  = "";
        Object[] endVals = new Object[endWaitProps.length];
        Object[] filterVals = new Object[filterPros.length];

        PropertyFilterSpec spec = new PropertyFilterSpec();
        ObjectSpec oSpec = new ObjectSpec();
        oSpec.setObj(objmor);
        oSpec.setSkip(false);
        spec.getObjectSet().add(oSpec);

        PropertySpec pSpec = new PropertySpec();
        pSpec.getPathSet().addAll(Arrays.asList(filterPros));
        pSpec.setType(objmor.getType());
        spec.getPropSet().add(pSpec);

        ManagedObjectReference filterSpecRef =
                vimPort.createFilter(serviceContent.getPropertyCollector(), spec,
                        true);

        boolean reached = false;

        UpdateSet updateSet = null;
        List<PropertyFilterUpdate> filtupary = null;
        List<ObjectUpdate> objupary = null;
        List<PropertyChange> propchgary = null;
        while (!reached) {
            updateSet =
                    vimPort.waitForUpdates(serviceContent.getPropertyCollector(),
                            version);
            if (updateSet == null || updateSet.getFilterSet() == null) {
                continue;
            }
            version = updateSet.getVersion();

            //Make this code more general purpose when PropCol changes later.
            filtupary = updateSet.getFilterSet();

            for (PropertyFilterUpdate filtup : filtupary) {
                objupary = filtup.getObjectSet();
                for (ObjectUpdate objup : objupary) {
                    if (objup.getKind() == ObjectUpdateKind.MODIFY
                            || objup.getKind() == ObjectUpdateKind.ENTER
                            || objup.getKind() == ObjectUpdateKind.LEAVE) {
                        propchgary = objup.getChangeSet();
                        for (PropertyChange propchg : propchgary) {
                            updateValues(endWaitProps, endVals, propchg);
                            updateValues(filterPros, filterVals, propchg);
                        }
                    }
                }
            }

            Object expctdval = null;
            //check if the expected values have been reached and exit the loop
            //if done
            //Also exit the WaitForUpdate loop if this is the case
            for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
                for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
                    expctdval = expectedVals[chgi][vali];

                    reached = expctdval.equals(endVals[chgi]) || reached;
                }
            }
        }

        //Destroy the filter when we are done
        vimPort.destroyPropertyFilter(filterSpecRef);
        return filterVals;
    }

    private static void updateValues(String[] props, Object[] vals, PropertyChange propchg) {
        for (int findi = 0; findi < props.length; findi++) {
            if (propchg.getName().lastIndexOf(props[findi]) >= 0) {
                if (propchg.getOp() == PropertyChangeOp.REMOVE) {
                    vals[findi] = "";
                } else {
                    vals[findi] = propchg.getVal();
                }
            }
        }
    }

    private static ManagedObjectReference getSnapshotReference(
          ManagedObjectReference vmmor, String vmName, String snapName)
        throws Exception {
        VirtualMachineSnapshotInfo snapInfo =
                (VirtualMachineSnapshotInfo) getEntityProps(vmmor,
                        new String[] { "snapshot" }).get("snapshot");
        ManagedObjectReference snapmor = null;
        if (snapInfo != null) {
            List<VirtualMachineSnapshotTree> listvmst =
                    snapInfo.getRootSnapshotList();
            snapmor = traverseSnapshotInTree(listvmst, snapName, false);
            if (snapmor == null) {
                System.out.println("No Snapshot named : " + snapName
                       + " found for VirtualMachine : " + vmName);
            }
        } else {
            System.out.
                    println("No Snapshots found for VirtualMachine : " + vmName);
        }
        return snapmor;
    }

    /**
     * Method to retrieve properties of a {@link ManagedObjectReference}
     *
     * @param entityMor
     *           {@link ManagedObjectReference} of the entity
     * @param props
     *           Array of properties to be looked up
     * @return Map of the property name and its corresponding value
     *
     * @throws InvalidPropertyFaultMsg
     *            If a property does not exist
     * @throws RuntimeFaultFaultMsg
     */
    private static Map<String, Object> getEntityProps(
            ManagedObjectReference entityMor, String[] props)
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {

        HashMap<String, Object> retVal = new HashMap<String, Object>();

        // Create Property Spec
        PropertySpec propertySpec = new PropertySpec();
        propertySpec.setAll(Boolean.FALSE);
        propertySpec.setType(entityMor.getType());
        propertySpec.getPathSet().addAll(Arrays.asList(props));

        // Now create Object Spec
        ObjectSpec objectSpec = new ObjectSpec();
        objectSpec.setObj(entityMor);

        // Create PropertyFilterSpec using the PropertySpec and ObjectPec
        // created above.
        PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
        propertyFilterSpec.getPropSet().add(propertySpec);
        propertyFilterSpec.getObjectSet().add(objectSpec);

        List<PropertyFilterSpec> propertyFilterSpecs =
                new ArrayList<PropertyFilterSpec>();
        propertyFilterSpecs.add(propertyFilterSpec);

        RetrieveResult rslts =
                vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                        propertyFilterSpecs, new RetrieveOptions());
        List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
        if (rslts != null && rslts.getObjects() != null
                && !rslts.getObjects().isEmpty()) {
            listobjcontent.addAll(rslts.getObjects());
        }
        String token = null;
        if (rslts != null && rslts.getToken() != null) {
            token = rslts.getToken();
        }
        while (token != null && !token.isEmpty()) {
            rslts =
                    vimPort.continueRetrievePropertiesEx(
                            serviceContent.getPropertyCollector(), token);
            token = null;
            if (rslts != null) {
                token = rslts.getToken();
                if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                    listobjcontent.addAll(rslts.getObjects());
                }
            }
        }
        for (ObjectContent oc : listobjcontent) {
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
                for (DynamicProperty dp : dps) {
                    retVal.put(dp.getName(), dp.getVal());
                }
            }
        }
        return retVal;
    }

    private static  ManagedObjectReference traverseSnapshotInTree(
            List<VirtualMachineSnapshotTree> snapTree, String findName,
            boolean print) {
        ManagedObjectReference snapmor = null;
        if (snapTree == null) {
            return snapmor;
        }
        for (VirtualMachineSnapshotTree node : snapTree) {
            if (print) {
                System.out.println("Snapshot Name : " + node.getName());
            }
            if (findName != null && node.getName().equalsIgnoreCase(findName)) {
                return node.getSnapshot();
            } else {
                List<VirtualMachineSnapshotTree> listvmst =
                        node.getChildSnapshotList();
                List<VirtualMachineSnapshotTree> childTree = listvmst;
                snapmor = traverseSnapshotInTree(childTree, findName, print);
            }
        }
        return snapmor;
    }


    /**
     *
     * @return An array of SelectionSpec to navigate from the VM and move upwards
     *         to reach the Datacenter
     */
    private static List<SelectionSpec> buildTraversalSpecForVMToDatacenter() {

        // For Folder -> Folder recursion
        SelectionSpec sspecvfolders = new SelectionSpec();
        sspecvfolders.setName("VisitFolders");

        TraversalSpec visitFolders = new TraversalSpec();
        visitFolders.setType("Folder");
        visitFolders.setPath("parent");
        visitFolders.setSkip(Boolean.FALSE);
        visitFolders.setName("VisitFolders");
        visitFolders.getSelectSet().add(sspecvfolders);

        // For vApp -> vApp recursion
        SelectionSpec sspecvApp = new SelectionSpec();
        sspecvApp.setName("vAppToVApp");

        SelectionSpec sspecvAppToFolder = new SelectionSpec();
        sspecvAppToFolder.setName("vAppToFolder");

        TraversalSpec vAppToFolder = new TraversalSpec();
        vAppToFolder.setType("VirtualApp");
        vAppToFolder.setPath("parentFolder");
        vAppToFolder.setSkip(Boolean.FALSE);
        vAppToFolder.setName("vAppToFolder");
        vAppToFolder.getSelectSet().add(sspecvfolders);

        TraversalSpec vAppToVApp = new TraversalSpec();
        vAppToVApp.setType("VirtualApp");
        vAppToVApp.setPath("parentVApp");
        vAppToVApp.setSkip(Boolean.FALSE);
        vAppToVApp.setName("vAppToVApp");
        vAppToVApp.getSelectSet().add(sspecvApp);
        vAppToVApp.getSelectSet().add(sspecvAppToFolder);

        TraversalSpec vmTovApp = new TraversalSpec();
        vmTovApp.setType("VirtualMachine");
        vmTovApp.setPath("parentVApp");
        vmTovApp.setSkip(Boolean.FALSE);
        vmTovApp.setName("vmTovApp");
        vmTovApp.getSelectSet().add(vAppToVApp);
        vmTovApp.getSelectSet().add(vAppToFolder);

        TraversalSpec vmToFolder = new TraversalSpec();
        vmToFolder.setType("VirtualMachine");
        vmToFolder.setPath("parent");
        vmToFolder.setSkip(Boolean.FALSE);
        vmToFolder.setName("vmToFolder");
        vmToFolder.getSelectSet().add(sspecvfolders);

        List<SelectionSpec> speclist = new ArrayList<SelectionSpec>();
        speclist.add(vmToFolder);
        speclist.add(vmTovApp);
        speclist.add(visitFolders);
        return speclist;
    }

    /**
     * Method to retrieve the Datacenter under which the specified VM resides
     *
     * @param vmMor
     *           {@link ManagedObjectReference} of the VM
     * @return {@link String} name of the datacenter that contains the VM.
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static String getDatacenterOfVM(ManagedObjectReference vmMor)
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        String datacenterName = "";

        // Create Property Spec
        PropertySpec propertySpec = new PropertySpec();
        propertySpec.setAll(Boolean.FALSE);
        propertySpec.setType("Datacenter");
        propertySpec.getPathSet().add("name");

        // Now create Object Spec
        ObjectSpec objectSpec = new ObjectSpec();
        objectSpec.setObj(vmMor);
        objectSpec.setSkip(Boolean.TRUE);
        objectSpec.getSelectSet().addAll(buildTraversalSpecForVMToDatacenter());

        // Create PropertyFilterSpec using the PropertySpec and ObjectPec
        // created above.
        PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
        propertyFilterSpec.getPropSet().add(propertySpec);
        propertyFilterSpec.getObjectSet().add(objectSpec);

        List<PropertyFilterSpec> propertyFilterSpecs =
                new ArrayList<PropertyFilterSpec>();
        propertyFilterSpecs.add(propertyFilterSpec);

        List<ObjectContent> oCont =
                vimPort.retrieveProperties(serviceContent.getPropertyCollector(),
                        propertyFilterSpecs);
        if (oCont != null) {
            for (ObjectContent oc : oCont) {
                List<DynamicProperty> dps = oc.getPropSet();
                if (dps != null) {
                    for (DynamicProperty dp : dps) {
                        datacenterName = (String) dp.getVal();
                    }
                }
                System.out.println("VM is present under " + datacenterName
                        + " Datacenter");
                break;
            }
        }
        return datacenterName;
    }

    private static void getVM() throws IllegalArgumentException, Exception {
        File file = new File(localPath);
        if (!file.exists()) {
            System.out.println("Wrong or invalid path " + localPath);
            return;
        }
        ManagedObjectReference vmRef =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        if (vmRef != null) {
            System.out.println("vmRef: " + vmRef.getValue());
            getDiskSizeInKB(vmRef);
            String dataCenterName = getDatacenterOfVM(vmRef);
            String[] vmDirectory = getVmDirectory(vmRef);
            if (vmDirectory[0] != null) {
                System.out.println("vmDirectory-0: " + vmDirectory[0]
                        + " datacenter as : " + dataCenterName);
                System.out
                        .println("Downloading Virtual Machine Configuration Directory");
                String dataStoreName =
                        vmDirectory[0].substring(vmDirectory[0].indexOf("[") + 1,
                                vmDirectory[0].lastIndexOf("]"));
                String configurationDir =
                        vmDirectory[0].substring(vmDirectory[0].indexOf("]") + 2,
                                vmDirectory[0].lastIndexOf("/"));
                boolean success =
                        new File(localPath + "/" + configurationDir + "#vm#"
                                + dataStoreName).mkdir();
                if (!success) {
                    System.out.println("Could not create " + localPath + "/"
                            + configurationDir + "#vm#" + dataStoreName + "directory");
                }
                downloadDirectory(configurationDir, configurationDir + "#vm#"
                        + dataStoreName, dataStoreName, dataCenterName);
                downloadedDir.put(configurationDir + "#vm#" + dataStoreName,
                        "Directory");
                System.out.println("Downloading Virtual Machine"
                        + " Configuration Directory Complete");
            }

            if (vmDirectory[1] != null) {
                System.out.println("Downloading Virtual Machine "
                        + "Snapshot / Suspend / Log Directory");
                for (int i = 1; i < vmDirectory.length; i++) {
                    String dataStoreName =
                            vmDirectory[i].substring(vmDirectory[i].indexOf("[") + 1,
                                    vmDirectory[i].lastIndexOf("]"));
                    String configurationDir = "";
                    String apiType = serviceContent.getAbout().getApiType();
                    if (apiType.equalsIgnoreCase("VirtualCenter")) {
                        configurationDir =
                                vmDirectory[i].substring(
                                        vmDirectory[i].indexOf("]") + 2,
                                        vmDirectory[i].length() - 1);
                    } else {
                        configurationDir =
                                vmDirectory[i]
                                        .substring(vmDirectory[i].indexOf("]") + 2);
                    }
                    if (!downloadedDir.containsKey(configurationDir + "#vm#"
                            + dataStoreName)) {
                        boolean success =
                                new File(localPath + "/" + configurationDir + "#vm#"
                                        + dataStoreName).mkdir();
                        if (!success) {
                            System.out.println("Could not create " + localPath + "/"
                                    + configurationDir + "#vm#" + dataStoreName
                                    + "directory");
                        }
                        downloadDirectory(configurationDir, configurationDir + "#vm#"
                                + dataStoreName, dataStoreName, dataCenterName);
                        downloadedDir.put(configurationDir + "#vm#" + dataStoreName,
                                "Directory");
                    } else {
                        System.out.println("Already Downloaded");
                    }
                }
                System.out.println("Downloading Virtual Machine Snapshot"
                        + " / Suspend / Log Directory Complete");
            }

            String[] virtualDiskLocations = getVDiskLocations(vmRef);
            if (virtualDiskLocations != null) {
                System.out.println("Downloading Virtual Disks");
                for (int i = 0; i < virtualDiskLocations.length; i++) {
                    if (virtualDiskLocations[i] != null) {
                        String dataStoreName =
                                virtualDiskLocations[i].substring(
                                        virtualDiskLocations[i].indexOf("[") + 1,
                                        virtualDiskLocations[i].lastIndexOf("]"));
                        String configurationDir =
                                virtualDiskLocations[i].substring(
                                        virtualDiskLocations[i].indexOf("]") + 2,
                                        virtualDiskLocations[i].lastIndexOf("/"));
                        if (!downloadedDir.containsKey(configurationDir + "#vm#"
                                + dataStoreName)) {
                            boolean success =
                                    new File(localPath + "/" + configurationDir
                                            + "#vdisk#" + dataStoreName).mkdir();
                            if (!success) {
                                System.out.println("Could not create " + localPath
                                        + "/" + configurationDir + "#vdisk#"
                                        + dataStoreName + "directory");
                            }
                            downloadDirectory(configurationDir, configurationDir
                                            + "#vdisk#" + dataStoreName, dataStoreName,
                                    dataCenterName);
                            downloadedDir.put(configurationDir + "#vdisk#"
                                    + dataStoreName, "Directory");
                        } else {
                            System.out.println("Already Downloaded");
                        }
                    } else {
                        System.out.println("Already Downloaded");
                    }
                }
                System.out.println("Downloading Virtual Disks Complete");
            } else {
                System.out.println("Downloading Virtual Disks Complete");
            }
        } else {
            throw new IllegalArgumentException("Virtual Machine " + virtualMachineName
                    + " Not Found.");
        }
    }

    private static String[] getVmDirectory(ManagedObjectReference vmmor)
            throws Exception {
        String[] vmDir = new String[4];
        VirtualMachineConfigInfo vmConfigInfo =
                (VirtualMachineConfigInfo)getEntityProps(vmmor,
                        new String[] { "config" }).get("config");
        if (vmConfigInfo != null) {
            vmDir[0] = vmConfigInfo.getFiles().getVmPathName();
            vmDir[1] = vmConfigInfo.getFiles().getSnapshotDirectory();
            vmDir[2] = vmConfigInfo.getFiles().getSuspendDirectory();
            vmDir[3] = vmConfigInfo.getFiles().getLogDirectory();
        } else {
            System.out.println("Connot Restore VM. Not Able "
                    + "To Find The Virtual Machine Config Info");
        }
        return vmDir;
    }

    private static void getDiskSizeInKB(ManagedObjectReference vmMor)
            throws Exception {
        VirtualMachineConfigInfo vmConfigInfo =
                (VirtualMachineConfigInfo) getEntityProps(vmMor,
                        new String[] { "config" }).get("config");
        if (vmConfigInfo != null) {
            List<VirtualDevice> livd = vmConfigInfo.getHardware().getDevice();
            for (VirtualDevice virtualDevice : livd) {
                if (virtualDevice instanceof VirtualDisk) {
                    System.out.println("Disk size in kb: "
                            + ((VirtualDisk) virtualDevice).getCapacityInKB());
                }
            }
        }
    }

    private static String[] getVDiskLocations(ManagedObjectReference vmmor)
            throws Exception {
        VirtualMachineConfigInfo vmConfigInfo =
                (VirtualMachineConfigInfo) getEntityProps(vmmor,
                        new String[] { "config" }).get("config");
        System.out.println("vmconfig info : " + vmConfigInfo);
        if (vmConfigInfo != null) {
            List<VirtualDevice> livd = vmConfigInfo.getHardware().getDevice();
            VirtualDevice[] vDevice = livd.toArray(new VirtualDevice[livd.size()]);
            int count = 0;
            String[] virtualDisk = new String[vDevice.length];

            for (int i = 0; i < vDevice.length; i++) {
                if (vDevice[i].getClass().getCanonicalName()
                        .equalsIgnoreCase("com.vmware.vim25.VirtualDisk")) {
                    try {
                        long size = ((VirtualDisk) vDevice[i]).getCapacityInKB();
                        System.out.println("Disk size in kb: " + size);
                        VirtualDeviceFileBackingInfo backingInfo =
                                (VirtualDeviceFileBackingInfo) vDevice[i].getBacking();
                        virtualDisk[count] = backingInfo.getFileName();
                        System.out.println("virtualDisk : " + virtualDisk[count]);
                        count++;
                    } catch (SOAPFaultException sfe) {
                        printSoapFaultException(sfe);
                    } catch (ClassCastException e) {
                        System.out.println("Got Exception : " + e);
                    }
                }
            }
            return virtualDisk;
        } else {
            System.out.println("Connot Restore VM. Not Able To"
                    + " Find The Virtual Machine Config Info");
            return null;
        }
    }

    private static void downloadDirectory(String directoryName,
                                          String localDirectory, String dataStoreName, String dataCenter)
            throws Exception {
        String serviceUrl = url;
        serviceUrl = serviceUrl.substring(0, serviceUrl.lastIndexOf("sdk") - 1);
        String httpUrl =
                serviceUrl + "/folder/" + directoryName + "?dcPath=" + dataCenter
                        + "&dsName=" + dataStoreName;
        httpUrl = httpUrl.replaceAll("\\ ", "%20");
        System.out.println("httpUrl : " + httpUrl);
        String[] linkMap = getListFiles(httpUrl);
        for (int i = 0; i < linkMap.length; i++) {
            System.out.println("Downloading VM File " + linkMap[i]);
            String urlString = serviceUrl + linkMap[i];
            String fileName =
                    localDirectory
                            + "/"
                            + linkMap[i].substring(linkMap[i].lastIndexOf("/"),
                            linkMap[i].lastIndexOf("?"));
            urlString = urlString.replaceAll("\\ ", "%20");
            getData(urlString, fileName);
        }
    }

    @SuppressWarnings("unchecked")
    private static String[] getListFiles(String urlString) throws Exception {
        HttpURLConnection conn = null;
        URL urlSt = new URL(urlString);
        conn = (HttpURLConnection) urlSt.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(true);

        // Maintain session
        List<String> cookies = (List<String>) headers.get("Set-cookie");
        cookieValue = cookies.get(0);
        StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
        cookieValue = tokenizer.nextToken();
        String pathData = "$" + tokenizer.nextToken();
        String cookie = "$Version=\"1\"; " + cookieValue + "; " + pathData;

        // set the cookie in the new request header
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("Cookie", Collections.singletonList(cookie));
        ((BindingProvider) vimPort).getRequestContext().put(
                MessageContext.HTTP_REQUEST_HEADERS, map);

        conn.setRequestProperty("Cookie", cookie);
        conn.setRequestProperty("Content-Type", "application/octet-stream");
        conn.setRequestProperty("Expect", "100-continue");
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Length", "1024");
        String line = null;
        String xmlString = "";
        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = in.readLine()) != null) {
            xmlString = xmlString + line;
        }
        xmlString = xmlString.replaceAll("&amp;", "&");
        xmlString = xmlString.replaceAll("%2e", ".");
        xmlString = xmlString.replaceAll("%2d", "-");
        xmlString = xmlString.replaceAll("%5f", "_");
        ArrayList<String> list = getFileLinks(xmlString);
        String[] linkMap = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            linkMap[i] = list.get(i);
        }
        return linkMap;
    }

    private static ArrayList<String> getFileLinks(String xmlString)
            throws Exception {
        ArrayList<String> linkMap = new ArrayList<String>();
        Pattern regex = Pattern.compile("<a href=\".*?\">");
        Matcher regexMatcher = regex.matcher(xmlString);
        while (regexMatcher.find()) {
            String data = regexMatcher.group();
            int ind = data.indexOf("\"") + 1;
            int lind = data.lastIndexOf("\"");
            data = data.substring(ind, lind);
            if (data.indexOf("folder?") == -1) {
                System.out.println("fileLinks data : " + data);
                linkMap.add(data);
            }
        }
        return linkMap;
    }

    @SuppressWarnings("unchecked")
    private static boolean getData(String urlString, String fileName) {
        try {
            HttpURLConnection conn = null;
            URL urlSt = new URL(urlString);
            conn = (HttpURLConnection) urlSt.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setAllowUserInteraction(true);
            // Maintain session
            List<String> cookies = (List<String>) headers.get("Set-cookie");
            cookieValue = cookies.get(0);
            StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
            cookieValue = tokenizer.nextToken();
            String pathData = "$" + tokenizer.nextToken();
            String cookie = "$Version=\"1\"; " + cookieValue + "; " + pathData;

            // set the cookie in the new request header
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map.put("Cookie", Collections.singletonList(cookie));
            ((BindingProvider) vimPort).getRequestContext().put(
                    MessageContext.HTTP_REQUEST_HEADERS, map);

            conn.setRequestProperty("Cookie", cookie);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("Expect", "100-continue");
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Length", "1024");
            InputStream in = conn.getInputStream();
/*            int leng = fileName.lastIndexOf("/");
            String dir = fileName.substring(0, leng - 1);
            String fName = fileName.substring(leng + 1);
            fName = fName.replace("%20", " ");
            dir = replaceSpecialChar(dir);
            fileName = localPath + "\\" + dir + "\\" + fName;*/
            OutputStream out =
                    new BufferedOutputStream(new FileOutputStream(fileName));
            int bufLen = 9 * 1024;
            byte[] buf = new byte[bufLen];
            byte[] tmp = null;
            int len = 0;
            int bytesRead = 0;
            while ((len = in.read(buf, 0, bufLen)) != -1) {
                bytesRead += len;
                tmp = new byte[len];
                System.arraycopy(buf, 0, tmp, 0, len);
                out.write(tmp, 0, len);
            }
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String replaceSpecialChar(String fileName) {
        fileName = fileName.replace(':', '_');
        fileName = fileName.replace('*', '_');
        fileName = fileName.replace('<', '_');
        fileName = fileName.replace('>', '_');
        fileName = fileName.replace('|', '_');
        return fileName;
    }

    public static boolean doHotFullBackup()
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
        boolean result  = false;
        ManagedObjectReference vmmor = getMOREFsInContainerByType(serviceContent.getRootFolder(),
                "VirtualMachine").get(virtualMachineName);
        if (null == vmmor) {
            return result;
        }
        String dataCenterName = getDatacenterOfVM(vmmor);
        String[] vmDirectory = getVmDirectory(vmmor);
        if (null != vmDirectory[0]) {   //
            int index = vmDirectory[0].lastIndexOf("/");
            String configFilePreName = vmDirectory[0].substring(index + 1,
                    vmDirectory[0].lastIndexOf(".vmx"));
            String dataStoreName = vmDirectory[0].substring(vmDirectory[0].indexOf("[") + 1,
                    vmDirectory[0].lastIndexOf("]"));
            String configureDir =
                    vmDirectory[0].substring(vmDirectory[0].indexOf("]") + 2, vmDirectory[0].lastIndexOf("/"));
            String vmFolderUrl = getVMFolderURL(configureDir, dataStoreName, dataCenterName);

            //备份第一步：先下载.vmsd文件和.vmx文件,这个两个文件不做修改，在恢复时至关重要
            //在vmFoldrUrl文件夹下去下载.vmsd文件和.vmx文件
            result = downloadConfigFiles(vmFolderUrl, localPath);

            if (!result) {
                System.out.println("Failed to full backup because download config failed");
                return result;
            }

            //备份第二步：创建快照
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = sf.format(new Date());
            snapshotname += now;
            result = createSnapshot(vmmor);
            if (!result) {
                System.out.println("Failed to full backup because create snapshot failed");
                return result;
            }

            //创建完快照要等待一段时间，远程服务器由于要处理相关的事务，需要占用配置文件
            //如果马上在获取新的配置文件，则会出现错误
            Thread.sleep(60000);

            //备份第三步：获取最新的.vmsd和.vmx文件，获取与当前快照相关的文件名称，
            //将最新的配置文件存放在temp文件夹下
            String tempConfigDir = localPath + "temp.backup\\";
            boolean success = new File(tempConfigDir).mkdir();
            if (!success) {
                System.out.println("Failed to create temp dir");
                return success;
            }
            result = downloadConfigFiles(vmFolderUrl, tempConfigDir);
            if (!result) {
                return result;
            }

            //备份第四步：解析第三部获取的.vmsd和.vmx文件，获得与当前快照相关的文件名,
            //下载时，就不用下载这些与快照相关的文件，和这两个配置文件
            String configFilePath = tempConfigDir + configFilePreName + ".vmx";
            ArrayList currentSnapFileList = getSnapshotFileNamesFromVmxFile(configFilePath);
            String vmsdFilePath = tempConfigDir + configFilePreName + ".vmsd";
            String currentVmsnFile = getVmsnFileNameFromVmsdFile(vmsdFilePath);

            ArrayList<String> shouldNotDownloadFileList = new ArrayList<String>();
            for (int i = 0; i< currentSnapFileList.size(); ++i) {
                shouldNotDownloadFileList.add((String)currentSnapFileList.get(i));
            }
            shouldNotDownloadFileList.add(currentVmsnFile);
            shouldNotDownloadFileList.add(configFilePreName + ".vmx");
            shouldNotDownloadFileList.add(configFilePreName + ".vmsd");
            shouldNotDownloadFileList.add(configFilePreName + ".vmx.lck");
/*            shouldNotDownloadFileList.add(configFilePreName + "-flat.vmdk");*/
            //备份第五步：获取备份时需要备份的文件列表
            ArrayList<String> downloadFileUrlList = getFileList4Backup(shouldNotDownloadFileList, vmFolderUrl);

            //备份第六步:下载你文件列表中的文件
            result = downloadFiles(downloadFileUrlList, localPath);
            if (!result) {
                System.out.println("Failed to download file");
                return result;
            }

            createDeltaFile4BackupScheduledTask();
            diskList = getDiskInfo(vmmor);
            Hashtable<String, String> changeIdTable = null;
            int diskNo = diskList.size();
            ArrayList<String> rootDiskNameList = getRootDiskNameList();
            if (diskNo != rootDiskNameList.size()) {
                return false;
            }
            changeIdTable = new Hashtable<String, String>();
            String diskName,key;
            for (int i = 0; i < diskNo; i++) {
                diskName = rootDiskNameList.get(i);
                key = diskName.substring(0, diskName.lastIndexOf("."));
                changeIdTable.put(key,"*");
            }

            result = generateDeltaConfigFile(localPath, changeIdTable);
            if (!result) {
                System.out.println("Failed to generate delta config file");
                return result;
            }

            String paramPath = localPath + configFilePreName + "backup.param";
            result = generateParamsFile(paramPath);
            if (!result) {
                System.out.println("Failed to generate param file");
                return result;
            }

            //备份第七步：删除快照
            result = removeSnapshot(vmmor);
            if (!result) {
                System.out.println("Failed to delete snapshot");
                return result;
            }

            //备份第八步：删除临时文件夹temp.backup
            deleteAllFilesOfDir(new File(tempConfigDir));
            System.out.println("VirtualMachine backup success");
        }
        return result;
    }

    private static void deleteAllFilesOfDir(File path) {
        if (!path.exists()) {
            return;
        }
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteAllFilesOfDir(files[i]);
            }
            path.delete();
        }
        else if (path.isFile()) {
            path.delete();
        }
    }

    private static String getVMFolderURL(String vmFolderName, String dataStoreName, String dataCenter)
        throws Exception {
        String serviceUrl = url;
        serviceUrl = serviceUrl.substring(0, serviceUrl.lastIndexOf("sdk") - 1);
        String vmFolderUrl =
                serviceUrl + "/folder/" + vmFolderName + "?dcPath=" + dataCenter
                        + "&dsName=" + dataStoreName;
        vmFolderUrl = vmFolderUrl.replaceAll("\\ ", "%20");

        return vmFolderUrl;
    }

    /**
     * 获取后缀名为.vmsd,vmx文件
     * @param vmFolderUrl
     * @param localDir
     * @return
     */
    private static boolean downloadConfigFiles(String vmFolderUrl, String localDir) throws Exception {
        boolean result = false;
        System.out.println("start to download config files");

        ArrayList<String> configFileList = getConfigFileList(vmFolderUrl);
        result = downloadFiles(configFileList, localDir);

        if (!result) {
            System.out.println("Failed to download config files");
        } else {
            System.out.println("Successful to download config files");
        }

        return result;
    }

    private static boolean downloadFiles(ArrayList<String> fileUrlList, String localDir) throws Exception {
        boolean result = false;
        for (int i = 0; i< fileUrlList.size(); ++i) {
            result = downloadFile2Directory(fileUrlList.get(i),localDir);
            if (!result) {
                break;
            }
        }
        return result;
    }

    private static boolean downloadFile2Directory(String fileUrl, String localDir) throws Exception {
        String filePath = localDir + fileUrl.substring(fileUrl.lastIndexOf("/") + 1,
                fileUrl.lastIndexOf("?"));
        return downloadFile2File(fileUrl, filePath);
    }

    private static boolean downloadFile2File(String fileUrl, String localFilePath) throws Exception {
        if (null == fileUrl || null == localFilePath) {
            System.out.println("Failed to download file because fileUrl or localFilePath is null");
            return false;
        }
        String fileName = getFileNameByFileUrl(fileUrl);
        System.out.println("starting to download file" + fileName);
        boolean result  = getData(fileUrl, localFilePath);

        if (!result) {
            System.out.println("Failed to download file " + fileName);
        } else {
            System.out.println("Successful to download file " + fileName);
        }
        return result;
    }

    private static ArrayList<String> getConfigFileList(String vmFolderUrl)
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
        ArrayList<String> configFileList = new ArrayList<String>();
        ManagedObjectReference vmmor = getMOREFsInContainerByType(serviceContent.getRootFolder(),
                "VirtualMachine").get(virtualMachineName);
        String[] vmDirectory = getVmDirectory(vmmor);
        int index = vmDirectory[0].lastIndexOf("/");
        String configFilePreName = vmDirectory[0].substring(index + 1, vmDirectory[0].lastIndexOf(".vmx"));

        String[] fileUrlList = getFileUrlList(vmFolderUrl);
        for (int i = 0; i < fileUrlList.length; ++i) {
            String fileUrl = fileUrlList[i];
            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1, fileUrl.indexOf("?"));
            if (fileName.equals(configFilePreName + ".vmsd")
                    || fileName.equals(configFilePreName + ".vmx")) {
                configFileList.add(fileUrl);
            }
        }
        if (configFileList.size() > 2) {
            System.out.println("Each virtual machine configuration file (.Vmx or.Vmsd file) can not be more than 2");
            return new ArrayList<String>();
        }
        return configFileList;
    }

    private static String[] getFileUrlList(String vmFolderUrl) throws Exception {
        String serviceUrl = url;
        serviceUrl = serviceUrl.substring(0, serviceUrl.lastIndexOf("sdk") - 1);
        String[] linkMap = getListFiles(vmFolderUrl);

        for (int i = 0; i < linkMap.length; ++i) {
            String urlString = serviceUrl + linkMap[i];
            urlString = urlString.replace("\\ ", "%20");
            linkMap[i] = urlString;
        }
        return linkMap;
    }

    private static String getFileNameByFilePath(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf('\\') + 1);
        return fileName;
    }

    private static String getFileNameByFileUrl(String fileUrl) {
        int index = fileUrl.lastIndexOf("/");
        String fileName = fileUrl.substring(index + 1, fileUrl.lastIndexOf("?"));
        return fileName;
    }

    private static ArrayList getSnapshotFileNamesFromVmxFile(String filePath) {
        ArrayList<String> snapFileNameList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while (null != (line = bf.readLine())) {
                if (line.contains("scsi0:0.fileName")) {
                    String snapFileName = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
                    snapFileNameList.add(snapFileName);
                    String snapDeltaFileName = snapFileName.substring(0, snapFileName.indexOf('.')) + "-delta.vmdk";
                    snapFileNameList.add(snapDeltaFileName);
                }
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
        return snapFileNameList;
    }

    private static String getVmsnFileNameFromVmsdFile(String vmsdFilePath) {
        int currentUid;
        String propUid = "uid = default";
        String currentSnapshotSequence = "snapshotNo";
        String vmsnFileName = null;
        try {
            FileReader fr = new FileReader(vmsdFilePath);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while (null != (line = bf.readLine())) {
                if (line.contains("snapshot.current")) {
                    int index = line.indexOf('"');
                    currentUid = Integer.parseInt(line.substring(index + 1, line.lastIndexOf('"')));
                    propUid = "uid = \"" +currentUid + "\"";
                } else if (line.contains(propUid)) {
                    currentSnapshotSequence = line.substring(0, line.indexOf('.'));
                } else if (line.contains(currentSnapshotSequence + ".filename")) {
                    int index = line.indexOf('"');
                    vmsnFileName = line.substring(index + 1, line.lastIndexOf('"'));
                    break;
                }
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vmsnFileName;
    }

    public static ArrayList<String> getFileList4Backup(ArrayList shouldNotDownloadFileList, String vmFolderUrl)
            throws Exception {
        String[] allFileUrlList = getFileUrlList(vmFolderUrl);
        ArrayList<String> downloadFileUrlList = new ArrayList<String>();
        if (null != shouldNotDownloadFileList && 0 < shouldNotDownloadFileList.size()) {
            for (int i = 0; i < allFileUrlList.length; ++i) {
                boolean flag = false;
                String fileUrl = allFileUrlList[i];
                int index = fileUrl.lastIndexOf("/");
                String fileName = fileUrl.substring(index + 1, fileUrl.lastIndexOf("?"));
                if (!fileName.contains(".")) {
                    continue;
                }
                for (int j = 0; j < shouldNotDownloadFileList.size(); j++) {
                    if (fileName.equals(shouldNotDownloadFileList.get(j))) {
                        flag = true;
                        break;
                    }
                }
                //排除vswp文件
                if (fileName.endsWith(".vswp")) {
                    flag = true;
                }
                if (!flag) {
                    downloadFileUrlList.add(fileUrl);
                }
            }
        } else {
            for (int i = 0; i < allFileUrlList.length; ++i) {
                downloadFileUrlList.add(allFileUrlList[i]);
            }
        }
        return downloadFileUrlList;
    }

    /**
     * 获取虚拟磁盘信息
     * @param vmmor
     * @return
     * @throws Exception
     */
    private static ArrayList<GuestDiskInfo> getDiskInfo(ManagedObjectReference vmmor) throws Exception {
        ArrayList<GuestDiskInfo> diskList = new ArrayList<GuestDiskInfo>();
        VirtualMachineConfigInfo vmConfigInfo =
                (VirtualMachineConfigInfo) getEntityProps(vmmor,
                        new String[] { "config" }).get("config");
        List<VirtualDevice> devices = vmConfigInfo.getHardware().getDevice();

        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getDeviceInfo().getLabel().contains("Hard disk")
                    || devices.get(i).getDeviceInfo().getLabel().contains("硬盘")) {
                GuestDiskInfo diskInfo = new GuestDiskInfo();
                String tmpDiskCapacity = devices.get(i).getDeviceInfo().getSummary();
                tmpDiskCapacity = tmpDiskCapacity.substring(0,tmpDiskCapacity.length()-3);
                String diskCapacity = tmpDiskCapacity.replace(",","");
                diskInfo.setCapacity(Long.parseLong(diskCapacity));
                diskInfo.setCapacity(diskInfo.getCapacity()/1024);
                VirtualDiskFlatVer2BackingInfo backing = (VirtualDiskFlatVer2BackingInfo)devices.get(i).getBacking();
                diskInfo.setDiskPath(backing.getFileName());
                diskList.add(diskInfo);
            }
        }
        return diskList;
    }

    /**
     *
     * @return
     */
    private static ArrayList<String> getVMDKDeltaFilePath() {
        ArrayList<String> deltaFileList = new ArrayList<String>();
        ArrayList<String> fileNameList = getFileNameListInDirectory(localPath);
        String fileName;
        for (int i = 0; i < fileNameList.size(); ++i) {
            fileName = fileNameList.get(i);
            if (fileName.endsWith(".vmdk.delta")) {
                deltaFileList.add(fileName);
            }
        }
        return deltaFileList;
    }

    private static ArrayList<String> getFileNameListInDirectory(String directory) {
        if (directory == null || directory == "") {
            return  null;
        }
        ArrayList<String> fileNameList = new ArrayList<String>();
        File dir = new File(directory);

        if (!dir.isDirectory()) {
            return null;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    String fileName = files[i].getName();
                    fileNameList.add(fileName);
                }
            }
        }
        return fileNameList;
    }

    private static long getBackedSize() {
        ArrayList<String> deltaFileList = getVMDKDeltaFilePath();
        long backedSize = 0;
        for (int i = 0; i < deltaFileList.size(); ++i) {
            backedSize += getFileSize(localPath + "\\" + deltaFileList.get(i));
        }
        return backedSize;
    }

    private static long getFileSize(String filePath) {
        File file  = new File(filePath);
        return file.length();
    }

    public static boolean doIncrementBackup()
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
        boolean result = false;
        System.out.println("start to increment backup");
        VirtualMachineParams vmParams = new VirtualMachineParams();
        result = initVirtualMachineParams(vmParams);
        if (!result) {
            System.out.println("failed to increment backup");
        }

        ManagedObjectReference vmRef =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        diskList = getDiskInfo(vmRef);
        //创建快照
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sf.format(new Date());
        snapshotname = snapshotname + time;
        result = createSnapshot(vmRef);
        if (!result) {
            return result;
        }

        Thread.sleep(60000);

        //备份第一步：下载配置文件
        result = BackupConfigFiles4ScheduledTask(vmParams);
        if (!result) {
            System.out.println("failed to increment backup");
            return result;
        }

        //备份第二步：更改配置文件，创建恢复时用的.vmdk配置文件
        result = generateVMDKFile4ScheduledTask();
        if (!result) {
            System.out.println("failed to increment backup");
            return result;
        }

        //备份第三步：增量数据偏移位置
        createDeltaFile4BackupScheduledTask();
        result = createDeltaConfigFile4ScheduledTask("E:\\vmbackup\\backup-chain7\\");
        if (!result) {
            System.out.println("failed to increment backup");
            return result;
        }
/*        //创建快照
        SimpleDateFormat sf = new SimpleDateFormat("YY-MM-DD HH:mm:ss");
        String time = sf.format(new Date());
        snapshotname = snapshotname + time;
        result = createSnapshot(vmRef);
        if (!result) {
            return result;
        }*/
        String paramsFile = localPath + virtualMachineName + "backup.param";
        generateParamsFile(paramsFile);
//        removeSnapshot(vmRef);
        return result;
    }

    private static boolean createDeltaFile4BackupScheduledTask()
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, IOException {
        boolean result = false;
        ArrayList<String> deltaFileNameList = getDeltaFileNameList();
        String deltaFilePath;
        for (int i = 0; i < deltaFileNameList.size(); ++i) {
            deltaFilePath = localPath + deltaFileNameList.get(i);
            result = new File(deltaFilePath).createNewFile();
        }
        return result;
    }

    /**
     * 为C++创建参数文件
     * @param paramsFilePath
     * @return
     * @throws Exception
     */
    private static boolean generateParamsFile(String paramsFilePath) {
        boolean result = false;
        try {
            File file = new File(paramsFilePath);
            FileOutputStream fout = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fout));
            bufferedWriter.write("diskNo=" + diskList.size() + "\r\n");
            GuestDiskInfo diskInfo = diskList.get(0);
            String diskPath = diskInfo.getDiskPath();
            String VMPath = diskPath.substring(0, diskPath.lastIndexOf("/"));
            ArrayList<String> fileNameList = getFileNameListInDirectory(localPath);
            int diskCount = 1;
            for (int i = 0; i < fileNameList.size(); ++i) {
                String fileName = fileNameList.get(i);
                if (fileName.endsWith(".delta.config")) {
                    String diskName = fileName.substring(0, fileName.lastIndexOf(".delta.config"));
                    bufferedWriter.write("#diskNo_" + diskCount + "#\r\n");
                    bufferedWriter.write("vmDiskPath=" + VMPath + "\\" +diskName + "\r\n");
                    bufferedWriter.write("deltaFilePath=" + localPath + diskName + ".delta\r\n");
                    bufferedWriter.write("deltaConfigPath=" + localPath + fileName + "\r\n");
                    diskCount++;
                }
            }
            bufferedWriter.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 通过localDirectory目录下的delta.config文件获取上一次备份时的changeId
     * @param localPath
     * @return
     */
    private static Hashtable<String, String> getChangeIdTable(String localPath) {
        Hashtable<String, String> changeIdTable = new Hashtable<String, String>();
        ArrayList<String> fileNameList = getFileNameListInDirectory(localPath);
        ArrayList<String> deltaConfigFileNameList = new ArrayList<String>();
        for (int i = 0; i < fileNameList.size(); ++i) {
            String fileName = fileNameList.get(i);
            if (fileName.endsWith(".delta.config")) {
                deltaConfigFileNameList.add(fileName);
            }
        }
        for (int i = 0; i < deltaConfigFileNameList.size(); ++i) {
            String deltaConfigFileName = deltaConfigFileNameList.get(i);
            Map<String, String> pairs = getChangeIdInConfigFile(localPath + deltaConfigFileName);
            Set<Map.Entry<String, String>> entries = pairs.entrySet();
            if (!entries.isEmpty()) {
                for (Map.Entry<String, String> entry : entries) {
                    changeIdTable.put(entry.getKey(),entry.getValue());
                }
            }
        }
        return changeIdTable;
    }

    /**
     * 通过localDirectory目录下的delta.config文件获取上一次备份时的changeId
     * @param deltaConfigFilePath
     * @return
     */
    private static Map<String, String> getChangeIdInConfigFile(String deltaConfigFilePath) {
        Map<String, String> pairs = new HashMap<String, String>();
        if (null == deltaConfigFilePath || deltaConfigFilePath.isEmpty()) {
            return pairs;
        }
        try {
            File file = new File(deltaConfigFilePath);
            FileInputStream fin = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fin));
            String line;
            String key = null;
            String value = null;
            while (null != (line = bufferedReader.readLine())) {
                String tempkey = null;
                if (line.contains("\t")) {
                    tempkey = line.substring(0, line.indexOf(":"));
                    if (tempkey.equals("RootDiskFileName")) {
                        key = line.substring(line.indexOf("\t") + 1);
                    } else if (tempkey.equals("ChangeId")) {
                        value = line.substring(line.indexOf("\t") + 1);
                        break;
                    }
                }
            }
            pairs.put(key, value);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pairs;
    }

    private static boolean createDeltaConfigFile4ScheduledTask(String localDir)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        boolean result = false;
        Hashtable<String, String> changeIdTable = null;
            changeIdTable = getChangeIdTable(localDir);
        if (0 == changeIdTable.size()) {
            return false;
        }
        result = generateDeltaConfigFile(localPath, changeIdTable);
        return result;
    }


    /**
     * 创建纪录增量数据偏移位置的配置文件
     * @param deltaConfigDirectory
     * @param changedIdTable
     * @return
     */
    private static boolean generateDeltaConfigFile(String deltaConfigDirectory, Hashtable changedIdTable)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        if (changedIdTable.isEmpty()) {
            return false;
        }
        boolean result = false;
        ArrayList<String> deltaFileNameList = getDeltaFileNameList();
        ArrayList<String> rootDiskNameList = getRootDiskNameList();
        ManagedObjectReference vmmor =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        VirtualMachineSnapshotInfo vmSnapshotInfo =
                (VirtualMachineSnapshotInfo)getEntityProps(vmmor, new String[] { "snapshot" }).get("snapshot");
        ManagedObjectReference currentSnapshotMor = vmSnapshotInfo.getCurrentSnapshot();

        VirtualMachineConfigInfo vmConfigInfo =
                (VirtualMachineConfigInfo)getEntityProps(currentSnapshotMor, new String[] { "config" }).get("config");
        List<VirtualDevice> virtualDevices = vmConfigInfo.getHardware().getDevice();
        int diskNo = 0;
        for (int i = 0; i < virtualDevices.size(); ++i) {
            String deviceLabel = virtualDevices.get(i).getDeviceInfo().getLabel();
            if (deviceLabel.contains("Hard disk") || deviceLabel.contains("硬盘")) {
                diskNo++;
                VirtualDeviceBackingInfo backingInfo = virtualDevices.get(i).getBacking();
                VirtualDiskFlatVer2BackingInfo backing = (VirtualDiskFlatVer2BackingInfo)backingInfo;
                String rootDiskName = getRootDiskNameByBacking(backing);
                String preRootDiskName = rootDiskName.substring(0, rootDiskName.lastIndexOf("."));
                preRootDiskName = preRootDiskName.substring(preRootDiskName.lastIndexOf("/") + 1);
                String changedId = (String)changedIdTable.get(preRootDiskName);
                VirtualDisk virtualDisk = (VirtualDisk)virtualDevices.get(i);
                long diskSizeInKB = virtualDisk.getCapacityInKB();
                String fileName = backing.getFileName();
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                String deltaConfigFileName = null;
                try {
                    FileWriter fw = null;
                    String deltaFileName =null;
                    for (int j  = 0; j < deltaFileNameList.size(); ++j) {
                        if (deltaFileNameList.get(j).contains(preRootDiskName)) {
                            deltaFileName = deltaFileNameList.get(j);
                            deltaConfigFileName = deltaFileName + ".config";
                            break;
                        }
                    }
                    if (null == deltaConfigFileName || null == deltaFileName) {
                        System.out.println("not found delta file");
                        break;
                    }
                    System.out.println("start to create NO" + "(" + diskNo + ")" + "delta config file");
                    fw  = new FileWriter(deltaConfigDirectory + "\\" + deltaConfigFileName);
                    fw.write("### VM 备份配置信息###\r\n");
                    fw.write("DeviceUUID:\t" + backing.getUuid() + "\r\n");
                    fw.write("DeviceKey:\t" + virtualDevices.get(i).getKey() + "\r\n");
                    //RootDiskFileName 用于初始化changedIdHashTable 的key值，
                    //程序没从delta.config文件中读取上一次的changedId，并放入hashTable中
                    fw.write("RootDiskFileName:\t" + preRootDiskName + "\r\n");
                    fw.write("CurrentDiskFileName:\t" + deltaFileName.substring(0, deltaFileName.lastIndexOf(".")) + "\r\n");
                    fw.write("DeltaFileName:\t" + deltaFileName + "\r\n");
                    fw.write("ChangeId:\t" + backing.getChangeId() + "\r\n");
                    fw.write("ContentId:\t" + backing.getContentId() + "\r\n");
                    fw.flush();

                    if (changedId.equals("*")) {   //第一次完全备份
                        fw.write("TotalSizeOfChangedData(in bytes):\t" + diskSizeInKB*1024 + "\r\n");
                        fw.write("Data:" + "\r\n");
                        fw.write("Offset(in bytes)\tLength(in bytes)" + "\r\n");
                        String toWrite = "0" + "\t" + (diskSizeInKB * 1024) + "\r\n";
                        fw.write(toWrite);
                    } else {   //增量备份*/
                        long changedContentTotalLength = 0;
                        long blockLength = 0;
                        long blockStartOffset = 0;

                        DiskChangeInfo diskChangeInfo = null;
                        diskChangeInfo = vimPort.
                                queryChangedDiskAreas(vmmor, currentSnapshotMor, virtualDevices.get(i).getKey(), 0, changedId);
                        List<DiskChangeExtent> diskChangeExtents = diskChangeInfo.getChangedArea();
                        if (diskChangeExtents.isEmpty()) {
                            fw.write("TotalSizeOfChangedData(in bytes):\t" + changedContentTotalLength + "\r\n");
                            fw.write("Data:\r\n");
                            fw.write("Offset(in bytes)\tLength(in bytes)" + "\r\n");
                            fw.write("0\t0" + "\r\n");
                        } else {
                            for (int j = 0; j < diskChangeExtents.size(); ++j) {
                                blockLength = diskChangeExtents.get(j).getLength();
                                changedContentTotalLength = changedContentTotalLength + blockLength;
                            }

                            fw.write("TotalSizeOfChangedData(in bytes):\t" + changedContentTotalLength + "\r\n");
                            fw.write("Data:\r\n");
                            fw.write("Offset(in bytes)\tLength(in bytes)\r\n");
                            for (int j = 0; j < diskChangeExtents.size(); ++j) {
                                blockLength = diskChangeExtents.get(j).getLength();
                                blockStartOffset = diskChangeExtents.get(j).getStart();

                                String towrite = blockStartOffset + "\t" + blockLength + "\r\n";
                                fw.write(towrite);
                            }
                        }
                    }
                    fw.close();
                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }

    private static String getRootDiskNameByBacking(VirtualDiskFlatVer2BackingInfo backing) {
        VirtualDiskFlatVer2BackingInfo currentBacking = (VirtualDiskFlatVer2BackingInfo)backing;
        VirtualDiskFlatVer2BackingInfo parentBacking = currentBacking.getParent();
        if (null == parentBacking) {
            return currentBacking.getFileName();
        } else {
            return getRootDiskNameByBacking(parentBacking);
        }
    }

    private static ArrayList<String> getDeltaFileNameList()
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        ArrayList<String> currentSnapshotFileNames = getCurrentSnapshotFileName();
        String tmp = null;
        for (int i = 0; i < currentSnapshotFileNames.size(); ++i) {
            tmp = currentSnapshotFileNames.remove(i);
            currentSnapshotFileNames.add(i, tmp + ".delta");
        }
        return currentSnapshotFileNames;
    }

    /**
     *
     * @return
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static boolean generateVMDKFile4ScheduledTask()
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
        boolean result = true;
        ArrayList<String> localFileNameList = getFileNameListInDirectory(localPath);
        ArrayList<String> rootDiskNameList = getRootDiskNameList();
        ArrayList<String> diskNameList4CurrentInUse = getCurrentSnapshotFileName();

        for (int i = 0; i < rootDiskNameList.size(); ++i) {
            String rootDiskName = rootDiskNameList.get(i);
            String currentDiskNameInUse = null;
            for (int j = 0; j < diskNameList4CurrentInUse.size(); ++j) {
                String diskName = diskNameList4CurrentInUse.get(j);
                if (diskName.contains(rootDiskName.substring(0, rootDiskName.lastIndexOf(".")))) {
                    currentDiskNameInUse = diskName;
                    break;
                }
            }
            if (null == currentDiskNameInUse) {
                continue;
            }
            for (int k = 0; k < localFileNameList.size(); ++k) {
                String localFileName = localFileNameList.get(k);
                if (localFileName.contains(rootDiskName)) {
                    result = CreateNewVMDKFile4CurrentDiskInUse(localPath + localFileName, localPath + currentDiskNameInUse);
                    if (!result) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private static boolean CreateNewVMDKFile4CurrentDiskInUse(String oldVmdkFilePath, String newVmdkFilePath) {
        boolean result = false;
        String newVmdkFileName = getFileNameByFilePath(newVmdkFilePath);
        try {
            File old = new File(oldVmdkFilePath);
            FileInputStream fin  = new FileInputStream(old);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            File newFile = new File(newVmdkFilePath);
            FileOutputStream fout = new FileOutputStream(newFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

            boolean shouldModify = false;
            String line = null;
            while (null != (line = br.readLine())) {
                if (line.contains("# Extent description") || line.contains("# Change Tracking File")) {
                    shouldModify  = true;
                }
                if (shouldModify) {
                    if (line.contains("-flat.vmdk")) {
                        line = line.substring(0, line.indexOf('"')) + "\"" + newVmdkFileName.substring(0, newVmdkFileName.lastIndexOf(".vmdk")) + "-flat.vmdk\"";
                        shouldModify = false;
                    } else if (line.contains("ctk.vmdk")) {
                        line = line.substring(0, line.indexOf('"')) + "\"" + newVmdkFileName.substring(0, newVmdkFileName.lastIndexOf(".vmdk")) + "-ctk.vmdk\"";
                        shouldModify = false;
                    }
                }
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.flush();
            bw.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean BackupConfigFiles4ScheduledTask(VirtualMachineParams vmParams) throws Exception {

        boolean result = false;
        ArrayList<String> fileUrlList = getConfigFileList4ScheduledTask(vmParams);
        if (0 == fileUrlList.size()) {
            return result;
        }
        for (int i = 0; i < fileUrlList.size(); ++i) {
            String fileUrl = fileUrlList.get(i);
            String fileName = getFileNameByFileUrl(fileUrl);

            if (fileName.length() -5 == fileName.indexOf(".vmdk")) {
                fileName = fileName + ".original";
                result = downloadFile2File(fileUrl, localPath +fileName);

            } else {
                result = downloadFile2Directory(fileUrl, localPath);
            }

            if (!result) {
                System.out.println("Failed to backup config file");
                break;
            }
        }
        if (result) {
            System.out.println("success to backup config file");
        }
        return result;
    }

    public static ArrayList<String> getConfigFileList4ScheduledTask(VirtualMachineParams vmParams) throws Exception {
        ArrayList<String> fileList;
        String vmFolderUrl  = vmParams.getVMFolderUrl();
        fileList = getConfigFileList(vmFolderUrl);

        //获取后缀名为.vmxf和.nvram的文件的URL地址
        String preQuestionMark = vmFolderUrl.substring(0, vmFolderUrl.lastIndexOf("?"));
        String afterQuestionMark = vmFolderUrl.substring(vmFolderUrl.lastIndexOf("?"));
        String vmxFile = preQuestionMark + "/" + vmParams.getConfigFileName() + ".vmxf" + afterQuestionMark;
        String nvramFile = preQuestionMark + "/" + vmParams.getConfigFileName() + ".nvram" + afterQuestionMark;
        fileList.add(vmxFile);
        fileList.add(nvramFile);

        ArrayList<String> snapshotFileNameList = getCurrentSnapshotFileName();
        if (0 == snapshotFileNameList.size()) {
            return  null;
        }
        String tmp = null;
        for (int i = 0; i < snapshotFileNameList.size(); ++i) {
            tmp = snapshotFileNameList.remove(i);
            snapshotFileNameList.add(i, preQuestionMark + "/" + tmp + afterQuestionMark);
        }
        addArrayList2ArrayList(fileList, snapshotFileNameList);

        ArrayList<String> rootDiskNameList = getRootDiskNameList();
        if (0 == rootDiskNameList.size()) {
            return null;
        }
        String tmps = null;
        for (int i = 0; i < rootDiskNameList.size(); ++i) {
            tmps = rootDiskNameList.remove(i);
            rootDiskNameList.add(i, preQuestionMark + "/" + tmps + afterQuestionMark);
        }
        addArrayList2ArrayList(fileList, rootDiskNameList);
        return fileList;
    }

    /**
     * 获取虚拟机初始情况下的虚拟磁盘名称列表
     *
     * @return
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static ArrayList<String> getRootDiskNameList()
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {

        ManagedObjectReference vmmor =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        ArrayList<String> rootDiskNameList = new ArrayList<String>();
        VirtualMachineSnapshotInfo rootSnapshotMors =
                (VirtualMachineSnapshotInfo)getEntityProps(vmmor, new String[] { "snapshot" }).get("snapshot");
        List<VirtualMachineSnapshotTree> listvmsht =
                rootSnapshotMors.getRootSnapshotList();
        if (!listvmsht.isEmpty()) {
                VirtualHardware rootSnapshotHardware =
                        (VirtualHardware)getEntityProps(listvmsht.get(0).getSnapshot(), new String[] { "config.hardware" }).get("config.hardware");
                ArrayList virtualDiskFileNameList = getVirtualDiskNameList(rootSnapshotHardware);
                addArrayList2ArrayList(rootDiskNameList, virtualDiskFileNameList);
        }
        return rootDiskNameList;
    }

    /**
     * 将fromList列表中的对象添加到toList列表中
     * @param toList
     * @param fromList
     * @return
     */
    private static ArrayList addArrayList2ArrayList(ArrayList toList, ArrayList fromList) {
        for (int i = 0; i < fromList.size(); ++i) {
            toList.add(fromList.get(i));
        }
        return toList;
    }

    /**
     * 获取快照文件名称
     * 如果虚拟机有快照，则快照磁盘名称和当前系统使用磁盘名称一致；
     * 因为，虚拟机创建快照后，所有写入虚拟机的数据都会写到快照磁盘文件中
     *
     * @return
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static ArrayList<String> getCurrentSnapshotFileName()
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {

        ManagedObjectReference vmmor =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        ArrayList<String> snapshotFileNameList;
        VirtualHardware currentHardwareInUse = (VirtualHardware)getEntityProps(vmmor, new String[] { "config.hardware" }).get("config.hardware");
        snapshotFileNameList = getVirtualDiskNameList(currentHardwareInUse);
        return snapshotFileNameList;

    }

    private static ArrayList<String> getVirtualDiskNameList(VirtualHardware virtualHardware) {
        ArrayList<String> virtualFileNameList = new ArrayList<String>();
        List<VirtualDevice> virtualDevices = virtualHardware.getDevice();
        for (int i = 0; i< virtualDevices.size(); ++i) {
            String deviceLable = virtualDevices.get(i).getDeviceInfo().getLabel();
            if (deviceLable.contains("Hard disk") || deviceLable.contains("硬盘")) {
                VirtualDeviceBackingInfo backingInfo = virtualDevices.get(i).getBacking();
                VirtualDiskFlatVer2BackingInfo backing = (VirtualDiskFlatVer2BackingInfo)backingInfo;
                //String uuid = backing.getUuid();
                String virtualDiskFileName  = backing.getFileName().substring(backing.getFileName().lastIndexOf("/") + 1);
                virtualFileNameList.add(virtualDiskFileName);
            }
        }
        return virtualFileNameList;
    }

    /**
     * 初始化虚拟机参数
     * @param vmParams
     * @return
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     * @throws Exception
     */
    public static boolean initVirtualMachineParams(VirtualMachineParams vmParams)
        throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
        boolean result = false;
        ManagedObjectReference vmmor =
                getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(virtualMachineName);
        if (null == vmmor || null == vmParams) {
            System.out.println("Failure to init");
            return result;
        }

        vmParams.setDataCenterName(getDatacenterOfVM(vmmor));
        String[] vmDirectory = getVmDirectory(vmmor);
        if (null != vmDirectory[0]) {
            int index = vmDirectory[0].lastIndexOf("/");
            vmParams.setConfigFileName(vmDirectory[0].substring(index + 1, vmDirectory[0].lastIndexOf(".vmx")));
            vmParams.setDataStoreName(vmDirectory[0].substring(vmDirectory[0].indexOf("[") + 1, vmDirectory[0].lastIndexOf("]")));
            String configurationDir = vmDirectory[0].substring(vmDirectory[0].indexOf("]") + 2, vmDirectory[0].lastIndexOf("/"));
            vmParams.setVMFolderUrl(getVMFolderURL(configurationDir, vmParams.getDataStoreName(), vmParams.getDataCenterName()));
            result = true;
        } else {
            System.out.println("failure to init");
        }
        return result;
    }
}

class VirtualMachineParams {
    private String ConfigFileName;
    private String DataCenterName;
    private String DataStoreName;
    private String VMFolderUrl;

    public VirtualMachineParams() {

    }

    public String getConfigFileName() {
        return ConfigFileName;
    }

    public void setConfigFileName(String configFileName) {
        ConfigFileName = configFileName;
    }

    public String getDataCenterName() {
        return DataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        DataCenterName = dataCenterName;
    }

    public String getDataStoreName() {
        return DataStoreName;
    }

    public void setDataStoreName(String dataStoreName) {
        DataStoreName = dataStoreName;
    }

    public String getVMFolderUrl() {
        return VMFolderUrl;
    }

    public void setVMFolderUrl(String VMFolderUrl) {
        this.VMFolderUrl = VMFolderUrl;
    }
}