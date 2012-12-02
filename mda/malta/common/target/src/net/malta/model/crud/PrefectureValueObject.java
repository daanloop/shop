// license-header java merge-point
package net.malta.model.crud;

public class PrefectureValueObject
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

    private java.lang.Integer[] publicUsers;

    public java.lang.Integer[] getPublicUsers()
    {
        return this.publicUsers;
    }

    public void setPublicUsers(java.lang.Integer[] publicUsers)
    {
        this.publicUsers = publicUsers;
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

}