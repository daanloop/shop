// license-header java merge-point
package net.malta.model.crud;

public final class GiftCardManageableServiceBase
    implements GiftCardManageableService
{
    private net.malta.model.crud.GiftCardManageableDao dao;

    public void setDao(net.malta.model.crud.GiftCardManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.GiftCardManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.GiftCardValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.GiftCardManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises) - 'name' can not be null");
        }

        return toValueObject(dao.create(id, name, deliveryAddresses, deliveryAddressChoises));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, deliveryAddresses, deliveryAddressChoises));
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

    public net.malta.model.crud.GiftCardValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.GiftCardManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.GiftCardManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises) - 'name' can not be null");
        }

        return toValueObject(dao.update(id, name, deliveryAddresses, deliveryAddressChoises));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.GiftCardManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.GiftCard)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.GiftCardValueObject toValueObject(net.malta.model.GiftCard entity)
    {
        final net.malta.model.crud.GiftCardValueObject valueObject = new net.malta.model.crud.GiftCardValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());

        final java.util.Collection deliveryAddresses = entity.getDeliveryAddresses();
        if (deliveryAddresses == null || deliveryAddresses.isEmpty())
        {
            valueObject.setDeliveryAddresses(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[deliveryAddresses.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = deliveryAddresses.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.DeliveryAddress element = (net.malta.model.DeliveryAddress)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setDeliveryAddresses(values);
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
