// license-header java merge-point
package net.malta.model.crud;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public final class ManagePublicUser extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PublicUserForm form = (net.malta.model.crud.PublicUserForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("mail"))) ? null : form.getMail()
            , (StringUtils.isBlank(request.getParameter("mailforconfirm"))) ? null : form.getMailforconfirm()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("devliveryhour"))) ? 0 : form.getDevliveryhour()
            , (StringUtils.isBlank(request.getParameter("deliverydate"))) ? 0 : form.getDeliverydate()
            , (StringUtils.isBlank(request.getParameter("deliveryphone"))) ? 0 : form.getDeliveryphone()
            , (StringUtils.isBlank(request.getParameter("deliverykana"))) ? null : form.getDeliverykana()
            , (StringUtils.isBlank(request.getParameter("deliveryblocknumber"))) ? null : form.getDeliveryblocknumber()
            , (StringUtils.isBlank(request.getParameter("deliveryaddress"))) ? null : form.getDeliveryaddress()
            , (StringUtils.isBlank(request.getParameter("deliveryname"))) ? null : form.getDeliveryname()
            , (StringUtils.isBlank(request.getParameter("deliveryzipfour"))) ? 0 : form.getDeliveryzipfour()
            , (StringUtils.isBlank(request.getParameter("deliveryzipthree"))) ? 0 : form.getDeliveryzipthree()
            , (StringUtils.isBlank(request.getParameter("deliverypref"))) ? null : form.getDeliverypref()
            , (StringUtils.isBlank(request.getParameter("delivertodifferentaddress"))) ? false : form.isDelivertodifferentaddress()
            , (StringUtils.isBlank(request.getParameter("male"))) ? false : form.isMale()
            , (StringUtils.isBlank(request.getParameter("brithday"))) ? 0 : form.getBrithday()
            , (StringUtils.isBlank(request.getParameter("birthmonth"))) ? 0 : form.getBirthmonth()
            , (StringUtils.isBlank(request.getParameter("municipality"))) ? null : form.getMunicipality()
            , (StringUtils.isBlank(request.getParameter("birthyear"))) ? 0 : form.getBirthyear()
            , (StringUtils.isBlank(request.getParameter("keitai"))) ? null : form.getKeitai()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("password"))) ? null : form.getPassword()
            , (StringUtils.isBlank(request.getParameter("fax"))) ? null : form.getFax()
            , (StringUtils.isBlank(request.getParameter("registed"))) ? false : form.isRegisted()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("passwordonetimehash"))) ? null : form.getPasswordonetimehash()
            , (StringUtils.isBlank(request.getParameter("purchases"))) ? null : form.getPurchases()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PublicUserForm form = (net.malta.model.crud.PublicUserForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("mail"))) ? null : form.getMail()
            , (StringUtils.isBlank(request.getParameter("mailforconfirm"))) ? null : form.getMailforconfirm()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("devliveryhour"))) ? 0 : form.getDevliveryhour()
            , (StringUtils.isBlank(request.getParameter("deliverydate"))) ? 0 : form.getDeliverydate()
            , (StringUtils.isBlank(request.getParameter("deliveryphone"))) ? 0 : form.getDeliveryphone()
            , (StringUtils.isBlank(request.getParameter("deliverykana"))) ? null : form.getDeliverykana()
            , (StringUtils.isBlank(request.getParameter("deliveryblocknumber"))) ? null : form.getDeliveryblocknumber()
            , (StringUtils.isBlank(request.getParameter("deliveryaddress"))) ? null : form.getDeliveryaddress()
            , (StringUtils.isBlank(request.getParameter("deliveryname"))) ? null : form.getDeliveryname()
            , (StringUtils.isBlank(request.getParameter("deliveryzipfour"))) ? 0 : form.getDeliveryzipfour()
            , (StringUtils.isBlank(request.getParameter("deliveryzipthree"))) ? 0 : form.getDeliveryzipthree()
            , (StringUtils.isBlank(request.getParameter("deliverypref"))) ? null : form.getDeliverypref()
            , (StringUtils.isBlank(request.getParameter("delivertodifferentaddress"))) ? false : form.isDelivertodifferentaddress()
            , (StringUtils.isBlank(request.getParameter("male"))) ? false : form.isMale()
            , (StringUtils.isBlank(request.getParameter("brithday"))) ? 0 : form.getBrithday()
            , (StringUtils.isBlank(request.getParameter("birthmonth"))) ? 0 : form.getBirthmonth()
            , (StringUtils.isBlank(request.getParameter("municipality"))) ? null : form.getMunicipality()
            , (StringUtils.isBlank(request.getParameter("birthyear"))) ? 0 : form.getBirthyear()
            , (StringUtils.isBlank(request.getParameter("keitai"))) ? null : form.getKeitai()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("password"))) ? null : form.getPassword()
            , (StringUtils.isBlank(request.getParameter("fax"))) ? null : form.getFax()
            , (StringUtils.isBlank(request.getParameter("registed"))) ? false : form.isRegisted()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("passwordonetimehash"))) ? null : form.getPasswordonetimehash()
            , (StringUtils.isBlank(request.getParameter("purchases"))) ? null : form.getPurchases()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().readBackingLists();
        form.setPurchasesBackingList((java.util.List)backingLists.get("purchases"));
        form.setDeliveryAddressesBackingList((java.util.List)backingLists.get("deliveryAddresses"));
        form.setPrefectureBackingList((java.util.List)backingLists.get("prefecture"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PublicUserForm form = (net.malta.model.crud.PublicUserForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_Purchase")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_Purchase"));
            form.setPurchases(array);
        }
        form.setPurchasesBackingList((java.util.List)backingLists.get("purchases"));
        if (StringUtils.isNotBlank(request.getParameter("ref_DeliveryAddress")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_DeliveryAddress"));
            form.setDeliveryAddresses(array);
        }
        form.setDeliveryAddressesBackingList((java.util.List)backingLists.get("deliveryAddresses"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Prefecture")))
        {
            form.setPrefecture(new java.lang.Integer(request.getParameter("ref_Prefecture")));
        }
        form.setPrefectureBackingList((java.util.List)backingLists.get("prefecture"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PublicUserForm form = (net.malta.model.crud.PublicUserForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("mail"))) ? null : form.getMail()
            , (StringUtils.isBlank(request.getParameter("mailforconfirm"))) ? null : form.getMailforconfirm()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("devliveryhour"))) ? 0 : form.getDevliveryhour()
            , (StringUtils.isBlank(request.getParameter("deliverydate"))) ? 0 : form.getDeliverydate()
            , (StringUtils.isBlank(request.getParameter("deliveryphone"))) ? 0 : form.getDeliveryphone()
            , (StringUtils.isBlank(request.getParameter("deliverykana"))) ? null : form.getDeliverykana()
            , (StringUtils.isBlank(request.getParameter("deliveryblocknumber"))) ? null : form.getDeliveryblocknumber()
            , (StringUtils.isBlank(request.getParameter("deliveryaddress"))) ? null : form.getDeliveryaddress()
            , (StringUtils.isBlank(request.getParameter("deliveryname"))) ? null : form.getDeliveryname()
            , (StringUtils.isBlank(request.getParameter("deliveryzipfour"))) ? 0 : form.getDeliveryzipfour()
            , (StringUtils.isBlank(request.getParameter("deliveryzipthree"))) ? 0 : form.getDeliveryzipthree()
            , (StringUtils.isBlank(request.getParameter("deliverypref"))) ? null : form.getDeliverypref()
            , (StringUtils.isBlank(request.getParameter("delivertodifferentaddress"))) ? false : form.isDelivertodifferentaddress()
            , (StringUtils.isBlank(request.getParameter("male"))) ? false : form.isMale()
            , (StringUtils.isBlank(request.getParameter("brithday"))) ? 0 : form.getBrithday()
            , (StringUtils.isBlank(request.getParameter("birthmonth"))) ? 0 : form.getBirthmonth()
            , (StringUtils.isBlank(request.getParameter("municipality"))) ? null : form.getMunicipality()
            , (StringUtils.isBlank(request.getParameter("birthyear"))) ? 0 : form.getBirthyear()
            , (StringUtils.isBlank(request.getParameter("keitai"))) ? null : form.getKeitai()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("password"))) ? null : form.getPassword()
            , (StringUtils.isBlank(request.getParameter("fax"))) ? null : form.getFax()
            , (StringUtils.isBlank(request.getParameter("registed"))) ? false : form.isRegisted()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("passwordonetimehash"))) ? null : form.getPasswordonetimehash()
            , (StringUtils.isBlank(request.getParameter("purchases"))) ? null : form.getPurchases()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PublicUserForm form = (net.malta.model.crud.PublicUserForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getPublicUserManageableService().delete(selectedRows);
        }

        return preload(mapping, actionForm, request, response);
    }

    private void saveMaxResultsWarning(HttpServletRequest request)
    {
        final HttpSession session = request.getSession();

        ActionMessages messages = (ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new ActionMessages();
            session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.warningmessages", new ActionMessage("maximum.results.fetched.warning", "250"));
    }

}
