// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class CategoryManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements CategoryManageableDao
{
    private net.malta.model.CategoryDao dao;

    public void setDao(net.malta.model.CategoryDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.CategoryDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.ProductDao productsDao = null;

    public void setProductsDao(net.malta.model.ProductDao productsDao)
    {
        this.productsDao = productsDao;
    }

    protected net.malta.model.ProductDao getProductsDao()
    {
        return this.productsDao;
    }

    private java.util.Set findProductByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ProductImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.Category create(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
    {
        final net.malta.model.Category entity = new net.malta.model.CategoryImpl();
        entity.setId(id);
        entity.setName(name);
        final java.util.Set productsEntities = (products != null && products.length > 0)
            ? this.findProductByIds(products)
            : java.util.Collections.EMPTY_SET;

        entity.setProducts(productsEntities);


        return (net.malta.model.Category)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.CategoryImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            if (products != null && products.length > 0) criteria.createCriteria("products").add(Expression.in("id", products));
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
            final Criteria criteria = session.createCriteria(net.malta.model.CategoryImpl.class);
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
            lists.put("products", session.createQuery("select item.id, item.id from net.malta.model.Product item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Category update(java.lang.Integer id, java.lang.String name, java.lang.Integer[] products)
    {
        final net.malta.model.Category entity = this.getDao().load(id);

        entity.setName(name);
        final java.util.Set productsEntities = (products != null && products.length > 0)
            ? this.findProductByIds(products)
            : java.util.Collections.EMPTY_SET;

        entity.setProducts(productsEntities);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.CategoryImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}