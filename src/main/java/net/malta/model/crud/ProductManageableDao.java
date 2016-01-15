// license-header java merge-point
package net.malta.model.crud;

public interface ProductManageableDao
{
    public net.malta.model.Product create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow);

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Product update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow);

    public void delete(java.lang.Integer[] ids);

}