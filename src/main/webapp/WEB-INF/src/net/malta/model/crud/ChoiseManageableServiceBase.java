// license-header java merge-point
package net.malta.model.crud;

public final class ChoiseManageableServiceBase
    implements ChoiseManageableService
{
    private net.malta.model.crud.ChoiseManageableDao dao;

    public void setDao(net.malta.model.crud.ChoiseManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.ChoiseManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.ChoiseValueObject create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        if (purchase == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises) - 'purchase' can not be null");
        }

        if (item == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises) - 'item' can not be null");
        }

        return toValueObject(dao.create(id, ordernum, pricewithtax, wrapping, purchase, item, deliveryAddressChoises));
    }

    public java.util.List read(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        return toValueObjects(dao.read(id, ordernum, pricewithtax, wrapping, purchase, item, deliveryAddressChoises));
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

    public net.malta.model.crud.ChoiseValueObject update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises) - 'id' can not be null");
        }

        if (purchase == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises) - 'purchase' can not be null");
        }

        if (item == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises) - 'item' can not be null");
        }

        return toValueObject(dao.update(id, ordernum, pricewithtax, wrapping, purchase, item, deliveryAddressChoises));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.ChoiseManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Choise)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.ChoiseValueObject toValueObject(net.malta.model.Choise entity)
    {
        final net.malta.model.crud.ChoiseValueObject valueObject = new net.malta.model.crud.ChoiseValueObject();

        valueObject.setId(entity.getId());
        valueObject.setOrdernum(entity.getOrdernum());
        valueObject.setPricewithtax(entity.getPricewithtax());
        valueObject.setWrapping(entity.isWrapping());

        final net.malta.model.Purchase purchase = entity.getPurchase();
        if (purchase != null)
        {
            valueObject.setPurchase(purchase.getId());
        }

        final net.malta.model.Item item = entity.getItem();
        if (item != null)
        {
            valueObject.setItem(item.getId());
        }

        final java.util.Collection deliveryAddressChoises = entity.getDeliveryAddressChoises();
        if (deliveryAddressChoises == null || deliveryAddressChoises.isEmpty())
        {
            valueObject.setDeliveryAddressChoises(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[deliveryAddressChoises.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = deliveryAddressChoises.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.DeliveryAddressChoise element = (net.malta.model.DeliveryAddressChoise)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setDeliveryAddressChoises(values);
        }

        return valueObject;
    }
}
