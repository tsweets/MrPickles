<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <spring:message code="application_name" var="app_name" htmlEscape="false"/>
    <title><spring:message code="welcome_h3" arguments="${app_name}" /></title>
    <link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/theme.css"/>
</head>
<body>

<div class="container-fluid">
    <!-- Header Begin -->
    <div class="row-fluid">
        <div id="header" class="span12"><tiles:insertAttribute name="header"/></div>
    </div>
    <!-- Header End -->

    <!-- Middle Section Begin -->
    <div id="middleSection" class="row-fluid">
        <div class="span2">
            <div id="nav"><tiles:insertAttribute name="menu"/></div>
        </div>
        <div class="span10">
            <!-- Message Section Begin -->
            <div class="row-fluid">
                <div id="message"><tiles:insertAttribute name="message"/></div>
            </div>
            <!-- Message Section End -->
            <!-- Content Section Begin -->
            <div class="row-fluid">
                <div id="body"><tiles:insertAttribute name="body"/></div>
            </div>
            <!-- Content Section End -->
        </div>
    </div>
    <!-- Middle Section End -->
    <div class="push"><!-- Give the Footer a little bit of room--></div>
    <!-- Footer Begin -->
    <footer>
    <div class="row-fluid">
        <div id="footer" class="span12"><tiles:insertAttribute name="footer"/></div>
    </div>
    </footer>
    <!-- Footer End -->

</div>


<script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/resources/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.bootstrapfix.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ga.js"></script>
<script type="text/javascript">
    $(document).ready( function() { $.ga.load("UA-XXXXXXXX-X"); } );
</script>


</body>
</html>


