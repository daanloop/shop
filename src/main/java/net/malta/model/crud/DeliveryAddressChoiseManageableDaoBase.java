// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class DeliveryAddressChoiseManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements DeliveryAddressChoiseManageableDao
{
    private net.malta.model.DeliveryAddressChoiseDao dao;

    public void setDao(net.malta.model.DeliveryAddressChoiseDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.DeliveryAddressChoiseDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.DeliveryAddressDao deliveryAddressDao = null;

    public void setDeliveryAddressDao(net.malta.model.DeliveryAddressDao deliveryAddressDao)
    {
        this.deliveryAddressDao = deliveryAddressDao;
    }

    protected net.malta.model.DeliveryAddressDao getDeliveryAddressDao()
    {
        return this.deliveryAddressDao;
    }

    private net.malta.model.ChoiseDao choiseDao = null;

    public void setChoiseDao(net.malta.model.ChoiseDao choiseDao)
    {
        this.choiseDao = choiseDao;
    }

    protected net.malta.model.ChoiseDao getChoiseDao()
    {
        return this.choiseDao;
    }

    private net.malta.model.GiftCardDao giftCardDao = null;

    public void setGiftCardDao(net.malta.model.GiftCardDao giftCardDao)
    {
        this.giftCardDao = giftCardDao;
    }

    protected net.malta.model.GiftCardDao getGiftCardDao()
    {
        return this.giftCardDao;
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

    private java.util.Set findChoiseByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ChoiseImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    private java.util.Set findGiftCardByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.GiftCardImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.DeliveryAddressChoise create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
    {
        final net.malta.model.DeliveryAddressChoise entity = new net.malta.model.DeliveryAddressChoiseImpl();
        entity.setId(id);
        entity.setOrdernum(ordernum);
        entity.setPreferreddate(preferreddate);
        entity.setPreferredtime(preferredtime);
        net.malta.model.DeliveryAddress deliveryAddressEntity = null;
        if (deliveryAddress != null)
        {
            deliveryAddressEntity = (net.malta.model.DeliveryAddress)getDeliveryAddressDao().load(deliveryAddress);
        }

        entity.setDeliveryAddress(deliveryAddressEntity);

        net.malta.model.Choise choiseEntity = null;
        if (choise != null)
        {
            choiseEntity = (net.malta.model.Choise)getChoiseDao().load(choise);
        }

        entity.setChoise(choiseEntity);

        net.malta.model.GiftCard giftCardEntity = null;
        if (giftCard != null)
        {
            giftCardEntity = (net.malta.model.GiftCard)getGiftCardDao().load(giftCard);
        }

        entity.setGiftCard(giftCardEntity);


        return (net.malta.model.DeliveryAddressChoise)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressChoiseImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            criteria.add(Expression.eq("ordernum", new java.lang.Integer(ordernum)));
            if (preferreddate != null)
                criteria.add(Expression.ilike("preferreddate", preferreddate, MatchMode.START));
            if (preferredtime != null)
                criteria.add(Expression.ilike("preferredtime", preferredtime, MatchMode.START));
            if (deliveryAddress != null) criteria.createCriteria("deliveryAddress").add(Expression.eq("id", deliveryAddress));
            if (choise != null) criteria.createCriteria("choise").add(Expression.eq("id", choise));
            if (giftCard != null) criteria.createCriteria("giftCard").add(Expression.eq("id", giftCard));
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
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressChoiseImpl.class);
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
            lists.put("deliveryAddress", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddress item order by item.id").list());
            lists.put("choise", session.createQuery("select item.id, item.id from net.malta.model.Choise item order by item.id").list());
            lists.put("giftCard", session.createQuery("select item.id, item.id from net.malta.model.GiftCard item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.DeliveryAddressChoise update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
    {
        final net.malta.model.DeliveryAddressChoise entity = this.getDao().load(id);

        entity.setOrdernum(ordernum);
        entity.setPreferreddate(preferreddate);
        entity.setPreferredtime(preferredtime);
        net.malta.model.DeliveryAddress deliveryAddressEntity = null;
        if (deliveryAddress != null)
        {
            deliveryAddressEntity = getDeliveryAddressDao().load(deliveryAddress);
        }

        entity.setDeliveryAddress(deliveryAddressEntity);

        net.malta.model.Choise choiseEntity = null;
        if (choise != null)
        {
            choiseEntity = getChoiseDao().load(choise);
        }

        entity.setChoise(choiseEntity);

        net.malta.model.GiftCard giftCardEntity = null;
        if (giftCard != null)
        {
            giftCardEntity = getGiftCardDao().load(giftCard);
        }

        entity.setGiftCard(giftCardEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.DeliveryAddressChoiseImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}