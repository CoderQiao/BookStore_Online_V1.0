package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/22 - 2:23
*/

import cn.qtlplay.bookstore.beans.Book;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class BookAction extends AbstractEntityActionImpl<Book> implements SessionAware {
    public BookAction() {
        super();
    }

    private int categoryId;
    private String keyword;
    private Map<String,Object> session;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String list(){
        List<Book> books = this.getService().findAll();
        session.put("books",books);
        return SUCCESS;
    }

    public String searchBookByCategoryId(){
        List<Book> books = this.getService().findBy("categoryId",this.getCategoryId());
        session.put("books",books);
        return SUCCESS;
    }
    public String searchBookByName(){
        List<Book> books = this.getService().findBy("bookName",this.getKeyword());
        session.put("books",books);
        return SUCCESS;
    }
}
