// license-header java merge-point
package net.malta.model.crud;

public interface PrefectureManageableDao
{
    public net.malta.model.Prefecture create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses);

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Prefecture update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses);

    public void delete(java.lang.Integer[] ids);

}