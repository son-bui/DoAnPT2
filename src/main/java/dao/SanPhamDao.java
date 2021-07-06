/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.SanPham;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author Son_Bui
 */
public class SanPhamDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public void Them(SanPham sp) {
        String sql = String.format("insert into sanpham (tensp,quycach,gia) values('%s','%s','%s')", sp.getTensp(), sp.getQuycach(), sp.getGia());
        template.update(sql);
    }

    public int CapNhat(SanPham sp) {
        String sql = String.format("update sanpham set tensp='%s',quycach='%s', gia='%s' where id=%d",sp.getTensp(), sp.getQuycach(), sp.getGia(),sp.getId());
        return template.update(sql);
    }

    public int Xoa(int id) {
        String sql = "delete from sanpham where id = " + id;
        return template.update(sql);
    }

    public SanPham TimKiemSanPhamTheoId(int id) {
        String sql = "select * from sanpham where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<SanPham>(SanPham.class));
    }

    public List<SanPham> LayDanhSachSanPham() {
        return template.query("select * from SanPham", new RowMapper<SanPham>() {
            public SanPham mapRow(ResultSet rs, int row) throws SQLException {
                SanPham e = new SanPham();
                e.setId(rs.getInt(1));
                e.setTensp(rs.getString(2));
                e.setQuycach(rs.getString(3));
                e.setGia(rs.getFloat(4));
                return e;
            }
        });
    }
}
