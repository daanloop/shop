// license-header java merge-point
package net.malta.model.crud;

public final class PrefectureManageableServiceBase
    implements PrefectureManageableService
{
    private net.malta.model.crud.PrefectureManageableDao dao;

    public void setDao(net.malta.model.crud.PrefectureManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.PrefectureManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.PrefectureValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PrefectureManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses) - 'name' can not be null");
        }

        return toValueObject(dao.create(id, name, publicUsers, deliveryAddresses));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, publicUsers, deliveryAddresses));
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

    public net.malta.model.crud.PrefectureValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PrefectureManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PrefectureManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses) - 'name' can not be null");
        }

        return toValueObject(dao.update(id, name, publicUsers, deliveryAddresses));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PrefectureManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Prefecture)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.PrefectureValueObject toValueObject(net.malta.model.Prefecture entity)
    {
        final net.malta.model.crud.PrefectureValueObject valueObject = new net.malta.model.crud.PrefectureValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());

        final java.util.Collection publicUsers = entity.getPublicUsers();
        if (publicUsers == null || publicUsers.isEmpty())
        {
            valueObject.setPublicUsers(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[publicUsers.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = publicUsers.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.PublicUser element = (net.malta.model.PublicUser)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setPublicUsers(values);
        }

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

        return valueObject;
    }
}
