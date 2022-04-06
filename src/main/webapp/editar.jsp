<%@page import="com.emergentes.Producto"%>
<%
Producto p=(Producto)request.getAttribute("miProducto"); 


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link   href="css/style.css"   type="text/css" rel="stylesheet"  >
        <title>Edicion</title>
    </head>
    <body id="form">
        <h1>Productos</h1>
        <h1 ><%=(p.getId()==0)?"Nuevo Registro":"Editar Registro"%></h1>
        <div id="registro">
            <form action="ServletControl" method="POST">
                <input  type="hidden" name ="id" value="<%=p.getId()%>">
                <table>
                    <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripcion" value="<%=p.getDescripcion()%>" required></td>
                        
                    </tr>   
                     
                    <tr>
                        <td>Cantidad</td>
                        <td><input type="number" name="cantidad" value="<%=p.getCantidad()%>" required></td>
                        
                    </tr>   
                    <tr>
                        <td>Precio</td>
                        <td><input type="number" name="precio" value="<%=p.getPrecio()%>" step="any" required ></td>
                        
                    </tr>   
                    <tr>
                        <td>Categoria</td>
                        <td><input type="text" name="categoria" value="<%=p.getCategoria()%>" required></td>
                        
                    </tr>   
                    <tr>
                        <td></td>
                          <td><input type="submit" value="Enviar"></td>
                    </tr>
                    
                  
                </table> 
              
            </form>    
                        <a href="index.jsp">Volver</a>
        </div>    
              
    </body>
</html>
