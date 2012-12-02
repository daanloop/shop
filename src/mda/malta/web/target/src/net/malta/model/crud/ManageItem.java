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

public final class ManageItem extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ItemForm form = (net.malta.model.crud.ItemForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getItemManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("main"))) ? false : form.isMain()
            , (StringUtils.isBlank(request.getParameter("product"))) ? null : form.getProduct()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? null : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("zoom"))) ? null : form.getZoom()
            , (StringUtils.isBlank(request.getParameter("detailed"))) ? null : form.getDetailed()
            , (StringUtils.isBlank(request.getParameter("defaultattachment"))) ? null : form.getDefaultattachment()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ItemForm form = (net.malta.model.crud.ItemForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getItemManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("main"))) ? false : form.isMain()
            , (StringUtils.isBlank(request.getParameter("product"))) ? null : form.getProduct()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? null : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("zoom"))) ? null : form.getZoom()
            , (StringUtils.isBlank(request.getParameter("detailed"))) ? null : form.getDetailed()
            , (StringUtils.isBlank(request.getParameter("defaultattachment"))) ? null : form.getDefaultattachment()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getItemManageableService().readBackingLists();
        form.setProductBackingList((java.util.List)backingLists.get("product"));
        form.setChoisesBackingList((java.util.List)backingLists.get("choises"));
        form.setCarriageBackingList((java.util.List)backingLists.get("carriage"));
        form.setZoomBackingList((java.util.List)backingLists.get("zoom"));
        form.setDetailedBackingList((java.util.List)backingLists.get("detailed"));
        form.setDefaultattachmentBackingList((java.util.List)backingLists.get("defaultattachment"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ItemForm form = (net.malta.model.crud.ItemForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getItemManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getItemManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_Product")))
        {
            form.setProduct(new java.lang.Integer(request.getParameter("ref_Product")));
        }
        form.setProductBackingList((java.util.List)backingLists.get("product"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Choise")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_Choise"));
            form.setChoises(array);
        }
        form.setChoisesBackingList((java.util.List)backingLists.get("choises"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Carriage")))
        {
            form.setCarriage(new java.lang.Integer(request.getParameter("ref_Carriage")));
        }
        form.setCarriageBackingList((java.util.List)backingLists.get("carriage"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Attachment")))
        {
            form.setZoom(new java.lang.Integer(request.getParameter("ref_Attachment")));
        }
        form.setZoomBackingList((java.util.List)backingLists.get("zoom"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Attachment")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_Attachment"));
            form.setDetailed(array);
        }
        form.setDetailedBackingList((java.util.List)backingLists.get("detailed"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Attachment")))
        {
            form.setDefaultattachment(new java.lang.Integer(request.getParameter("ref_Attachment")));
        }
        form.setDefaultattachmentBackingList((java.util.List)backingLists.get("defaultattachment"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ItemForm form = (net.malta.model.crud.ItemForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getItemManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("main"))) ? false : form.isMain()
            , (StringUtils.isBlank(request.getParameter("product"))) ? null : form.getProduct()
            , (StringUtils.isBlank(request.getParameter("choises"))) ? null : form.getChoises()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? null : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("zoom"))) ? null : form.getZoom()
            , (StringUtils.isBlank(request.getParameter("detailed"))) ? null : form.getDetailed()
            , (StringUtils.isBlank(request.getParameter("defaultattachment"))) ? null : form.getDefaultattachment()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ItemForm form = (net.malta.model.crud.ItemForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getItemManageableService().delete(selectedRows);
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
