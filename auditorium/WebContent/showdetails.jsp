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
	 String qr="select*from addetails";
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(qr);
    out.print("<table align=center border=2px>");	 
    
    out.print("<th>COLLEGE-NAME</th><th>OWNER-NAME</th><th>AUDITORIUM-DETAILS</th><th>AUDITORIUM-SIZE</th><th>AREA</th><th>CITY</th><th>ADDRESS</th><th>CONTACT</th><th>FACALITIES</th>");
	 
	 if(rs.next())
	 {
		 do
		 {
	 String collegename=rs.getString("collegename");
	 String ownername=rs.getString("ownername");
	 String details=rs.getString("details");
	 String auditoriumname=rs.getString("auditoriumname");
	 String area=rs.getString("area");
	 String city=rs.getString("city");
	 String contact=rs.getString("contact");
	 String address=rs.getString("address");
	 String facalities=rs.getString("facalities");
	 
	 out.print("<tr>");
	 out.println("<td>");
	 out.println(collegename);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(ownername);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(details);
	 out.println("</td>");
	 out.print("<td>");
	out.println(auditoriumname);
	out.println("</td>");
	 out.println("<td>");
	out.println(area);
	 out.println("</td>");
    out.println("<td>");
	out.println(city);
   out.println("</td>");
   out.println("<td>");
	out.println(contact);
   out.println("</td>");	 
   out.println("<td>");
	out.println(address);
   out.println("</td>");
   out.println("<td>");
	out.println(facalities);
   out.println("</td>");
   out.println("<td>");
	 out.println("<a href=delete?collegename="+collegename+">delete</a>");
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<a href=update.jsp?collegename="+collegename+"&ownername="+ownername+"&details="+details+"&auditoriumname="+auditoriumname+"&area="+area+"&city="+city+"&contact="+contact+"&address="+address+"&facalities="+facalities+">update</a>");
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