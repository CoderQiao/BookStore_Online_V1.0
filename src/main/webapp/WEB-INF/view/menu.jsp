<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>图书分类</h2>
<ul id="categories">
    <s:iterator value="#session.categories">
        <li>
            <a href="searchBookByCategoryId?categoryId=<s:property value="categoryId"/>">
                <s:property value="categoryName" />
            </a>
        </li>
    </s:iterator>
</ul>