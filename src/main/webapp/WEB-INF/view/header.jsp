<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="header" class="clearfix">
  <h1>
    <s:a href="index.jsp" includeContext="true"><img class="logo" src="images/logo.png" alt="叮当网">网上书店</s:a>
  </h1>
  <div id="tool-bar">
    <s:if test="#session.user==null">
      <p><a href="index.jsp?page=login">[登录]</a>
    </s:if>
    <s:else>
      <p><s:property value="#session.user.realName"/>
      (<s:property value="#session.user.loginName"/>)，欢迎您!
      <s:if test="#session.user.orders!=null">
        <s:if test="#session.user.orders.size>0">
      	<a href="index.jsp?page=orders">[我的订单]</a> |
      	</s:if>
      </s:if> 
      <a href="logout">[注销]</a> |
    </s:else>
      <a class="icon-24 cart" href="/index.jsp?page=cart">购物车</a>
      <s:if test="#session.cart!=null">
        <sup class="badge"><s:property value="#session.order_list.size"/></sup>
      </s:if>
       |
    <s:form action="searchBookByName" theme="simple" method="get" cssClass="search-bar">
  	  <p>
  	    <s:textfield name="keyword"/>
  	    <s:submit value="搜索"/>
      </p>
    </s:form>
  </div>
</div>