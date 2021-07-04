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
public class KhachHangController {

    private static final Logger logger = Logger.getLogger(NhanVienController.class);
    
    @RequestMapping(value = "/khachhang/list")
    public ModelAndView LayDanhSach(){
        logger.info("Hien thi giao dien danh sach khach hang");
        return new ModelAndView("KhachHang/listKhachHang");
    }
    
    @RequestMapping(value = "/khachhang/add")
    public ModelAndView Them_ui(){
        logger.info("Hien thi giao dien them khach hang moi");
        return new ModelAndView("KhachHang/addKhachHang");
    }
    
    @RequestMapping(value = "/khachhang/edit")
    public ModelAndView CapNhat_ui(){
        logger.info("Hien thi giao dien cap nhat khach hang moi");
        return new ModelAndView("KhachHang/editKhachHang");
    }
}
