/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.HoaDon;
import model.ThongKeDonHang;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Son_Bui
 */
public class ThongKeDonHangDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<ThongKeDonHang> LayDanhSachHoaDon() {
        return template.query(
                "select hd.id, kh.tenKh, hd.ngayLap, sum(hd.tongTien) AS tongTien "
                + "FROM khachhang AS kh JOIN hoadon AS hd ON kh.id=hd.maKh "
                + "group by kh.tenKh, hd.ngayLap", new RowMapper<ThongKeDonHang>() {
            public ThongKeDonHang mapRow(ResultSet rs, int row) throws SQLException {
                ThongKeDonHang e = new ThongKeDonHang();
                e.setId(rs.getInt(1));
                e.setTenKh(rs.getString(2));
                e.setNgayLap(rs.getString(3));
                e.setTongTien(rs.getFloat(4));
                return e;
            }
        });
    }
}
