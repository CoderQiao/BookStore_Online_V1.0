package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/22 - 1:50
*/

import cn.qtlplay.bookstore.beans.Category;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class CategoryAction extends AbstractEntityActionImpl<Category> implements SessionAware {
    public CategoryAction() {
        super();
    }
    private Map<String,Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String list(){
        List<Category> categories = this.getService().findAll();
        session.put("categories",categories);
        return SUCCESS;
    }

}
