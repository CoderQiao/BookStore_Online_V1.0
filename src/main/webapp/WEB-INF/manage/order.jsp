<%--
  Created by IntelliJ IDEA.
  User: 乔同良
  Date: 2020/6/25
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>用户管理</h2>

<s:if test="#session.orders.size > 0">
    <s:form theme="simple" action="updateUserById" method="POST">
        <s:actionerror/>
        <s:actionmessage/>
        <table id="cart" class="table table-striped">
            <tr><th>ID</th><th>书名</th><th>书籍ID</th><th>价格</th><th>用户ID</th><th>登录名</th><th>数量</th><th>总价</th><th>删除</th></tr>
            <s:iterator value="#session.orders">
                <tr>
                    <td>
                        <s:property value="orderId"/>
                    </td>
                    <td>
                        <s:property value="bookName"/>
                    </td>
                    <td>
                        <s:property value="userId"/>
                    </td>
                    <td>
                        <s:property value="price"/>
                    </td>
                    <td>
                        <s:property value="userId"/>
                    </td>
                    <td>
                        <s:property value="loginName"/>
                    </td>
                    <td>
                        <s:property value="bookNumber"></s:property>
                    </td>
                    <td>
                        <s:property value="priceTotal"></s:property>
                    </td>
                    <td>
                        <a href="deleteOrderById?orderId=<s:property value="orderId"/>">[删除]</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:form>
</s:if>
<s:else>
    <p class="message">没有任何订单信息！</p>
</s:else>
