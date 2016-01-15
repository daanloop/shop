// license-header java merge-point
package net.malta.model.crud;

public final class PurchaseManageableServiceBase
    implements PurchaseManageableService
{
    private net.malta.model.crud.PurchaseManageableDao dao;

    public void setDao(net.malta.model.crud.PurchaseManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.PurchaseManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.PurchaseValueObject create(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception
    {
        if (date == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PurchaseManageableService.create(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod) - 'date' can not be null");
        }

        return toValueObject(dao.create(id, total, carriage, totalordernum, shipped, date, temp, cancelled, removed, publicUser, choises, paymentMethod));
    }

    public java.util.List read(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception
    {
        return toValueObjects(dao.read(id, total, carriage, totalordernum, shipped, date, temp, cancelled, removed, publicUser, choises, paymentMethod));
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

    public net.malta.model.crud.PurchaseValueObject update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PurchaseManageableService.update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod) - 'id' can not be null");
        }

        if (date == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PurchaseManageableService.update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod) - 'date' can not be null");
        }

        return toValueObject(dao.update(id, total, carriage, totalordernum, shipped, date, temp, cancelled, removed, publicUser, choises, paymentMethod));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PurchaseManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Purchase)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.PurchaseValueObject toValueObject(net.malta.model.Purchase entity)
    {
        final net.malta.model.crud.PurchaseValueObject valueObject = new net.malta.model.crud.PurchaseValueObject();

        valueObject.setId(entity.getId());
        valueObject.setTotal(entity.getTotal());
        valueObject.setCarriage(entity.getCarriage());
        valueObject.setTotalordernum(entity.getTotalordernum());
        valueObject.setShipped(entity.isShipped());
        valueObject.setDate(entity.getDate());
        valueObject.setTemp(entity.isTemp());
        valueObject.setCancelled(entity.isCancelled());
        valueObject.setRemoved(entity.isRemoved());

        final net.malta.model.PublicUser publicUser = entity.getPublicUser();
        if (publicUser != null)
        {
            valueObject.setPublicUser(publicUser.getId());
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

        final net.malta.model.PaymentMethod paymentMethod = entity.getPaymentMethod();
        if (paymentMethod != null)
        {
            valueObject.setPaymentMethod(paymentMethod.getId());
        }

        return valueObject;
    }
}
