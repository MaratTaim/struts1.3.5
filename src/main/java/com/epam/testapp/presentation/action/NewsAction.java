package com.epam.testapp.presentation.action;

import com.epam.testapp.datebase.AbstractDAO;
import com.epam.testapp.datebase.pool.ConnectionPool;
import com.epam.testapp.presentation.form.NewsForm;
import com.epam.testapp.util.Const;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


@Component
public class NewsAction extends LookupDispatchAction {

    @Autowired
    private ConnectionPool pool;
    @Autowired
    private AbstractDAO newsDAO;

    @Override
    protected Map getKeyMethodMap() {
        Map map = new HashMap<>();
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
            Connection connection = pool.getConnection();
            connection.setAutoCommit(false);
            NewsForm newsForm = (NewsForm) form;
            newsDAO.setConnection(connection);

            newsForm.setNewsList(newsDAO.getList());
        } catch (Exception e){
            System.out.println(Const.EX_LIST);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.LIST);
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            Connection connection = pool.getConnection();
            connection.setAutoCommit(false);
            NewsForm newsForm = (NewsForm) form;
            newsDAO.setConnection(connection);

            int id = Integer.parseInt(request.getParameter(Const.ID));
            request.setAttribute(Const.NEWS, newsDAO.fetchById(id));
            newsForm.setNewsMessage(newsDAO.fetchById(id));
        } catch (Exception e){
            System.out.println(Const.EX_VIEW);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.VIEW);
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = 0;
        try{
            Connection connection = pool.getConnection();
            connection.setAutoCommit(false);
            NewsForm newsForm = (NewsForm) form;
            newsDAO.setConnection(connection);
            id = Integer.parseInt(request.getParameter(Const.ID));

            newsForm.setNewsMessage(newsDAO.fetchById(id));
        } catch (Exception e){
            System.out.println(Const.EX_EDIT + id);
            return mapping.findForward(Const.CR_MODIFY);
        }

        return mapping.findForward(Const.CR_MODIFY);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = 0;
        try{
            Connection connection = pool.getConnection();
            connection.setAutoCommit(false);
            NewsForm newsForm = (NewsForm) form;
            newsDAO.setConnection(connection);
            String[] delete = request.getParameterValues(Const.DELETE);
            String dId = request.getParameter(Const.ID);

            if(delete != null){
                for(String str: delete){
                    id = Integer.parseInt(str);
                    newsDAO.remove(id);
                }
            } else if(dId != null){
                id = Integer.parseInt(dId);
                newsDAO.remove(id);
            }

            newsForm.setNewsList(newsDAO.getList());
        } catch (Exception e){
            System.out.println(Const.EX_DELETE + id);
            return mapping.findForward(Const.LIST);
        }

        return mapping.findForward(Const.LIST);
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Const.LIST);
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection connection = pool.getConnection();
        connection.setAutoCommit(false);
        NewsForm newsForm = (NewsForm) form;
        newsDAO.setConnection(connection);
        int id = newsForm.getNewsMessage().getId();

        try{
            if (id == 0){
                newsDAO.save(newsForm.getNewsMessage());
            } else {
                newsDAO.update(newsForm.getNewsMessage());
            }
        }catch (Exception e){
            System.out.println(Const.EX_SAVE);
            return mapping.findForward(Const.CR_MODIFY);
        }
        request.setAttribute(Const.NEWS, newsForm.getNewsMessage());
        return mapping.findForward(Const.VIEW);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Const.CR_MODIFY);
    }
}
