// license-header java merge-point
package net.malta.model.crud;

public final class CarriageManageableServiceBase
    implements CarriageManageableService
{
    private net.malta.model.crud.CarriageManageableDao dao;

    public void setDao(net.malta.model.crud.CarriageManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.CarriageManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.CarriageValueObject create(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CarriageManageableService.create(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items) - 'name' can not be null");
        }

        return toValueObject(dao.create(id, name, value, items));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, value, items));
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

    public net.malta.model.crud.CarriageValueObject update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CarriageManageableService.update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CarriageManageableService.update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items) - 'name' can not be null");
        }

        return toValueObject(dao.update(id, name, value, items));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CarriageManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Carriage)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.CarriageValueObject toValueObject(net.malta.model.Carriage entity)
    {
        final net.malta.model.crud.CarriageValueObject valueObject = new net.malta.model.crud.CarriageValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());
        valueObject.setValue(entity.getValue());

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

        return valueObject;
    }
}
