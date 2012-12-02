// license-header java merge-point
package net.malta.model.crud;

public final class DeliveryAddressManageableServiceBase
    implements DeliveryAddressManageableService
{
    private net.malta.model.crud.DeliveryAddressManageableDao dao;

    public void setDao(net.malta.model.crud.DeliveryAddressManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.DeliveryAddressManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.DeliveryAddressValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'name' can not be null");
        }

        if (kana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'kana' can not be null");
        }

        if (phone == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'phone' can not be null");
        }

        if (address == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'address' can not be null");
        }

        if (buildingname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'buildingname' can not be null");
        }

        if (pref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'pref' can not be null");
        }

        if (preferreddate == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'preferreddate' can not be null");
        }

        if (preferredtime == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'preferredtime' can not be null");
        }

        if (publicUser == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'publicUser' can not be null");
        }

        return toValueObject(dao.create(id, name, kana, zipthree, zipfour, phone, address, buildingname, pref, preferreddate, preferredtime, hasgiftcard, deliveryAddressChoises, publicUser, giftCard, prefecture));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, kana, zipthree, zipfour, phone, address, buildingname, pref, preferreddate, preferredtime, hasgiftcard, deliveryAddressChoises, publicUser, giftCard, prefecture));
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

    public net.malta.model.crud.DeliveryAddressValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'name' can not be null");
        }

        if (kana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'kana' can not be null");
        }

        if (phone == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'phone' can not be null");
        }

        if (address == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'address' can not be null");
        }

        if (buildingname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'buildingname' can not be null");
        }

        if (pref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'pref' can not be null");
        }

        if (preferreddate == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'preferreddate' can not be null");
        }

        if (preferredtime == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'preferredtime' can not be null");
        }

        if (publicUser == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String phone, java.lang.String address, java.lang.String buildingname, java.lang.String pref, java.lang.String preferreddate, java.lang.String preferredtime, boolean hasgiftcard, java.lang.Integer[] deliveryAddressChoises, java.lang.Integer publicUser, java.lang.Integer giftCard, java.lang.Integer prefecture) - 'publicUser' can not be null");
        }

        return toValueObject(dao.update(id, name, kana, zipthree, zipfour, phone, address, buildingname, pref, preferreddate, preferredtime, hasgiftcard, deliveryAddressChoises, publicUser, giftCard, prefecture));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.DeliveryAddressManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.DeliveryAddress)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.DeliveryAddressValueObject toValueObject(net.malta.model.DeliveryAddress entity)
    {
        final net.malta.model.crud.DeliveryAddressValueObject valueObject = new net.malta.model.crud.DeliveryAddressValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());
        valueObject.setKana(entity.getKana());
        valueObject.setZipthree(entity.getZipthree());
        valueObject.setZipfour(entity.getZipfour());
        valueObject.setPhone(entity.getPhone());
        valueObject.setAddress(entity.getAddress());
        valueObject.setBuildingname(entity.getBuildingname());
        valueObject.setPref(entity.getPref());
        valueObject.setPreferreddate(entity.getPreferreddate());
        valueObject.setPreferredtime(entity.getPreferredtime());
        valueObject.setHasgiftcard(entity.isHasgiftcard());

        final java.util.Collection deliveryAddressChoises = entity.getDeliveryAddressChoises();
        if (deliveryAddressChoises == null || deliveryAddressChoises.isEmpty())
        {
            valueObject.setDeliveryAddressChoises(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[deliveryAddressChoises.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = deliveryAddressChoises.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.DeliveryAddressChoise element = (net.malta.model.DeliveryAddressChoise)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setDeliveryAddressChoises(values);
        }

        final net.malta.model.PublicUser publicUser = entity.getPublicUser();
        if (publicUser != null)
        {
            valueObject.setPublicUser(publicUser.getId());
        }

        final net.malta.model.GiftCard giftCard = entity.getGiftCard();
        if (giftCard != null)
        {
            valueObject.setGiftCard(giftCard.getId());
        }

        final net.malta.model.Prefecture prefecture = entity.getPrefecture();
        if (prefecture != null)
        {
            valueObject.setPrefecture(prefecture.getId());
        }

        return valueObject;
    }
}
