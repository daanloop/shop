// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package net.malta.model;

/**
 * @see net.malta.model.Product
 */
public interface ProductDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public final static int TRANSFORM_NONE = 0;

    /**
     * Loads an instance of net.malta.model.Product from the persistent store.
     */
    public net.malta.model.Product load(java.lang.Integer id);

    /**
     * <p>
     * Does the same thing as {@link #load(java.lang.Integer)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     * optionally transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     *
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     */
    public Object load(int transform, java.lang.Integer id);

    /**
     * Loads all entities of type {@link net.malta.model.Product}.
     *
     * @return the loaded entities.
     */
    public java.util.Collection loadAll();

    /**
     * <p>
     * Does the same thing as {@link #loadAll()} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     *
     * @param transform the flag indicating what transformation to use.
     * @return the loaded entities.
     */
    public java.util.Collection loadAll(final int transform);

    /**
     * Creates an instance of net.malta.model.Product and adds it to the persistent store.
     */
    public net.malta.model.Product create(net.malta.model.Product product);

    /**
     * <p>
     * Does the same thing as {@link #create(net.malta.model.Product)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     */
    public Object create(int transform, net.malta.model.Product product);

    /**
     * Creates a new instance of net.malta.model.Product and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of net.malta.model.Product
     * instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     * Does the same thing as {@link #create(net.malta.model.Product)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entities (into value objects for example). By default, transformation does
     * not occur.
     * </p>
     */
    public java.util.Collection create(int transform, java.util.Collection entities);

    /**
     * <p>
     * Creates a new <code>net.malta.model.Product</code>
     * instance from <strong>all</strong> attributes and adds it to
     * the persistent store.
     * </p>
     */
    public net.malta.model.Product create(
        java.lang.String no,
        java.lang.String name,
        java.util.Date date,
        boolean pub,
        int pricewithtax,
        java.lang.String size,
        java.lang.String material,
        java.lang.String catchcopy,
        java.lang.String description,
        java.lang.String note,
        int stocknum,
        boolean removed,
        java.lang.String mainitemname,
        java.lang.String english);

    /**
     * <p>
     * Does the same thing as {@link #create(java.lang.String, java.lang.String, java.util.Date, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.lang.String, java.lang.String)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     */
    public Object create(
        int transform,
        java.lang.String no,
        java.lang.String name,
        java.util.Date date,
        boolean pub,
        int pricewithtax,
        java.lang.String size,
        java.lang.String material,
        java.lang.String catchcopy,
        java.lang.String description,
        java.lang.String note,
        int stocknum,
        boolean removed,
        java.lang.String mainitemname,
        java.lang.String english);


    /**
     * Updates the <code>product</code> instance in the persistent store.
     */
    public void update(net.malta.model.Product product);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of net.malta.model.Product from the persistent store.
     */
    public void remove(net.malta.model.Product product);

    /**
     * Removes the instance of net.malta.model.Product having the given
     * <code>identifier</code> from the persistent store.
     */
    public void remove(java.lang.Integer id);

    /**
     * Removes all entities in the given <code>entities<code> collection.
     */
    public void remove(java.util.Collection entities);

}
