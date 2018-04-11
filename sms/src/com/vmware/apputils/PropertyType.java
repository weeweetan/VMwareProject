package com.vmware.apputils;

/**
 * Specifies the data type of a property.
 * If the property is an enum, the enum name is also stored.
 */
public class PropertyType {

   /**
    * Enumeration of various type names that are supported
    */
   public enum Type {Str, Long, Double, Enum};

   /**
    * Type value for an instance of the class
    */
   public Type type;

   /**
    * Contains the name of the enum type if the property is an
    * enum.
    */
   public final String enumName;

   /**
    * Identifies if the property type is a numeric or not.
    */
   public boolean isNumber;

   /**
    * Attribute to represent a string type
    */
   public static final PropertyType StringPropertyType
      = new PropertyType(Type.Str);

   /**
    * Attribute to represent a long type
    */
   public static final PropertyType LongPropertyType
      = new PropertyType(Type.Long);

   /**
    * Attribute to represent a double type
    */
   public static final PropertyType DoublePropertyType
      = new PropertyType(Type.Double);

   /**
    * Create an enum propertyType and specify the name of the enum.
    */
   public PropertyType(String enumName) {
      this.enumName = enumName;
      type = Type.Enum;
      isNumber = false;
   }

   /**
    * Internal constructor. For string and number, use the
    * corresponding final attributes. For enum, use the enumName
    * constructor
    */
   private PropertyType(Type type) {
      this.type = type;
      enumName = null;
      if (type == Type.Double 
          || type == Type.Long) {
         isNumber = true;
      } else {
         isNumber = false;
      }
   }
}
