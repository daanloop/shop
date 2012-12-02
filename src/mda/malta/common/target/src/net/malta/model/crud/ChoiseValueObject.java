// license-header java merge-point
package net.malta.model.crud;

public class ChoiseValueObject
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

    private int ordernum;

    public int getOrdernum()
    {
        return this.ordernum;
    }

    public void setOrdernum(int ordernum)
    {
        this.ordernum = ordernum;
    }

    private int pricewithtax;

    public int getPricewithtax()
    {
        return this.pricewithtax;
    }

    public void setPricewithtax(int pricewithtax)
    {
        this.pricewithtax = pricewithtax;
    }

    private boolean wrapping;

    public boolean isWrapping()
    {
        return this.wrapping;
    }

    public void setWrapping(boolean wrapping)
    {
        this.wrapping = wrapping;
    }

    private java.lang.Integer purchase;

    public java.lang.Integer getPurchase()
    {
        return this.purchase;
    }

    public void setPurchase(java.lang.Integer purchase)
    {
        this.purchase = purchase;
    }

    private java.lang.Integer item;

    public java.lang.Integer getItem()
    {
        return this.item;
    }

    public void setItem(java.lang.Integer item)
    {
        this.item = item;
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