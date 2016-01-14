// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class PaymentMethodManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements PaymentMethodManageableDao
{
    private net.malta.model.PaymentMethodDao dao;

    public void setDao(net.malta.model.PaymentMethodDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.PaymentMethodDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.PurchaseDao purchasesDao = null;

    public void setPurchasesDao(net.malta.model.PurchaseDao purchasesDao)
    {
        this.purchasesDao = purchasesDao;
    }

    protected net.malta.model.PurchaseDao getPurchasesDao()
    {
        return this.purchasesDao;
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

    public net.malta.model.PaymentMethod create(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
    {
        final net.malta.model.PaymentMethod entity = new net.malta.model.PaymentMethodImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setNote(note);
        final java.util.Set purchasesEntities = (purchases != null && purchases.length > 0)
            ? this.findPurchaseByIds(purchases)
            : java.util.Collections.EMPTY_SET;

        entity.setPurchases(purchasesEntities);


        return (net.malta.model.PaymentMethod)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PaymentMethodImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (note != null)
                criteria.add(Expression.ilike("note", note, MatchMode.START));
            if (purchases != null && purchases.length > 0) criteria.createCriteria("purchases").add(Expression.in("id", purchases));
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
            final Criteria criteria = session.createCriteria(net.malta.model.PaymentMethodImpl.class);
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
            lists.put("purchases", session.createQuery("select item.id, item.id from net.malta.model.Purchase item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.PaymentMethod update(java.lang.Integer id, java.lang.String name, java.lang.String note, java.lang.Integer[] purchases)
    {
        final net.malta.model.PaymentMethod entity = this.getDao().load(id);

        entity.setName(name);
        entity.setNote(note);
        final java.util.Set purchasesEntities = (purchases != null && purchases.length > 0)
            ? this.findPurchaseByIds(purchases)
            : java.util.Collections.EMPTY_SET;

        entity.setPurchases(purchasesEntities);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.PaymentMethodImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}