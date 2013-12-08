<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DigiPass - We make traveling fun!</title>
<jsp:include page="resources.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<section class="main clearfix">
			<%
				if (response.getHeader("msg") != null
						&& response.getHeader("msgType") != null) {
			%>
			<div class="alert alert-<%=response.getHeader("msgType")%>"><%=response.getHeader("msg")%></div>
			<%
				}
			%>

			<div class="row">
				<div class="col-sm-3">
					<p>Database</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Add Initial Data</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>User Types</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>Users</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>Companies</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<p>Database</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>Buses</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>Lines</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
				<div class="col-sm-3">
					<p>Lines</p>
					<a href="/digipass/admin?cmd=create">Create Database</a><br /> <a
						href="/digipass/admin?cmd=populate">Populate Database</a><br /> <a
						href="/digipass/admin?cmd=delete">Delete Database</a>
				</div>
			</div>
		</section>
</body>
</html>
