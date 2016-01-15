// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class DeliveryAddressManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements DeliveryAddressManageableDao
{
    private net.malta.model.DeliveryAddressDao dao;

    public void setDao(net.malta.model.DeliveryAddressDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.DeliveryAddressDao getDao()
    {
        return this.dao;
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

    private net.malta.model.PublicUserDao publicUserDao = null;

    public void setPublicUserDao(net.malta.model.PublicUserDao publicUserDao)
    {
        this.publicUserDao = publicUserDao;
    }

    protected net.malta.model.PublicUserDao getPublicUserDao()
    {
        return this.publicUserDao;
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

    private net.malta.model.PrefectureDao prefectureDao = null;

    public void setPrefectureDao(net.malta.model.PrefectureDao prefectureDao)
    {
        this.prefectureDao = prefectureDao;
    }

    protected net.malta.model.PrefectureDao getPrefectureDao()
    {
        return this.prefectureDao;
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

    private java.util.Set findPrefectureByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PrefectureImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.DeliveryAddress create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
    {
        final net.malta.model.DeliveryAddress entity = new net.malta.model.DeliveryAddressImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setKana(kana);
        entity.setZipthree(zipthree);
        entity.setZipfour(zipfour);
        entity.setPhone(phone);
        entity.setAddress(address);
        entity.setBuildingname(buildingname);
        entity.setPref(pref);
        entity.setPreferreddate(preferreddate);
        entity.setPreferredtime(preferredtime);
        entity.setHasgiftcard(hasgiftcard);
        final java.util.Set deliveryAddressChoisesEntities = (deliveryAddressChoises != null && deliveryAddressChoises.length > 0)
            ? this.findDeliveryAddressChoiseByIds(deliveryAddressChoises)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddressChoises(deliveryAddressChoisesEntities);

        net.malta.model.PublicUser publicUserEntity = null;
        if (publicUser != null)
        {
            publicUserEntity = (net.malta.model.PublicUser)getPublicUserDao().load(publicUser);
        }

        entity.setPublicUser(publicUserEntity);

        net.malta.model.GiftCard giftCardEntity = null;
        if (giftCard != null)
        {
            giftCardEntity = (net.malta.model.GiftCard)getGiftCardDao().load(giftCard);
        }

        entity.setGiftCard(giftCardEntity);

        net.malta.model.Prefecture prefectureEntity = null;
        if (prefecture != null)
        {
            prefectureEntity = (net.malta.model.Prefecture)getPrefectureDao().load(prefecture);
        }

        entity.setPrefecture(prefectureEntity);


        return (net.malta.model.DeliveryAddress)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (kana != null)
                criteria.add(Expression.ilike("kana", kana, MatchMode.START));
            criteria.add(Expression.eq("zipthree", new java.lang.Integer(zipthree)));
            criteria.add(Expression.eq("zipfour", new java.lang.Integer(zipfour)));
            if (phone != null)
                criteria.add(Expression.ilike("phone", phone, MatchMode.START));
            if (address != null)
                criteria.add(Expression.ilike("address", address, MatchMode.START));
            if (buildingname != null)
                criteria.add(Expression.ilike("buildingname", buildingname, MatchMode.START));
            if (pref != null)
                criteria.add(Expression.ilike("pref", pref, MatchMode.START));
            if (preferreddate != null)
                criteria.add(Expression.ilike("preferreddate", preferreddate, MatchMode.START));
            if (preferredtime != null)
                criteria.add(Expression.ilike("preferredtime", preferredtime, MatchMode.START));
            if (hasgiftcard) criteria.add(Expression.eq("hasgiftcard", java.lang.Boolean.TRUE));
                if (deliveryAddressChoises != null && deliveryAddressChoises.length > 0) criteria.createCriteria("deliveryAddressChoises").add(Expression.in("id", deliveryAddressChoises));
            if (publicUser != null) criteria.createCriteria("publicUser").add(Expression.eq("id", publicUser));
            if (giftCard != null) criteria.createCriteria("giftCard").add(Expression.eq("id", giftCard));
            if (prefecture != null) criteria.createCriteria("prefecture").add(Expression.eq("id", prefecture));
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
            final Criteria criteria = session.createCriteria(net.malta.model.DeliveryAddressImpl.class);
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
            lists.put("deliveryAddressChoises", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddressChoise item order by item.id").list());
            lists.put("publicUser", session.createQuery("select item.id, item.id from net.malta.model.PublicUser item order by item.id").list());
            lists.put("giftCard", session.createQuery("select item.id, item.id from net.malta.model.GiftCard item order by item.id").list());
            lists.put("prefecture", session.createQuery("select item.id, item.id from net.malta.model.Prefecture item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.DeliveryAddress update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
    {
        final net.malta.model.DeliveryAddress entity = this.getDao().load(id);

        entity.setName(name);
        entity.setKana(kana);
        entity.setZipthree(zipthree);
        entity.setZipfour(zipfour);
        entity.setPhone(phone);
        entity.setAddress(address);
        entity.setBuildingname(buildingname);
        entity.setPref(pref);
        entity.setPreferreddate(preferreddate);
        entity.setPreferredtime(preferredtime);
        entity.setHasgiftcard(hasgiftcard);
        final java.util.Set deliveryAddressChoisesEntities = (deliveryAddressChoises != null && deliveryAddressChoises.length > 0)
            ? this.findDeliveryAddressChoiseByIds(deliveryAddressChoises)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddressChoises(deliveryAddressChoisesEntities);

        net.malta.model.PublicUser publicUserEntity = null;
        if (publicUser != null)
        {
            publicUserEntity = getPublicUserDao().load(publicUser);
        }

        entity.setPublicUser(publicUserEntity);

        net.malta.model.GiftCard giftCardEntity = null;
        if (giftCard != null)
        {
            giftCardEntity = getGiftCardDao().load(giftCard);
        }

        entity.setGiftCard(giftCardEntity);

        net.malta.model.Prefecture prefectureEntity = null;
        if (prefecture != null)
        {
            prefectureEntity = getPrefectureDao().load(prefecture);
        }

        entity.setPrefecture(prefectureEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.DeliveryAddressImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}