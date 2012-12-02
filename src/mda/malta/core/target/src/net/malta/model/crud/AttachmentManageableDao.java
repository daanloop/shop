// license-header java merge-point
package net.malta.model.crud;

public interface AttachmentManageableDao
{
    public net.malta.model.Attachment create(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault);

    public java.util.List read(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault);

    public java.util.List readAll();

    public java.util.Map readBackingLists();

    public net.malta.model.Attachment update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault);

    public void delete(java.lang.Integer[] ids);

}