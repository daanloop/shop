// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class PrefectureManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements PrefectureManageableDao
{
    private net.malta.model.PrefectureDao dao;

    public void setDao(net.malta.model.PrefectureDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.PrefectureDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.PublicUserDao publicUsersDao = null;

    public void setPublicUsersDao(net.malta.model.PublicUserDao publicUsersDao)
    {
        this.publicUsersDao = publicUsersDao;
    }

    protected net.malta.model.PublicUserDao getPublicUsersDao()
    {
        return this.publicUsersDao;
    }

    private net.malta.model.DeliveryAddressDao deliveryAddressesDao = null;

    public void setDeliveryAddressesDao(net.malta.model.DeliveryAddressDao deliveryAddressesDao)
    {
        this.deliveryAddressesDao = deliveryAddressesDao;
    }

    protected net.malta.model.DeliveryAddressDao getDeliveryAddressesDao()
    {
        return this.deliveryAddressesDao;
    }

    private java.util.Set findPublicUserByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PublicUserImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    private java.util.Set findDeliveryAddressByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.Prefecture create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
    {
        final net.malta.model.Prefecture entity = new net.malta.model.PrefectureImpl();
        entity.setId(id);
        entity.setName(name);
        final java.util.Set publicUsersEntities = (publicUsers != null && publicUsers.length > 0)
            ? this.findPublicUserByIds(publicUsers)
            : java.util.Collections.EMPTY_SET;

        entity.setPublicUsers(publicUsersEntities);

        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);


        return (net.malta.model.Prefecture)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PrefectureImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (publicUsers != null && publicUsers.length > 0) criteria.createCriteria("publicUsers").add(Expression.in("id", publicUsers));
            if (deliveryAddresses != null && deliveryAddresses.length > 0) criteria.createCriteria("deliveryAddresses").add(Expression.in("id", deliveryAddresses));
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
            final Criteria criteria = session.createCriteria(net.malta.model.PrefectureImpl.class);
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
            lists.put("publicUsers", session.createQuery("select item.id, item.id from net.malta.model.PublicUser item order by item.id").list());
            lists.put("deliveryAddresses", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddress item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Prefecture update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] publicUsers, java.lang.Integer[] deliveryAddresses)
    {
        final net.malta.model.Prefecture entity = this.getDao().load(id);

        entity.setName(name);
        final java.util.Set publicUsersEntities = (publicUsers != null && publicUsers.length > 0)
            ? this.findPublicUserByIds(publicUsers)
            : java.util.Collections.EMPTY_SET;

        entity.setPublicUsers(publicUsersEntities);

        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.PrefectureImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}