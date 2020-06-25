<%--
  Created by IntelliJ IDEA.
  User: 乔同良
  Date: 2020/6/25
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>用户管理</h2>

<s:if test="#session.books.size > 0">
    <s:form theme="simple" action="updateUserById" method="POST">
        <s:actionerror/>
        <s:actionmessage/>
        <table id="cart" class="table table-striped">
            <tr><th>ID</th><th>书名</th><th>作者</th><th>价格</th><th>图片</th><th>类别</th><th>删除</th><th>修改</th></tr>
            <s:iterator value="#session.books">
                <tr>
                    <td>
                        <s:property value="bookId"/>
                    </td>
                    <td>
                        <s:property value="bookName"/>
                    </td>
                    <td>
                        <s:property value="author"/>
                    </td>
                    <td>
                        <s:property value="price"/>
                    </td>
                    <td>
                        <s:property value="image"/>
                    </td>
                    <td>
                        <s:property value="categoryId"/>
                    </td>
                    <td>
                        <a href="deleteBookById?bookId=<s:property value="bookId"/>">[删除]</a>
                    </td>
                    <td>
                        <a href="updateBookById?bookId=<s:property value="bookId"/>">[修改]</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <p class="action-bar">
            <a href="toAddBook">添加书籍</a>
        </p>
    </s:form>
</s:if>
<s:else>
    <p class="message">没有任何图书信息！</p>
</s:else>
