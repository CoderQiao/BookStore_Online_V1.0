package cn.qtlplay.test;/*
    @author 乔同良
    @date 2020/6/21 - 上午12:25
*/

import cn.qtlplay.bookstore.actions.TestAction;
import cn.qtlplay.bookstore.beans.User;
import org.junit.Test;

import java.util.List;

public class Test1 {
    /*
    * 不可测试
    * */
    @Test
    public void TestAction(){
        TestAction testAction = new TestAction();
        List<User> users = testAction.testUser();
        for (User user : users){
            System.out.println(user.toString());
        }
    }
}
