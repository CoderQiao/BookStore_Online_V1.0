<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>管理员登录</h2>
<s:form theme="simple" action="admin-login" method="post">
  <s:actionerror/>
  <p><label>登录名:</label><s:textfield name="model.loginName"/></p>
  <p><label>密码:</label><s:password name="model.password"/></p>
  <p class="action-bar"><s:submit value="登录" cssClass="button-blue"/></p>
</s:form>