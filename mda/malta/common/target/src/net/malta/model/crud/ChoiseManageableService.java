// license-header java merge-point
package net.malta.model.crud;

public interface ChoiseManageableService
{
    public net.malta.model.crud.ChoiseValueObject create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public java.util.List read(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.ChoiseValueObject update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
