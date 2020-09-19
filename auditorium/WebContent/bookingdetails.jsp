<!DOCTYPE HTML>
<!--
	Prism by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>auditorium</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	</head>
	<body>

		<!-- Banner -->
			<section id="banner">
				<div class="inner split">
					<section>
						<h2>The auditorium</h2>
					</section>
			
				</div>
			</section>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>



<%@page import="java.sql.*" %>
<%
try{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
	 String qr="select*from booking";
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(qr);
    out.print("<table align=center border=1px>");	 
    
   
    out.print("<th>ID</th><th>DATE</th><th>TIME</th>");
	 if(rs.next())
	 {
		 do
		 {
	 String id=rs.getString("id");
	 String date=rs.getString("date");
	 String time=rs.getString("time");
	 String purpose=rs.getString("purpose");
	 
	 out.print("<tr>");
	 out.println("<td>");
	 out.println(id);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(date);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(time);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(purpose);
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<a href=proceed.html?id="+id+"&=date"+date+"&time="+time+"&purpose="+purpose+">Proceed</a>");
	 out.println("</td>");
	 out.println("</tr>");
	
		 }while(rs.next());
		 
	 }
	 out.println("</table>");
	 con.close();
	}catch(Exception e)
	{
		out.println(e);
	}
%>