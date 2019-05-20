<%@ page import="com.sda.model.Person"%>
<html>
<body>
	<%! boolean test=true; %>
	<%! Person p = new Person("bogdan", "marinau"); %>

	<%! public int sum(int a, int b) {
        return a+b;
    }
    %>

	<h2>Hello World2!</h2>
	<%-- This is a comment --%>
	<%if(sum(10,10) > 15) { %>
	<h1><%= p.getFirstName()%></h1>
	<%} else {%>
	<h1>false</h1>
	<%} %>

</body>
</html>
