// license-header java merge-point
package net.malta.model.crud;

public interface ChoiseManageableDao
{
    public net.malta.model.Choise create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises);

    public java.util.List read(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Choise update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises);

    public void delete(java.lang.Integer[] ids);

}