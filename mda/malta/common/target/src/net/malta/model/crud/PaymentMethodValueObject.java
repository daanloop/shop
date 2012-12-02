// license-header java merge-point
package net.malta.model.crud;

public class PaymentMethodValueObject
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

    private java.lang.String note;

    public java.lang.String getNote()
    {
        return this.note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    private java.lang.Integer[] purchases;

    public java.lang.Integer[] getPurchases()
    {
        return this.purchases;
    }

    public void setPurchases(java.lang.Integer[] purchases)
    {
        this.purchases = purchases;
    }

}