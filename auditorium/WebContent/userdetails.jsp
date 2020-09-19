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



<%@ page import="java.sql.*" %>
<%
try{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
	 String qr="select*from user";
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(qr);
    out.print("<table align=center border=1px>");	
    out.print("<th>FIRST-NAME</th><th>LAST-NAME</th><th>CONTACT</th><th>EMAIL</th><th>PASSWORD</th><th>ADDRESS</th><th>CITY</th><th>STATE</th>");
    if(rs.next())
    {
   	 do{
    
String fname=rs.getString("fname");
String lname=rs.getString	 ("lname");
String contact=rs.getString("contact");
String email=rs.getString("email");
String pwd=rs.getString("pwd");
String address=rs.getString("address");
String city=rs.getString("city");
String state=rs.getString("state");
out.print("<tr>");
out.println("<td>");
out.println(fname);
out.println("</td>");
out.println("<td>");
out.println(lname);
out.println("</td>");
out.println("<td>");
out.println(contact);
out.println("</td>");
out.print("<td>");
out.println(email);
out.println("</td>");
out.println("<td>");
out.println(pwd);
out.println("</td>");
out.println("<td>");
out.println(address);
out.println("</td>");
out.println("<td>");
out.println(city);
out.println("</td>");
out.println("<td>");
out.println(state);
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