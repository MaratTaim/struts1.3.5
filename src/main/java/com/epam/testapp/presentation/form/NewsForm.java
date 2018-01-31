package com.epam.testapp.presentation.form;

import com.epam.testapp.model.News;
import com.epam.testapp.util.Const;
import com.epam.testapp.util.ParseDate;
import org.apache.struts.action.*;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsForm extends ActionForm {

    private News newsMessage;

    private List<News> newsList;

    public News getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(News newsMessage) {
        this.newsMessage = newsMessage;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        newsMessage = new News();
        newsList = new ArrayList<>();
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        String page = request.getParameter(Const.PAGE);
        if(Const.ADD.equalsIgnoreCase(page)){
            if (checkEmpty(newsMessage.getTitle())) {
                errors.add(Const.TITLE_ERR, new ActionMessage(Const.KEY_TITLE_REQ));
            } else if (checkLength(newsMessage.getTitle(), 100)) {
                errors.add(Const.TITLE_ERR, new ActionMessage(Const.KEY_TITLE_LEN));
            }
            if (checkEmpty(newsMessage.getBrief())) {
                errors.add(Const.BRIEF_ERR, new ActionMessage(Const.KEY_BRIEF_REQ));
            } else if (checkLength(newsMessage.getBrief(), 500)) {
                errors.add(Const.BRIEF_ERR, new ActionMessage(Const.KEY_BRIEF_LEN));
            }
            if (checkEmpty(newsMessage.getContent())) {
                errors.add(Const.CONTENT_ERR, new ActionMessage(Const.KEY_CONT_REQ));
            } else if (checkLength(newsMessage.getContent(), 2048)) {
                errors.add(Const.CONTENT_ERR, new ActionMessage(Const.KEY_CONT_LEN));
            }
            if (checkEmpty(newsMessage.getDate())) {
                errors.add(Const.DATE_ERR, new ActionMessage(Const.KEY_DATE_REQ));
            } else if (checkDate(newsMessage.getDate())) {
                errors.add(Const.DATE_ERR, new ActionMessage(Const.KEY_DATE_FORMAT));
            }
        }

        return errors;
    }

    private boolean checkEmpty(String str) {
        if (str == null || str.length() < 1) {
            return true;
        }
        return false;
    }

    private boolean checkLength(String str, int count) {
        if (str.length() > count) {
            return true;
        }
        return false;
    }

    private boolean checkDate(String date){
        try{
            Date currentDate = Date.valueOf(ParseDate.parse(date, Const.TO_SQL));
            SimpleDateFormat dateFormat = new SimpleDateFormat(Const.DATE_PATTERN);
            dateFormat.format(currentDate);
            return false;
        }catch (Exception e){
            return  true;
        }
    }

}
