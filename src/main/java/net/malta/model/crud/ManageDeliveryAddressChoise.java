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

public final class ManageDeliveryAddressChoise extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressChoiseForm form = (net.malta.model.crud.DeliveryAddressChoiseForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("ordernum"))) ? 0 : form.getOrdernum()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("deliveryAddress"))) ? null : form.getDeliveryAddress()
            , (StringUtils.isBlank(request.getParameter("choise"))) ? null : form.getChoise()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressChoiseForm form = (net.malta.model.crud.DeliveryAddressChoiseForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("ordernum"))) ? 0 : form.getOrdernum()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("deliveryAddress"))) ? null : form.getDeliveryAddress()
            , (StringUtils.isBlank(request.getParameter("choise"))) ? null : form.getChoise()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().readBackingLists();
        form.setDeliveryAddressBackingList((java.util.List)backingLists.get("deliveryAddress"));
        form.setChoiseBackingList((java.util.List)backingLists.get("choise"));
        form.setGiftCardBackingList((java.util.List)backingLists.get("giftCard"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressChoiseForm form = (net.malta.model.crud.DeliveryAddressChoiseForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_DeliveryAddress")))
        {
            form.setDeliveryAddress(new java.lang.Integer(request.getParameter("ref_DeliveryAddress")));
        }
        form.setDeliveryAddressBackingList((java.util.List)backingLists.get("deliveryAddress"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Choise")))
        {
            form.setChoise(new java.lang.Integer(request.getParameter("ref_Choise")));
        }
        form.setChoiseBackingList((java.util.List)backingLists.get("choise"));
        if (StringUtils.isNotBlank(request.getParameter("ref_GiftCard")))
        {
            form.setGiftCard(new java.lang.Integer(request.getParameter("ref_GiftCard")));
        }
        form.setGiftCardBackingList((java.util.List)backingLists.get("giftCard"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressChoiseForm form = (net.malta.model.crud.DeliveryAddressChoiseForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("ordernum"))) ? 0 : form.getOrdernum()
            , (StringUtils.isBlank(request.getParameter("preferreddate"))) ? null : form.getPreferreddate()
            , (StringUtils.isBlank(request.getParameter("preferredtime"))) ? null : form.getPreferredtime()
            , (StringUtils.isBlank(request.getParameter("deliveryAddress"))) ? null : form.getDeliveryAddress()
            , (StringUtils.isBlank(request.getParameter("choise"))) ? null : form.getChoise()
            , (StringUtils.isBlank(request.getParameter("giftCard"))) ? null : form.getGiftCard()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DeliveryAddressChoiseForm form = (net.malta.model.crud.DeliveryAddressChoiseForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getDeliveryAddressChoiseManageableService().delete(selectedRows);
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
