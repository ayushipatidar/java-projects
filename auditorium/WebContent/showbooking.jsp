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







<%@ page import="java.sql.*"
%>
<%
try{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
	 String qr="select*from proceed";
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(qr);
    out.print("<table align=center border=1px>");	 
	 out.println("<th>Email</th><th>Working</th><th>Charge</th>");
	 if(rs.next())
	 {
		 do
		 {
	 String email=rs.getString("email");
	 String working=rs.getString("working");
	 String charge=rs.getString("charge");
	 out.print("<tr>");
	 out.println("<td>");
	 out.println(email);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(working);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(charge);
	 out.println("</td>");
	 out.print("</tr>");
	
		 }while(rs.next());
	 }
	 out.println("</table>");
	 con.close();
	}catch(Exception e)
	{
		out.println(e);
	}
%>
<footer id="footer">
				<div class="copyright">
					 <a href="index.html">logout</a>.
				</div>
			</footer>