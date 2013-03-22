<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="home" value="/" />
<spring:message code="button_home" var="home_label" htmlEscape="false" />
<spring:message code="application_name" var="app_name" htmlEscape="false"/>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
<%--
        <div class="container">
--%>
            <a class="brand active" href="${home}" name="${fn:escapeXml(home_label)}" title="${fn:escapeXml(home_label)}">
                <c:out value="${app_name}"/>
            </a>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <c:choose>
                        <c:when test="${pageContext['request'].userPrincipal != null}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome,
                                    ${appUser.userName}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="${logout}">Logout</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Sign
                                In<b class="caret"></b></a>

                            <div class="dropdown-menu signin-pad">
                                <spring:url value="/resources/j_spring_security_check" var="form_url" />
                                <form id="loginUserForm" method="post" action="${fn:escapeXml(form_url)}" class="pull-right">
                                    <label for="j_username">Username</label>
                                    <input class="span3" type="text" id="j_username" name="j_username"
                                           placeholder="Username"/>
                                    <label for="j_password">Password</label>
                                    <input class="span3" type="password" id="j_password" name="j_password"
                                           placeholder="Password"/>
                                    <input type="submit" name="Login" class="btn small" value="Login"/>
                                    <br/><br/>
                                    <a href="forgotPassword" style="margin-left: -4px;">Forgot your password?</a>
                                </form>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
<%--
        </div>
--%>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        // Setup drop down menu
        $('.dropdown-toggle').dropdown();

        // Fix input element click problem
        $('.dropdown input, .dropdown label').click(function (e) {
            e.stopPropagation();
        });
    });

    $(document).ready(function () {
        $("#loginMerchantForm").validate({
            rules:{
                username_lgn:{
                    required:true
                },
                password_lgn:{
                    required:true
                }
            },
            errorClass:"control-group error",
            validClass:"control-group success",
            errorElement:"span",
            highlight:function (element, errorClass, validClass) {
                if (element.type === 'radio') {
                    this.findByName(element.name).parent("div").parent("div").removeClass(validClass).addClass(errorClass);
                } else {
                    $(element).parent("div").parent("div").removeClass(validClass).addClass(errorClass);
                }
            },
            unhighlight:function (element, errorClass, validClass) {
                if (element.type === 'radio') {
                    this.findByName(element.name).parent("div").parent("div").removeClass(errorClass).addClass(validClass);
                } else {
                    $(element).parent("div").parent("div").removeClass(errorClass).addClass(validClass);
                }
            }
        });
    });
</script>