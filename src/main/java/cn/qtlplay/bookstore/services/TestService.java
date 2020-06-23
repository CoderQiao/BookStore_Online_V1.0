package cn.qtlplay.bookstore.services;/*
    @author 乔同良
    @date 2020/6/19 - 0:38
*/

import cn.qtlplay.bookstore.beans.User;
import cn.qtlplay.bookstore.daos.TestDao;

import java.util.List;

public class TestService {

    private TestDao testDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public List<User> list(){
        return testDao.list();
    }
}
