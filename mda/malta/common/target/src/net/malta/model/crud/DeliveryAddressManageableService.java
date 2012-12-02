// license-header java merge-point
package net.malta.model.crud;

public interface DeliveryAddressManageableService
{
    public net.malta.model.crud.DeliveryAddressValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.DeliveryAddressValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
