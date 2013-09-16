<%-- 
    Document   : index
    Created on : Sep 11, 2013, 7:48:45 PM
    Author     : agunn1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <script src="jQuery.js"></script>
        <script src="script.js"></script>
        <title>Order</title>
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
              
              <form id="form1" name="form1" method="POST" onsubmit="" action="OrderController" />
              <p>Entree:</p>
            <select id="entree" name="entree" size="1" />
            <br/>
                <option value="steak">36 oz. Porter House</option>
                <br/>
                <option value="burger">4 lb. Steak Burger</option>
                <br/>
                <option value="chicken">2 lb. Chicken Breast</option>
                <br/>
                <option value="salad">Salad</option>
                <br/>
            </select>
              <p>Side:</p>
              <select id="side" name="side" size="1" />
              <br/>
                <option value="fries">Fries</option>
                <br/>
                <option value="potato">Baked Potato</option>
                <br/>
                <option value="salad">Salad</option>
                <br/>
                <option value="soup">Soup</option>
                <br/>
            </select>
              <p>Drink</p>
              <select id="drink" name="drink" size="1" />
              <br/>
                <option value="high life">Miller High Life</option>
                <br/>
                <option value="miller lite">Miller Lite</option>
                <br/>
                <option value="blue moon">Blue Moon</option>
                <br/>
                <option value="soda">Soda</option>
                <br/>
            </select>
              <br/>
              <br/>
              <input type="submit" name="submit" id="submit" value="Place Order"/>
              </form>
              
          </div><!-- End of tab1 -->

          <!------------------------>
        </div><!-- End of tabs -->
            </div><!-- End of content -->
    </div><!-- End of container -->

      </body>
    </html>