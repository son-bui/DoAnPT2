/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Utils.Session;
import dao.SanPhamDao;
import dao.KhachHangDao;
import java.util.List;
import model.ItemInCart;
import model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Trung
 */
@Controller
public class ShopController {
    @Autowired
    SanPhamDao dao;
    
    @Autowired
    KhachHangDao cusdao;
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){       
        List<SanPham> lst;

            lst = dao.LayDanhSachSanPham();

        ModelAndView mav = new ModelAndView("shopview");       
        mav.addObject("list", lst);
        mav.addObject("totalItem", Utils.Session.CartInfoInSession.getCarts().size());
        return mav;
    }
    
    @RequestMapping(value = "/shop/add",method = RequestMethod.POST)
    public String add(ItemInCart item){
        Session.CartInfoInSession.addItem(item);
        return "redirect:/shop.html";
    }
    
    @RequestMapping(value = "/cart/clear",method = RequestMethod.GET)
    public String clearCart(HttpServletRequest request){
        Session.CartInfoInSession.clearCart();
        return "redirect:/cart.html";
    }
    
    @RequestMapping(value = "/cart/delete",method = RequestMethod.GET)
    public String deleteItem(HttpServletRequest request){
        int prodId = Integer.parseInt(request.getParameter("id"));
        
        Session.CartInfoInSession.deleteItemByProdId(prodId);
        return "redirect:/cart.html";
    }
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart_UI(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("cartview");
        
        mav.addObject("list", Session.CartInfoInSession.getCarts());
        mav.addObject("lstcus", cusdao.LayDanhSachKhachHang());
        mav.addObject("totalprice", Session.CartInfoInSession.getTotalPrice());
        
        return mav;
    }
}
