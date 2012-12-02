// license-header java merge-point
package net.malta.model.crud;

public class GiftCardValueObject
    implements java.io.Serializable
{
    private java.lang.Integer id;

    public java.lang.Integer getId()
    {
        return this.id;
    }

    public void setId(java.lang.Integer id)
    {
        this.id = id;
    }

    private java.lang.String name;

    public java.lang.String getName()
    {
        return this.name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }

    private java.lang.Integer[] deliveryAddresses;

    public java.lang.Integer[] getDeliveryAddresses()
    {
        return this.deliveryAddresses;
    }

    public void setDeliveryAddresses(java.lang.Integer[] deliveryAddresses)
    {
        this.deliveryAddresses = deliveryAddresses;
    }

    private java.lang.Integer[] deliveryAddressChoises;

    public java.lang.Integer[] getDeliveryAddressChoises()
    {
        return this.deliveryAddressChoises;
    }

    public void setDeliveryAddressChoises(java.lang.Integer[] deliveryAddressChoises)
    {
        this.deliveryAddressChoises = deliveryAddressChoises;
    }

}