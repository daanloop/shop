// license-header java merge-point
package net.malta.model.crud;

public interface DbFileManageableService
{
    public net.malta.model.crud.DbFileValueObject create(java.lang.Integer id, byte[] data)
        throws Exception;

    public java.util.List read(java.lang.Integer id, byte[] data)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public byte[] getData(java.lang.Integer id)
        throws Exception;

    public net.malta.model.crud.DbFileValueObject update(java.lang.Integer id, byte[] data)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
