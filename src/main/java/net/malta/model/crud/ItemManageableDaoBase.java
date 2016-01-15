// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class ItemManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements ItemManageableDao
{
    private net.malta.model.ItemDao dao;

    public void setDao(net.malta.model.ItemDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.ItemDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.ProductDao productDao = null;

    public void setProductDao(net.malta.model.ProductDao productDao)
    {
        this.productDao = productDao;
    }

    protected net.malta.model.ProductDao getProductDao()
    {
        return this.productDao;
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

    private net.malta.model.CarriageDao carriageDao = null;

    public void setCarriageDao(net.malta.model.CarriageDao carriageDao)
    {
        this.carriageDao = carriageDao;
    }

    protected net.malta.model.CarriageDao getCarriageDao()
    {
        return this.carriageDao;
    }

    private net.malta.model.AttachmentDao zoomDao = null;

    public void setZoomDao(net.malta.model.AttachmentDao zoomDao)
    {
        this.zoomDao = zoomDao;
    }

    protected net.malta.model.AttachmentDao getZoomDao()
    {
        return this.zoomDao;
    }

    private net.malta.model.AttachmentDao detailedDao = null;

    public void setDetailedDao(net.malta.model.AttachmentDao detailedDao)
    {
        this.detailedDao = detailedDao;
    }

    protected net.malta.model.AttachmentDao getDetailedDao()
    {
        return this.detailedDao;
    }

    private net.malta.model.AttachmentDao defaultattachmentDao = null;

    public void setDefaultattachmentDao(net.malta.model.AttachmentDao defaultattachmentDao)
    {
        this.defaultattachmentDao = defaultattachmentDao;
    }

    protected net.malta.model.AttachmentDao getDefaultattachmentDao()
    {
        return this.defaultattachmentDao;
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

    private java.util.Set findCarriageByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.CarriageImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    private java.util.Set findAttachmentByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.AttachmentImpl.class);
            criteria.add(Expression.in("id", ids));
            return new java.util.HashSet(criteria.list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    public net.malta.model.Item create(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
    {
        final net.malta.model.Item entity = new net.malta.model.ItemImpl();
        entity.setId(id);
        entity.setNo(no);
        entity.setName(name);
        entity.setPricewithtax(pricewithtax);
        entity.setSize(size);
        entity.setMaterial(material);
        entity.setCatchcopy(catchcopy);
        entity.setDescription(description);
        entity.setNote(note);
        entity.setStocknum(stocknum);
        entity.setMain(main);
        net.malta.model.Product productEntity = null;
        if (product != null)
        {
            productEntity = (net.malta.model.Product)getProductDao().load(product);
        }

        entity.setProduct(productEntity);

        final java.util.Set choisesEntities = (choises != null && choises.length > 0)
            ? this.findChoiseByIds(choises)
            : java.util.Collections.EMPTY_SET;

        entity.setChoises(choisesEntities);

        net.malta.model.Carriage carriageEntity = null;
        if (carriage != null)
        {
            carriageEntity = (net.malta.model.Carriage)getCarriageDao().load(carriage);
        }

        entity.setCarriage(carriageEntity);

        net.malta.model.Attachment zoomEntity = null;
        if (zoom != null)
        {
            zoomEntity = (net.malta.model.Attachment)getZoomDao().load(zoom);
        }

        entity.setZoom(zoomEntity);

        final java.util.Set detailedEntities = (detailed != null && detailed.length > 0)
            ? this.findAttachmentByIds(detailed)
            : java.util.Collections.EMPTY_SET;

        entity.setDetailed(detailedEntities);

        net.malta.model.Attachment defaultattachmentEntity = null;
        if (defaultattachment != null)
        {
            defaultattachmentEntity = (net.malta.model.Attachment)getDefaultattachmentDao().load(defaultattachment);
        }

        entity.setDefaultattachment(defaultattachmentEntity);


        return (net.malta.model.Item)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ItemImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (no != null)
                criteria.add(Expression.ilike("no", no, MatchMode.START));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
            criteria.add(Expression.eq("pricewithtax", new java.lang.Integer(pricewithtax)));
            if (size != null)
                criteria.add(Expression.ilike("size", size, MatchMode.START));
            if (material != null)
                criteria.add(Expression.ilike("material", material, MatchMode.START));
            if (catchcopy != null)
                criteria.add(Expression.ilike("catchcopy", catchcopy, MatchMode.START));
            if (description != null)
                criteria.add(Expression.ilike("description", description, MatchMode.START));
            if (note != null)
                criteria.add(Expression.ilike("note", note, MatchMode.START));
            criteria.add(Expression.eq("stocknum", new java.lang.Integer(stocknum)));
            if (main) criteria.add(Expression.eq("main", java.lang.Boolean.TRUE));
                if (product != null) criteria.createCriteria("product").add(Expression.eq("id", product));
            if (choises != null && choises.length > 0) criteria.createCriteria("choises").add(Expression.in("id", choises));
            if (carriage != null) criteria.createCriteria("carriage").add(Expression.eq("id", carriage));
            if (zoom != null) criteria.createCriteria("zoom").add(Expression.eq("id", zoom));
            if (detailed != null && detailed.length > 0) criteria.createCriteria("detailed").add(Expression.in("id", detailed));
            if (defaultattachment != null) criteria.createCriteria("defaultattachment").add(Expression.eq("id", defaultattachment));
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
            final Criteria criteria = session.createCriteria(net.malta.model.ItemImpl.class);
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
            lists.put("product", session.createQuery("select item.id, item.id from net.malta.model.Product item order by item.id").list());
            lists.put("choises", session.createQuery("select item.id, item.id from net.malta.model.Choise item order by item.id").list());
            lists.put("carriage", session.createQuery("select item.id, item.id from net.malta.model.Carriage item order by item.id").list());
            lists.put("zoom", session.createQuery("select item.id, item.id from net.malta.model.Attachment item order by item.id").list());
            lists.put("detailed", session.createQuery("select item.id, item.id from net.malta.model.Attachment item order by item.id").list());
            lists.put("defaultattachment", session.createQuery("select item.id, item.id from net.malta.model.Attachment item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Item update(java.lang.Integer id, java.lang.String no, java.lang.String name, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean main, java.lang.Integer product, java.lang.Integer[] choises, java.lang.Integer carriage, java.lang.Integer zoom, java.lang.Integer[] detailed, java.lang.Integer defaultattachment)
    {
        final net.malta.model.Item entity = this.getDao().load(id);

        entity.setNo(no);
        entity.setName(name);
        entity.setPricewithtax(pricewithtax);
        entity.setSize(size);
        entity.setMaterial(material);
        entity.setCatchcopy(catchcopy);
        entity.setDescription(description);
        entity.setNote(note);
        entity.setStocknum(stocknum);
        entity.setMain(main);
        net.malta.model.Product productEntity = null;
        if (product != null)
        {
            productEntity = getProductDao().load(product);
        }

        entity.setProduct(productEntity);

        final java.util.Set choisesEntities = (choises != null && choises.length > 0)
            ? this.findChoiseByIds(choises)
            : java.util.Collections.EMPTY_SET;

        entity.setChoises(choisesEntities);

        net.malta.model.Carriage carriageEntity = null;
        if (carriage != null)
        {
            carriageEntity = getCarriageDao().load(carriage);
        }

        entity.setCarriage(carriageEntity);

        net.malta.model.Attachment zoomEntity = null;
        if (zoom != null)
        {
            zoomEntity = getZoomDao().load(zoom);
        }

        entity.setZoom(zoomEntity);

        final java.util.Set detailedEntities = (detailed != null && detailed.length > 0)
            ? this.findAttachmentByIds(detailed)
            : java.util.Collections.EMPTY_SET;

        entity.setDetailed(detailedEntities);

        net.malta.model.Attachment defaultattachmentEntity = null;
        if (defaultattachment != null)
        {
            defaultattachmentEntity = getDefaultattachmentDao().load(defaultattachment);
        }

        entity.setDefaultattachment(defaultattachmentEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.ItemImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}