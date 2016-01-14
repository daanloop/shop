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

public final class ManageDbFile extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getDbFileManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            // we don't test using request.getParameter because for file uploads this will always return null
            , (form.getData() == null) ? null : form.getData().getFileData()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDbFileManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            ,  null
        );
        form.setManageableList(list);

        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        return mapping.getInputForward();
    }

    public ActionForward preload(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getDbFileManageableService().readAll();
        form.setManageableList(list);


        if (list.size() >= 250)
        {
            saveMaxResultsWarning(request);
        }

        return mapping.getInputForward();
    }

    protected ActionForward unspecified(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return preload(mapping, actionForm, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getDbFileManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            // we don't test using request.getParameter because for file uploads this will always return null
            , (form.getData() == null) ? null : form.getData().getFileData()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getDbFileManageableService().delete(selectedRows);
        }

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward getData(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.DbFileForm form = (net.malta.model.crud.DbFileForm) actionForm;
        final byte[] data = net.malta.ManageableServiceLocator.instance().getDbFileManageableService().getData(form.getId());

        if (data != null)
        {
            response.setContentType("application/octet-stream");
            response.setContentLength(data.length);
            response.setHeader("Content-disposition", "attachment; filename=dbfile-data.bin");
            response.getOutputStream().write(data);
        }

        // let the browser simply download the field, do not forward
        return null;
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
