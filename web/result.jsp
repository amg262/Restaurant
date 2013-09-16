<%-- 
    Document   : result
    Created on : Sep 11, 2013, 8:23:57 PM
    Author     : agunn1
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <script src="jQuery.js"></script>
        <script src="script.js"></script>
        <title>JSP Page</title>
    </head>
    
    <center>
    <body background="badgers.jpg">
    </center>

    <div class="container">
      <div class="content">
        <h1>Header</h1>
        <p></p>
        <div class="tabs">
          <!-- tabs -->
          <ul class="tabNavigation">
                    <li><a href="#tab1">Tab 1</a></li>
          </ul>
          
          
          <div id="tab1">
              <p>You ordered:</p>
              
              <%
                  
                  
                  
                  String bill = "";
                  String tax = "";
                  String gratuity = "";
                  String finalBill = "";
                  
                  List entrees = (List)request.getAttribute("entree");
                  List sides = (List)request.getAttribute("side");
                  List drinks = (List)request.getAttribute("drink");
                  
                  Object obj = request.getAttribute("bill");
                  Object obj2 = request.getAttribute("tax");
                  Object obj3 = request.getAttribute("gratuity");
                  Object obj4 = request.getAttribute("finalBill");
                  
                  
                  for (int i = 0; i < entrees.size(); i++){
                      out.println("Entree: " + entrees.get(i) + "<br />");
                  }
                  
                  for (int i = 0; i < sides.size(); i++){
                      out.println("Side: " + sides.get(i) + "<br />");
                  }
                  
                  for (int i = 0; i < drinks.size(); i++){
                      out.println("Drink: " + drinks.get(i) + "<br />");
                  }
                  
                  
                  /////////////////////////////////////////////////
                  if (obj != null){
                      bill = obj.toString();
                  }
                  out.println("<br />");
                  out.println("Bill:  " + bill);
                  
                  ////////////////////////////////////////////////
                  if (obj2 != null){
                      tax = obj2.toString();
                  }
                  out.println("<br />");
                  out.println("Tax:  " + tax);
                  
                  ////////////////////////////////////////////////
                  if (obj3 != null){
                      gratuity = obj3.toString();
                  }
                  out.println("<br />");
                  out.println("Gratuity:  " + gratuity);
                  
                  ////////////////////////////////////////////////
                  if (obj4 != null){
                      finalBill = obj4.toString();
                  }
                  out.println("<br />");
                  out.println("Final Bill:  " + finalBill);
                  
                %>
              
                <p>
                    <a href="index.jsp">< Back</a>
                </p>
          </div><!-- End of tab1 -->
          <!------------------------>
        </div><!-- End of tabs -->
            </div><!-- End of content -->
    </div><!-- End of container -->

      </body>
    </html>