// license-header java merge-point
package net.malta.model.crud;

public final class StaticDataForm
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

    private java.lang.String fromaddress;

    public java.lang.String getFromaddress()
    {
        return this.fromaddress;
    }

    public void setFromaddress(java.lang.String fromaddress)
    {
        this.fromaddress = fromaddress;
    }

    private java.lang.String sitename;

    public java.lang.String getSitename()
    {
        return this.sitename;
    }

    public void setSitename(java.lang.String sitename)
    {
        this.sitename = sitename;
    }

    private java.lang.String basepath;

    public java.lang.String getBasepath()
    {
        return this.basepath;
    }

    public void setBasepath(java.lang.String basepath)
    {
        this.basepath = basepath;
    }

    private boolean unix;

    public boolean isUnix()
    {
        return this.unix;
    }

    public void setUnix(boolean unix)
    {
        this.unix = unix;
    }

    private int mapeventspan;

    public int getMapeventspan()
    {
        return this.mapeventspan;
    }

    public void setMapeventspan(int mapeventspan)
    {
        this.mapeventspan = mapeventspan;
    }

    private org.apache.struts.upload.FormFile noimage;

    public org.apache.struts.upload.FormFile getNoimage()
    {
        return this.noimage;
    }

    public void setNoimage(org.apache.struts.upload.FormFile noimage)
    {
        this.noimage = noimage;
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

    private java.lang.String creditcardprocesurl;

    public java.lang.String getCreditcardprocesurl()
    {
        return this.creditcardprocesurl;
    }

    public void setCreditcardprocesurl(java.lang.String creditcardprocesurl)
    {
        this.creditcardprocesurl = creditcardprocesurl;
    }

    private java.lang.String contract_code;

    public java.lang.String getContract_code()
    {
        return this.contract_code;
    }

    public void setContract_code(java.lang.String contract_code)
    {
        this.contract_code = contract_code;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        fromaddress = null;
        sitename = null;
        basepath = null;
        unix = false;
        mapeventspan = 0;
        noimage = null;
        carriage = 0;
        creditcardprocesurl = null;
        contract_code = null;
    }
}