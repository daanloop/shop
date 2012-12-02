// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class DbFileManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements DbFileManageableDao
{
    private net.malta.model.DbFileDao dao;

    public void setDao(net.malta.model.DbFileDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.DbFileDao getDao()
    {
        return this.dao;
    }

    private java.util.Set findAttachmentByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.AttachmentImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.DbFile create(java.lang.Integer id, byte[] data)
    {
        final net.malta.model.DbFile entity = new net.malta.model.DbFileImpl();
        entity.setId(id);
        entity.setData(data);

        return (net.malta.model.DbFile)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, byte[] data)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DbFileImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (data != null)
            criteria.add(Expression.eq("data", data));
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
            final Criteria criteria = session.createCriteria(net.malta.model.DbFileImpl.class);
            criteria.setMaxResults(250);
            return criteria.list();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public byte[] getData(java.lang.Integer id)
    {
        try
        {
            byte[] value = null;

            final org.hibernate.Query queryObject = super.getSession(false).createQuery("select entity.data from net.malta.model.DbFile as entity where entity.id = :id");
            queryObject.setParameter("id", id);
            final java.util.Iterator iterator = queryObject.iterate();
            if (iterator.hasNext())
            {
                value = (byte[])iterator.next();
            }

            return value;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.DbFile update(java.lang.Integer id, byte[] data)
    {
        final net.malta.model.DbFile entity = this.getDao().load(id);

        entity.setData(data);

        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.DbFileImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}