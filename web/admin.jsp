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
        <link rel="stylesheet" href="styles/styles.css" type="text/css">
        <script src="scripts/jQuery.js"></script>
        <script src="scripts/script.js"></script>
    </head>

    <center>
    <body background="styles/badgers.jpg">
    
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
              <form method="POST" action="DatabaseController?action=update" />
              <h3>Add/Edit Item</h3>
               <p>
                   Item ID: <input type="text" name="id" size="2" /></br>
              Name: <input type="text" name="name" /></br>
              Price: <input type="text" name="price" /></br>
              <input type="submit" value="Submit"/>
              </p>
          </form>
              
              <form method="POST" action="DatabaseController?action=getById" />
              <h3>Get Item by ID</h3>
               <p>
              Item ID: <input type="text" name="id2" size="2" /></br>
              <input type="submit" value="Submit"/>
              </p>
          </form>
              
              
              <form method="POST" action="DatabaseController?action=delete" />
              <h3>Delete Item</h3>
               <p>
              Item ID: <input type="text" name="id3" size="2" /></br>
              <input type="submit" value="Submit"/>
              </p>
          </form>
              
              
              <form method="POST" action="DatabaseController?action=getAll" />
              <h3>Display All Items</h3>
              <input type="submit" value="Submit"/>
              </p>
          </form>
              
              
              
              ${item}
              ${menuList}
          </div><!-- End of tab1 -->

          <!------------------------>
        </div><!-- End of tabs -->
        </div><!-- End of content -->
    </div><!-- End of container -->

      </body>
    </center>
    </html>