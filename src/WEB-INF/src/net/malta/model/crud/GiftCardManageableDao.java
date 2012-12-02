// license-header java merge-point
package net.malta.model.crud;

public interface GiftCardManageableDao
{
    public net.malta.model.GiftCard create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises);

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.GiftCard update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises);

    public void delete(java.lang.Integer[] ids);

}