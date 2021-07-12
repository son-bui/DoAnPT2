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
 * @author Trung
 */
@Controller
public class MuaHangController {
    private static final Logger logger = Logger.getLogger(MuaHangController.class);

    @Autowired
    SanPhamDao dao;
    @RequestMapping(value = "/muahang/list", method = RequestMethod.GET)
    public ModelAndView LayDanhSach() {
        logger.info("Hien thi giao dien danh sach san pham khi mua hang");
        List<SanPham> lst = dao.LayDanhSachSanPham();
        return new ModelAndView("MuaHang/listMuaHang", "list", lst);
    }
}
