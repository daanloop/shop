// license-header java merge-point
package net.malta.model.crud;

public interface CategoryManageableService
{
    public net.malta.model.crud.CategoryValueObject create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.CategoryValueObject update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
