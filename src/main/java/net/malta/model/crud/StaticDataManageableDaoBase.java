// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class StaticDataManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements StaticDataManageableDao
{
    private net.malta.model.StaticDataDao dao;

    public void setDao(net.malta.model.StaticDataDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.StaticDataDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.StaticData create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
    {
        final net.malta.model.StaticData entity = new net.malta.model.StaticDataImpl();
        entity.setId(id);
        entity.setFromaddress(fromaddress);
        entity.setSitename(sitename);
        entity.setBasepath(basepath);
        entity.setUnix(unix);
        entity.setMapeventspan(mapeventspan);
        entity.setNoimage(noimage);
        entity.setCarriage(carriage);
        entity.setCreditcardprocesurl(creditcardprocesurl);
        entity.setContract_code(contract_code);

        return (net.malta.model.StaticData)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.StaticDataImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (fromaddress != null)
                criteria.add(Expression.ilike("fromaddress", fromaddress, MatchMode.START));
            if (sitename != null)
                criteria.add(Expression.ilike("sitename", sitename, MatchMode.START));
            if (basepath != null)
                criteria.add(Expression.ilike("basepath", basepath, MatchMode.START));
            if (unix) criteria.add(Expression.eq("unix", java.lang.Boolean.TRUE));
                criteria.add(Expression.eq("mapeventspan", new java.lang.Integer(mapeventspan)));
            if (noimage != null)
            criteria.add(Expression.eq("noimage", noimage));
            criteria.add(Expression.eq("carriage", new java.lang.Integer(carriage)));
            if (creditcardprocesurl != null)
                criteria.add(Expression.ilike("creditcardprocesurl", creditcardprocesurl, MatchMode.START));
            if (contract_code != null)
                criteria.add(Expression.ilike("contract_code", contract_code, MatchMode.START));
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
            final Criteria criteria = session.createCriteria(net.malta.model.StaticDataImpl.class);
            criteria.setMaxResults(250);
            return criteria.list();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public byte[] getNoimage(java.lang.Integer id)
    {
        try
        {
            byte[] value = null;

            final org.hibernate.Query queryObject = super.getSession(false).createQuery("select entity.noimage from net.malta.model.StaticData as entity where entity.id = :id");
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

    public net.malta.model.StaticData update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
    {
        final net.malta.model.StaticData entity = this.getDao().load(id);

        entity.setFromaddress(fromaddress);
        entity.setSitename(sitename);
        entity.setBasepath(basepath);
        entity.setUnix(unix);
        entity.setMapeventspan(mapeventspan);
        entity.setNoimage(noimage);
        entity.setCarriage(carriage);
        entity.setCreditcardprocesurl(creditcardprocesurl);
        entity.setContract_code(contract_code);

        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.StaticDataImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}