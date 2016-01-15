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

public final class ManagePurchase extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PurchaseForm form = (net.malta.model.crud.PurchaseForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("total"))) ? 0 : form.getTotal()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("totalordernum"))) ? 0 : form.getTotalordernum()
            , (StringUtils.isBlank(request.getParameter("shipped"))) ? false : form.isShipped()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("cancelled"))) ? false : form.isCancelled()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("paymentMethod"))) ? null : form.getPaymentMethod()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PurchaseForm form = (net.malta.model.crud.PurchaseForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("total"))) ? 0 : form.getTotal()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("totalordernum"))) ? 0 : form.getTotalordernum()
            , (StringUtils.isBlank(request.getParameter("shipped"))) ? false : form.isShipped()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("cancelled"))) ? false : form.isCancelled()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("paymentMethod"))) ? null : form.getPaymentMethod()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().readBackingLists();
        form.setPublicUserBackingList((java.util.List)backingLists.get("publicUser"));
        form.setChoisesBackingList((java.util.List)backingLists.get("choises"));
        form.setPaymentMethodBackingList((java.util.List)backingLists.get("paymentMethod"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PurchaseForm form = (net.malta.model.crud.PurchaseForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_PublicUser")))
        {
            form.setPublicUser(new java.lang.Integer(request.getParameter("ref_PublicUser")));
        }
        form.setPublicUserBackingList((java.util.List)backingLists.get("publicUser"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Choise")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_Choise"));
            form.setChoises(array);
        }
        form.setChoisesBackingList((java.util.List)backingLists.get("choises"));
        if (StringUtils.isNotBlank(request.getParameter("ref_PaymentMethod")))
        {
            form.setPaymentMethod(new java.lang.Integer(request.getParameter("ref_PaymentMethod")));
        }
        form.setPaymentMethodBackingList((java.util.List)backingLists.get("paymentMethod"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PurchaseForm form = (net.malta.model.crud.PurchaseForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("total"))) ? 0 : form.getTotal()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("totalordernum"))) ? 0 : form.getTotalordernum()
            , (StringUtils.isBlank(request.getParameter("shipped"))) ? false : form.isShipped()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("temp"))) ? false : form.isTemp()
            , (StringUtils.isBlank(request.getParameter("cancelled"))) ? false : form.isCancelled()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("publicUser"))) ? null : form.getPublicUser()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("paymentMethod"))) ? null : form.getPaymentMethod()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.PurchaseForm form = (net.malta.model.crud.PurchaseForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getPurchaseManageableService().delete(selectedRows);
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
