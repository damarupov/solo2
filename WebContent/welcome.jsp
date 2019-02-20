<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!</h3>
   
          <fieldset style="width: 500px">
            <legend> Hello,
        			<%=session.getAttribute("name")%> </legend>
            <table>
                <tr>
                    <td> Currently you have <%=session.getAttribute("entry")%> entries!</td>
                </tr>
                <tr>
                    <td>Click "Check in" If you want to have new entry!</td>
                </tr>
                <tr>
                    <td><input type="submit"  name = "btn1" value="Check in!" /></td>
                </tr>
            </table>
        </fieldset>

</body>
</html>