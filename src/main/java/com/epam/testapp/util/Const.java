package com.epam.testapp.util;

import java.sql.Date;

public class Const{


//    LocaleAction
    public static final String STRUTS_LOCALE = "org.apache.struts.action.LOCALE";
    public static final String PAGE = "page";
    public static final String RU = "ru";
    public static final String RU_U = "RU";

//    NewsAction
    public static final String LIST = "list";
    public static final String ID = "id";
    public static final String NEWS = "news";
    public static final String EDIT = "edit";
    public static final String ADD = "add";
    public static final String VIEW = "view";
    public static final String DELETE = "delete";
    public static final String CANCEL = "cancel";
    public static final String SAVE = "save";
    public static final String CR_MODIFY= "createModify";
    public static final String EX_LIST = "Exception with LIST";
    public static final String EX_VIEW = "Exception with VIEW";
    public static final String EX_EDIT = "Exception with EDIT ";
    public static final String EX_DELETE = "Exception with DELETE";
    public static final String EX_SAVE = "Exception with SAVE";
    public static final String LB_LIST = "label.list";
    public static final String LB_VIEW = "label.view";
    public static final String LB_EDIT = "label.edit";
    public static final String LB_DELETE = "label.delete";
    public static final String LB_CANCEL = "label.cancel";
    public static final String LB_SAVE = "label.save";
    public static final String LB_ADD = "label.add";

//    NewsForm
    public static final String TITLE_ERR = "titleErr";
    public static final String BRIEF_ERR = "briefErr";
    public static final String CONTENT_ERR = "contentErr";
    public static final String DATE_ERR = "dateErr";
    public static final String KEY_TITLE_REQ = "error.title.required";
    public static final String KEY_TITLE_LEN = "error.title.length";
    public static final String KEY_BRIEF_REQ = "error.brief.required";
    public static final String KEY_BRIEF_LEN = "error.brief.length";
    public static final String KEY_CONT_REQ = "error.content.required";
    public static final String KEY_CONT_LEN = "error.content.length";
    public static final String KEY_DATE_REQ = "error.date.required";
    public static final String KEY_DATE_FORMAT = "error.date.format";
    public static final String DATE_PATTERN = "yyyy MM dd";

//    ParseDate
    public static final int TO_SQL = 2;
    public static final int FROM_SQL = 1;

//    Current Date
    public static final  String KURR_DATE = ParseDate.parse(new Date(new java.util.Date().getTime()).toString(),Const.FROM_SQL);

}