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
    <header class="clearfix">
        <img class="logo" src="/digipass/static/img/digipass_logo.png"/>
        <nav class="codrops-demos">
            <%--<a class="current-demo" href="index.html">About Us</a>--%>
            <%--<a href="#">Demo 2</a>--%>
            <%--<a href="#">Sign Up</a>--%>
            <select id="cd-dropdown" name="cd-dropdown" class="cd-select">
                <option value="-1" selected>Choose your company</option>
                <option value="1" class="icon-monkey">Egged</option>
                <option value="2" class="icon-bear">Dan</option>
                <option value="3" class="icon-squirrel">Israel Rail</option>
                <option value="4" class="icon-elephant">Sign Up</option>
            </select>
        </nav>
    </header>
    <section class="main clearfix">
        <p>Account Information</p>
        <div class="row">
        	<div class="col-md-5">
	        	<div id="account_snapshot">
	            	<div class="row">
	            		<div class="col-md-6">
	            			<span>User Details</span>
	            		</div>
	            		<div class="col-md-6">
	            			<span>Lilac Orenshtein</span>
	            		</div>
	            		
	            		<div class="col-md-6">
	            			<span>User Type</span>
	            		</div>
	            		<div class="col-md-6">
	            			<span>Student</span>
	            		</div>
	            		
	            		<div class="col-md-6">
	            			<span>Card Status</span>
	            		</div>
	            		<div class="col-md-6">
	            			<span>Active</span>
	            		</div>
	            		
	            		<div class="col-md-6">
	            			<span>Remaining Credit</span>
	            		</div>
	            		<div class="col-md-6">
	            			<span>&#8362;&nbsp;240</span>
	            		</div>
	            	</div>
	        	</div>
        	</div>
        	<div class="col-md-7"></div>
        </div>
    </section>
    <section class="main clearfix">
        <p>Recent History</p>
        <span>The following table includes details from your most recent travels using DigiPass.</span>
        <div class="table-responsive">
		    <table class="table table-condensed">
				<!-- <tr>
		            <th>Company Information</th>
		            <th>Line Number</th>
		            <th>From</th>
		            <th>Destination</th>
		            <th>Date/Time</th>
		            <th>Amount Due</th>
				</tr> -->
				<tr>
					<td><img class="company-icon-small" src="/digipass/static/img/egged.png"/><span>Egged</span></td>
					<td><span>504</span></td>
					<td><span>Raanana</span></td>
					<td><span>Tel Aviv</span></td>
					<td><span>October 1st, 9:24am</span></td>
					<td><span>&#8362;&nbsp;15.2</span></td>
				</tr>
				<tr>
					<td><img class="company-icon-small" src="/digipass/static/img/egged.png"/><span>Egged</span></td>
					<td><span>502</span></td>
					<td><span>Kfar Saba</span></td>
					<td><span>Ra'anana</span></td>
					<td><span>October 1st, 17:24am</span></td>
					<td><span>&#8362;&nbsp;25</span></td>
				</tr>
				<tr>
					<td><img class="company-icon-small" src="/digipass/static/img/dan.png"/><span>Dan</span></td>
					<td><span>972</span></td>
					<td><span>Raanana</span></td>
					<td><span>Jerusalem</span></td>
					<td><span>October 2nd, 7:30am</span></td>
					<td><span>&#8362;&nbsp;15.2</span></td>
				</tr> 
				<tr>	
					<td><img class="company-icon-small" src="/digipass/static/img/israelrail.png"/><span>Israel Train</span></td>
					<td><span>NA</span></td>
					<td><span>Jerusalem</span></td>
					<td><span>Be'erSheva</span></td>
					<td><span>October 2nd, 3pm</span></td>
					<td><span>&#8362;&nbsp;45.5</span></td>
				</tr> 
				<tr>	
					<td><img class="company-icon-small" src="/digipass/static/img/dan.png"/><span>Dan</span></td>
					<td><span>124</span></td>
					<td><span>Be'er Sheva</span></td>
					<td><span>Eilat</span></td>
					<td><span>October 2nd, 7:30pm</span></td>
					<td><span>&#8362;&nbsp;85.3</span></td>
				</tr>  
			</table>
		</div>
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
