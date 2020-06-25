package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/25 - 10:30
*/

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ManageAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
