// license-header java merge-point
package net.malta.model.crud;

public interface PaymentMethodManageableService
{
    public net.malta.model.crud.PaymentMethodValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.PaymentMethodValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
