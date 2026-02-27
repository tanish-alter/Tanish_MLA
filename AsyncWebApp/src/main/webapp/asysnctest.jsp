<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Async Servlet with javaScript and XMLHttpRequest</h1>
<p id = "mla"></p>
<script type = "text/javascript">
function mlaDisp(inputData){
	document.getElementById("mla").innerHTML = inputData;
}

let yourPromise = new Promise(function (yourResolve, yourReject){
	
	let input = 1;
	
	if(input == 0){
		yourResolve("Success...........");
	}
	
	else{
		yourReject("Failure / Rejected / Deny etc");
	
	}

});

yourPromise.then(
		function(value)
		{
			mlaDisp(value);
		},
		function(error)
		{
			mlaDisp(error);
		}
		
	)


</script>
</body>
</html>