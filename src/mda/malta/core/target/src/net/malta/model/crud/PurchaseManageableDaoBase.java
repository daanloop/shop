// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class PurchaseManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements PurchaseManageableDao
{
    private net.malta.model.PurchaseDao dao;

    public void setDao(net.malta.model.PurchaseDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.PurchaseDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.PublicUserDao publicUserDao = null;

    public void setPublicUserDao(net.malta.model.PublicUserDao publicUserDao)
    {
        this.publicUserDao = publicUserDao;
    }

    protected net.malta.model.PublicUserDao getPublicUserDao()
    {
        return this.publicUserDao;
    }

    private net.malta.model.ChoiseDao choisesDao = null;

    public void setChoisesDao(net.malta.model.ChoiseDao choisesDao)
    {
        this.choisesDao = choisesDao;
    }

    protected net.malta.model.ChoiseDao getChoisesDao()
    {
        return this.choisesDao;
    }

    private net.malta.model.PaymentMethodDao paymentMethodDao = null;

    public void setPaymentMethodDao(net.malta.model.PaymentMethodDao paymentMethodDao)
    {
        this.paymentMethodDao = paymentMethodDao;
    }

    protected net.malta.model.PaymentMethodDao getPaymentMethodDao()
    {
        return this.paymentMethodDao;
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

    private java.util.Set findPaymentMethodByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PaymentMethodImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.Purchase create(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
    {
        final net.malta.model.Purchase entity = new net.malta.model.PurchaseImpl();
        entity.setId(id);
        entity.setTotal(total);
        entity.setCarriage(carriage);
        entity.setTotalordernum(totalordernum);
        entity.setShipped(shipped);
        entity.setDate(date);
        entity.setTemp(temp);
        entity.setCancelled(cancelled);
        entity.setRemoved(removed);
        net.malta.model.PublicUser publicUserEntity = null;
        if (publicUser != null)
        {
            publicUserEntity = (net.malta.model.PublicUser)getPublicUserDao().load(publicUser);
        }

        entity.setPublicUser(publicUserEntity);

        final java.util.Set choisesEntities = (choises != null && choises.length > 0)
            ? this.findChoiseByIds(choises)
            : java.util.Collections.EMPTY_SET;

        entity.setChoises(choisesEntities);

        net.malta.model.PaymentMethod paymentMethodEntity = null;
        if (paymentMethod != null)
        {
            paymentMethodEntity = (net.malta.model.PaymentMethod)getPaymentMethodDao().load(paymentMethod);
        }

        entity.setPaymentMethod(paymentMethodEntity);


        return (net.malta.model.Purchase)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PurchaseImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            criteria.add(Expression.eq("total", new java.lang.Integer(total)));
            criteria.add(Expression.eq("carriage", new java.lang.Integer(carriage)));
            criteria.add(Expression.eq("totalordernum", new java.lang.Integer(totalordernum)));
            if (shipped) criteria.add(Expression.eq("shipped", java.lang.Boolean.TRUE));
                if (date != null)
            {
                // we check whether or not the user supplied time information within this particular date argument
                // if he/she didn't we assume he/she wishes to search in the scope of the entire day
                final java.util.Calendar calendar = new java.util.GregorianCalendar();
                calendar.setTime(date);
                if ( calendar.get(java.util.Calendar.HOUR) != 0
                     || calendar.get(java.util.Calendar.MINUTE) != 0
                     || calendar.get(java.util.Calendar.SECOND) != 0
                     || calendar.get(java.util.Calendar.MILLISECOND) != 0 )
                {
                    criteria.add(Expression.eq("date", date));
                }
                else
                {
                    calendar.add(java.util.Calendar.DATE, 1);
                    criteria.add(Expression.between("date", date, calendar.getTime()));
                }
            }
            if (temp) criteria.add(Expression.eq("temp", java.lang.Boolean.TRUE));
                if (cancelled) criteria.add(Expression.eq("cancelled", java.lang.Boolean.TRUE));
                if (removed) criteria.add(Expression.eq("removed", java.lang.Boolean.TRUE));
                if (publicUser != null) criteria.createCriteria("publicUser").add(Expression.eq("id", publicUser));
            if (choises != null && choises.length > 0) criteria.createCriteria("choises").add(Expression.in("id", choises));
            if (paymentMethod != null) criteria.createCriteria("paymentMethod").add(Expression.eq("id", paymentMethod));
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
            final Criteria criteria = session.createCriteria(net.malta.model.PurchaseImpl.class);
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
            lists.put("publicUser", session.createQuery("select item.id, item.id from net.malta.model.PublicUser item order by item.id").list());
            lists.put("choises", session.createQuery("select item.id, item.id from net.malta.model.Choise item order by item.id").list());
            lists.put("paymentMethod", session.createQuery("select item.id, item.id from net.malta.model.PaymentMethod item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Purchase update(java.lang.Integer id, int total, int carriage, int totalordernum, boolean shipped, java.util.Date date, boolean temp, boolean cancelled, boolean removed, java.lang.Integer publicUser, java.lang.Integer[] choises, java.lang.Integer paymentMethod)
    {
        final net.malta.model.Purchase entity = this.getDao().load(id);

        entity.setTotal(total);
        entity.setCarriage(carriage);
        entity.setTotalordernum(totalordernum);
        entity.setShipped(shipped);
        entity.setDate(date);
        entity.setTemp(temp);
        entity.setCancelled(cancelled);
        entity.setRemoved(removed);
        net.malta.model.PublicUser publicUserEntity = null;
        if (publicUser != null)
        {
            publicUserEntity = getPublicUserDao().load(publicUser);
        }

        entity.setPublicUser(publicUserEntity);

        final java.util.Set choisesEntities = (choises != null && choises.length > 0)
            ? this.findChoiseByIds(choises)
            : java.util.Collections.EMPTY_SET;

        entity.setChoises(choisesEntities);

        net.malta.model.PaymentMethod paymentMethodEntity = null;
        if (paymentMethod != null)
        {
            paymentMethodEntity = getPaymentMethodDao().load(paymentMethod);
        }

        entity.setPaymentMethod(paymentMethodEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.PurchaseImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}