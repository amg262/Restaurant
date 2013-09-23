<%-- 
    Document   : index
    Created on : Sep 11, 2013, 7:48:45 PM
    Author     : agunn1
--%>

<%@page import="model.Menu"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
             <!--   <option value="steak">36 oz. Porter House</option>
                <br/>
                <option value="burger">4 lb. Steak Burger</option>
                <br/>
                <option value="chicken">2 lb. Chicken Breast</option>
                <br/>
                <option value="salad">Salad</option>
                <br/> -->
                
        <%
        
            List<Menu> entree = (List<Menu>) request.getAttribute("entreeItems");
            
            for (Menu e : entree){
                int i = 0;
                out.println("<br />");
                out.println("<option value='entree" + i + "'>" + e.getName() +  "    "  + e.getDesc() + "\t$" + e.getPrice() + "</option>" );
                out.println("<br />");
                i++;
            }

        %>
            </select>
            
            
            
              <p>Side:</p>
              <select id="side" name="side" size="1" />
              <br/>
                <!-- <option value="fries">Fries</option>
                <br/>
                <option value="potato">Baked Potato</option>
                <br/>
                <option value="salad">Salad</option>
                <br/>
                <option value="soup">Soup</option>
                <br/> -->
               
        <%
            
            List<Menu> side = (List<Menu>) request.getAttribute("sideItems");
            
            for (Menu s : side){
                int i=0;
                out.println("<br />");
                out.println("<option value='side" + i + "'>" + s.getName() +  "    "  + s.getDesc() + "\t$" + s.getPrice() + "</option>" );
                out.println("<br />");
                i++;
            }
    
        %>
            </select>
            
            
            
              <p>Drink</p>
              <select id="drink" name="drink" size="1" />
              <br/>
              <!--  <option value="high life">Miller High Life</option>
                <br/>
                <option value="miller lite">Miller Lite</option>
                <br/>
                <option value="blue moon">Blue Moon</option>
                <br/>
                <option value="soda">Soda</option>
                <br/> -->
         <%
       
            List<Menu> drink = (List<Menu>) request.getAttribute("drinkItems");

            for (Menu d : drink){
                int i=0;
                out.println("<br />");
                out.println("<option value='drink" + i + "'>" + d.getName() +  "    "  + d.getDesc() + "\t$" + d.getPrice() + "</option>" );
                out.println("<br />");
                i++;
            }
    
        %>       
            </select>
            
            
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