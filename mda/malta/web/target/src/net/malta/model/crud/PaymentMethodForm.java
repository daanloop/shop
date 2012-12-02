// license-header java merge-point
package net.malta.model.crud;

public final class PaymentMethodForm
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

    private java.util.List purchasesBackingList;

    public java.util.List getPurchasesBackingList()
    {
        return this.purchasesBackingList;
    }

    public void setPurchasesBackingList(java.util.List purchasesBackingList)
    {
        this.purchasesBackingList = purchasesBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        name = null;
        note = null;
        purchases = null;
        purchasesBackingList = null;
    }
}