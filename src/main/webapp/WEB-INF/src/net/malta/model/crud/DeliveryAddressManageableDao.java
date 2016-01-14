// license-header java merge-point
package net.malta.model.crud;

public interface DeliveryAddressManageableDao
{
    public net.malta.model.DeliveryAddress create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture);

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.DeliveryAddress update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture);

    public void delete(java.lang.Integer[] ids);

}