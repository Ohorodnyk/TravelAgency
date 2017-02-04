<nav >
	<a href="${pageContext.request.contextPath}/"><img class="logo"
		src="${pageContext.request.contextPath}/static/img/logo.png"></a>
	<ul>
		 
			<li >
			<a href="${pageContext.request.contextPath}/">Home</a>	
			</li>
			
			 <li> <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle my" type="button" data-toggle="dropdown"> Client
            <span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/clientForm1">Reserve Hotel</a> </li>
			</ul>
            </li> 
            
             <li> <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Visa
			<span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/visaForm">Visas by Client</a> </li>
			<li><a href="${pageContext.request.contextPath}/visaForm2">Count Of Visas By Country</a> </li>
			</ul>
		   	            
            <li> <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Countries
            <span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/countries">Show countries</a> </li>
			</ul>
            </li>
             <li> <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Cities
            <span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/cities">Show cities</a> </li>
			</ul>
            </li>          
             <li>  <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">   Hotels
			<span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/hotelForm">Find by city</a> </li>
			<li><a href="${pageContext.request.contextPath}/hotelForm2">Count of Free Rooms</a> </li>
			<li><a href="${pageContext.request.contextPath}/hotelForm3">Avaliable by City and Date </a> </li>
			</ul>
			
			
			<li> <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Statistic
			<span class="caret"></span></button>
		    <ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/clientForm">Client Statistic</a> </li>
			<li><a href="${pageContext.request.contextPath}/hotelForm4">Hotel Statistic</a> </li>
			
			</ul>
		
	</ul>
	
	<img class="travel"
		src="${pageContext.request.contextPath}/static/img/travel.png">
</nav>