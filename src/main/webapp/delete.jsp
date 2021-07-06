<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Review"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<meta charset="UTF-8">
<style>
h1{
  font-size: 25px;
    font-weight: bold;
    margin: 0;
  text-align: center;
}
hr {
	height: 3px;
}
hr.big {
	height: 15px;
}
button.top {
    width: auto;
    padding:0;
    margin:0;
    background:none;
    border:0;
    font-size:0;
    line-height:0;
    overflow:visible;
    cursor:pointer;
}
.evaluation{
  display: flex;
  flex-direction: row-reverse;
  justify-content: center;
}
.evaluation input[type='radio']{
  display: none;
}
.evaluation label{
  position: relative;
  padding: 10px 10px 0;
  color: gray;
  cursor: pointer;
  font-size: 50px;
}
.evaluation label .text{
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  text-align: center;
  font-size: 12px;
  color: gray;
}
.evaluation label:hover,
.evaluation label:hover ~ label,
.evaluation input[type='radio']:checked ~ label{
  color: #ffcc00;
}
</style>

<title>レビュー削除画面</title>
</head>
<div class="container">
<header>
	<hr color="#006400">
	<p class="text-center">
		<button class="top" type="button"
			onclick="location.href='HomeServlet'"
			style="background-color: white;">
			<div class="row"><h1>本の感想</h1></div>
		</button>
		</p>
	<hr class="big" color="#006400">
</header>
</div>
<body>
<div class="container">
	<h1>このレビューを削除しますか？</h1>
	<%
	Review r = (Review) request.getAttribute("delete");
	%>
			<table class="table" border="0">
			<tbody>
			<tr><td>『<%= r.getName() %>』<%
						for (int m = 0; m < r.getStar(); m++) {
					%> <font color="#FFD700">★</font> <%
 						}
 			%></td></tr>
			<tr><td><b><%=r.getTitle()%></b></td></tr>
			<tr><td>内容：<%= r.getReason() %></td></tr>
			<tr><td>
	</td></tr>
			<hr color="green">
			
			</tbody>
			</table>
	<form action= "./DeleteServlet" method= "post">
		<p class="text-center">
			<a href="./HomeServlet" class="btn btn-success">戻る</a>
			<button type="submit" class="btn btn-danger" name="delete2" value="<%= r.getName() %>">削除する</button>
		</p>
	</form>

	<footer>
		<hr color="#006400">
		<p class="text-center">
		<button class="top" type="button"
			onclick="location.href='HomeServlet'"
			style="background-color: white;">
			<font size=3><b>本の感想</b></font>
		</button>
		</p>
		<hr color="#006400">
	</footer>
</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>

</body>
</html>