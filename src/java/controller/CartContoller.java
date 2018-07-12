package controller;
 
import cart.CartBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {
  
 //public static final String addToCart
  
 public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  String strAction = request.getParameter("action");
   
   
  if(strAction!=null && !strAction.equals("")) {
   if(strAction.equals("add")) {
    addToCart(request);
   } else if (strAction.equals("Update")) {
    updateCart(request);
   } else if (strAction.equals("Delete")) {
    deleteCart(request);
   }
  }
  response.sendRedirect("Cart_coba.jsp");
 }
  
 protected void deleteCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strItemIndex = request.getParameter("itemIndex");
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
  }
  cartBean.deleteCartItem(strItemIndex);
 }
  
 protected void updateCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strQty = request.getParameter("qty");
  String strItemIndex = request.getParameter("itemIndex");
  
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
  }
  cartBean.updateCartItem(strItemIndex, strQty);
 }
  
 protected void addToCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  int id_produk=request.getIntHeader("id_produk");
  String strKd_produk = request.getParameter("kd_produk");
  String strNm_produk = request.getParameter("nm_produk");
  String strHarga = request.getParameter("harga");
  String strQty = request.getParameter("qty");
   
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
 
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
   session.setAttribute("cart", cartBean);
  }
   
  cartBean.addCartItem(strKd_produk, strNm_produk, strHarga, strQty);
 }
 
}
