/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Son_Bui
 */
@Controller
public class SanPhamController {

    private static final Logger logger = Logger.getLogger(SanPhamController.class);
    
    @RequestMapping(value = "/sanpham/list")
    public ModelAndView LayDanhSach(){
        logger.info("Hien thi giao dien danh sach san pham");
        return new ModelAndView("SanPham/listSanPham");
    }
    
    @RequestMapping(value = "/sanpham/add")
    public ModelAndView Them_ui(){
        logger.info("Hien thi giao dien them san pham moi");
        return new ModelAndView("SanPham/addSanPham");
    }
    
    @RequestMapping(value = "/sanpham/edit")
    public ModelAndView CapNhat_ui(){
        logger.info("Hien thi giao dien cap nhat san pham");
        return new ModelAndView("SanPham/editSanPham");
    }
}

