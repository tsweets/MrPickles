<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${danger}">
    <div class="alert alert-danger">
        <i class="fa fa-times-circle"></i>
        <a class="close" data-dismiss="alert">x</a>
            ${dangerMessage}
    </div>
</c:if>

<c:if test="${warning}">
    <div class="alert alert-warning">
        <i class="fa fa-info-circle"></i>
        <a class="close" data-dismiss="alert">x</a>
            ${warningMessage}
    </div>
</c:if>

<c:if test="${success}">
    <div class="alert alert-success">
        <i class="fa fa-check-square-o"></i>
        <a class="close" data-dismiss="alert">x</a>
            ${successMessage}
    </div>
</c:if>

<c:if test="${info}">
    <div class="alert alert-info">
        <i class="fa fa-lightbulb-o"></i>
        <a class="close" data-dismiss="alert">x</a>
            ${infoMessage}
    </div>
</c:if>

<c:if test="${infoWithAction}">
    <div class="alert alert-block alert-info fade in">

        <button class="close" data-dismiss="alert">&times;</button>
        <h4 class="alert-heading"><i class="fa fa-lightbulb-o"></i> ${infoWithActionHeading}</h4>
        <p>${infoWithActionContent}</p>
        <p>
            <a class="btn btn-info" href="${infoWithActionPrimaryActionLink}">${infoWithActionPrimaryAction}</a>
            <a class="btn" href="${infoWithActionSecActionLink}">${infoWithActionSecAction}</a>
        </p>
    </div>
</c:if>