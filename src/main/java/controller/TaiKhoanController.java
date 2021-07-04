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
public class TaiKhoanController {
    private static final Logger logger = Logger.getLogger(SanPhamController.class);
    
    @RequestMapping(value = "/taikhoan/list")
    public ModelAndView LayDanhSach(){
        logger.info("Hien thi giao dien danh sach tai khoan");
        return new ModelAndView("TaiKhoan/listTaiKhoan");
    }
    
    @RequestMapping(value = "/taikhoan/edit")
    public ModelAndView CapNhat_ui(){
        logger.info("Hien thi giao dien cap nhat tai khoan");
        return new ModelAndView("TaiKhoan/editTaiKhoan");
    }
}
