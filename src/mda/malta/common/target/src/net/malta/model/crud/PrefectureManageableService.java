// license-header java merge-point
package net.malta.model.crud;

public interface PrefectureManageableService
{
    public net.malta.model.crud.PrefectureValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.PrefectureValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
