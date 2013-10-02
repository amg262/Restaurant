<%-- 
    Document   : index
    Created on : Sep 11, 2013, 7:48:45 PM
    Author     : agunn1
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="db.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/styles.css" type="text/css">
        <script src="scripts/jQuery.js"></script>
        <script src="scripts/script.js"></script>
        <title>Order</title>
    </head>
    
    <center>
    <body background="styles/badgers.jpg">
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
              ${email}
              <form id="form1" name="form1" onsubmit="return validateForm()" action="OrderController" />
            <br/>
        <%
            
            
            NumberFormat n = NumberFormat.getCurrencyInstance();
        
            List<MenuItem> menu = (List<MenuItem>) request.getAttribute("allMenuItems");
            int i = 0;
            for (MenuItem m : menu){
                
                out.println("<br />");
                out.println("<input type='checkbox'  name='menuEntry" + i
                            + "' value='menuEntry" + i
                            + "' id='menuEntry" + i + "'>"
                            + m.getName() + "\t"
                            + n.format(m.getPrice())
                            + "</input>" );
                
                out.println("<br />");
                i++;
            }

        %>

              <br/>
              <br/>
              <input type="submit" name="submit" id="submit" value="Place Order"/>
              </form>
            
            
            <p>
                <a href="home.html">< Back</a>
            </p>
              
          </div><!-- End of tab1 -->

          <!------------------------>
        </div><!-- End of tabs -->
            </div><!-- End of content -->
    </div><!-- End of container -->

      </body>
    </html>