// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringManageableServiceLocator.vsl in andromda-spring-cartridge.
//
package net.malta;

/**
 * Locates and provides all available application services.
 */
public class ManageableServiceLocator
{
    /**
     * The default application context location.
     */
    private final String DEFAULT_BEAN_REFERENCE_LOCATION = "beanRefFactory.xml";

    /**
     * The bean factory reference location.
     */
    private String beanFactoryReferenceLocation;

    protected ManageableServiceLocator()
    {
        // shouldn't be instantiated
    }

    /**
     * The shared instance of this ManageableServiceLocator.
     */
    private final static ManageableServiceLocator instance = new ManageableServiceLocator();

    /**
     * Gets the shared instance of this Class
     *
     * @return the shared service locator instance.
     */
    public static final ManageableServiceLocator instance()
    {
        return instance;
    }

    /**
     * Initializes the Spring application context from
     * the given <code>beanFactoryReferenceLocation</code>.  If <code>null</code>
     * is specified for the <code>beanFactoryReferenceLocation</code>
     * then the default application context will be used.
     *
     * @param contextLocation the location of the context
     */
    public synchronized void init(String beanFactoryReferenceLocation)
    {
        this.beanFactoryReferenceLocation = beanFactoryReferenceLocation;
        this.beanFactoryReference = null;
    }

    /**
     * The bean factory reference instance.
     */
    private org.springframework.beans.factory.access.BeanFactoryReference beanFactoryReference;

    /**
     * Gets the Spring ApplicationContext.
     */
    protected synchronized org.springframework.context.ApplicationContext getContext()
    {
        if (this.beanFactoryReference == null)
        {
            if (this.beanFactoryReferenceLocation == null)
            {
                this.beanFactoryReferenceLocation = DEFAULT_BEAN_REFERENCE_LOCATION;
            }
            org.springframework.beans.factory.access.BeanFactoryLocator beanFactoryLocator =
                org.springframework.context.access.ContextSingletonBeanFactoryLocator.getInstance(
                    this.beanFactoryReferenceLocation);
            this.beanFactoryReference = beanFactoryLocator.useBeanFactory("beanRefFactory");
        }
        return (org.springframework.context.ApplicationContext)this.beanFactoryReference.getFactory();
    }

    /**
     * Shuts down the ManageableServiceLocator and releases any used resources.
     */
    public synchronized void shutdown()
    {
        if (this.beanFactoryReference != null)
        {
            this.beanFactoryReference.release();
            this.beanFactoryReference = null;
        }
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.DbFileManageableService}.
     */
    public final net.malta.model.crud.DbFileManageableService getDbFileManageableService()
    {
        return (net.malta.model.crud.DbFileManageableService)
            getContext().getBean("DbFileManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.AttachmentManageableService}.
     */
    public final net.malta.model.crud.AttachmentManageableService getAttachmentManageableService()
    {
        return (net.malta.model.crud.AttachmentManageableService)
            getContext().getBean("AttachmentManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.PublicUserManageableService}.
     */
    public final net.malta.model.crud.PublicUserManageableService getPublicUserManageableService()
    {
        return (net.malta.model.crud.PublicUserManageableService)
            getContext().getBean("PublicUserManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.ItemManageableService}.
     */
    public final net.malta.model.crud.ItemManageableService getItemManageableService()
    {
        return (net.malta.model.crud.ItemManageableService)
            getContext().getBean("ItemManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.PurchaseManageableService}.
     */
    public final net.malta.model.crud.PurchaseManageableService getPurchaseManageableService()
    {
        return (net.malta.model.crud.PurchaseManageableService)
            getContext().getBean("PurchaseManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.ProductManageableService}.
     */
    public final net.malta.model.crud.ProductManageableService getProductManageableService()
    {
        return (net.malta.model.crud.ProductManageableService)
            getContext().getBean("ProductManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.ChoiseManageableService}.
     */
    public final net.malta.model.crud.ChoiseManageableService getChoiseManageableService()
    {
        return (net.malta.model.crud.ChoiseManageableService)
            getContext().getBean("ChoiseManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.CategoryManageableService}.
     */
    public final net.malta.model.crud.CategoryManageableService getCategoryManageableService()
    {
        return (net.malta.model.crud.CategoryManageableService)
            getContext().getBean("CategoryManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.DeliveryAddressManageableService}.
     */
    public final net.malta.model.crud.DeliveryAddressManageableService getDeliveryAddressManageableService()
    {
        return (net.malta.model.crud.DeliveryAddressManageableService)
            getContext().getBean("DeliveryAddressManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.DeliveryAddressChoiseManageableService}.
     */
    public final net.malta.model.crud.DeliveryAddressChoiseManageableService getDeliveryAddressChoiseManageableService()
    {
        return (net.malta.model.crud.DeliveryAddressChoiseManageableService)
            getContext().getBean("DeliveryAddressChoiseManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.GiftCardManageableService}.
     */
    public final net.malta.model.crud.GiftCardManageableService getGiftCardManageableService()
    {
        return (net.malta.model.crud.GiftCardManageableService)
            getContext().getBean("GiftCardManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.StaticDataManageableService}.
     */
    public final net.malta.model.crud.StaticDataManageableService getStaticDataManageableService()
    {
        return (net.malta.model.crud.StaticDataManageableService)
            getContext().getBean("StaticDataManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.CarriageManageableService}.
     */
    public final net.malta.model.crud.CarriageManageableService getCarriageManageableService()
    {
        return (net.malta.model.crud.CarriageManageableService)
            getContext().getBean("CarriageManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.PaymentMethodManageableService}.
     */
    public final net.malta.model.crud.PaymentMethodManageableService getPaymentMethodManageableService()
    {
        return (net.malta.model.crud.PaymentMethodManageableService)
            getContext().getBean("PaymentMethodManageableService");
    }

    /**
     * Gets an instance of {@link net.malta.model.crud.PrefectureManageableService}.
     */
    public final net.malta.model.crud.PrefectureManageableService getPrefectureManageableService()
    {
        return (net.malta.model.crud.PrefectureManageableService)
            getContext().getBean("PrefectureManageableService");
    }

}
