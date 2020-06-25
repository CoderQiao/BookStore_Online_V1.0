<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
  <p><label>ID：</label><s:property value="#session.user.userId"/></p>
  <p><label>登录名：</label><s:property value="#session.user.loginName"/></p>
  <p><label>姓名：</label><s:property value="#session.user.realName"/></p>
  <p><label>邮箱：</label><s:property value="#session.user.email"/></p>
  <p><label>性别：</label><s:property value="#session.user.gender"></s:property> </p>
</div>