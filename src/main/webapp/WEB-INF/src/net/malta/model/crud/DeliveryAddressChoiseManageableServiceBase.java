// license-header java merge-point
package net.malta.model.crud;

public final class DeliveryAddressChoiseManageableServiceBase
    implements DeliveryAddressChoiseManageableService
{
    private net.malta.model.crud.DeliveryAddressChoiseManageableDao dao;

    public void setDao(net.malta.model.crud.DeliveryAddressChoiseManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.DeliveryAddressChoiseManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.DeliveryAddressChoiseValueObject create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception
    {
        if (preferreddate == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'preferreddate' can not be null");
        }

        if (preferredtime == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'preferredtime' can not be null");
        }

        if (deliveryAddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'deliveryAddress' can not be null");
        }

        if (choise == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.create(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'choise' can not be null");
        }

        return toValueObject(dao.create(id, ordernum, preferreddate, preferredtime, deliveryAddress, choise, giftCard));
    }

    public java.util.List read(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception
    {
        return toValueObjects(dao.read(id, ordernum, preferreddate, preferredtime, deliveryAddress, choise, giftCard));
    }

    public java.util.List readAll()
        throws Exception
    {
        return toValueObjects(dao.readAll());
    }

    public java.util.Map readBackingLists()
        throws Exception
    {
        return getDao().readBackingLists();
    }

    public net.malta.model.crud.DeliveryAddressChoiseValueObject update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'id' can not be null");
        }

        if (preferreddate == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'preferreddate' can not be null");
        }

        if (preferredtime == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'preferredtime' can not be null");
        }

        if (deliveryAddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'deliveryAddress' can not be null");
        }

        if (choise == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.update(java.lang.Integer id, int ordernum, java.lang.String preferreddate, java.lang.String preferredtime, java.lang.Integer deliveryAddress, java.lang.Integer choise, java.lang.Integer giftCard) - 'choise' can not be null");
        }

        return toValueObject(dao.update(id, ordernum, preferreddate, preferredtime, deliveryAddress, choise, giftCard));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressChoiseManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.DeliveryAddressChoise)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.DeliveryAddressChoiseValueObject toValueObject(net.malta.model.DeliveryAddressChoise entity)
    {
        final net.malta.model.crud.DeliveryAddressChoiseValueObject valueObject = new net.malta.model.crud.DeliveryAddressChoiseValueObject();

        valueObject.setId(entity.getId());
        valueObject.setOrdernum(entity.getOrdernum());
        valueObject.setPreferreddate(entity.getPreferreddate());
        valueObject.setPreferredtime(entity.getPreferredtime());

        final net.malta.model.DeliveryAddress deliveryAddress = entity.getDeliveryAddress();
        if (deliveryAddress != null)
        {
            valueObject.setDeliveryAddress(deliveryAddress.getId());
        }

        final net.malta.model.Choise choise = entity.getChoise();
        if (choise != null)
        {
            valueObject.setChoise(choise.getId());
        }

        final net.malta.model.GiftCard giftCard = entity.getGiftCard();
        if (giftCard != null)
        {
            valueObject.setGiftCard(giftCard.getId());
        }

        return valueObject;
    }
}
