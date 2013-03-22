<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



  <spring:url value="/" var="home"/>
  <span>
    <a href="${home}">
      <spring:message code="button_home"/>
    </a>
  </span>
  <c:if test="${pageContext['request'].userPrincipal != null}">
    <c:out value=" | "/>
    <span>
      <spring:url value="/resources/j_spring_security_logout" var="logout"/>
      <a href="${logout}">
        <spring:message code="security_logout"/>
      </a>
    </span>
  </c:if>

  <span id="language">
    <c:out value=" | "/>
    <spring:message code="global_language"/>
    <c:out value=": "/>
    <spring:url var="img" value="/resources/images/en.png" />
    <spring:message code="global_language_switch" arguments="English" var="lang_label" htmlEscape="false" />
    <a href="?lang=en" title="${fn:escapeXml(lang_label)}">
        <img class="flag" src="${img}" alt="${fn:escapeXml(lang_label)}" />
    </a>
    <c:out value=" " />
    <spring:url var="img" value="/resources/images/es.png" />
    <spring:message code="global_language_switch" arguments="Espanol" var="lang_label" htmlEscape="false" />
    <a href="?lang=es" title="${fn:escapeXml(lang_label)}">
        <img class="flag" src="${img}" alt="${fn:escapeXml(lang_label)}" />
    </a>
    </span>

  <spring:url value="/resources/images/springsource-logo.png" var="logo"/>
  <spring:message code="global_sponsored" htmlEscape="false" var="sponsored"/>
  <span>
    <a href="http://springsource.com" title="${fn:escapeXml(sponsored)}">
      <img align="right" alt="${fn:escapeXml(sponsored)}" src="${logo}"/>
    </a>
  </span>

