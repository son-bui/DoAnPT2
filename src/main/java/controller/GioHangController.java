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
import model.SanPhamGh;
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
public class GioHangController {
    @Autowired
    SanPhamDao dao;
    
    @Autowired
    KhachHangDao cusdao;
    @RequestMapping(value = "/muahang", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){       
        List<SanPham> lst;

            lst = dao.LayDanhSachSanPham();

        ModelAndView mav = new ModelAndView("muahangview");       
        mav.addObject("list", lst);
        mav.addObject("totalItem", Utils.Session.SanPhamGHSession.getCarts().size());
        return mav;
    }
    
    @RequestMapping(value = "/muahang/add",method = RequestMethod.POST)
    public String add(SanPhamGh item){
        Session.SanPhamGHSession.addItem(item);
        return "redirect:/muahang.html";
    }
    
    @RequestMapping(value = "/giohang/clear",method = RequestMethod.GET)
    public String clearCart(HttpServletRequest request){
        Session.SanPhamGHSession.clearCart();
        return "redirect:/giohang.html";
    }
    
    @RequestMapping(value = "/giohang/delete",method = RequestMethod.GET)
    public String deleteItem(HttpServletRequest request){
        int prodId = Integer.parseInt(request.getParameter("id"));
        
        Session.SanPhamGHSession.deleteItemByProdId(prodId);
        return "redirect:/giohang.html";
    }
    
    @RequestMapping(value = "/giohang", method = RequestMethod.GET)
    public ModelAndView cart_UI(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("giohangview");
        
        mav.addObject("list", Session.SanPhamGHSession.getCarts());
        mav.addObject("lstcus", cusdao.LayDanhSachKhachHang());
        mav.addObject("totalprice", Session.SanPhamGHSession.getTotalPrice());
        
        return mav;
    }
}
