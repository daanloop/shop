// license-header java merge-point
package net.malta.model.crud;

public final class ChoiseForm
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

    private java.util.List purchaseBackingList;

    public java.util.List getPurchaseBackingList()
    {
        return this.purchaseBackingList;
    }

    public void setPurchaseBackingList(java.util.List purchaseBackingList)
    {
        this.purchaseBackingList = purchaseBackingList;
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

    private java.util.List itemBackingList;

    public java.util.List getItemBackingList()
    {
        return this.itemBackingList;
    }

    public void setItemBackingList(java.util.List itemBackingList)
    {
        this.itemBackingList = itemBackingList;
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

    private java.util.List deliveryAddressChoisesBackingList;

    public java.util.List getDeliveryAddressChoisesBackingList()
    {
        return this.deliveryAddressChoisesBackingList;
    }

    public void setDeliveryAddressChoisesBackingList(java.util.List deliveryAddressChoisesBackingList)
    {
        this.deliveryAddressChoisesBackingList = deliveryAddressChoisesBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        ordernum = 0;
        pricewithtax = 0;
        wrapping = false;
        purchase = null;
        purchaseBackingList = null;
        item = null;
        itemBackingList = null;
        deliveryAddressChoises = null;
        deliveryAddressChoisesBackingList = null;
    }
}