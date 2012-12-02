// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class CarriageManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements CarriageManageableDao
{
    private net.malta.model.CarriageDao dao;

    public void setDao(net.malta.model.CarriageDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.CarriageDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.ItemDao itemsDao = null;

    public void setItemsDao(net.malta.model.ItemDao itemsDao)
    {
        this.itemsDao = itemsDao;
    }

    protected net.malta.model.ItemDao getItemsDao()
    {
        return this.itemsDao;
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

    public net.malta.model.Carriage create(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
    {
        final net.malta.model.Carriage entity = new net.malta.model.CarriageImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setValue(value);
        final java.util.Set itemsEntities = (items != null && items.length > 0)
            ? this.findItemByIds(items)
            : java.util.Collections.EMPTY_SET;

        entity.setItems(itemsEntities);


        return (net.malta.model.Carriage)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.CarriageImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            criteria.add(Expression.eq("value", new java.lang.Integer(value)));
            if (items != null && items.length > 0) criteria.createCriteria("items").add(Expression.in("id", items));
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
            final Criteria criteria = session.createCriteria(net.malta.model.CarriageImpl.class);
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
            lists.put("items", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Carriage update(java.lang.Integer id, java.lang.String name, int value, java.lang.Integer[] items)
    {
        final net.malta.model.Carriage entity = this.getDao().load(id);

        entity.setName(name);
        entity.setValue(value);
        final java.util.Set itemsEntities = (items != null && items.length > 0)
            ? this.findItemByIds(items)
            : java.util.Collections.EMPTY_SET;

        entity.setItems(itemsEntities);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.CarriageImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}