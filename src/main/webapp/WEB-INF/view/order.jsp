<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>订单信息如下：</h2>
<table id="order" class="table">
  <caption>
     <label>总价格：</label><em class="price"><s:property value="#session.totalPrice"/></em>
     <label>用户：</label><em><s:property value="#session.user.loginName"/></em>
  </caption>
    <tr><th>图书</th><th>单价</th><th>数量</th><th>价格</th></tr>
  <s:iterator value="#session.orders">
    <tr>
      <td>
        <img class="book small" alt="<s:property value="bookName"/>" src="images/book.png"/>
        <strong><s:property value="bookName"/></strong>
      </td>
      <td><s:property value="price"/></td>
      <td><s:property value="bookNumber"/></td>
      <td><s:property value="price*bookNumber"/></td>
    </tr>
  </s:iterator>
</table>
<p class="action-bar"><a class="button" href="index.jsp">返回首页</a></p>