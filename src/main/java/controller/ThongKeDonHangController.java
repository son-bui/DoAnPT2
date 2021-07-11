/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ThongKeDonHangDao;
import java.util.List;
import model.ThongKeDonHang;
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
public class ThongKeDonHangController {

    private static final Logger logger = Logger.getLogger(ThongKeDonHangController.class);
    @Autowired
    ThongKeDonHangDao dao;

    @RequestMapping(value = "/thongkedonhang", method = RequestMethod.GET)
    public ModelAndView LayDanhSach() {
        logger.info("Hien thi giao dien danh sach san pham");
        List<ThongKeDonHang> lst = dao.LayDanhSachHoaDon();
        return new ModelAndView("ThongKe/ThongKeDonHang", "list", lst);
    }

}
