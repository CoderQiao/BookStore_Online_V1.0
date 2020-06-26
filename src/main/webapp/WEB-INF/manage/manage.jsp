<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="styles/style.css"/>
<title>网上书城后台管理</title>
</head>
<body>
<%--head--%>
<div id="header" class="clearfix">
  <h1>
    <s:a href="#" includeContext="true"><img class="logo" src="images/logo.png" alt="">后台管理</s:a>
  </h1>
  <div id="tool-bar">
      <p><s:property value="#session.admin.loginName"/>，欢迎您!
      <a href="admin-logout">[退出]</a>
  </div>
</div>
<%--nav--%>
<div id="nav">
  <ul>
    <li>
      <a href="user-list">用户管理</a>
    </li>
    <li>
      <a href="book-manage">书籍管理</a>
    </li>
    <li>
      <a href="order-manage">订单管理</a>
    </li>
    <li>
      <a href="toAdminLogin">登录</a>
    </li>
    <li>
      <a href="about">系统说明</a>
    </li>
  </ul>
</div>
  <div id="main-container" class="clearfix">
    <div id="aside">
      <h2>操作</h2>
      <ul id="categories">
        <li>
          <a href="user-list">用户管理</a>
        </li>
        <li>
          <a href="book-manage">书籍管理</a>
        </li>
        <li>
          <a href="order-manage">订单管理</a>
        </li>
        <li>
          <a href="toAdminLogin">登录</a>
        </li>
        <li>
          <a href="about">系统说明</a>
        </li>
      </ul>
    </div>
    <div id="content">
      <s:if test="#parameters.page!=null">
        <s:include value="/WEB-INF/manage/%{#parameters.page}.jsp"/>
      </s:if>
      <s:else>
        <div>
          网上书城后台管理系统
        </div>
      </s:else>
    </div>
  </div>
  <s:include value="/footer.jsp"/>
</body>
</html>