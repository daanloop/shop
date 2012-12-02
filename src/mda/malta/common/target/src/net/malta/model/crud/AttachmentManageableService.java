// license-header java merge-point
package net.malta.model.crud;

public interface AttachmentManageableService
{
    public net.malta.model.crud.AttachmentValueObject create(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception;

    public java.util.List read(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception;

    public java.util.List readAll()
        throws Exception;

    public java.util.Map readBackingLists()
        throws Exception;

    public net.malta.model.crud.AttachmentValueObject update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception;

    public void delete(java.lang.Integer[] ids)
        throws Exception;

}
