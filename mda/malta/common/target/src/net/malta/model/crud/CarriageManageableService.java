// license-header java merge-point
package net.malta.model.crud;

public interface CarriageManageableService
{
    public net.malta.model.crud.CarriageValueObject create(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.CarriageValueObject update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
