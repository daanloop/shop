// license-header java merge-point
package net.malta.model.crud;

public final class AttachmentForm
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

    private java.lang.String filetype;

    public java.lang.String getFiletype()
    {
        return this.filetype;
    }

    public void setFiletype(java.lang.String filetype)
    {
        this.filetype = filetype;
    }

    private float width;

    public float getWidth()
    {
        return this.width;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    private float height;

    public float getHeight()
    {
        return this.height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    private boolean wide;

    public boolean isWide()
    {
        return this.wide;
    }

    public void setWide(boolean wide)
    {
        this.wide = wide;
    }

    private java.lang.Integer dbFile;

    public java.lang.Integer getDbFile()
    {
        return this.dbFile;
    }

    public void setDbFile(java.lang.Integer dbFile)
    {
        this.dbFile = dbFile;
    }

    private java.util.List dbFileBackingList;

    public java.util.List getDbFileBackingList()
    {
        return this.dbFileBackingList;
    }

    public void setDbFileBackingList(java.util.List dbFileBackingList)
    {
        this.dbFileBackingList = dbFileBackingList;
    }

    private java.lang.Integer aszoom;

    public java.lang.Integer getAszoom()
    {
        return this.aszoom;
    }

    public void setAszoom(java.lang.Integer aszoom)
    {
        this.aszoom = aszoom;
    }

    private java.util.List aszoomBackingList;

    public java.util.List getAszoomBackingList()
    {
        return this.aszoomBackingList;
    }

    public void setAszoomBackingList(java.util.List aszoomBackingList)
    {
        this.aszoomBackingList = aszoomBackingList;
    }

    private java.lang.Integer asdetailed;

    public java.lang.Integer getAsdetailed()
    {
        return this.asdetailed;
    }

    public void setAsdetailed(java.lang.Integer asdetailed)
    {
        this.asdetailed = asdetailed;
    }

    private java.util.List asdetailedBackingList;

    public java.util.List getAsdetailedBackingList()
    {
        return this.asdetailedBackingList;
    }

    public void setAsdetailedBackingList(java.util.List asdetailedBackingList)
    {
        this.asdetailedBackingList = asdetailedBackingList;
    }

    private java.lang.Integer asdefault;

    public java.lang.Integer getAsdefault()
    {
        return this.asdefault;
    }

    public void setAsdefault(java.lang.Integer asdefault)
    {
        this.asdefault = asdefault;
    }

    private java.util.List asdefaultBackingList;

    public java.util.List getAsdefaultBackingList()
    {
        return this.asdefaultBackingList;
    }

    public void setAsdefaultBackingList(java.util.List asdefaultBackingList)
    {
        this.asdefaultBackingList = asdefaultBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        filetype = null;
        width = 0;
        height = 0;
        wide = false;
        dbFile = null;
        dbFileBackingList = null;
        aszoom = null;
        aszoomBackingList = null;
        asdetailed = null;
        asdetailedBackingList = null;
        asdefault = null;
        asdefaultBackingList = null;
    }
}