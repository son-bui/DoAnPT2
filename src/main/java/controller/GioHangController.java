/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utils.Session;
import dao.HoaDonDao;
import dao.SanPhamDao;
import dao.KhachHangDao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.SanPhamGh;
import model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import model.HoaDon;
import model.KhachHang;

/**
 *
 * @author Trung
 */
@Controller
public class GioHangController {

    @Autowired
    SanPhamDao dao;

    @Autowired
    HoaDonDao hoaDonDao;

    @Autowired
    KhachHangDao cusdao;

    @RequestMapping(value = "/muahang", method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request) {
        List<SanPham> lst;

        lst = dao.LayDanhSachSanPham();

        ModelAndView mav = new ModelAndView("muahangview");
        mav.addObject("list", lst);
        mav.addObject("totalItem", Utils.Session.SanPhamGHSession.getCarts().size());
        return mav;
    }

    @RequestMapping(value = "/muahang/add", method = RequestMethod.POST)
    public String add(SanPhamGh item) {
        Session.SanPhamGHSession.addItem(item);
        return "redirect:/muahang.html";
    }

    @RequestMapping(value = "/giohang/clear", method = RequestMethod.GET)
    public String clearCart(HttpServletRequest request) {
        Session.SanPhamGHSession.clearCart();
        return "redirect:/giohang.html";
    }

    @RequestMapping(value = "/giohang/delete", method = RequestMethod.GET)
    public String deleteItem(HttpServletRequest request) {
        int prodId = Integer.parseInt(request.getParameter("id"));

        Session.SanPhamGHSession.deleteItemByProdId(prodId);
        return "redirect:/giohang.html";
    }

    @RequestMapping(value = "/giohang", method = RequestMethod.GET)
    public ModelAndView cart_UI(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("giohangview");

        mav.addObject("list", Session.SanPhamGHSession.getCarts());
        mav.addObject("lstcus", cusdao.LayDanhSachKhachHang());
        mav.addObject("totalprice", Session.SanPhamGHSession.getTotalPrice());

        return mav;
    }

    @RequestMapping(value = "/thanhtoan")
    public String ThanhToan(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        float tongtien = Session.SanPhamGHSession.getTotalPrice();
        KhachHang kh = cusdao.TimKiemKhachHangId(id);
        float sodu = tongtien - kh.getSoDu();
        cusdao.ThanhToan(id, sodu);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        String date = String.valueOf(dtf.format(localDate));
        
        HoaDon hd = new HoaDon();
        hd.setMaKh(id);
        hd.setNgayLap(date);
        hd.setTongTien(tongtien);
        hoaDonDao.Them(hd);

        return "redirect:/khachhang/list.html";
    }
}
