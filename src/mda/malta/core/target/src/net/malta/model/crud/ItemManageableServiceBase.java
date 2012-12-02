// license-header java merge-point
package net.malta.model.crud;

public final class ItemManageableServiceBase
    implements ItemManageableService
{
    private net.malta.model.crud.ItemManageableDao dao;

    public void setDao(net.malta.model.crud.ItemManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.ItemManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.ItemValueObject create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
        throws Exception
    {
        if (no == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'no' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'name' can not be null");
        }

        if (size == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'size' can not be null");
        }

        if (material == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'material' can not be null");
        }

        if (catchcopy == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'catchcopy' can not be null");
        }

        if (description == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'description' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'note' can not be null");
        }

        if (product == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'product' can not be null");
        }

        return toValueObject(dao.create(id, no, name, pricewithtax, size, material, catchcopy, description, note, stocknum, main, product, choises, carriage, zoom, detailed, defaultattachment));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
        throws Exception
    {
        return toValueObjects(dao.read(id, no, name, pricewithtax, size, material, catchcopy, description, note, stocknum, main, product, choises, carriage, zoom, detailed, defaultattachment));
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

    public net.malta.model.crud.ItemValueObject update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'id' can not be null");
        }

        if (no == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'no' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'name' can not be null");
        }

        if (size == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'size' can not be null");
        }

        if (material == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'material' can not be null");
        }

        if (catchcopy == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'catchcopy' can not be null");
        }

        if (description == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'description' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'note' can not be null");
        }

        if (product == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment) - 'product' can not be null");
        }

        return toValueObject(dao.update(id, no, name, pricewithtax, size, material, catchcopy, description, note, stocknum, main, product, choises, carriage, zoom, detailed, defaultattachment));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ItemManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Item)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.ItemValueObject toValueObject(net.malta.model.Item entity)
    {
        final net.malta.model.crud.ItemValueObject valueObject = new net.malta.model.crud.ItemValueObject();

        valueObject.setId(entity.getId());
        valueObject.setNo(entity.getNo());
        valueObject.setName(entity.getName());
        valueObject.setPricewithtax(entity.getPricewithtax());
        valueObject.setSize(entity.getSize());
        valueObject.setMaterial(entity.getMaterial());
        valueObject.setCatchcopy(entity.getCatchcopy());
        valueObject.setDescription(entity.getDescription());
        valueObject.setNote(entity.getNote());
        valueObject.setStocknum(entity.getStocknum());
        valueObject.setMain(entity.isMain());

        final net.malta.model.Product product = entity.getProduct();
        if (product != null)
        {
            valueObject.setProduct(product.getId());
        }

        final java.util.Collection choises = entity.getChoises();
        if (choises == null || choises.isEmpty())
        {
            valueObject.setChoises(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[choises.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = choises.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Choise element = (net.malta.model.Choise)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setChoises(values);
        }

        final net.malta.model.Carriage carriage = entity.getCarriage();
        if (carriage != null)
        {
            valueObject.setCarriage(carriage.getId());
        }

        final net.malta.model.Attachment zoom = entity.getZoom();
        if (zoom != null)
        {
            valueObject.setZoom(zoom.getId());
        }

        final java.util.Collection detailed = entity.getDetailed();
        if (detailed == null || detailed.isEmpty())
        {
            valueObject.setDetailed(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[detailed.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = detailed.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Attachment element = (net.malta.model.Attachment)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setDetailed(values);
        }

        final net.malta.model.Attachment defaultattachment = entity.getDefaultattachment();
        if (defaultattachment != null)
        {
            valueObject.setDefaultattachment(defaultattachment.getId());
        }

        return valueObject;
    }
}
