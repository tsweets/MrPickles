<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute defaultValue="Client Portal" name="title"/></title>
    <meta charset="UTF-8">
    <spring:message code="application_name" var="app_name" htmlEscape="false"/>
    <title><spring:message code="welcome_h3" arguments="${app_name}" /></title>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/less/theme.css"/>
    <link rel="stylesheet" href="/resources/fonticons/flaticons/flaticon.css"/>
    <link rel="stylesheet" href="/resources/fonticons/fontawesome/css/font-awesome.min.css"/>


</head>
<body>
<!-- page -->
<div class="wrapper">
    <div class="container">
        <!-- header -->
        <header id="header">
            <tiles:insertAttribute name="header"/>
        </header>
        <!-- /header -->

        <!-- message -->
        <div id="message">
            <tiles:insertAttribute name="message"/>
        </div>
        <!-- /header -->

        <!-- content -->
        <div id="body">
            <tiles:insertAttribute name="body"/>
        </div>
        <!-- /content -->
    </div>
    <div class="push"><!--//--></div>
</div>
<!-- /page -->
<!-- footer -->
<footer>
    <div class="container">
        <tiles:insertAttribute name="footer"/>
    </div>
</footer>
<!-- /footer -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
<%--
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.bootstrapfix.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ga.js"></script>
<script type="text/javascript">
    $(document).ready( function() { $.ga.load("UA-XXXXXXXX-X"); } );
</script>
--%>

</body>
</html>
