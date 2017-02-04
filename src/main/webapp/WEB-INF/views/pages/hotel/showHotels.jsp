<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div>
 
	<table>
		<th>HotelName</th>
		<c:forEach items="${set}" var="hotel">
			<tr>
				<td><c:out value="${hotel.name}" />
				<td>
			</tr>
		</c:forEach>
	</table>


	
     
</div>