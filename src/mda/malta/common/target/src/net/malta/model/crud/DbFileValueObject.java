// license-header java merge-point
package net.malta.model.crud;

public class DbFileValueObject
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

    private byte[] data;

    public byte[] getData()
    {
        return this.data;
    }

    public void setData(byte[] data)
    {
        this.data = data;
    }

}