// license-header java merge-point
package net.malta.model.crud;

public interface GiftCardManageableService
{
    public net.malta.model.crud.GiftCardValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.GiftCardValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
