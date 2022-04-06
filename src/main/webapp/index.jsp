<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Producto"%>
<%
    ArrayList<Producto> lista=( ArrayList<Producto>)session.getAttribute("listapro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link  href="css/style.css" type="text/css" rel="stylesheet">
    
        <title>JSP Page</title>
    </head>
         <body>
        <div id="cabecera">
        <h3>PRIMER PARCIAL TEM-742</h3>
        <h3>Nombre:Cecilio Poma Muñoz</h3>
        <h3>Carnet:7339585</h3>
        </div>
         
        <h1>Productos</h1>
      
        <div id="table">
              <a href="ServletControl?op=nuevo">Nuevo Producto</a>
        <table border="1">
            <th>Id</th> 
            <th>Descripcion</th> 
            <th>Cantidad</th> 
            <th>Precio</th> 
            <th>Categoria</th> 
            <th>Editar</th> 
            <th>Eliminar</th> 
            
           <%  if(lista!=null){
               for(Producto p:lista){
       %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getDescripcion()%></td>
                <td><%=p.getCantidad()%></td>
                <td><%=p.getPrecio()%></td>
                <td><%=p.getCategoria()%></td>
              <td><a href="ServletControl?op=editar&id=<%=p.getId()%>">Editar</a></td>
              <td><a href="ServletControl?op=eliminar&id=<%=p.getId()%>">Eliminar</a></td>
         </tr>  
            
            <%
                }
              }
            %>
            
        </table>
        
        </div>
        
        
    </body>
</html>
