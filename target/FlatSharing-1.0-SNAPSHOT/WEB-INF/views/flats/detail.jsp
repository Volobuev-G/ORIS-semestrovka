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

<t:mainLayout title ="Flat detail">
    <div class="book-page">
        <h1 class="book-name">${flat.getFlatName()}</h1>
        <div class="book-field">
            <span class="field-name">Status:</span>
            <span class="field-value">${flat.getStatus()}</span>
        </div>
            <%--        <div class="book-description">Some description for the first book</div>--%>
    </div>
</t:mainLayout>
