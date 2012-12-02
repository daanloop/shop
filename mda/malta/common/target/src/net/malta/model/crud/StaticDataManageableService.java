// license-header java merge-point
package net.malta.model.crud;

public interface StaticDataManageableService
{
    public net.malta.model.crud.StaticDataValueObject create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public byte[] getNoimage(java.lang.Integer id)
        throws Exception;

    public net.malta.model.crud.StaticDataValueObject update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
