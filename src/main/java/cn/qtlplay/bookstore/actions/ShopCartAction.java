package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/23 - 16:34
*/

import cn.qtlplay.bookstore.beans.Book;
import cn.qtlplay.bookstore.beans.Order;
import cn.qtlplay.bookstore.beans.User;
import cn.qtlplay.bookstore.services.Service;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCartAction extends ActionSupport implements SessionAware {

    private int bookId;
    private int bookNumber;
    private long totalPrice;
    private Map<String,Object> session;
    private Service bookService;

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Service getBookService() {
        return bookService;
    }

    public void setBookService(Service bookService) {
        this.bookService = bookService;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String addOrUpdateShopCart(){

       Map<Integer,Order> orders = (Map<Integer, Order>) session.get("orders");
       Book book = (Book)this.getBookService().get(this.getBookId());
       if(orders != null){
           if(orders.containsKey(this.getBookId())){
               Order order = orders.get(book.getBookId());
               order.setBookNumber(order.getBookNumber()+1);
               orders.put(book.getBookId(),order);
               session.put("orders",orders);
           }
           else{
               Order order = new Order(book.getBookId(),book.getBookName(),1,book.getPrice(),(long)book.getPrice());
               orders.put(this.getBookId(),order);
               session.put("orders",orders);
           }

       }
       else{
               orders = new HashMap<Integer, Order>();
               Order order = new Order(book.getBookId(),book.getBookName(),1,book.getPrice(),(long)book.getPrice());
               orders.put(this.getBookId(),order);
               session.put("orders",orders);
       }

       this.updateOrderList();
       return SUCCESS;
    }

    public String removeShopCart(){
        Map<Integer,Order> orders = (Map<Integer, Order>) session.get("orders");
        Order order = orders.get(this.getBookId());
        if(order.getBookNumber()<=0){return SUCCESS;}
        order.setBookNumber(order.getBookNumber()-1);
        orders.put(this.getBookId(),order);
        session.put("orders",orders);

        this.updateOrderList();
        return SUCCESS;
    }

    public String checkout(){
        User user = (User)session.get("user");
        Map<Integer,Order> orders = (Map<Integer, Order>) session.get("orders");
        if(user == null){
            this.addActionMessage("请先登录！");
            return INPUT;
        }
        if(orders == null){
            this.addActionError("购物车为空，去添加书籍吧！");
            return ERROR;
        }
        for(Integer bookId : orders.keySet()){
            Order order = orders.get(bookId);
            if(order.getBookNumber() == 0){
                orders.remove(bookId,order);
            }
            if(order.getBookId() == this.getBookId()){
                orders.remove(bookId,order);
                order.setBookNumber(this.getBookNumber());
                orders.put(bookId,order);
            }
        }
        session.put("orders",orders);
        this.updateOrderList();
        return SUCCESS;
    }

    public void updateOrderList(){
        Map<Integer,Order> orders = (Map<Integer, Order>) session.get("orders");
        List<Order> order_list = new ArrayList<Order>();
        totalPrice = 0;
        for(int bookId : orders.keySet()){
            totalPrice += orders.get(bookId).getPriceTotal() * orders.get(bookId).getBookNumber();
            order_list.add(orders.get(bookId));
        }
        session.put("totalPrice",totalPrice);
        session.put("order_list",order_list);
    }

    public String deleteFromShopCart(){
        Map<Integer,Order> orders = (Map<Integer, Order>) session.get("orders");
        if(orders.containsKey(this.getBookId())){
            orders.remove(this.getBookId(),orders.get(this.getBookId()));
        }
        session.put("orders",orders);
        this.updateOrderList();
        return SUCCESS;
    }


}
