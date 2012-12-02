// license-header java merge-point
package net.malta.model.crud;

public final class PaymentMethodManageableServiceBase
    implements PaymentMethodManageableService
{
    private net.malta.model.crud.PaymentMethodManageableDao dao;

    public void setDao(net.malta.model.crud.PaymentMethodManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.PaymentMethodManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.PaymentMethodValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases) - 'name' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases) - 'note' can not be null");
        }

        return toValueObject(dao.create(id, name, note, purchases));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, note, purchases));
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

    public net.malta.model.crud.PaymentMethodValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases) - 'name' can not be null");
        }

        if (note == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases) - 'note' can not be null");
        }

        return toValueObject(dao.update(id, name, note, purchases));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PaymentMethodManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.PaymentMethod)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.PaymentMethodValueObject toValueObject(net.malta.model.PaymentMethod entity)
    {
        final net.malta.model.crud.PaymentMethodValueObject valueObject = new net.malta.model.crud.PaymentMethodValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());
        valueObject.setNote(entity.getNote());

        final java.util.Collection purchases = entity.getPurchases();
        if (purchases == null || purchases.isEmpty())
        {
            valueObject.setPurchases(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[purchases.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = purchases.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Purchase element = (net.malta.model.Purchase)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setPurchases(values);
        }

        return valueObject;
    }
}
