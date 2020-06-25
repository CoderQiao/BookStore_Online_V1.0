<%--
  Created by IntelliJ IDEA.
  User: 乔同良
  Date: 2020/6/25
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>书籍管理</h2>
<s:form theme="simple" action="addBoob" method="post">
    <s:actionerror/>
    <p><label>书名:</label><s:textfield name="model.bookName"/></p>
    <p><label>作者:</label><s:textfield name="model.author" /></p>
    <p><label>价格:</label><s:textfield name="model.price" /></p>
    <p><label>图片:</label><s:textfield name="model.image" /></p>
    <p><label>类别:</label><s:radio name="model.categoryId" list="#{'1':'小说','2':'诗歌','3':'计算机','4':'英语'}"/></p>
    <p class="action-bar"><s:submit value="提交"/></p>
</s:form>
