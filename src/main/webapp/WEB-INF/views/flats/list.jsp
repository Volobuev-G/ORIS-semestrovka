<%--
  Created by IntelliJ IDEA.
  User: Volobuev
  Date: 21.11.2022
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title ="Main page">
    <div class="text-info">Flats in DB: ${flatCount} </div>
    <div class="books-list">
        <c:forEach items="${flats}" var="flat">
            <div class="book-card">
                <div class="book-header">
                    <h3 class="book-name"><a href="<c:url value="/flat/detail?id=${flat.id}"/>">${flat.getFlatName()}</a></h3>
                    <span class="book-info">${book.getStatus()}</span>
                    <%--<div class="book-action-icon"><a href="/book/delete/1" class="text-danger"><i class="glyphicon glyphicon-remove"></i></a></div>
                    <div class="book-action-icon"><a href="/book/edit/1" class="text-success"><i class="glyphicon glyphicon-edit"></i></a></div>--%>
                    <div class="clearfix"></div>
                </div>
                <%--<div class="book-description">Some description for the first book</div>--%>
            </div>
        </c:forEach>

    </div>
</t:mainLayout>
