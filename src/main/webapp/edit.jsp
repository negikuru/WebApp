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

<title>レビュー編集画面</title>
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
	<% 
	String error = (String)request.getAttribute("error");
	if(error != null){%>
	<br><font color="red"><h3><%=error %></h3></font>
	<%} %>
	
	<%
	Review review = (Review) request.getAttribute("edit");
	
	%>
	<form method="post" action="./EditServlet">
		<table class="review" border="1" align="center" width="100%"
			style="border-collapse: collapse; border-color: #d3d3d3; table-layout: auto">
			<tbody>
				<tr>
					<td>題名</td>
					<%
						if (review != null) {
					%>
					<td><input type="text" name="name" maxlength="20" size="30"
						onkeyup="CountDownLength('inputlength1',value,20);"
						value="<%=review.getName()%>" readonly> <%
 	} else {
 %>
					<td><input type="text" name="name" maxlength="20" size="30"
						onkeyup="CountDownLength('inputlength1',value,20);"> <%
 	}
					
 %> <br> <font color="red">題名は編集できません</font>
					</td>
				</tr>

				<tr>
					<td>この本の評価</td>
					<td>
						<div class="evaluation">
							<input id="star1" type="radio" name="star" value="5" /> <label
								for="star1"><span class="text">最高</span>★</label> <input
								id="star2" type="radio" name="star" value="4" /> <label
								for="star2"><span class="text">良い</span>★</label> <input
								id="star3" type="radio" name="star" value="3" /> <label
								for="star3"><span class="text">普通</span>★</label> <input
								id="star4" type="radio" name="star" value="2" /> <label
								for="star4"><span class="text">悪い</span>★</label> <input
								id="star5" type="radio" name="star" value="1" /> <label
								for="star5"><span class="text">最悪</span>★</label>
						</div>

					</td>
				</tr>

				<tr>
					<td>レビュータイトル</td>
					<%
						if (review != null) {
					%>
					<td><textarea name="title" maxlength="50" cols="30" rows="3"
							onkeyup="CountDownLength('inputlength2',value,50);"><%=review.getTitle()%></textarea>
						<%
							} else {
						%>
					<td><textarea name="title" maxlength="50" cols="30" rows="3"
							onkeyup="CountDownLength('inputlength2',value,50);"></textarea>
						<%
							}
						%> <br> <font color="slateblue"><p id="inputlength2">残り50文字記述できます。</p></font>
					</td>

				</tr>
				<tr>
					<td>レビュー</td>
					<%
						if (review != null) {
					%>
					<td><textarea name="reason" maxlength="100" cols="30"
							rows="5" onkeyup="CountDownLength('inputlength4',value,100);"><%=review.getReason()%></textarea>
						<%
							} else {
						%>
					<td><textarea name="reason" maxlength="100" cols="30"
							rows="5" onkeyup="CountDownLength('inputlength4',value,100);"></textarea>
						<%
							}
						%> <font color="slateblue"><p id="inputlength4">残り100文字記述できます。</p></font>
					</td>
				</tr>
				
			</tbody>
		</table>
		<br>
		<p class="text-center">
			<a href="./HomeServlet" class="btn btn-success">戻る</a>
			<button type="submit" class="btn btn-danger" name="edit2" value="a">編集完了</button>
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
	<script>
		function CountDownLength(idn, str, mnum) {
			document.getElementById(idn).innerHTML = "残り" + (mnum - str.length)
					+ "文字記述できます。";
		}
	</script>	

</body>
</html>