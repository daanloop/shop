// license-header java merge-point
package net.malta.model.crud;

public interface DeliveryAddressChoiseManageableDao
{
    public net.malta.model.DeliveryAddressChoise create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard);

    public java.util.List read(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.DeliveryAddressChoise update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard);

    public void delete(java.lang.Integer[] ids);

}