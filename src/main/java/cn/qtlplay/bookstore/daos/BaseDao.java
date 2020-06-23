package cn.qtlplay.bookstore.daos;/*
    @author 乔同良
    @date 2020/6/18 - 15:09
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDao {

    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
