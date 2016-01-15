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

public final class ManageAttachment extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.AttachmentForm form = (net.malta.model.crud.AttachmentForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("filetype"))) ? null : form.getFiletype()
            , (StringUtils.isBlank(request.getParameter("width"))) ? 0 : form.getWidth()
            , (StringUtils.isBlank(request.getParameter("height"))) ? 0 : form.getHeight()
            , (StringUtils.isBlank(request.getParameter("wide"))) ? false : form.isWide()
            , (StringUtils.isBlank(request.getParameter("dbFile"))) ? null : form.getDbFile()
            , (StringUtils.isBlank(request.getParameter("aszoom"))) ? null : form.getAszoom()
            , (StringUtils.isBlank(request.getParameter("asdetailed"))) ? null : form.getAsdetailed()
            , (StringUtils.isBlank(request.getParameter("asdefault"))) ? null : form.getAsdefault()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.AttachmentForm form = (net.malta.model.crud.AttachmentForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("filetype"))) ? null : form.getFiletype()
            , (StringUtils.isBlank(request.getParameter("width"))) ? 0 : form.getWidth()
            , (StringUtils.isBlank(request.getParameter("height"))) ? 0 : form.getHeight()
            , (StringUtils.isBlank(request.getParameter("wide"))) ? false : form.isWide()
            , (StringUtils.isBlank(request.getParameter("dbFile"))) ? null : form.getDbFile()
            , (StringUtils.isBlank(request.getParameter("aszoom"))) ? null : form.getAszoom()
            , (StringUtils.isBlank(request.getParameter("asdetailed"))) ? null : form.getAsdetailed()
            , (StringUtils.isBlank(request.getParameter("asdefault"))) ? null : form.getAsdefault()
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().readBackingLists();
        form.setDbFileBackingList((java.util.List)backingLists.get("dbFile"));
        form.setAszoomBackingList((java.util.List)backingLists.get("aszoom"));
        form.setAsdetailedBackingList((java.util.List)backingLists.get("asdetailed"));
        form.setAsdefaultBackingList((java.util.List)backingLists.get("asdefault"));

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.AttachmentForm form = (net.malta.model.crud.AttachmentForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        final java.util.Map backingLists = net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().readBackingLists();
        if (StringUtils.isNotBlank(request.getParameter("ref_DbFile")))
        {
            form.setDbFile(new java.lang.Integer(request.getParameter("ref_DbFile")));
        }
        form.setDbFileBackingList((java.util.List)backingLists.get("dbFile"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Item")))
        {
            form.setAszoom(new java.lang.Integer(request.getParameter("ref_Item")));
        }
        form.setAszoomBackingList((java.util.List)backingLists.get("aszoom"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Item")))
        {
            form.setAsdetailed(new java.lang.Integer(request.getParameter("ref_Item")));
        }
        form.setAsdetailedBackingList((java.util.List)backingLists.get("asdetailed"));
        if (StringUtils.isNotBlank(request.getParameter("ref_Item")))
        {
            form.setAsdefault(new java.lang.Integer(request.getParameter("ref_Item")));
        }
        form.setAsdefaultBackingList((java.util.List)backingLists.get("asdefault"));

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.AttachmentForm form = (net.malta.model.crud.AttachmentForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("filetype"))) ? null : form.getFiletype()
            , (StringUtils.isBlank(request.getParameter("width"))) ? 0 : form.getWidth()
            , (StringUtils.isBlank(request.getParameter("height"))) ? 0 : form.getHeight()
            , (StringUtils.isBlank(request.getParameter("wide"))) ? false : form.isWide()
            , (StringUtils.isBlank(request.getParameter("dbFile"))) ? null : form.getDbFile()
            , (StringUtils.isBlank(request.getParameter("aszoom"))) ? null : form.getAszoom()
            , (StringUtils.isBlank(request.getParameter("asdetailed"))) ? null : form.getAsdetailed()
            , (StringUtils.isBlank(request.getParameter("asdefault"))) ? null : form.getAsdefault()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.AttachmentForm form = (net.malta.model.crud.AttachmentForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getAttachmentManageableService().delete(selectedRows);
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
