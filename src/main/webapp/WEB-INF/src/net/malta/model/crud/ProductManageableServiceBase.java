// license-header java merge-point
package net.malta.model.crud;

public final class ProductManageableServiceBase
    implements ProductManageableService
{
    private net.malta.model.crud.ProductManageableDao dao;

    public void setDao(net.malta.model.crud.ProductManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.ProductManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.ProductValueObject create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
        throws Exception
    {
        if (no == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'no' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'name' can not be null");
        }

        if (date == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'date' can not be null");
        }

        if (size == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'size' can not be null");
        }

        if (material == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'material' can not be null");
        }

        if (catchcopy == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'catchcopy' can not be null");
        }

        if (description == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'description' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'note' can not be null");
        }

        if (mainitemname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'mainitemname' can not be null");
        }

        if (english == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'english' can not be null");
        }

        return toValueObject(dao.create(id, no, name, date, pub, pricewithtax, size, material, catchcopy, description, note, stocknum, removed, mainitemname, english, items, category, thumnail, slideshow));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
        throws Exception
    {
        return toValueObjects(dao.read(id, no, name, date, pub, pricewithtax, size, material, catchcopy, description, note, stocknum, removed, mainitemname, english, items, category, thumnail, slideshow));
    }

    public java.util.List readAll()
        throws Exception
    {
        return toValueObjects(dao.readAll());
    }

    public java.util.Map readBackingLists()
        throws Exception
    {
        return getDao().readBackingLists();
    }

    public net.malta.model.crud.ProductValueObject update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'id' can not be null");
        }

        if (no == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'no' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'name' can not be null");
        }

        if (date == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'date' can not be null");
        }

        if (size == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'size' can not be null");
        }

        if (material == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'material' can not be null");
        }

        if (catchcopy == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'catchcopy' can not be null");
        }

        if (description == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'description' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'note' can not be null");
        }

        if (mainitemname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'mainitemname' can not be null");
        }

        if (english == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow) - 'english' can not be null");
        }

        return toValueObject(dao.update(id, no, name, date, pub, pricewithtax, size, material, catchcopy, description, note, stocknum, removed, mainitemname, english, items, category, thumnail, slideshow));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ProductManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Product)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.ProductValueObject toValueObject(net.malta.model.Product entity)
    {
        final net.malta.model.crud.ProductValueObject valueObject = new net.malta.model.crud.ProductValueObject();

        valueObject.setId(entity.getId());
        valueObject.setNo(entity.getNo());
        valueObject.setName(entity.getName());
        valueObject.setDate(entity.getDate());
        valueObject.setPub(entity.isPub());
        valueObject.setPricewithtax(entity.getPricewithtax());
        valueObject.setSize(entity.getSize());
        valueObject.setMaterial(entity.getMaterial());
        valueObject.setCatchcopy(entity.getCatchcopy());
        valueObject.setDescription(entity.getDescription());
        valueObject.setNote(entity.getNote());
        valueObject.setStocknum(entity.getStocknum());
        valueObject.setRemoved(entity.isRemoved());
        valueObject.setMainitemname(entity.getMainitemname());
        valueObject.setEnglish(entity.getEnglish());

        final java.util.Collection items = entity.getItems();
        if (items == null || items.isEmpty())
        {
            valueObject.setItems(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[items.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = items.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Item element = (net.malta.model.Item)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setItems(values);
        }

        final net.malta.model.Category category = entity.getCategory();
        if (category != null)
        {
            valueObject.setCategory(category.getId());
        }

        final net.malta.model.Attachment thumnail = entity.getThumnail();
        if (thumnail != null)
        {
            valueObject.setThumnail(thumnail.getId());
        }

        final net.malta.model.Attachment slideshow = entity.getSlideshow();
        if (slideshow != null)
        {
            valueObject.setSlideshow(slideshow.getId());
        }

        return valueObject;
    }
}
