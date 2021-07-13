/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KhachHangDao;
import java.util.List;
import model.KhachHang;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Son_Bui
 */
@Controller
public class KhachHangController {

    private static final Logger logger = Logger.getLogger(KhachHangController.class);

    @Autowired
    KhachHangDao dao;

    @RequestMapping(value = "/khachhang/list", method = RequestMethod.GET)
    public ModelAndView LayDanhSach() {
        logger.info("Hien thi giao dien danh sach khach hang");
        List<KhachHang> lst = dao.LayDanhSachKhachHang();
        return new ModelAndView("KhachHang/listKhachHang", "list", lst);
    }

    @RequestMapping(value = "/khachhang/add")
    public ModelAndView Them_ui() {
        logger.info("Hien thi giao dien them khach hang moi");
        return new ModelAndView("KhachHang/addKhachHang");
    }

    @RequestMapping(value = "/khachhang/create", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String Them(KhachHang kh) {
        logger.info("Them khach hang moi");
        dao.Them(kh);
        return "redirect:/khachhang/list.html";
    }

    @RequestMapping(value = "/khachhang/update", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhat(KhachHang kh) {
        dao.CapNhat(kh);
        logger.info("Cap nhat khach hang");
        return "redirect:/khachhang/list.html";
    }

    @RequestMapping(value = "/khachhang/edit")
    public ModelAndView CapNhat_ui(@RequestParam("id") int id) {
        logger.info("Hien thi giao dien cap nhat khach hang moi");
        KhachHang kh = dao.TimKiemKhachHangId(id);
        return new ModelAndView("KhachHang/editKhachHang", "kh", kh);
    }

    @RequestMapping(value = "/khachhang/delete")
    public String Xoa(@RequestParam("id") int id) {
        dao.Xoa(id);
        return "redirect:/khachhang/list.html";

    }

    @RequestMapping(value = "/khachhang/search", method = RequestMethod.POST)
    public ModelAndView TimKiem(String tenKH) {
        logger.info("Hien thi giao dien danh sach khach hang");
        List<KhachHang> lst = dao.TimKiemDanhSachKhachHang();
        return new ModelAndView("KhachHang/listKhachHang", "list", lst);
    }
}
