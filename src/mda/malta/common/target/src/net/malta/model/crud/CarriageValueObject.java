// license-header java merge-point
package net.malta.model.crud;

public class CarriageValueObject
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

    private int value;

    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    private java.lang.Integer[] items;

    public java.lang.Integer[] getItems()
    {
        return this.items;
    }

    public void setItems(java.lang.Integer[] items)
    {
        this.items = items;
    }

}