package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/24 - 22:59
*/

import cn.qtlplay.bookstore.beans.Admin;
import cn.qtlplay.bookstore.beans.Order;
import cn.qtlplay.bookstore.beans.User;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderAction extends AbstractEntityActionImpl<Order> implements SessionAware {

    private int orderId;
    private Map<String,Object> session;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String AddOrders(){

        User user = (User)session.get("user");
        if(user == null){
            return INPUT;
        }
        List<Order> order_list = (List<Order>) session.get("order_list");
        Map<Integer,Order> orders = (Map<Integer,Order>)session.get("orders");
        long priceTotal = (long)session.get("totalPrice");
        for(Order order : order_list){
            order.setPriceTotal(priceTotal);
            order.setUserId(user.getUserId());
            order.setLoginName(user.getLoginName());
            this.getService().save(order);
        }
        //session.remove("orders",orders);
        //session.replace("orders",new HashMap<Integer,Order>());

        Map<Integer,Order> orders1 = new HashMap<Integer, Order>();
        session.put("orders",orders1);
        session.remove("order_list",order_list);
        return SUCCESS;
    }

    public String list(){
        User user = (User)session.get("user");
        if(user == null){
            return INPUT;
        }
        List<Order> orders = this.getService().findBy("userId",user.getUserId());
        session.put("orders",orders);
        long totalPrice = 0;
        for(Order order : orders){
            totalPrice += order.getPrice();
        }
        session.put("totalPrice",totalPrice);
        return SUCCESS;
    }

    public String orderList(){
        Admin admin = (Admin)session.get("admin");
        if(admin == null){
            return INPUT;
        }
        List<Order> orders = this.getService().findAll();
        session.put("orders",orders);
        return SUCCESS;
    }

    public String deleteOrderById(){
        this.getService().delete(this.getOrderId());
        return SUCCESS;
    }
    public String about(){
        return SUCCESS;
    }

}
