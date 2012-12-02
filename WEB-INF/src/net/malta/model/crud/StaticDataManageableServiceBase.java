// license-header java merge-point
package net.malta.model.crud;

public final class StaticDataManageableServiceBase
    implements StaticDataManageableService
{
    private net.malta.model.crud.StaticDataManageableDao dao;

    public void setDao(net.malta.model.crud.StaticDataManageableDao dao)
    {
        this.dao = dao;
    }

    protected net.malta.model.crud.StaticDataManageableDao getDao()
    {
        return this.dao;
    }

    public net.malta.model.crud.StaticDataValueObject create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception
    {
        if (fromaddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'fromaddress' can not be null");
        }

        if (sitename == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'sitename' can not be null");
        }

        if (basepath == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'basepath' can not be null");
        }

        if (noimage == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'noimage' can not be null");
        }

        if (creditcardprocesurl == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'creditcardprocesurl' can not be null");
        }

        if (contract_code == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.create(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'contract_code' can not be null");
        }

        return toValueObject(dao.create(id, fromaddress, sitename, basepath, unix, mapeventspan, noimage, carriage, creditcardprocesurl, contract_code));
    }

    public java.util.List read(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception
    {
        return toValueObjects(dao.read(id, fromaddress, sitename, basepath, unix, mapeventspan, noimage, carriage, creditcardprocesurl, contract_code));
    }

    public java.util.List readAll()
        throws Exception
    {
        return toValueObjects(dao.readAll());
    }

    public byte[] getNoimage(java.lang.Integer id)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.getNoimage(java.lang.Integer id) - 'id' can not be null");
        }

        return dao.getNoimage(id);
    }

    public net.malta.model.crud.StaticDataValueObject update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code)
        throws Exception
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'id' can not be null");
        }

        if (fromaddress == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'fromaddress' can not be null");
        }

        if (sitename == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'sitename' can not be null");
        }

        if (basepath == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'basepath' can not be null");
        }

        if (noimage == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'noimage' can not be null");
        }

        if (creditcardprocesurl == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'creditcardprocesurl' can not be null");
        }

        if (contract_code == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.update(java.lang.Integer id, java.lang.String fromaddress, java.lang.String sitename, java.lang.String basepath, boolean unix, int mapeventspan, byte[] noimage, int carriage, java.lang.String creditcardprocesurl, java.lang.String contract_code) - 'contract_code' can not be null");
        }

        return toValueObject(dao.update(id, fromaddress, sitename, basepath, unix, mapeventspan, noimage, carriage, creditcardprocesurl, contract_code));
    }

    public void delete(java.lang.Integer[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "net.malta.model.crud.StaticDataManageableService.delete(java.lang.Integer[] ids) - 'ids' can not be null");
        }

        dao.delete(ids);
    }


    private static java.util.List toValueObjects(java.util.Collection entities)
    {
        final java.util.List list = new java.util.ArrayList();

        for (java.util.Iterator iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject((net.malta.model.StaticData)iterator.next()));
        }

        return list;
    }

    private static net.malta.model.crud.StaticDataValueObject toValueObject(net.malta.model.StaticData entity)
    {
        final net.malta.model.crud.StaticDataValueObject valueObject = new net.malta.model.crud.StaticDataValueObject();

        valueObject.setId(entity.getId());
        valueObject.setFromaddress(entity.getFromaddress());
        valueObject.setSitename(entity.getSitename());
        valueObject.setBasepath(entity.getBasepath());
        valueObject.setUnix(entity.isUnix());
        valueObject.setMapeventspan(entity.getMapeventspan());
        valueObject.setNoimage(entity.getNoimage());
        valueObject.setCarriage(entity.getCarriage());
        valueObject.setCreditcardprocesurl(entity.getCreditcardprocesurl());
        valueObject.setContract_code(entity.getContract_code());

        return valueObject;
    }
}
