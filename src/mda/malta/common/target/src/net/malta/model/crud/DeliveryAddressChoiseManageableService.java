// license-header java merge-point
package net.malta.model.crud;

public interface DeliveryAddressChoiseManageableService
{
    public net.malta.model.crud.DeliveryAddressChoiseValueObject create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception;

    public java.util.List read(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.DeliveryAddressChoiseValueObject update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
