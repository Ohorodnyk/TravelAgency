<form method="post"
	action="${pageContext.request.contextPath}/reserveHotel">
	   <label for="firstName">First Name:</label> <br />
	   <input type="text" id="firstName" name="firstName" placeholder="Enter First Name" /> 

	<br /> <label for="lastName">Last Name:</label>  <br />
	<input type="text" 	id="lastName" name="lastName" placeholder="Enter Last Name" /> <br />  	
	
	<label for="country">Country:</label>  <br />
	<input type="text" id="country" name="country" placeholder="Enter Country" /> <br /> 

	<label for="city">City:</label>  <br />
	<input type="text" id="city" name="city" placeholder="Enter city" /> <br /> 
		
	<label for="date">Date:</label> <br />	
	<input type="text" id="date" name="date" placeholder="Enter date(yyyy-mm-dd)" /> <br /> <br/>
  
   <input type="submit" value="Send" />

</form>