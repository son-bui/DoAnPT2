/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.KhachHang;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author Son_Bui
 */
public class KhachHangDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public void Them(KhachHang kh) {
        String sql = String.format("insert into khachhang (tenKh,sdt,diaChi,soDu) values('%s','%s','%s','%s')", kh.getTenKh(), kh.getSdt(), kh.getDiaChi(), kh.getSoDu());
        template.update(sql);
    }

    public int CapNhat(KhachHang kh) {
        String sql = String.format("update khachhang set tenKh='%s',sdt='%s', diaChi='%s', soDu='%s' where id=%d",kh.getTenKh(), kh.getSdt(), kh.getDiaChi(), kh.getSoDu(),kh.getId());
        return template.update(sql);
    }

    public int Xoa(int id) {
        String sql = "delete from khachhang where id = " + id;
        return template.update(sql);
    }

    public KhachHang TimKiemKhachHangId(int id) {
        String sql = "select * from khachhang where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<KhachHang>(KhachHang.class));
    }

    public List<KhachHang> LayDanhSachKhachHang() {
        return template.query("select * from khachhang", new RowMapper<KhachHang>() {
            public KhachHang mapRow(ResultSet rs, int row) throws SQLException {
                KhachHang e = new KhachHang();
                e.setId(rs.getInt(1));
                e.setTenKh(rs.getString(2));
                e.setSdt(rs.getString(3));
                e.setDiaChi(rs.getString(4));
                e.setSoDu(rs.getFloat(4));            
                return e;
            }
        });
    }
}
