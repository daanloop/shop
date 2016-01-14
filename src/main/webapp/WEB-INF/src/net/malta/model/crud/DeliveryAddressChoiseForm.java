// license-header java merge-point
package net.malta.model.crud;

public final class DeliveryAddressChoiseForm
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

    private java.lang.String preferreddate;

    public java.lang.String getPreferreddate()
    {
        return this.preferreddate;
    }

    public void setPreferreddate(java.lang.String preferreddate)
    {
        this.preferreddate = preferreddate;
    }

    private java.lang.String preferredtime;

    public java.lang.String getPreferredtime()
    {
        return this.preferredtime;
    }

    public void setPreferredtime(java.lang.String preferredtime)
    {
        this.preferredtime = preferredtime;
    }

    private java.lang.Integer deliveryAddress;

    public java.lang.Integer getDeliveryAddress()
    {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(java.lang.Integer deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    private java.util.List deliveryAddressBackingList;

    public java.util.List getDeliveryAddressBackingList()
    {
        return this.deliveryAddressBackingList;
    }

    public void setDeliveryAddressBackingList(java.util.List deliveryAddressBackingList)
    {
        this.deliveryAddressBackingList = deliveryAddressBackingList;
    }

    private java.lang.Integer choise;

    public java.lang.Integer getChoise()
    {
        return this.choise;
    }

    public void setChoise(java.lang.Integer choise)
    {
        this.choise = choise;
    }

    private java.util.List choiseBackingList;

    public java.util.List getChoiseBackingList()
    {
        return this.choiseBackingList;
    }

    public void setChoiseBackingList(java.util.List choiseBackingList)
    {
        this.choiseBackingList = choiseBackingList;
    }

    private java.lang.Integer giftCard;

    public java.lang.Integer getGiftCard()
    {
        return this.giftCard;
    }

    public void setGiftCard(java.lang.Integer giftCard)
    {
        this.giftCard = giftCard;
    }

    private java.util.List giftCardBackingList;

    public java.util.List getGiftCardBackingList()
    {
        return this.giftCardBackingList;
    }

    public void setGiftCardBackingList(java.util.List giftCardBackingList)
    {
        this.giftCardBackingList = giftCardBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        ordernum = 0;
        preferreddate = null;
        preferredtime = null;
        deliveryAddress = null;
        deliveryAddressBackingList = null;
        choise = null;
        choiseBackingList = null;
        giftCard = null;
        giftCardBackingList = null;
    }
}