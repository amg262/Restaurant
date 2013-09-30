<%-- 
    Document   : adminResult
    Created on : Sep 30, 2013, 4:44:06 PM
    Author     : Andy
--%>

<%@page import="db.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                  
                  MenuItem item = new MenuItem();
                  Object obj;
                  
                  obj = request.getAttribute("item");
                  MenuItem Item = (MenuItem)obj;
                  
                  out.println("<br />");
                  out.println(item.getMenuItemId() + "<br />" +
                              item.getName() + "<br />" +
                              item.getPrice());
                  
                  
              %>
    </body>
</html>
