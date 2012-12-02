// license-header java merge-point
package net.malta.model.crud;

public final class PrefectureForm
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

    private java.lang.Integer[] publicUsers;

    public java.lang.Integer[] getPublicUsers()
    {
        return this.publicUsers;
    }

    public void setPublicUsers(java.lang.Integer[] publicUsers)
    {
        this.publicUsers = publicUsers;
    }

    private java.util.List publicUsersBackingList;

    public java.util.List getPublicUsersBackingList()
    {
        return this.publicUsersBackingList;
    }

    public void setPublicUsersBackingList(java.util.List publicUsersBackingList)
    {
        this.publicUsersBackingList = publicUsersBackingList;
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

    private java.util.List deliveryAddressesBackingList;

    public java.util.List getDeliveryAddressesBackingList()
    {
        return this.deliveryAddressesBackingList;
    }

    public void setDeliveryAddressesBackingList(java.util.List deliveryAddressesBackingList)
    {
        this.deliveryAddressesBackingList = deliveryAddressesBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        name = null;
        publicUsers = null;
        publicUsersBackingList = null;
        deliveryAddresses = null;
        deliveryAddressesBackingList = null;
    }
}