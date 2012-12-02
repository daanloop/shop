// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class GiftCardManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements GiftCardManageableDao
{
    private net.malta.model.GiftCardDao dao;

    public void setDao(net.malta.model.GiftCardDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.GiftCardDao getDao()
    {
        return this.dao;
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

    private net.malta.model.DeliveryAddressChoiseDao deliveryAddressChoisesDao = null;

    public void setDeliveryAddressChoisesDao(net.malta.model.DeliveryAddressChoiseDao deliveryAddressChoisesDao)
    {
        this.deliveryAddressChoisesDao = deliveryAddressChoisesDao;
    }

    protected net.malta.model.DeliveryAddressChoiseDao getDeliveryAddressChoisesDao()
    {
        return this.deliveryAddressChoisesDao;
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

    private java.util.Set findDeliveryAddressChoiseByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressChoiseImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.GiftCard create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
    {
        final net.malta.model.GiftCard entity = new net.malta.model.GiftCardImpl();
        entity.setId(id);
        entity.setName(name);
        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);

        final java.util.Set deliveryAddressChoisesEntities = (deliveryAddressChoises != null && deliveryAddressChoises.length > 0)
            ? this.findDeliveryAddressChoiseByIds(deliveryAddressChoises)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddressChoises(deliveryAddressChoisesEntities);


        return (net.malta.model.GiftCard)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.GiftCardImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (deliveryAddresses != null && deliveryAddresses.length > 0) criteria.createCriteria("deliveryAddresses").add(Expression.in("id", deliveryAddresses));
            if (deliveryAddressChoises != null && deliveryAddressChoises.length > 0) criteria.createCriteria("deliveryAddressChoises").add(Expression.in("id", deliveryAddressChoises));
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
            final Criteria criteria = session.createCriteria(net.malta.model.GiftCardImpl.class);
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
            lists.put("deliveryAddresses", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddress item order by item.id").list());
            lists.put("deliveryAddressChoises", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddressChoise item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.GiftCard update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] deliveryAddresses, java.lang.Integer[] deliveryAddressChoises)
    {
        final net.malta.model.GiftCard entity = this.getDao().load(id);

        entity.setName(name);
        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);

        final java.util.Set deliveryAddressChoisesEntities = (deliveryAddressChoises != null && deliveryAddressChoises.length > 0)
            ? this.findDeliveryAddressChoiseByIds(deliveryAddressChoises)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddressChoises(deliveryAddressChoisesEntities);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.GiftCardImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}