<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




	<h3>Client has ${set.size()} visas</h3>
	<table>
		<th>Country</th>
		<th>Start Date</th>
		<th>End Date</th>
		<c:forEach items="${set}" var="visa">
			<tr>
				<td><c:out value="${visa.country.name}" />
				<td><c:out value="${visa.startDate}" />
				<td><c:out value="${visa.endDate}" />
				<td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Client visited ${list.size()} countries</h3>
	<table>
		<th>Country</th>
		<c:forEach items="${list}" var="country">
			<tr>
				<td><c:out value="${country.name}" />
				<td>
			</tr>
		</c:forEach>
	</table>