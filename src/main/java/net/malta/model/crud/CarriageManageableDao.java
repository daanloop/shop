// license-header java merge-point
package net.malta.model.crud;

public interface CarriageManageableDao
{
    public net.malta.model.Carriage create(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items);

    public java.util.List read(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Carriage update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items);

    public void delete(java.lang.Integer[] ids);

}