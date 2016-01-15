// license-header java merge-point
package net.malta.model.crud;

public interface ItemManageableDao
{
    public net.malta.model.Item create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment);

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Item update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment);

    public void delete(java.lang.Integer[] ids);

}