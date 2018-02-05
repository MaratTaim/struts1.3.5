package com.epam.testapp.presentation.action;

import com.epam.testapp.datebase.AbstractDAO;
import com.epam.testapp.presentation.form.NewsForm;
import com.epam.testapp.util.Const;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Component
public class NewsAction extends LookupDispatchAction {
    private final Logger logger = Logger.getLogger(NewsAction.class);

    @Autowired
    private AbstractDAO newsDAO;

    @Override
    protected Map getKeyMethodMap() {
        Map map = new HashMap<String, String>();
        map.put(Const.LB_LIST, Const.LIST);
        map.put(Const.LB_VIEW, Const.VIEW);
        map.put(Const.LB_EDIT, Const.EDIT);
        map.put(Const.LB_DELETE, Const.DELETE);
        map.put(Const.LB_CANCEL, Const.CANCEL);
        map.put(Const.LB_SAVE, Const.SAVE);
        map.put(Const.LB_ADD, Const.ADD);

        return map;
    }

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{

            NewsForm newsForm = (NewsForm) form;
            newsForm.setNewsList(newsDAO.getList());

        } catch (Exception e){
            logger.error(Const.EX_LIST, e);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.LIST);
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{

            NewsForm newsForm = (NewsForm) form;
            Long id = Long.parseLong(request.getParameter(Const.ID));

            request.setAttribute(Const.NEWS, newsDAO.fetchById(id));
            newsForm.setNewsMessage(newsDAO.fetchById(id));

        } catch (Exception e){
            logger.info(Const.EX_VIEW, e);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.VIEW);
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = 0L;
        try{

            NewsForm newsForm = (NewsForm) form;
            id = Long.parseLong(request.getParameter(Const.ID));
            newsForm.setNewsMessage(newsDAO.fetchById(id));

        } catch (Exception e){
            logger.info(Const.EX_EDIT + id, e);
            return mapping.findForward(Const.CR_MODIFY);
        }

        return mapping.findForward(Const.CR_MODIFY);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = 0L;
        try{

            NewsForm newsForm = (NewsForm) form;
            String[] delete = request.getParameterValues(Const.DELETE);
            String dId = request.getParameter(Const.ID);

            if(delete != null){
                for(String str: delete){
                    id = Long.parseLong(str);
                    newsDAO.remove(id);
                }
            } else if(dId != null){
                id = Long.parseLong(dId);
                newsDAO.remove(id);
            }

            newsForm.setNewsList(newsDAO.getList());

        } catch (Exception e){
            logger.info(Const.EX_DELETE + id, e);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.LIST);
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Const.LIST);
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        Long id = newsForm.getNewsMessage().getId();
        try{
            if (id == 0){
                newsDAO.save(newsForm.getNewsMessage());
            } else {
                newsDAO.update(newsForm.getNewsMessage());
            }

        }catch (Exception e){
            logger.info(Const.EX_SAVE, e);
            return mapping.findForward(Const.CR_MODIFY);
        }

        request.setAttribute(Const.NEWS, newsForm.getNewsMessage());
        return mapping.findForward(Const.VIEW);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Const.CR_MODIFY);
    }
}
