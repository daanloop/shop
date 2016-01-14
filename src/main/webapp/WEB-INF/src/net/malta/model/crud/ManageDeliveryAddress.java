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

public final class ManageDeliveryAddress extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressForm form = (net.malta.model.crud.DeliveryAddressForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("hasgiftcard"))) ? false : form.isHasgiftcard()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressForm form = (net.malta.model.crud.DeliveryAddressForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("hasgiftcard"))) ? false : form.isHasgiftcard()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().readBackingLists();
        form.setDeliveryAddressChoisesBackingList((java.util.List)backingLists.get("deliveryAddressChoises"));
        form.setPublicUserBackingList((java.util.List)backingLists.get("publicUser"));
        form.setGiftCardBackingList((java.util.List)backingLists.get("giftCard"));
        form.setPrefectureBackingList((java.util.List)backingLists.get("prefecture"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressForm form = (net.malta.model.crud.DeliveryAddressForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_DeliveryAddressChoise")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_DeliveryAddressChoise"));
            form.setDeliveryAddressChoises(array);
        }
        form.setDeliveryAddressChoisesBackingList((java.util.List)backingLists.get("deliveryAddressChoises"));
        if (StringUtils.isNotBlank(request.getParameter("ref_PublicUser")))
        {
            form.setPublicUser(new java.lang.Integer(request.getParameter("ref_PublicUser")));
        }
        form.setPublicUserBackingList((java.util.List)backingLists.get("publicUser"));
        if (StringUtils.isNotBlank(request.getParameter("ref_GiftCard")))
        {
            form.setGiftCard(new java.lang.Integer(request.getParameter("ref_GiftCard")));
        }
        form.setGiftCardBackingList((java.util.List)backingLists.get("giftCard"));
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
        final net.malta.model.crud.DeliveryAddressForm form = (net.malta.model.crud.DeliveryAddressForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("kana"))) ? null : form.getKana()
            , (StringUtils.isBlank(request.getParameter("zipthree"))) ? 0 : form.getZipthree()
            , (StringUtils.isBlank(request.getParameter("zipfour"))) ? 0 : form.getZipfour()
            , (StringUtils.isBlank(request.getParameter("phone"))) ? null : form.getPhone()
            , (StringUtils.isBlank(request.getParameter("address"))) ? null : form.getAddress()
            , (StringUtils.isBlank(request.getParameter("buildingname"))) ? null : form.getBuildingname()
            , (StringUtils.isBlank(request.getParameter("pref"))) ? null : form.getPref()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("hasgiftcard"))) ? false : form.isHasgiftcard()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
            , (StringUtils.isBlank(request.getParameter("prefecture"))) ? null : form.getPrefecture()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressForm form = (net.malta.model.crud.DeliveryAddressForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getDeliveryAddressManageableService().delete(selectedRows);
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
