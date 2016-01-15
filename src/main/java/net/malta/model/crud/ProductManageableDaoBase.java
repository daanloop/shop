// license-header java merge-point
package net.malta.model.crud;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Expression;

public final class ProductManageableDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements ProductManageableDao
{
    private net.malta.model.ProductDao dao;

    public void setDao(net.malta.model.ProductDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.ProductDao getDao()
    {
        return this.dao;
    }

    private net.malta.model.ItemDao itemsDao = null;

    public void setItemsDao(net.malta.model.ItemDao itemsDao)
    {
        this.itemsDao = itemsDao;
    }

    protected net.malta.model.ItemDao getItemsDao()
    {
        return this.itemsDao;
    }

    private net.malta.model.CategoryDao categoryDao = null;

    public void setCategoryDao(net.malta.model.CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    protected net.malta.model.CategoryDao getCategoryDao()
    {
        return this.categoryDao;
    }

    private net.malta.model.AttachmentDao thumnailDao = null;

    public void setThumnailDao(net.malta.model.AttachmentDao thumnailDao)
    {
        this.thumnailDao = thumnailDao;
    }

    protected net.malta.model.AttachmentDao getThumnailDao()
    {
        return this.thumnailDao;
    }

    private net.malta.model.AttachmentDao slideshowDao = null;

    public void setSlideshowDao(net.malta.model.AttachmentDao slideshowDao)
    {
        this.slideshowDao = slideshowDao;
    }

    protected net.malta.model.AttachmentDao getSlideshowDao()
    {
        return this.slideshowDao;
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

    private java.util.Set findCategoryByIds(java.lang.Integer[] ids)
    {
        final Session session = this.getSession(false);
        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.CategoryImpl.class);
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

    public net.malta.model.Product create(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
    {
        final net.malta.model.Product entity = new net.malta.model.ProductImpl();
        entity.setId(id);
        entity.setNo(no);
        entity.setName(name);
        entity.setDate(date);
        entity.setPub(pub);
        entity.setPricewithtax(pricewithtax);
        entity.setSize(size);
        entity.setMaterial(material);
        entity.setCatchcopy(catchcopy);
        entity.setDescription(description);
        entity.setNote(note);
        entity.setStocknum(stocknum);
        entity.setRemoved(removed);
        entity.setMainitemname(mainitemname);
        entity.setEnglish(english);
        final java.util.Set itemsEntities = (items != null && items.length > 0)
            ? this.findItemByIds(items)
            : java.util.Collections.EMPTY_SET;

        entity.setItems(itemsEntities);

        net.malta.model.Category categoryEntity = null;
        if (category != null)
        {
            categoryEntity = (net.malta.model.Category)getCategoryDao().load(category);
        }

        entity.setCategory(categoryEntity);

        net.malta.model.Attachment thumnailEntity = null;
        if (thumnail != null)
        {
            thumnailEntity = (net.malta.model.Attachment)getThumnailDao().load(thumnail);
        }

        entity.setThumnail(thumnailEntity);

        net.malta.model.Attachment slideshowEntity = null;
        if (slideshow != null)
        {
            slideshowEntity = (net.malta.model.Attachment)getSlideshowDao().load(slideshow);
        }

        entity.setSlideshow(slideshowEntity);


        return (net.malta.model.Product)this.getDao().create(entity);
    }

    public java.util.List read(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
    {
        final Session session = getSession(false);

        try
        {
            final Criteria criteria = session.createCriteria(net.malta.model.ProductImpl.class);

            if (id != null)
            criteria.add(Expression.eq("id", id));
            if (no != null)
                criteria.add(Expression.ilike("no", no, MatchMode.START));
            if (name != null)
                criteria.add(Expression.ilike("name", name, MatchMode.START));
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
            if (pub) criteria.add(Expression.eq("pub", java.lang.Boolean.TRUE));
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
            if (removed) criteria.add(Expression.eq("removed", java.lang.Boolean.TRUE));
                if (mainitemname != null)
                criteria.add(Expression.ilike("mainitemname", mainitemname, MatchMode.START));
            if (english != null)
                criteria.add(Expression.ilike("english", english, MatchMode.START));
            if (items != null && items.length > 0) criteria.createCriteria("items").add(Expression.in("id", items));
            if (category != null) criteria.createCriteria("category").add(Expression.eq("id", category));
            if (thumnail != null) criteria.createCriteria("thumnail").add(Expression.eq("id", thumnail));
            if (slideshow != null) criteria.createCriteria("slideshow").add(Expression.eq("id", slideshow));
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
            final Criteria criteria = session.createCriteria(net.malta.model.ProductImpl.class);
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
            lists.put("items", session.createQuery("select item.id, item.id from net.malta.model.Item item order by item.id").list());
            lists.put("category", session.createQuery("select item.id, item.id from net.malta.model.Category item order by item.id").list());
            lists.put("thumnail", session.createQuery("select item.id, item.id from net.malta.model.Attachment item order by item.id").list());
            lists.put("slideshow", session.createQuery("select item.id, item.id from net.malta.model.Attachment item order by item.id").list());
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
        return lists;
    }

    public net.malta.model.Product update(java.lang.Integer id, java.lang.String no, java.lang.String name, java.util.Date date, boolean pub, int pricewithtax, java.lang.String size, java.lang.String material, java.lang.String catchcopy, java.lang.String description, java.lang.String note, int stocknum, boolean removed, java.lang.String mainitemname, java.lang.String english, java.lang.Integer[] items, java.lang.Integer category, java.lang.Integer thumnail, java.lang.Integer slideshow)
    {
        final net.malta.model.Product entity = this.getDao().load(id);

        entity.setNo(no);
        entity.setName(name);
        entity.setDate(date);
        entity.setPub(pub);
        entity.setPricewithtax(pricewithtax);
        entity.setSize(size);
        entity.setMaterial(material);
        entity.setCatchcopy(catchcopy);
        entity.setDescription(description);
        entity.setNote(note);
        entity.setStocknum(stocknum);
        entity.setRemoved(removed);
        entity.setMainitemname(mainitemname);
        entity.setEnglish(english);
        final java.util.Set itemsEntities = (items != null && items.length > 0)
            ? this.findItemByIds(items)
            : java.util.Collections.EMPTY_SET;

        entity.setItems(itemsEntities);

        net.malta.model.Category categoryEntity = null;
        if (category != null)
        {
            categoryEntity = getCategoryDao().load(category);
        }

        entity.setCategory(categoryEntity);

        net.malta.model.Attachment thumnailEntity = null;
        if (thumnail != null)
        {
            thumnailEntity = getThumnailDao().load(thumnail);
        }

        entity.setThumnail(thumnailEntity);

        net.malta.model.Attachment slideshowEntity = null;
        if (slideshow != null)
        {
            slideshowEntity = getSlideshowDao().load(slideshow);
        }

        entity.setSlideshow(slideshowEntity);


        this.getDao().update(entity);
        return entity;
    }

    public void delete(java.lang.Integer[] ids)
    {
        final Session session = getSession(false);
        try
        {
            final org.hibernate.Query queryObject =
                session.createQuery("delete net.malta.model.ProductImpl where id in (:ids)");
            queryObject.setParameterList("ids", ids);
            queryObject.executeUpdate();
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

}