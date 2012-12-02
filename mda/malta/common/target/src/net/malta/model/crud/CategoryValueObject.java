// license-header java merge-point
package net.malta.model.crud;

public class CategoryValueObject
    implements java.io.Serializable
{
    private java.lang.Integer id;

    public java.lang.Integer getId()
    {
        return this.id;
    }

    public void setId(java.lang.Integer id)
    {
        this.id = id;
    }

    private java.lang.String name;

    public java.lang.String getName()
    {
        return this.name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }

    private java.lang.Integer[] products;

    public java.lang.Integer[] getProducts()
    {
        return this.products;
    }

    public void setProducts(java.lang.Integer[] products)
    {
        this.products = products;
    }

}