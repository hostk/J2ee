<%@ include file="/WEB-INF/views/user_include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-danger text-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="#"><img alt="Online Shopping"  src="/userImage/sLogo.jpg" width="100" height="40"/></a>
    <div class="collapse navbar-collapse text-light	" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown ml-4 text-light">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          		<c:forEach items="${ cList }" var="item" varStatus="row">
          <a class="dropdown-item" href="${item.id }">${item.name}</a>
          </c:forEach>
          
        </div>
      </li>
    </ul>
  </div>
  <form:form class="form-inline" action="sumbit" method="GET">
      <form:input id="search" class="form-control" type="text" placeholder="Search" path="${search }"/>
      <input type="submit" value="Search">
      </form:form>
  </div>
</nav>
<script>
 $document.ready(function(){
$( 'input', this ).on( 'keyup change', function () {
    if ( table.column(i).search() !== this.value ) {
        table
            .column(i)
            .search( this.value )
            .draw();
    }
} );
}); 
</script>
<script>
    $(document).reday(function(){
    	$("#search").on("keyup",function(){
    		var value=$(this).val().toLowerCase();
    		$("#mySearch li").filter(function(){
    			$(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
    		});
    	});
    });
    
</script>
</body>
</html>