package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/22 - 2:23
*/

import cn.qtlplay.bookstore.beans.Admin;
import cn.qtlplay.bookstore.beans.Book;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class BookAction extends AbstractEntityActionImpl<Book> implements SessionAware, ModelDriven<Book> {
    public BookAction() {
        super();
    }

    private String keyword;
    private Map<String,Object> session;
    private Book model;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public Book getModel() {
        if(model == null){
            model = new Book();
        }
        return model;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String list(){

        List<Book> books = this.getService().findAll();
        session.put("books",books);
        session.put("categoryId",model.getCategoryId());
        return SUCCESS;
    }

    public String searchBookByCategoryId(){
        List<Book> books = this.getService().findBy("categoryId",model.getCategoryId());
        session.put("books",books);
        return SUCCESS;
    }

    public String searchBookByName(){
        List<Book> books = this.getService().findBy("bookName",this.getKeyword());
        session.put("books",books);
        return SUCCESS;
    }

    public String manage(){
        return SUCCESS;
    }
    public String deleteBookById(){
        this.getService().delete(model.getBookId());
        this.addActionMessage("已删除书籍信息："+this.getService().get(model.getBookId()));
        return SUCCESS;
    }

    public String updateBookById(){
        Book book = this.getService().get(model.getBookId());
        model = book;
        this.addActionMessage("书籍信息已更新，书名为="+model.getBookName());
        return SUCCESS;
    }
    public String addBoob(){
        this.getService().save(model);
        this.addActionMessage("书籍已添加，书名为："+model.getBookName());
        return SUCCESS;
    }

}
