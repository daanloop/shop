// license-header java merge-point
package net.malta.model.crud;

public final class PurchaseForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.util.List manageableList = null;

    public java.util.List getManageableList()
    {
        return this.manageableList;
    }

    public void setManageableList(java.util.List manageableList)
    {
        this.manageableList = manageableList;
    }

    private java.lang.Integer[] selectedRows = null;

    public java.lang.Integer[] getSelectedRows()
    {
        return this.selectedRows;
    }

    public void setSelectedRows(java.lang.Integer[] selectedRows)
    {
        this.selectedRows = selectedRows;
    }

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

    private static final java.text.DateFormat dateFormatter = new java.text.SimpleDateFormat("yyyy/MM/dd");
    static { dateFormatter.setLenient(true); }

    public java.lang.String getDateAsString()
    {
        return (date == null) ? null : dateFormatter.format(date);
    }

    public void setDateAsString(java.lang.String date)
    {
        try
        {
            this.date = (org.apache.commons.lang.StringUtils.isBlank(date)) ? null : dateFormatter.parse(date);
        }
        catch (java.text.ParseException pe)
        {
            throw new java.lang.RuntimeException(pe);
        }
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

    private java.util.List publicUserBackingList;

    public java.util.List getPublicUserBackingList()
    {
        return this.publicUserBackingList;
    }

    public void setPublicUserBackingList(java.util.List publicUserBackingList)
    {
        this.publicUserBackingList = publicUserBackingList;
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

    private java.util.List choisesBackingList;

    public java.util.List getChoisesBackingList()
    {
        return this.choisesBackingList;
    }

    public void setChoisesBackingList(java.util.List choisesBackingList)
    {
        this.choisesBackingList = choisesBackingList;
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

    private java.util.List paymentMethodBackingList;

    public java.util.List getPaymentMethodBackingList()
    {
        return this.paymentMethodBackingList;
    }

    public void setPaymentMethodBackingList(java.util.List paymentMethodBackingList)
    {
        this.paymentMethodBackingList = paymentMethodBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        total = 0;
        carriage = 0;
        totalordernum = 0;
        shipped = false;
        date = null;
        temp = false;
        cancelled = false;
        removed = false;
        publicUser = null;
        publicUserBackingList = null;
        choises = null;
        choisesBackingList = null;
        paymentMethod = null;
        paymentMethodBackingList = null;
    }
}