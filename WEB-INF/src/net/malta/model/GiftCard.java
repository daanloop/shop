// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateEntity.vsl in andromda-hibernate-cartridge.
//
package net.malta.model;

/**
 * 
 */
public abstract class GiftCard
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -6601358939754896701L;

    private java.lang.Integer id;

    /**
     * 
     */
    public java.lang.Integer getId()
    {
        return this.id;
    }

    public void setId(java.lang.Integer id)
    {
        this.id = id;
    }

    private java.lang.String name;

    /**
     * 
     */
    public java.lang.String getName()
    {
        return this.name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }

    private java.util.Collection deliveryAddresses = new java.util.HashSet();

    /**
     * 
     */
    public java.util.Collection getDeliveryAddresses()
    {
        return this.deliveryAddresses;
    }

    public void setDeliveryAddresses(java.util.Collection deliveryAddresses)
    {
        this.deliveryAddresses = deliveryAddresses;
    }

    private java.util.Collection deliveryAddressChoises = new java.util.HashSet();

    /**
     * 
     */
    public java.util.Collection getDeliveryAddressChoises()
    {
        return this.deliveryAddressChoises;
    }

    public void setDeliveryAddressChoises(java.util.Collection deliveryAddressChoises)
    {
        this.deliveryAddressChoises = deliveryAddressChoises;
    }

    /**
     * Returns <code>true</code> if the argument is an GiftCard instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     */
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof GiftCard))
        {
            return false;
        }
        final GiftCard that = (GiftCard)object;
        if (this.id == null || that.getId() == null || !this.id.equals(that.getId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     */
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (id == null ? 0 : id.hashCode());

        return hashCode;
    }

    /**
     * Constructs new instances of {@link net.malta.model.GiftCard}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link net.malta.model.GiftCard}.
         */
        public static net.malta.model.GiftCard newInstance()
        {
            return new net.malta.model.GiftCardImpl();
        }

        /**
         * Constructs a new instance of {@link net.malta.model.GiftCard}, taking all required and/or
         * read-only properties as arguments.
         */
        public static net.malta.model.GiftCard newInstance(java.lang.String name)
        {
            final net.malta.model.GiftCard entity = new net.malta.model.GiftCardImpl();
            entity.setName(name);
            return entity;
        }

        /**
         * Constructs a new instance of {@link net.malta.model.GiftCard}, taking all possible properties
         * (except the identifier(s))as arguments.
         */
        public static net.malta.model.GiftCard newInstance(java.lang.String name, java.util.Collection deliveryAddresses, java.util.Collection deliveryAddressChoises)
        {
            final net.malta.model.GiftCard entity = new net.malta.model.GiftCardImpl();
            entity.setName(name);
            entity.setDeliveryAddresses(deliveryAddresses);
            entity.setDeliveryAddressChoises(deliveryAddressChoises);
            return entity;
        }
    }
    
// HibernateEntity.vsl merge-point
}