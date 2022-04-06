package com.emergentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletControl", urlPatterns = {"/ServletControl"})
public class ServletControl extends HttpServlet {
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   HttpSession ses=request.getSession();    
     if(ses.getAttribute("listapro")==null){
         ArrayList<Producto> listaaux=new ArrayList<Producto>();
         ses.setAttribute("listapro",listaaux);
     }   
    ArrayList<Producto> lista= ( ArrayList<Producto>)ses.getAttribute("listapro");
    int id,pos;
    String op=request.getParameter("op");
    String opcion=(op!=null)?op:"view";
    Producto p=new Producto();
    
    switch(opcion){
        case "nuevo":
            request.setAttribute("miProducto",p);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
           break;
        case "editar":
         id=Integer.parseInt(request.getParameter("id"));
         pos=buscarIndice(request,id);
         p=lista.get(pos);
         request.setAttribute("miProducto",p);
         request.getRequestDispatcher("editar.jsp").forward(request, response);
         break;
        case "eliminar":
          id=Integer.parseInt(request.getParameter("id"));
          pos=buscarIndice(request,id);
          lista.remove(pos);
          ses.setAttribute("listapro", lista);
          response.sendRedirect("index.jsp");
          break;
        case "view": response.sendRedirect("index.jsp");
        break;
    }

    }//metodo doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession ses=request.getSession();
      ArrayList<Producto> lista=(  ArrayList<Producto>)ses.getAttribute("listapro");
      Producto p=new Producto();
      p.setId(Integer.parseInt(request.getParameter("id")));
      p.setDescripcion(request.getParameter("descripcion"));
      p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
      p.setPrecio(Double.parseDouble(request.getParameter("precio")));
      p.setCategoria(request.getParameter("categoria"));
     
        int id=p.getId();
      if(id==0){
     int ultId;
          ultId=UltimoId(request);
          p.setId(ultId);
           lista.add(p);
      }else{
            lista.set(buscarIndice(request,id),p);
      }
       ses.setAttribute("listapro", lista);
       response.sendRedirect("index.jsp");
        
    }

 private int buscarIndice(HttpServletRequest request,int id){
    HttpSession ses=request.getSession();
      ArrayList<Producto> lista=( ArrayList<Producto>) ses.getAttribute("listapro");
       int i=0;
       
        if(lista.size() >0){
            while(i< lista.size()){
                if(lista.get(i).getId() ==id){
                    break;
                }else {
                    i++;
                }
            }
        }
   return i;    
   }
   
   private int UltimoId(HttpServletRequest request){
    HttpSession ses=request.getSession();
      ArrayList<Producto> lista=( ArrayList<Producto>) ses.getAttribute("listapro");    
     
       int idaux=0;
       for(Producto item:lista){
          idaux=item.getId(); 
           
       }
       
   return idaux+1;    
   }
   
   
   
   
   
   
   

}//class
