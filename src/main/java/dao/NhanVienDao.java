/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.NhanVien;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pmtu
 */
public class NhanVienDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void Them(NhanVien nv) {
        String sql = String.format("insert into nhanvien (hoten,diachi,dienthoai) values('%s','%s','%s')", nv.getHoten(), nv.getDiachi(), nv.getDienthoai());
        template.update(sql);
    }

    public int CapNhat(NhanVien nv) {
        String sql = String.format("update NhanVien set hoten='%s',diachi='%s', dienthoai='%s' where manv=%d",nv.getHoten(),nv.getDiachi(),nv.getDienthoai(),nv.getManv());
        return template.update(sql);
    }

    public int Xoa(int manv) {
        String sql = "delete from nhanvien where manv = " + manv;
        return template.update(sql);
    }

    public NhanVien TimKiemNhanVienTheoManv(int manv) {
        String sql = "select * from NhanVien where manv=?";
        return template.queryForObject(sql, new Object[]{manv}, new BeanPropertyRowMapper<NhanVien>(NhanVien.class));
    }

    public List<NhanVien> LayDanhSachNhanVien() {
        return template.query("select * from NhanVien", new RowMapper<NhanVien>() {
            public NhanVien mapRow(ResultSet rs, int row) throws SQLException {
                NhanVien e = new NhanVien();
                e.setManv(rs.getInt(1));
                e.setHoten(rs.getString(2));
                e.setDiachi(rs.getString(3));
                e.setDienthoai(rs.getString(4));
                return e;
            }
        });
    }

}
