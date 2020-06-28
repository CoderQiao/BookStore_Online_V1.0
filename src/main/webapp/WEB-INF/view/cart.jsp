<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>购物车</h2>

<s:if test="#session.totalPrice > 0">
  <s:form theme="simple" action="AddOrders" method="post">
    <table id="cart" class="table table-striped">
      <tr><th>图书名称</th><th>价格</th><th>数量</th><th>操作</th></tr>
    <s:iterator value="#session.order_list_cart">
      <tr>
	    <td>
	      <input type="hidden" name="bookId" value="<s:property value="bookId"/>"/>
	      <s:property value="bookName"/>
	    </td>
	    <td>
	      <s:property value="price"/>
	    </td>
	    <td>
	      <s:if test="bookNumber>1">
	      <a href="removeShopCart?bookId=<s:property value="bookId"/>">[-]</a>
	      </s:if>
	      <s:else>
	      <span>[-]</span>
	      </s:else>
            <s:property value="bookNumber"></s:property>
	      <a href="addOrUpdateShopCart?bookId=<s:property value="bookId"/>">[+]</a>
	    </td>
	    <td>
	      <a href="deleteFromShopCart?bookId=<s:property value="bookId"/>">[删除]</a>
	    </td>
      </tr>
    </s:iterator>
      <tr>
        <td id="totalPrice" colspan="4">
          <strong>总价：</strong>
          <em class="price"><s:property value="#session.totalPrice"/></em>
        </td>
      </tr>
    </table>
    <p class="action-bar">
      <s:submit value="购买"/>
    </p>
  </s:form>
</s:if>
<s:else>
  <p class="message">购物车为空，您还没有购买任何图书！</p>
  <p class="action-bar"><a class="button" href="index.jsp">返回首页</a></p>
</s:else>