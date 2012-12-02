// license-header java merge-point
package net.malta.model.crud;

public final class AttachmentManageableServiceBase
    implements AttachmentManageableService
{
    private net.malta.model.crud.AttachmentManageableDao dao;

    public void setDao(net.malta.model.crud.AttachmentManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.AttachmentManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.AttachmentValueObject create(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception
    {
        if (filetype == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.AttachmentManageableService.create(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault) - 'filetype' can not be null");
        }

        return toValueObject(dao.create(id, filetype, width, height, wide, dbFile, aszoom, asdetailed, asdefault));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception
    {
        return toValueObjects(dao.read(id, filetype, width, height, wide, dbFile, aszoom, asdetailed, asdefault));
    }

    public java.util.List readAll()
        throws Exception
    {
        return toValueObjects(dao.readAll());
    }

    public java.util.Map readBackingLists()
        throws Exception
    {
        return getDao().readBackingLists();
    }

    public net.malta.model.crud.AttachmentValueObject update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.AttachmentManageableService.update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault) - 'id' can not be null");
        }

        if (filetype == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.AttachmentManageableService.update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault) - 'filetype' can not be null");
        }

        return toValueObject(dao.update(id, filetype, width, height, wide, dbFile, aszoom, asdetailed, asdefault));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.AttachmentManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.Attachment)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.AttachmentValueObject toValueObject(net.malta.model.Attachment entity)
    {
        final net.malta.model.crud.AttachmentValueObject valueObject = new net.malta.model.crud.AttachmentValueObject();

        valueObject.setId(entity.getId());
        valueObject.setFiletype(entity.getFiletype());
        valueObject.setWidth(entity.getWidth());
        valueObject.setHeight(entity.getHeight());
        valueObject.setWide(entity.isWide());

        final net.malta.model.DbFile dbFile = entity.getDbFile();
        if (dbFile != null)
        {
            valueObject.setDbFile(dbFile.getId());
        }

        final net.malta.model.Item aszoom = entity.getAszoom();
        if (aszoom != null)
        {
            valueObject.setAszoom(aszoom.getId());
        }

        final net.malta.model.Item asdetailed = entity.getAsdetailed();
        if (asdetailed != null)
        {
            valueObject.setAsdetailed(asdetailed.getId());
        }

        final net.malta.model.Item asdefault = entity.getAsdefault();
        if (asdefault != null)
        {
            valueObject.setAsdefault(asdefault.getId());
        }

        return valueObject;
    }
}
