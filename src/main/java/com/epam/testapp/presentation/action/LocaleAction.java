package com.epam.testapp.presentation.action;


import com.epam.testapp.util.Const;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Component
public class LocaleAction extends DispatchAction {

    public ActionForward english(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
                                throws Exception {
        HttpSession session = request.getSession();
        String page = request.getParameter(Const.PAGE);
        session.setAttribute(Const.STRUTS_LOCALE, Locale.ENGLISH);

        return mapping.findForward(page);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
                                throws Exception {
        HttpSession session = request.getSession();
        String page = request.getParameter(Const.PAGE);
        session.setAttribute(Const.STRUTS_LOCALE, new Locale(Const.RU,Const.RU_U));
        return mapping.findForward(page);
    }


}