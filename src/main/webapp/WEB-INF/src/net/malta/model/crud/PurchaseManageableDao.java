// license-header java merge-point
package net.malta.model.crud;

public interface PurchaseManageableDao
{
    public net.malta.model.Purchase create(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod);

    public java.util.List read(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Purchase update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod);

    public void delete(java.lang.Integer[] ids);

}