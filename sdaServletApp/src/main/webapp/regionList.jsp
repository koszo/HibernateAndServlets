<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sda.service.RegionService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>regionList</title>
</head>
<body>
	<h1>region List</h1>

	<table border="1px">
		<tr>
			<td>RegionID</td>
			<td>RegionName</td>
			<td>deletebutton</td>
			<td>Update Region</td>
		</tr>
		<c:forEach items="${regionList}" var="region">
			<tr>
				<td>${region.getRegionId()}</td>
				<td>${region.getRegionName()}</td>
				<td><form method="post"
						action="${pageContext.request.contextPath}/regionDelete">
						<input type="submit" value="Delete" name="delete"> <input
							type="hidden" value="${region.getRegionId()}" name="regionId">
					</form></td>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/regionUpdate">
						<input type="submit" value="Update" name="update"> <input
							type="hidden" value="${region.getRegionId()}" name="regionId">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<form method="post"
		action="${pageContext.request.contextPath}/regionCreate">
		Input new region:<br> <input type="text" name="newRegion"><br />
		<input type="submit" value="Submit">
	</form>

</body>
</html>