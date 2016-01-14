// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class ChoiseManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements ChoiseManageableDao
{
    private net.malta.model.ChoiseDao dao;

    public void setDao(net.malta.model.ChoiseDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.ChoiseDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.PurchaseDao purchaseDao = null;

    public void setPurchaseDao(net.malta.model.PurchaseDao purchaseDao)
    {
        this.purchaseDao = purchaseDao;
    }

    protected net.malta.model.PurchaseDao getPurchaseDao()
    {
        return this.purchaseDao;
    }

    private net.malta.model.ItemDao itemDao = null;

    public void setItemDao(net.malta.model.ItemDao itemDao)
    {
        this.itemDao = itemDao;
    }

    protected net.malta.model.ItemDao getItemDao()
    {
        return this.itemDao;
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

    private java.util.Set findPurchaseByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PurchaseImpl.class);
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

    public net.malta.model.Choise create(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
    {
        final net.malta.model.Choise entity = new net.malta.model.ChoiseImpl();
        entity.setId(id);
        entity.setOrdernum(ordernum);
        entity.setPricewithtax(pricewithtax);
        entity.setWrapping(wrapping);
        net.malta.model.Purchase purchaseEntity = null;
        if (purchase != null)
        {
            purchaseEntity = (net.malta.model.Purchase)getPurchaseDao().load(purchase);
        }

        entity.setPurchase(purchaseEntity);

        net.malta.model.Item itemEntity = null;
        if (item != null)
        {
            itemEntity = (net.malta.model.Item)getItemDao().load(item);
        }

        entity.setItem(itemEntity);

        final java.util.Set deliveryAddressChoisesEntities = (deliveryAddressChoises != null && deliveryAddressChoises.length > 0)
            ? this.findDeliveryAddressChoiseByIds(deliveryAddressChoises)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddressChoises(deliveryAddressChoisesEntities);


        return (net.malta.model.Choise)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ChoiseImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            criteria.add(Expression.eq("ordernum", new java.lang.Integer(ordernum)));
            criteria.add(Expression.eq("pricewithtax", new java.lang.Integer(pricewithtax)));
            if (wrapping) criteria.add(Expression.eq("wrapping", java.lang.Boolean.TRUE));
                if (purchase != null) criteria.createCriteria("purchase").add(Expression.eq("id", purchase));
            if (item != null) criteria.createCriteria("item").add(Expression.eq("id", item));
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
            final Criteria criteria = session.createCriteria(net.malta.model.ChoiseImpl.class);
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
            lists.put("purchase", session.createQuery("select item.id, item.id from net.malta.model.Purchase item order by item.id").list());
            lists.put("item", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
            lists.put("deliveryAddressChoises", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddressChoise item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Choise update(java.lang.Integer id, int ordernum, int pricewithtax, boolean wrapping, java.lang.Integer purchase, java.lang.Integer item, java.lang.Integer[] deliveryAddressChoises)
    {
        final net.malta.model.Choise entity = this.getDao().load(id);

        entity.setOrdernum(ordernum);
        entity.setPricewithtax(pricewithtax);
        entity.setWrapping(wrapping);
        net.malta.model.Purchase purchaseEntity = null;
        if (purchase != null)
        {
            purchaseEntity = getPurchaseDao().load(purchase);
        }

        entity.setPurchase(purchaseEntity);

        net.malta.model.Item itemEntity = null;
        if (item != null)
        {
            itemEntity = getItemDao().load(item);
        }

        entity.setItem(itemEntity);

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
                session.createQuery("delete net.malta.model.ChoiseImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}