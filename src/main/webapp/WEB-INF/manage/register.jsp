<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>用户注册</h2> 
<s:form theme="simple" action="addUser" method="post">
  <s:actionerror/>
  <p><label>登录名:</label><s:textfield name="model.loginName"/></p>
  <p><label>姓名:</label><s:textfield name="model.realName" /></p>
  <p><label>密码:</label><s:password name="model.password" /></p>
  <p><label>确认密码:</label><s:password name="password2" /></p>
  <p><label>性别:</label><s:radio name="model.gender" list="#{'男':'男','女':'女'}"/></p>
  <p><label>邮箱:</label><s:textfield name="model.email"/></p>
  <p class="action-bar"><s:submit value="提交"/></p>
</s:form>