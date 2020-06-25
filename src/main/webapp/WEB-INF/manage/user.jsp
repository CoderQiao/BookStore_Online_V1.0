<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>用户管理</h2>

<s:if test="#session.users.size > 0">
    <s:form theme="simple" action="updateUserById" method="POST">
        <s:actionerror/>
        <s:actionmessage/>
        <table id="cart" class="table table-striped">
            <tr><th>ID</th><th>用户名</th><th>真实姓名</th><th>性别</th><th>邮箱</th><th>删除</th><th>修改</th></tr>
            <s:iterator value="#session.users">
                <tr>
                    <td>
                        <s:property value="userId"/>
                    </td>
                    <td>
                        <s:property value="loginName"/>
                    </td>
                    <td>
                        <s:property value="realName"/>
                    </td>
                    <td>
                        <s:property value="gender"/>
                    </td>
                    <td>
                        <s:property value="email"/>
                    </td>
                    <td>
                        <a href="deleteUserById?userId=<s:property value="userId"/>">[删除]</a>
                    </td>
                    <td>
                        <a href="updateUserById?userId=<s:property value="userId"/>">[修改]</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <p class="action-bar">
            <a href="toAddUser">添加用户</a>
        </p>
    </s:form>
</s:if>
<s:else>
    <p class="message">没有任何用户信息！</p>
</s:else>