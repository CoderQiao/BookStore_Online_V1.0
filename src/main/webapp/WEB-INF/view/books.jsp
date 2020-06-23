<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>图书列表</h2>

<s:if test="#session.books.size>0">
<ul id="books">
  <s:iterator value="#session.books">
	<li>
	  <s:if test="image!=null">
	    <img class="book" src="images/<s:property value="image"/>" />
	  </s:if>
	  <s:else>
	    <img class="book" src="images/book.png"/>
	  </s:else>
	  <p>书名：<strong><s:property value="bookName"/></strong></p>
	  <p>价格：<strong><s:property value="price"/></strong></p>
	  <a class="button button-blue" href="addOrUpdateShopCart?bookId=<s:property value="bookId"/>">
		添加到购物车
	  </a>
	</li>
  </s:iterator>
</ul>
</s:if>
<s:else>
  <p class="message">
    <s:if test="keyword==null">对不起，暂无图书!!!</s:if>
    <s:else>对不起，找不到包含关键字“<s:property value="keyword"/>”的图书</s:else>
  </p>
</s:else>