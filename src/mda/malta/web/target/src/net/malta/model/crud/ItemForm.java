// license-header java merge-point
package net.malta.model.crud;

public final class ItemForm
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

    private java.lang.String no;

    public java.lang.String getNo()
    {
        return this.no;
    }

    public void setNo(java.lang.String no)
    {
        this.no = no;
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

    private int pricewithtax;

    public int getPricewithtax()
    {
        return this.pricewithtax;
    }

    public void setPricewithtax(int pricewithtax)
    {
        this.pricewithtax = pricewithtax;
    }

    private java.lang.String size;

    public java.lang.String getSize()
    {
        return this.size;
    }

    public void setSize(java.lang.String size)
    {
        this.size = size;
    }

    private java.lang.String material;

    public java.lang.String getMaterial()
    {
        return this.material;
    }

    public void setMaterial(java.lang.String material)
    {
        this.material = material;
    }

    private java.lang.String catchcopy;

    public java.lang.String getCatchcopy()
    {
        return this.catchcopy;
    }

    public void setCatchcopy(java.lang.String catchcopy)
    {
        this.catchcopy = catchcopy;
    }

    private java.lang.String description;

    public java.lang.String getDescription()
    {
        return this.description;
    }

    public void setDescription(java.lang.String description)
    {
        this.description = description;
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

    private int stocknum;

    public int getStocknum()
    {
        return this.stocknum;
    }

    public void setStocknum(int stocknum)
    {
        this.stocknum = stocknum;
    }

    private boolean main;

    public boolean isMain()
    {
        return this.main;
    }

    public void setMain(boolean main)
    {
        this.main = main;
    }

    private java.lang.Integer product;

    public java.lang.Integer getProduct()
    {
        return this.product;
    }

    public void setProduct(java.lang.Integer product)
    {
        this.product = product;
    }

    private java.util.List productBackingList;

    public java.util.List getProductBackingList()
    {
        return this.productBackingList;
    }

    public void setProductBackingList(java.util.List productBackingList)
    {
        this.productBackingList = productBackingList;
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

    private java.lang.Integer carriage;

    public java.lang.Integer getCarriage()
    {
        return this.carriage;
    }

    public void setCarriage(java.lang.Integer carriage)
    {
        this.carriage = carriage;
    }

    private java.util.List carriageBackingList;

    public java.util.List getCarriageBackingList()
    {
        return this.carriageBackingList;
    }

    public void setCarriageBackingList(java.util.List carriageBackingList)
    {
        this.carriageBackingList = carriageBackingList;
    }

    private java.lang.Integer zoom;

    public java.lang.Integer getZoom()
    {
        return this.zoom;
    }

    public void setZoom(java.lang.Integer zoom)
    {
        this.zoom = zoom;
    }

    private java.util.List zoomBackingList;

    public java.util.List getZoomBackingList()
    {
        return this.zoomBackingList;
    }

    public void setZoomBackingList(java.util.List zoomBackingList)
    {
        this.zoomBackingList = zoomBackingList;
    }

    private java.lang.Integer[] detailed;

    public java.lang.Integer[] getDetailed()
    {
        return this.detailed;
    }

    public void setDetailed(java.lang.Integer[] detailed)
    {
        this.detailed = detailed;
    }

    private java.util.List detailedBackingList;

    public java.util.List getDetailedBackingList()
    {
        return this.detailedBackingList;
    }

    public void setDetailedBackingList(java.util.List detailedBackingList)
    {
        this.detailedBackingList = detailedBackingList;
    }

    private java.lang.Integer defaultattachment;

    public java.lang.Integer getDefaultattachment()
    {
        return this.defaultattachment;
    }

    public void setDefaultattachment(java.lang.Integer defaultattachment)
    {
        this.defaultattachment = defaultattachment;
    }

    private java.util.List defaultattachmentBackingList;

    public java.util.List getDefaultattachmentBackingList()
    {
        return this.defaultattachmentBackingList;
    }

    public void setDefaultattachmentBackingList(java.util.List defaultattachmentBackingList)
    {
        this.defaultattachmentBackingList = defaultattachmentBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        no = null;
        name = null;
        pricewithtax = 0;
        size = null;
        material = null;
        catchcopy = null;
        description = null;
        note = null;
        stocknum = 0;
        main = false;
        product = null;
        productBackingList = null;
        choises = null;
        choisesBackingList = null;
        carriage = null;
        carriageBackingList = null;
        zoom = null;
        zoomBackingList = null;
        detailed = null;
        detailedBackingList = null;
        defaultattachment = null;
        defaultattachmentBackingList = null;
    }
}