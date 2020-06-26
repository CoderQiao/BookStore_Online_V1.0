package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/25 - 23:04
*/


import cn.qtlplay.bookstore.beans.Admin;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class AdminAction extends AbstractEntityActionImpl<Admin> implements SessionAware, ModelDriven<Admin> {

    private Map<String,Object> session;
    private Admin model;

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    @Override
    public Admin getModel() {
        if(model == null){
            model = new Admin();
        }
        return model;
    }
    public String admin_login(){
        String loginName = model.getLoginName();
        String password = model.getPassword();
        List<Admin> admins = this.getService().findBy("loginName",loginName);
        for(Admin admin : admins){
            if(admin.getPassword().equals(password)){
                session.put("admin",admin);
                return SUCCESS;
            }
        }
        this.addActionError("登录名或密码不正确！请重新登陆~");
        return INPUT;
    }
    public String toAdminLogin(){
        return SUCCESS;
    }
    public String logout(){
        session.clear();
        return SUCCESS;
    }

}
