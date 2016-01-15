// license-header java merge-point
package net.malta.model.crud;

public interface PaymentMethodManageableDao
{
    public net.malta.model.PaymentMethod create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases);

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.PaymentMethod update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases);

    public void delete(java.lang.Integer[] ids);

}