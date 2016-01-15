// license-header java merge-point
package net.malta.model.crud;

public final class ProductForm
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

    private boolean pub;

    public boolean isPub()
    {
        return this.pub;
    }

    public void setPub(boolean pub)
    {
        this.pub = pub;
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

    private boolean removed;

    public boolean isRemoved()
    {
        return this.removed;
    }

    public void setRemoved(boolean removed)
    {
        this.removed = removed;
    }

    private java.lang.String mainitemname;

    public java.lang.String getMainitemname()
    {
        return this.mainitemname;
    }

    public void setMainitemname(java.lang.String mainitemname)
    {
        this.mainitemname = mainitemname;
    }

    private java.lang.Integer[] items;

    public java.lang.Integer[] getItems()
    {
        return this.items;
    }

    public void setItems(java.lang.Integer[] items)
    {
        this.items = items;
    }

    private java.util.List itemsBackingList;

    public java.util.List getItemsBackingList()
    {
        return this.itemsBackingList;
    }

    public void setItemsBackingList(java.util.List itemsBackingList)
    {
        this.itemsBackingList = itemsBackingList;
    }

    private java.lang.Integer category;

    public java.lang.Integer getCategory()
    {
        return this.category;
    }

    public void setCategory(java.lang.Integer category)
    {
        this.category = category;
    }

    private java.util.List categoryBackingList;

    public java.util.List getCategoryBackingList()
    {
        return this.categoryBackingList;
    }

    public void setCategoryBackingList(java.util.List categoryBackingList)
    {
        this.categoryBackingList = categoryBackingList;
    }

    private java.lang.Integer thumnail;

    public java.lang.Integer getThumnail()
    {
        return this.thumnail;
    }

    public void setThumnail(java.lang.Integer thumnail)
    {
        this.thumnail = thumnail;
    }

    private java.util.List thumnailBackingList;

    public java.util.List getThumnailBackingList()
    {
        return this.thumnailBackingList;
    }

    public void setThumnailBackingList(java.util.List thumnailBackingList)
    {
        this.thumnailBackingList = thumnailBackingList;
    }

    private java.lang.Integer slideshow;

    public java.lang.Integer getSlideshow()
    {
        return this.slideshow;
    }

    public void setSlideshow(java.lang.Integer slideshow)
    {
        this.slideshow = slideshow;
    }

    private java.util.List slideshowBackingList;

    public java.util.List getSlideshowBackingList()
    {
        return this.slideshowBackingList;
    }

    public void setSlideshowBackingList(java.util.List slideshowBackingList)
    {
        this.slideshowBackingList = slideshowBackingList;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        id = null;
        no = null;
        name = null;
        date = null;
        pub = false;
        pricewithtax = 0;
        size = null;
        material = null;
        catchcopy = null;
        description = null;
        note = null;
        stocknum = 0;
        removed = false;
        mainitemname = null;
        items = null;
        itemsBackingList = null;
        category = null;
        categoryBackingList = null;
        thumnail = null;
        thumnailBackingList = null;
        slideshow = null;
        slideshowBackingList = null;
    }
}