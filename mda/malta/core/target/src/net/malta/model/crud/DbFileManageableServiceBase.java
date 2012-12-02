// license-header java merge-point
package net.malta.model.crud;

public final class DbFileManageableServiceBase
    implements DbFileManageableService
{
    private net.malta.model.crud.DbFileManageableDao dao;

    public void setDao(net.malta.model.crud.DbFileManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.DbFileManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.DbFileValueObject create(java.lang.Integer id, byte[] data)
        throws Exception
    {
        if (data == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DbFileManageableService.create(java.lang.Integer id, byte[] data) - 'data' can not be null");
        }

        return toValueObject(dao.create(id, data));
    }

    public java.util.List read(java.lang.Integer id, byte[] data)
        throws Exception
    {
        return toValueObjects(dao.read(id, data));
    }

    public java.util.List readAll()
        throws Exception
    {
        return toValueObjects(dao.readAll());
    }

    public byte[] getData(java.lang.Integer id)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DbFileManageableService.getData(java.lang.Integer id) - 'id' can not be null");
        }

        return dao.getData(id);
    }

    public net.malta.model.crud.DbFileValueObject update(java.lang.Integer id, byte[] data)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DbFileManageableService.update(java.lang.Integer id, byte[] data) - 'id' can not be null");
        }

        if (data == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DbFileManageableService.update(java.lang.Integer id, byte[] data) - 'data' can not be null");
        }

        return toValueObject(dao.update(id, data));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DbFileManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.DbFile)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.DbFileValueObject toValueObject(net.malta.model.DbFile entity)
    {
        final net.malta.model.crud.DbFileValueObject valueObject = new net.malta.model.crud.DbFileValueObject();

        valueObject.setId(entity.getId());
        valueObject.setData(entity.getData());

        return valueObject;
    }
}
