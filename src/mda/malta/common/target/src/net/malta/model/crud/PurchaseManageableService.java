// license-header java merge-point
package net.malta.model.crud;

public interface PurchaseManageableService
{
    public net.malta.model.crud.PurchaseValueObject create(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception;

    public java.util.List read(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.PurchaseValueObject update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
