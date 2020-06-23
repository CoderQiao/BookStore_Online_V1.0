package cn.qtlplay.bookstore.daos;/*
    @author 乔同良
    @date 2020/6/19 - 0:40
*/

import cn.qtlplay.bookstore.beans.User;

import java.util.List;

public class TestDao extends BaseDao{

    public List<User> list(){
        String hql = "FROM User";
        return getSession().createQuery(hql).list();
    }
}
