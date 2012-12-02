// license-header java merge-point
package net.malta.model.crud;

public interface CategoryManageableDao
{
    public net.malta.model.Category create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products);

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Category update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products);

    public void delete(java.lang.Integer[] ids);

}