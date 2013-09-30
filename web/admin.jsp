<%-- 
    Document   : admin
    Created on : Sep 25, 2013, 9:09:13 PM
    Author     : agunn1
--%>

<%@page import="java.util.List"%>
<%@page import="db.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <script src="jQuery.js"></script>
        <script src="script.js"></script>
    </head>

    <center>
    <body background="badgers.jpg">
    
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
              
              <form action="DatabaseController" />
              <h3>Add/Edit Item</h3>
               <p>
              Item ID: <input type="text" name="id" id="id" /></br>
              Name: <input type="text" name="name" id="id" /></br>
              Price: <input type="text" name="price" id="id" /></br>
              <input type="submit" value="Submit"/>
              </p>
          </form>
              
              
          </div><!-- End of tab1 -->

          <!------------------------>
        </div><!-- End of tabs -->
        </div><!-- End of content -->
    </div><!-- End of container -->

      </body>
    </center>
    </html>