<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:choose>

	<c:when test="${set.size()>0}">

		<h3>Information about visas:</h3>
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
		<br>
		<c:choose>

			<c:when test="${list.size()>0}">
				<h3>Hotels for reservation:</h3>
				<table>
					<th>Hotel</th>
					<th>Count of free rooms</th>
					<c:forEach items="${list}" var="array">
						<tr>
							<c:forEach items="${array}" var="object">
								<td><c:out value="${object}" /></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>

			</c:when>
			<c:otherwise>

				<h3>Sorry, but there are no free hotels</h3>
			</c:otherwise>
		</c:choose>

	</c:when>
	<c:otherwise>

		<h3>Client can't reserve a Hotel because of not valid visa</h3>
	</c:otherwise>
</c:choose>
