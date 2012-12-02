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

public final class ManageProduct extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ProductForm form = (net.malta.model.crud.ProductForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getProductManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("pub"))) ? false : form.isPub()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("mainitemname"))) ? null : form.getMainitemname()
            , (StringUtils.isBlank(request.getParameter("english"))) ? null : form.getEnglish()
            , (StringUtils.isBlank(request.getParameter("items"))) ? null : form.getItems()
            , (StringUtils.isBlank(request.getParameter("category"))) ? null : form.getCategory()
            , (StringUtils.isBlank(request.getParameter("thumnail"))) ? null : form.getThumnail()
            , (StringUtils.isBlank(request.getParameter("slideshow"))) ? null : form.getSlideshow()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ProductForm form = (net.malta.model.crud.ProductForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getProductManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("pub"))) ? false : form.isPub()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("mainitemname"))) ? null : form.getMainitemname()
            , (StringUtils.isBlank(request.getParameter("english"))) ? null : form.getEnglish()
            , (StringUtils.isBlank(request.getParameter("items"))) ? null : form.getItems()
            , (StringUtils.isBlank(request.getParameter("category"))) ? null : form.getCategory()
            , (StringUtils.isBlank(request.getParameter("thumnail"))) ? null : form.getThumnail()
            , (StringUtils.isBlank(request.getParameter("slideshow"))) ? null : form.getSlideshow()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getProductManageableService().readBackingLists();
        form.setItemsBackingList((java.util.List)backingLists.get("items"));
        form.setCategoryBackingList((java.util.List)backingLists.get("category"));
        form.setThumnailBackingList((java.util.List)backingLists.get("thumnail"));
        form.setSlideshowBackingList((java.util.List)backingLists.get("slideshow"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ProductForm form = (net.malta.model.crud.ProductForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getProductManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getProductManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_Item")))
        {
            final java.lang.Integer[] array = new java.lang.Integer[1];
            array[0] = new java.lang.Integer(request.getParameter("ref_Item"));
            form.setItems(array);
        }
        form.setItemsBackingList((java.util.List)backingLists.get("items"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Category")))
        {
            form.setCategory(new java.lang.Integer(request.getParameter("ref_Category")));
        }
        form.setCategoryBackingList((java.util.List)backingLists.get("category"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Attachment")))
        {
            form.setThumnail(new java.lang.Integer(request.getParameter("ref_Attachment")));
        }
        form.setThumnailBackingList((java.util.List)backingLists.get("thumnail"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Attachment")))
        {
            form.setSlideshow(new java.lang.Integer(request.getParameter("ref_Attachment")));
        }
        form.setSlideshowBackingList((java.util.List)backingLists.get("slideshow"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ProductForm form = (net.malta.model.crud.ProductForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getProductManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("no"))) ? null : form.getNo()
            , (StringUtils.isBlank(request.getParameter("name"))) ? null : form.getName()
            , (StringUtils.isBlank(request.getParameter("dateAsString"))) ? null : form.getDate()
            , (StringUtils.isBlank(request.getParameter("pub"))) ? false : form.isPub()
            , (StringUtils.isBlank(request.getParameter("pricewithtax"))) ? 0 : form.getPricewithtax()
            , (StringUtils.isBlank(request.getParameter("size"))) ? null : form.getSize()
            , (StringUtils.isBlank(request.getParameter("material"))) ? null : form.getMaterial()
            , (StringUtils.isBlank(request.getParameter("catchcopy"))) ? null : form.getCatchcopy()
            , (StringUtils.isBlank(request.getParameter("description"))) ? null : form.getDescription()
            , (StringUtils.isBlank(request.getParameter("note"))) ? null : form.getNote()
            , (StringUtils.isBlank(request.getParameter("stocknum"))) ? 0 : form.getStocknum()
            , (StringUtils.isBlank(request.getParameter("removed"))) ? false : form.isRemoved()
            , (StringUtils.isBlank(request.getParameter("mainitemname"))) ? null : form.getMainitemname()
            , (StringUtils.isBlank(request.getParameter("english"))) ? null : form.getEnglish()
            , (StringUtils.isBlank(request.getParameter("items"))) ? null : form.getItems()
            , (StringUtils.isBlank(request.getParameter("category"))) ? null : form.getCategory()
            , (StringUtils.isBlank(request.getParameter("thumnail"))) ? null : form.getThumnail()
            , (StringUtils.isBlank(request.getParameter("slideshow"))) ? null : form.getSlideshow()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.ProductForm form = (net.malta.model.crud.ProductForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getProductManageableService().delete(selectedRows);
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
