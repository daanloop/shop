// license-header java merge-point
package net.malta.model.crud;

public final class CategoryManageableServiceBase
    implements CategoryManageableService
{
    private net.malta.model.crud.CategoryManageableDao dao;

    public void setDao(net.malta.model.crud.CategoryManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.CategoryManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.CategoryValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CategoryManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products) - 'name' can not be null");
        }

        return toValueObject(dao.create(id, name, products));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, products));
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

    public net.malta.model.crud.CategoryValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CategoryManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CategoryManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products) - 'name' can not be null");
        }

        return toValueObject(dao.update(id, name, products));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.CategoryManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Category)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.CategoryValueObject toValueObject(net.malta.model.Category entity)
    {
        final net.malta.model.crud.CategoryValueObject valueObject = new net.malta.model.crud.CategoryValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());

        final java.util.Collection products = entity.getProducts();
        if (products == null || products.isEmpty())
        {
            valueObject.setProducts(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[products.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = products.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Product element = (net.malta.model.Product)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setProducts(values);
        }

        return valueObject;
    }
}
