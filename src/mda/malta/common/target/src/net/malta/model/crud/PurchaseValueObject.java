// license-header java merge-point
package net.malta.model.crud;

public class PurchaseValueObject
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

    private int total;

    public int getTotal()
    {
        return this.total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    private int carriage;

    public int getCarriage()
    {
        return this.carriage;
    }

    public void setCarriage(int carriage)
    {
        this.carriage = carriage;
    }

    private int totalordernum;

    public int getTotalordernum()
    {
        return this.totalordernum;
    }

    public void setTotalordernum(int totalordernum)
    {
        this.totalordernum = totalordernum;
    }

    private boolean shipped;

    public boolean isShipped()
    {
        return this.shipped;
    }

    public void setShipped(boolean shipped)
    {
        this.shipped = shipped;
    }

    private java.util.Date date;

    public java.util.Date getDate()
    {
        return this.date;
    }

    public void setDate(java.util.Date date)
    {
        this.date = date;
    }

    private boolean temp;

    public boolean isTemp()
    {
        return this.temp;
    }

    public void setTemp(boolean temp)
    {
        this.temp = temp;
    }

    private boolean cancelled;

    public boolean isCancelled()
    {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
    }

    private boolean removed;

    public boolean isRemoved()
    {
        return this.removed;
    }

    public void setRemoved(boolean removed)
    {
        this.removed = removed;
    }

    private java.lang.Integer publicUser;

    public java.lang.Integer getPublicUser()
    {
        return this.publicUser;
    }

    public void setPublicUser(java.lang.Integer publicUser)
    {
        this.publicUser = publicUser;
    }

    private java.lang.Integer[] choises;

    public java.lang.Integer[] getChoises()
    {
        return this.choises;
    }

    public void setChoises(java.lang.Integer[] choises)
    {
        this.choises = choises;
    }

    private java.lang.Integer paymentMethod;

    public java.lang.Integer getPaymentMethod()
    {
        return this.paymentMethod;
    }

    public void setPaymentMethod(java.lang.Integer paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

}