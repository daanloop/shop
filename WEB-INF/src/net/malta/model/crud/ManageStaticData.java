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

public final class ManageStaticData extends DispatchAction
{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.getSession().setAttribute("manageableForm", actionForm);
        return super.execute(mapping, actionForm, request, response);
    }

    public ActionForward create(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm)actionForm;

        net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().create(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("fromaddress"))) ? null : form.getFromaddress()
            , (StringUtils.isBlank(request.getParameter("sitename"))) ? null : form.getSitename()
            , (StringUtils.isBlank(request.getParameter("basepath"))) ? null : form.getBasepath()
            , (StringUtils.isBlank(request.getParameter("unix"))) ? false : form.isUnix()
            , (StringUtils.isBlank(request.getParameter("mapeventspan"))) ? 0 : form.getMapeventspan()
            // we don't test using request.getParameter because for file uploads this will always return null
            , (form.getNoimage() == null) ? null : form.getNoimage().getFileData()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("creditcardprocesurl"))) ? null : form.getCreditcardprocesurl()
            , (StringUtils.isBlank(request.getParameter("contract_code"))) ? null : form.getContract_code()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward read(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().read(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("fromaddress"))) ? null : form.getFromaddress()
            , (StringUtils.isBlank(request.getParameter("sitename"))) ? null : form.getSitename()
            , (StringUtils.isBlank(request.getParameter("basepath"))) ? null : form.getBasepath()
            , (StringUtils.isBlank(request.getParameter("unix"))) ? false : form.isUnix()
            , (StringUtils.isBlank(request.getParameter("mapeventspan"))) ? 0 : form.getMapeventspan()
            ,  null
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("creditcardprocesurl"))) ? null : form.getCreditcardprocesurl()
            , (StringUtils.isBlank(request.getParameter("contract_code"))) ? null : form.getContract_code()
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
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm)actionForm;

        final java.util.List list = net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().readAll();
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
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm) actionForm;

        net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().update(
            (StringUtils.isBlank(request.getParameter("id"))) ? null : form.getId()
            , (StringUtils.isBlank(request.getParameter("fromaddress"))) ? null : form.getFromaddress()
            , (StringUtils.isBlank(request.getParameter("sitename"))) ? null : form.getSitename()
            , (StringUtils.isBlank(request.getParameter("basepath"))) ? null : form.getBasepath()
            , (StringUtils.isBlank(request.getParameter("unix"))) ? false : form.isUnix()
            , (StringUtils.isBlank(request.getParameter("mapeventspan"))) ? 0 : form.getMapeventspan()
            // we don't test using request.getParameter because for file uploads this will always return null
            , (form.getNoimage() == null) ? null : form.getNoimage().getFileData()
            , (StringUtils.isBlank(request.getParameter("carriage"))) ? 0 : form.getCarriage()
            , (StringUtils.isBlank(request.getParameter("creditcardprocesurl"))) ? null : form.getCreditcardprocesurl()
            , (StringUtils.isBlank(request.getParameter("contract_code"))) ? null : form.getContract_code()
        );

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm) actionForm;

        final java.lang.Integer[] selectedRows = form.getSelectedRows();
        if (selectedRows != null && selectedRows.length > 0)
        {
            net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().delete(selectedRows);
        }

        return preload(mapping, actionForm, request, response);
    }

    public ActionForward getNoimage(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final net.malta.model.crud.StaticDataForm form = (net.malta.model.crud.StaticDataForm) actionForm;
        final byte[] noimage = net.malta.ManageableServiceLocator.instance().getStaticDataManageableService().getNoimage(form.getId());

        if (noimage != null)
        {
            response.setContentType("application/octet-stream");
            response.setContentLength(noimage.length);
            response.setHeader("Content-disposition", "attachment; filename=staticdata-noimage.bin");
            response.getOutputStream().write(noimage);
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
