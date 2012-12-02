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

public final class ManageGiftCard extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.GiftCardForm form = (net.malta.model.crud.GiftCardForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.GiftCardForm form = (net.malta.model.crud.GiftCardForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().readBackingLists();
        form.setDeliveryAddressesBackingList((java.util.List)backingLists.get("deliveryAddresses"));
        form.setDeliveryAddressChoisesBackingList((java.util.List)backingLists.get("deliveryAddressChoises"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.GiftCardForm form = (net.malta.model.crud.GiftCardForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_DeliveryAddress")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_DeliveryAddress"));
            form.setDeliveryAddresses(array);
        }
        form.setDeliveryAddressesBackingList((java.util.List)backingLists.get("deliveryAddresses"));
        if (StringUtils.isNotBlank(request.getParameter("ref_DeliveryAddressChoise")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_DeliveryAddressChoise"));
            form.setDeliveryAddressChoises(array);
        }
        form.setDeliveryAddressChoisesBackingList((java.util.List)backingLists.get("deliveryAddressChoises"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.GiftCardForm form = (net.malta.model.crud.GiftCardForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("deliveryAddresses"))) ? null : form.getDeliveryAddresses()
            , (StringUtils.isBlank(request.getParameter("deliveryAddressChoises"))) ? null : form.getDeliveryAddressChoises()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.GiftCardForm form = (net.malta.model.crud.GiftCardForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getGiftCardManageableService().delete(selectedRows);
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
