<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	
	<table>
	  
		<th>City</th>
		<c:forEach items="${set}" var="city">
			<tr>
				
				
				<td><c:out value="${city.name}" />
				<td>
			</tr>
		</c:forEach>
	</table>
</div>
