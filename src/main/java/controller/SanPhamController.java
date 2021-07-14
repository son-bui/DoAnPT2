/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SanPhamDao;
import java.util.List;
import model.SanPham;
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
public class SanPhamController {

    private static final Logger logger = Logger.getLogger(SanPhamController.class);

    @Autowired
    SanPhamDao dao;

    @RequestMapping(value = "/sanpham/list", method = RequestMethod.GET)
    public ModelAndView LayDanhSach() {
        logger.info("Hien thi giao dien danh sach san pham");
        List<SanPham> lst = dao.LayDanhSachSanPham();
        return new ModelAndView("SanPham/listSanPham", "list", lst);
    }

    @RequestMapping(value = "/sanpham/add")
    public ModelAndView Them_ui() {
        logger.info("Hien thi giao dien them san pham moi");
        return new ModelAndView("SanPham/addSanPham");
    }

    @RequestMapping(value = "/sanpham/create", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String Them(SanPham sp) {
        dao.Them(sp);
        logger.info("Cap nhat san pham");
        return "redirect:/sanpham/list.html";
    }

    @RequestMapping(value = "/sanpham/update", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhat(SanPham sp) {
        dao.CapNhat(sp);
        logger.info("Them san pham moi");

        return "redirect:/sanpham/list.html";
    }

    @RequestMapping(value = "/sanpham/edit")
    public ModelAndView CapNhat_ui(@RequestParam("id") int id) {
        logger.info("Hien thi giao dien cap nhat san pham");
        SanPham sp = dao.TimKiemSanPhamTheoId(id);
        return new ModelAndView("SanPham/editSanPham", "sp", sp);
    }

    @RequestMapping(value = "/sanpham/delete")
    public String Xoa(@RequestParam("id") int id) {
        dao.Xoa(id);
        return "redirect:/sanpham/list.html";

    }
    
    @RequestMapping(value = "/sanpham/search", method = RequestMethod.POST)
    public ModelAndView TimKiem(SanPham sp) {
        logger.info("Hien thi giao dien danh sach san pham");
        List<SanPham> lst = dao.TimKiemSanPham(sp);
        return new ModelAndView("SanPham/listSanPham", "list", lst);
    }
}
