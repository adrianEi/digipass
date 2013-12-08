<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DigiPass - We make traveling fun!</title>
    <jsp:include page="resources.jsp" />
</head>
<body>
<div class="container">
   <jsp:include page="header.jsp"></jsp:include>
    <section class="main clearfix">
        
    </section>
<!-- /container -->

<script type="text/javascript" src="/digipass/static/js/jquery.dropdown.js"></script>
<script type="text/javascript">

    $(function () {
        $('#cd-dropdown').dropdown({
            gutter: 5
        });
    });
</script>
</body>
</html>
