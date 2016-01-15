// license-header java merge-point
package net.malta.model.crud;

public interface StaticDataManageableDao
{
    public net.malta.model.StaticData create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code);

    public java.util.List read(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code);

    public java.util.List readAll();

    public byte[] getNoimage(java.lang.Integer id);

    public net.malta.model.StaticData update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code);

    public void delete(java.lang.Integer[] ids);

}