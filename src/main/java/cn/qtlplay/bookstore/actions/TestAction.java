package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/19 - 0:41
*/

import cn.qtlplay.bookstore.beans.User;
import cn.qtlplay.bookstore.services.TestService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class TestAction extends ActionSupport {
    private TestService testService;

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public String list(){
        List<User> users = testService.list();
        for(User user : users){
            System.out.println(user.toString());
        }
        return SUCCESS;
    }

    public List<User> testUser(){
        return testService.list();
    }
}
