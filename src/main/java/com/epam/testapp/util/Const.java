package com.epam.testapp.util;


public class Const{

//    ConnectionPool
    public static final String C_CREATE_CONN = "Can't crate connection";
    public static final String C_CLOSE_CONN = "Can't close connection";

//    NewsDAO
    public static final String ERR_LIST = "Error with get list";
    public static final String C_SAVE= "Can't save News";
    public static final String C_UPDATE= "Can't update News with id=";
    public static final String ERR_UPDATE = "Error with Update News";
    public static final String C_DELETE = "Can't delete News";
    public static final String ERR_DELETE = "Error with delete News";
    public static final String C_SELECT = "Can't select News";
    public static final String ERR_SELECT = "Error with fetchById";
    public static final String COMMIT_EX = "Commit exception";
    public static final String ROLLBACK_EX = "Rollback exception";

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


}