// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class PublicUserManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements PublicUserManageableDao
{
    private net.malta.model.PublicUserDao dao;

    public void setDao(net.malta.model.PublicUserDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.PublicUserDao getDao()
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

    private net.malta.model.DeliveryAddressDao deliveryAddressesDao = null;

    public void setDeliveryAddressesDao(net.malta.model.DeliveryAddressDao deliveryAddressesDao)
    {
        this.deliveryAddressesDao = deliveryAddressesDao;
    }

    protected net.malta.model.DeliveryAddressDao getDeliveryAddressesDao()
    {
        return this.deliveryAddressesDao;
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

    public net.malta.model.PublicUser create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
    {
        final net.malta.model.PublicUser entity = new net.malta.model.PublicUserImpl();
        entity.setId(id);
        entity.setName(name);
        entity.setKana(kana);
        entity.setZipthree(zipthree);
        entity.setZipfour(zipfour);
        entity.setPref(pref);
        entity.setAddress(address);
        entity.setBuildingname(buildingname);
        entity.setMail(mail);
        entity.setMailforconfirm(mailforconfirm);
        entity.setPhone(phone);
        entity.setDevliveryhour(devliveryhour);
        entity.setDeliverydate(deliverydate);
        entity.setDeliveryphone(deliveryphone);
        entity.setDeliverykana(deliverykana);
        entity.setDeliveryblocknumber(deliveryblocknumber);
        entity.setDeliveryaddress(deliveryaddress);
        entity.setDeliveryname(deliveryname);
        entity.setDeliveryzipfour(deliveryzipfour);
        entity.setDeliveryzipthree(deliveryzipthree);
        entity.setDeliverypref(deliverypref);
        entity.setDelivertodifferentaddress(delivertodifferentaddress);
        entity.setMale(male);
        entity.setBrithday(brithday);
        entity.setBirthmonth(birthmonth);
        entity.setMunicipality(municipality);
        entity.setBirthyear(birthyear);
        entity.setKeitai(keitai);
        entity.setRemoved(removed);
        entity.setPassword(password);
        entity.setFax(fax);
        entity.setRegisted(registed);
        entity.setTemp(temp);
        entity.setPasswordonetimehash(passwordonetimehash);
        final java.util.Set purchasesEntities = (purchases != null && purchases.length > 0)
            ? this.findPurchaseByIds(purchases)
            : java.util.Collections.EMPTY_SET;

        entity.setPurchases(purchasesEntities);

        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);

        net.malta.model.Prefecture prefectureEntity = null;
        if (prefecture != null)
        {
            prefectureEntity = (net.malta.model.Prefecture)getPrefectureDao().load(prefecture);
        }

        entity.setPrefecture(prefectureEntity);


        return (net.malta.model.PublicUser)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.PublicUserImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (kana != null)
                criteria.add(Expression.ilike("kana", kana, MatchMode.START));
            criteria.add(Expression.eq("zipthree", new java.lang.Integer(zipthree)));
            criteria.add(Expression.eq("zipfour", new java.lang.Integer(zipfour)));
            if (pref != null)
                criteria.add(Expression.ilike("pref", pref, MatchMode.START));
            if (address != null)
                criteria.add(Expression.ilike("address", address, MatchMode.START));
            if (buildingname != null)
                criteria.add(Expression.ilike("buildingname", buildingname, MatchMode.START));
            if (mail != null)
                criteria.add(Expression.ilike("mail", mail, MatchMode.START));
            if (mailforconfirm != null)
                criteria.add(Expression.ilike("mailforconfirm", mailforconfirm, MatchMode.START));
            if (phone != null)
                criteria.add(Expression.ilike("phone", phone, MatchMode.START));
            criteria.add(Expression.eq("devliveryhour", new java.lang.Integer(devliveryhour)));
            criteria.add(Expression.eq("deliverydate", new java.lang.Integer(deliverydate)));
            criteria.add(Expression.eq("deliveryphone", new java.lang.Integer(deliveryphone)));
            if (deliverykana != null)
                criteria.add(Expression.ilike("deliverykana", deliverykana, MatchMode.START));
            if (deliveryblocknumber != null)
                criteria.add(Expression.ilike("deliveryblocknumber", deliveryblocknumber, MatchMode.START));
            if (deliveryaddress != null)
                criteria.add(Expression.ilike("deliveryaddress", deliveryaddress, MatchMode.START));
            if (deliveryname != null)
                criteria.add(Expression.ilike("deliveryname", deliveryname, MatchMode.START));
            criteria.add(Expression.eq("deliveryzipfour", new java.lang.Integer(deliveryzipfour)));
            criteria.add(Expression.eq("deliveryzipthree", new java.lang.Integer(deliveryzipthree)));
            if (deliverypref != null)
                criteria.add(Expression.ilike("deliverypref", deliverypref, MatchMode.START));
            if (delivertodifferentaddress) criteria.add(Expression.eq("delivertodifferentaddress", java.lang.Boolean.TRUE));
                if (male) criteria.add(Expression.eq("male", java.lang.Boolean.TRUE));
                criteria.add(Expression.eq("brithday", new java.lang.Integer(brithday)));
            criteria.add(Expression.eq("birthmonth", new java.lang.Integer(birthmonth)));
            if (municipality != null)
                criteria.add(Expression.ilike("municipality", municipality, MatchMode.START));
            criteria.add(Expression.eq("birthyear", new java.lang.Integer(birthyear)));
            if (keitai != null)
                criteria.add(Expression.ilike("keitai", keitai, MatchMode.START));
            if (removed) criteria.add(Expression.eq("removed", java.lang.Boolean.TRUE));
                if (password != null)
                criteria.add(Expression.ilike("password", password, MatchMode.START));
            if (fax != null)
                criteria.add(Expression.ilike("fax", fax, MatchMode.START));
            if (registed) criteria.add(Expression.eq("registed", java.lang.Boolean.TRUE));
                if (temp) criteria.add(Expression.eq("temp", java.lang.Boolean.TRUE));
                if (passwordonetimehash != null)
                criteria.add(Expression.ilike("passwordonetimehash", passwordonetimehash, MatchMode.START));
            if (purchases != null && purchases.length > 0) criteria.createCriteria("purchases").add(Expression.in("id", purchases));
            if (deliveryAddresses != null && deliveryAddresses.length > 0) criteria.createCriteria("deliveryAddresses").add(Expression.in("id", deliveryAddresses));
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
            final Criteria criteria = session.createCriteria(net.malta.model.PublicUserImpl.class);
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
            lists.put("deliveryAddresses", session.createQuery("select item.id, item.id from net.malta.model.DeliveryAddress item order by item.id").list());
            lists.put("prefecture", session.createQuery("select item.id, item.id from net.malta.model.Prefecture item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.PublicUser update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
    {
        final net.malta.model.PublicUser entity = this.getDao().load(id);

        entity.setName(name);
        entity.setKana(kana);
        entity.setZipthree(zipthree);
        entity.setZipfour(zipfour);
        entity.setPref(pref);
        entity.setAddress(address);
        entity.setBuildingname(buildingname);
        entity.setMail(mail);
        entity.setMailforconfirm(mailforconfirm);
        entity.setPhone(phone);
        entity.setDevliveryhour(devliveryhour);
        entity.setDeliverydate(deliverydate);
        entity.setDeliveryphone(deliveryphone);
        entity.setDeliverykana(deliverykana);
        entity.setDeliveryblocknumber(deliveryblocknumber);
        entity.setDeliveryaddress(deliveryaddress);
        entity.setDeliveryname(deliveryname);
        entity.setDeliveryzipfour(deliveryzipfour);
        entity.setDeliveryzipthree(deliveryzipthree);
        entity.setDeliverypref(deliverypref);
        entity.setDelivertodifferentaddress(delivertodifferentaddress);
        entity.setMale(male);
        entity.setBrithday(brithday);
        entity.setBirthmonth(birthmonth);
        entity.setMunicipality(municipality);
        entity.setBirthyear(birthyear);
        entity.setKeitai(keitai);
        entity.setRemoved(removed);
        entity.setPassword(password);
        entity.setFax(fax);
        entity.setRegisted(registed);
        entity.setTemp(temp);
        entity.setPasswordonetimehash(passwordonetimehash);
        final java.util.Set purchasesEntities = (purchases != null && purchases.length > 0)
            ? this.findPurchaseByIds(purchases)
            : java.util.Collections.EMPTY_SET;

        entity.setPurchases(purchasesEntities);

        final java.util.Set deliveryAddressesEntities = (deliveryAddresses != null && deliveryAddresses.length > 0)
            ? this.findDeliveryAddressByIds(deliveryAddresses)
            : java.util.Collections.EMPTY_SET;

        entity.setDeliveryAddresses(deliveryAddressesEntities);

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
                session.createQuery("delete net.malta.model.PublicUserImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}