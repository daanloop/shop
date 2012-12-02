// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class AttachmentManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements AttachmentManageableDao
{
    private net.malta.model.AttachmentDao dao;

    public void setDao(net.malta.model.AttachmentDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.AttachmentDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.DbFileDao dbFileDao = null;

    public void setDbFileDao(net.malta.model.DbFileDao dbFileDao)
    {
        this.dbFileDao = dbFileDao;
    }

    protected net.malta.model.DbFileDao getDbFileDao()
    {
        return this.dbFileDao;
    }

    private net.malta.model.ItemDao aszoomDao = null;

    public void setAszoomDao(net.malta.model.ItemDao aszoomDao)
    {
        this.aszoomDao = aszoomDao;
    }

    protected net.malta.model.ItemDao getAszoomDao()
    {
        return this.aszoomDao;
    }

    private net.malta.model.ItemDao asdetailedDao = null;

    public void setAsdetailedDao(net.malta.model.ItemDao asdetailedDao)
    {
        this.asdetailedDao = asdetailedDao;
    }

    protected net.malta.model.ItemDao getAsdetailedDao()
    {
        return this.asdetailedDao;
    }

    private net.malta.model.ItemDao asdefaultDao = null;

    public void setAsdefaultDao(net.malta.model.ItemDao asdefaultDao)
    {
        this.asdefaultDao = asdefaultDao;
    }

    protected net.malta.model.ItemDao getAsdefaultDao()
    {
        return this.asdefaultDao;
    }

    private java.util.Set findDbFileByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DbFileImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    private java.util.Set findProductByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ProductImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    private java.util.Set findItemByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ItemImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.Attachment create(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
    {
        final net.malta.model.Attachment entity = new net.malta.model.AttachmentImpl();
        entity.setId(id);
        entity.setFiletype(filetype);
        entity.setWidth(width);
        entity.setHeight(height);
        entity.setWide(wide);
        net.malta.model.DbFile dbFileEntity = null;
        if (dbFile != null)
        {
            dbFileEntity = (net.malta.model.DbFile)getDbFileDao().load(dbFile);
        }

        entity.setDbFile(dbFileEntity);

        net.malta.model.Item aszoomEntity = null;
        if (aszoom != null)
        {
            aszoomEntity = (net.malta.model.Item)getAszoomDao().load(aszoom);
        }

        entity.setAszoom(aszoomEntity);

        net.malta.model.Item asdetailedEntity = null;
        if (asdetailed != null)
        {
            asdetailedEntity = (net.malta.model.Item)getAsdetailedDao().load(asdetailed);
        }

        entity.setAsdetailed(asdetailedEntity);

        net.malta.model.Item asdefaultEntity = null;
        if (asdefault != null)
        {
            asdefaultEntity = (net.malta.model.Item)getAsdefaultDao().load(asdefault);
        }

        entity.setAsdefault(asdefaultEntity);


        return (net.malta.model.Attachment)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.AttachmentImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (filetype != null)
                criteria.add(Expression.ilike("filetype", filetype, MatchMode.START));
            criteria.add(Expression.eq("width", new java.lang.Float(width)));
            criteria.add(Expression.eq("height", new java.lang.Float(height)));
            if (wide) criteria.add(Expression.eq("wide", java.lang.Boolean.TRUE));
                if (dbFile != null) criteria.createCriteria("dbFile").add(Expression.eq("id", dbFile));
            if (aszoom != null) criteria.createCriteria("aszoom").add(Expression.eq("id", aszoom));
            if (asdetailed != null) criteria.createCriteria("asdetailed").add(Expression.eq("id", asdetailed));
            if (asdefault != null) criteria.createCriteria("asdefault").add(Expression.eq("id", asdefault));
            criteria.setMaxResults(250);

            return criteria.list();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public java.util.List readAll()
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.AttachmentImpl.class);
            criteria.setMaxResults(250);
            return criteria.list();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public java.util.Map readBackingLists()
    {
        final java.util.Map lists = new java.util.HashMap();
        final Session session = this.getSession();

        try
        {
            lists.put("dbFile", session.createQuery("select item.id, item.id from net.malta.model.DbFile item order by item.id").list());
            lists.put("aszoom", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
            lists.put("asdetailed", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
            lists.put("asdefault", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Attachment update(java.lang.Integer id, java.lang.String filetype, float width, float height, boolean wide, java.lang.Integer dbFile, java.lang.Integer aszoom, java.lang.Integer asdetailed, java.lang.Integer asdefault)
    {
        final net.malta.model.Attachment entity = this.getDao().load(id);

        entity.setFiletype(filetype);
        entity.setWidth(width);
        entity.setHeight(height);
        entity.setWide(wide);
        net.malta.model.DbFile dbFileEntity = null;
        if (dbFile != null)
        {
            dbFileEntity = getDbFileDao().load(dbFile);
        }

        entity.setDbFile(dbFileEntity);

        net.malta.model.Item aszoomEntity = null;
        if (aszoom != null)
        {
            aszoomEntity = getAszoomDao().load(aszoom);
        }

        entity.setAszoom(aszoomEntity);

        net.malta.model.Item asdetailedEntity = null;
        if (asdetailed != null)
        {
            asdetailedEntity = getAsdetailedDao().load(asdetailed);
        }

        entity.setAsdetailed(asdetailedEntity);

        net.malta.model.Item asdefaultEntity = null;
        if (asdefault != null)
        {
            asdefaultEntity = getAsdefaultDao().load(asdefault);
        }

        entity.setAsdefault(asdefaultEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.AttachmentImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}