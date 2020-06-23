package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/21 - 13:25
*/

import cn.qtlplay.bookstore.beans.Order;
import cn.qtlplay.bookstore.beans.User;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class UserAction extends AbstractEntityActionImpl<User> implements SessionAware, ModelDriven<User> {

    private String password2;
    private Map<String,Object> session;
    private User model;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
    @Override
    public User getModel() {
        if(model == null){
            model = new User();
        }
        return model;
    }

    public String login(){
        String loginName = model.getLoginName();
        String password = model.getPassword();
        List<User> users = this.getService().findBy("loginName",loginName);
        if(users.isEmpty()){
            this.addActionError("没有登录名为'"+loginName+"'的用户！");
            return ERROR;
        }
        else{
            for(User user : users){
                if(user.getPassword().equals(password)){
                    session.put("user",user);
                    return SUCCESS;
                }
            }
        }
        this.addActionError("密码错误！");
        return ERROR;
    }

    public String logout(){
        session.remove("user");
        return SUCCESS;
    }

    public String register(){

        if(this.getPassword2().equals(this.model.getPassword())){
            try {
                this.getService().save(model);
            }catch (Exception e){
                this.addActionError(e.getMessage());
                return INPUT;
            }
        }
        else{
            this.addActionError("两个密码不一样，请重新输入！");
            return INPUT;
        }
        return SUCCESS;
    }

}
