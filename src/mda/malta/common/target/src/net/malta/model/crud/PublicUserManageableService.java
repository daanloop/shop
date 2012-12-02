// license-header java merge-point
package net.malta.model.crud;

public interface PublicUserManageableService
{
    public net.malta.model.crud.PublicUserValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.PublicUserValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
