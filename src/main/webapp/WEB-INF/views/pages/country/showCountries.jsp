<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	
	<table>
	    
		<th>CountryName</th>
		<c:forEach items="${set}" var="country">
			<tr>
				
				<td><c:out value="${country.name}" />
				<td>
			</tr>
		</c:forEach>
	</table>
</div>