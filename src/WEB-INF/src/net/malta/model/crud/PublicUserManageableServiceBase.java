// license-header java merge-point
package net.malta.model.crud;

public final class PublicUserManageableServiceBase
    implements PublicUserManageableService
{
    private net.malta.model.crud.PublicUserManageableDao dao;

    public void setDao(net.malta.model.crud.PublicUserManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.PublicUserManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.PublicUserValueObject create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'name' can not be null");
        }

        if (kana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'kana' can not be null");
        }

        if (pref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'pref' can not be null");
        }

        if (address == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'address' can not be null");
        }

        if (buildingname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'buildingname' can not be null");
        }

        if (mail == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'mail' can not be null");
        }

        if (mailforconfirm == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'mailforconfirm' can not be null");
        }

        if (phone == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'phone' can not be null");
        }

        if (deliverykana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliverykana' can not be null");
        }

        if (deliveryblocknumber == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryblocknumber' can not be null");
        }

        if (deliveryaddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryaddress' can not be null");
        }

        if (deliveryname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryname' can not be null");
        }

        if (deliverypref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliverypref' can not be null");
        }

        if (municipality == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'municipality' can not be null");
        }

        if (keitai == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'keitai' can not be null");
        }

        if (password == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'password' can not be null");
        }

        if (fax == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'fax' can not be null");
        }

        if (passwordonetimehash == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.create(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'passwordonetimehash' can not be null");
        }

        return toValueObject(dao.create(id, name, kana, zipthree, zipfour, pref, address, buildingname, mail, mailforconfirm, phone, devliveryhour, deliverydate, deliveryphone, deliverykana, deliveryblocknumber, deliveryaddress, deliveryname, deliveryzipfour, deliveryzipthree, deliverypref, delivertodifferentaddress, male, brithday, birthmonth, municipality, birthyear, keitai, removed, password, fax, registed, temp, passwordonetimehash, purchases, deliveryAddresses, prefecture));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception
    {
        return toValueObjects(dao.read(id, name, kana, zipthree, zipfour, pref, address, buildingname, mail, mailforconfirm, phone, devliveryhour, deliverydate, deliveryphone, deliverykana, deliveryblocknumber, deliveryaddress, deliveryname, deliveryzipfour, deliveryzipthree, deliverypref, delivertodifferentaddress, male, brithday, birthmonth, municipality, birthyear, keitai, removed, password, fax, registed, temp, passwordonetimehash, purchases, deliveryAddresses, prefecture));
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

    public net.malta.model.crud.PublicUserValueObject update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'id' can not be null");
        }

        if (name == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'name' can not be null");
        }

        if (kana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'kana' can not be null");
        }

        if (pref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'pref' can not be null");
        }

        if (address == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'address' can not be null");
        }

        if (buildingname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'buildingname' can not be null");
        }

        if (mail == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'mail' can not be null");
        }

        if (mailforconfirm == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'mailforconfirm' can not be null");
        }

        if (phone == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'phone' can not be null");
        }

        if (deliverykana == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliverykana' can not be null");
        }

        if (deliveryblocknumber == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryblocknumber' can not be null");
        }

        if (deliveryaddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryaddress' can not be null");
        }

        if (deliveryname == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliveryname' can not be null");
        }

        if (deliverypref == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'deliverypref' can not be null");
        }

        if (municipality == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'municipality' can not be null");
        }

        if (keitai == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'keitai' can not be null");
        }

        if (password == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'password' can not be null");
        }

        if (fax == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'fax' can not be null");
        }

        if (passwordonetimehash == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.update(java.lang.Integer id, java.lang.String name, java.lang.String kana, int zipthree, int zipfour, java.lang.String pref, java.lang.String address, java.lang.String buildingname, java.lang.String mail, java.lang.String mailforconfirm, java.lang.String phone, int devliveryhour, int deliverydate, int deliveryphone, java.lang.String deliverykana, java.lang.String deliveryblocknumber, java.lang.String deliveryaddress, java.lang.String deliveryname, int deliveryzipfour, int deliveryzipthree, java.lang.String deliverypref, boolean delivertodifferentaddress, boolean male, int brithday, int birthmonth, java.lang.String municipality, int birthyear, java.lang.String keitai, boolean removed, java.lang.String password, java.lang.String fax, boolean registed, boolean temp, java.lang.String passwordonetimehash, java.lang.Integer[] purchases, java.lang.Integer[] deliveryAddresses, java.lang.Integer prefecture) - 'passwordonetimehash' can not be null");
        }

        return toValueObject(dao.update(id, name, kana, zipthree, zipfour, pref, address, buildingname, mail, mailforconfirm, phone, devliveryhour, deliverydate, deliveryphone, deliverykana, deliveryblocknumber, deliveryaddress, deliveryname, deliveryzipfour, deliveryzipthree, deliverypref, delivertodifferentaddress, male, brithday, birthmonth, municipality, birthyear, keitai, removed, password, fax, registed, temp, passwordonetimehash, purchases, deliveryAddresses, prefecture));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.PublicUserManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.PublicUser)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.PublicUserValueObject toValueObject(net.malta.model.PublicUser entity)
    {
        final net.malta.model.crud.PublicUserValueObject valueObject = new net.malta.model.crud.PublicUserValueObject();

        valueObject.setId(entity.getId());
        valueObject.setName(entity.getName());
        valueObject.setKana(entity.getKana());
        valueObject.setZipthree(entity.getZipthree());
        valueObject.setZipfour(entity.getZipfour());
        valueObject.setPref(entity.getPref());
        valueObject.setAddress(entity.getAddress());
        valueObject.setBuildingname(entity.getBuildingname());
        valueObject.setMail(entity.getMail());
        valueObject.setMailforconfirm(entity.getMailforconfirm());
        valueObject.setPhone(entity.getPhone());
        valueObject.setDevliveryhour(entity.getDevliveryhour());
        valueObject.setDeliverydate(entity.getDeliverydate());
        valueObject.setDeliveryphone(entity.getDeliveryphone());
        valueObject.setDeliverykana(entity.getDeliverykana());
        valueObject.setDeliveryblocknumber(entity.getDeliveryblocknumber());
        valueObject.setDeliveryaddress(entity.getDeliveryaddress());
        valueObject.setDeliveryname(entity.getDeliveryname());
        valueObject.setDeliveryzipfour(entity.getDeliveryzipfour());
        valueObject.setDeliveryzipthree(entity.getDeliveryzipthree());
        valueObject.setDeliverypref(entity.getDeliverypref());
        valueObject.setDelivertodifferentaddress(entity.isDelivertodifferentaddress());
        valueObject.setMale(entity.isMale());
        valueObject.setBrithday(entity.getBrithday());
        valueObject.setBirthmonth(entity.getBirthmonth());
        valueObject.setMunicipality(entity.getMunicipality());
        valueObject.setBirthyear(entity.getBirthyear());
        valueObject.setKeitai(entity.getKeitai());
        valueObject.setRemoved(entity.isRemoved());
        valueObject.setPassword(entity.getPassword());
        valueObject.setFax(entity.getFax());
        valueObject.setRegisted(entity.isRegisted());
        valueObject.setTemp(entity.isTemp());
        valueObject.setPasswordonetimehash(entity.getPasswordonetimehash());

        final java.util.Collection purchases = entity.getPurchases();
        if (purchases == null || purchases.isEmpty())
        {
            valueObject.setPurchases(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[purchases.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = purchases.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.Purchase element = (net.malta.model.Purchase)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setPurchases(values);
        }

        final java.util.Collection deliveryAddresses = entity.getDeliveryAddresses();
        if (deliveryAddresses == null || deliveryAddresses.isEmpty())
        {
            valueObject.setDeliveryAddresses(null);
        }
        else
        {
            final java.lang.Integer[] values = new java.lang.Integer[deliveryAddresses.size()];
            int counter = 0;
            for (final java.util.Iterator iterator = deliveryAddresses.iterator(); iterator.hasNext();counter++)
            {
                final net.malta.model.DeliveryAddress element = (net.malta.model.DeliveryAddress)iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setDeliveryAddresses(values);
        }

        final net.malta.model.Prefecture prefecture = entity.getPrefecture();
        if (prefecture != null)
        {
            valueObject.setPrefecture(prefecture.getId());
        }

        return valueObject;
    }
}
