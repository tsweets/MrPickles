<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <spring:message code="application_name" var="app_name" htmlEscape="false"/>
    <title><spring:message code="welcome_h3" arguments="${app_name}" /></title>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/less/theme.css"/>
    <link rel="stylesheet" href="/resources/fonticons/flaticons/flaticon.css"/>
    <link rel="stylesheet" href="/resources/fonticons/fontawesome/css/font-awesome.min.css"/>
</head>
<body>

<div class="container-fluid">
    <!-- Header Begin -->
    <div class="row-fluid">
        <div id="header" class="col-md-12"><tiles:insertAttribute name="header"/></div>
    </div>
    <!-- Header End -->

    <!-- Middle Section Begin -->
    <div id="middleSection" class="row">
        <div class="col-md-2">
            <div id="nav"><tiles:insertAttribute name="menu"/></div>
        </div>
        <div class="col-md-9">
            <!-- Message Section Begin -->
            <div class="row">
                <div id="message"><tiles:insertAttribute name="message"/></div>
            </div>
            <!-- Message Section End -->
            <!-- Content Section Begin -->
            <div class="row">
                <div id="body"><tiles:insertAttribute name="body"/></div>
            </div>
            <!-- Content Section End -->
        </div>
    </div>
    <!-- Middle Section End -->
    <div class="push"><!-- Give the Footer a little bit of room--></div>
    <!-- Footer Begin -->
    <footer>
    <div class="row">
        <div id="footer" class="col-md-12"><tiles:insertAttribute name="footer"/></div>
    </div>
    </footer>
    <!-- Footer End -->

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.validate.bootstrapfix.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ga.js"></script>
<script type="text/javascript">
    $(document).ready( function() { $.ga.load("UA-XXXXXXXX-X"); } );
</script>


</body>
</html>


