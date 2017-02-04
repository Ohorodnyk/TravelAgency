<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>


	<c:choose>

		<c:when test="${list.size()>0}">

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

			<h3>There is no free rooms</h3>
		</c:otherwise>
	</c:choose>




</div>