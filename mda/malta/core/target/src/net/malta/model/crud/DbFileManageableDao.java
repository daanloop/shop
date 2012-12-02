// license-header java merge-point
package net.malta.model.crud;

public interface DbFileManageableDao
{
    public net.malta.model.DbFile create(java.lang.Integer id, byte[] data);

    public java.util.List read(java.lang.Integer id, byte[] data);

    public java.util.List readAll();

    public byte[] getData(java.lang.Integer id);

    public net.malta.model.DbFile update(java.lang.Integer id, byte[] data);

    public void delete(java.lang.Integer[] ids);

}