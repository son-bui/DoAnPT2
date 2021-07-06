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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Trung
 */
public class HoaDonDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public void Them(HoaDon hd) {
        String sql = String.format("insert into hoadon (maKh,ngayLap,tongTien) values('%s','%s','%s')", hd.getMaKh(), hd.getNgaylap(), hd.getTongtien());
        template.update(sql);
    }

    public int CapNhat(HoaDon hd) {
        String sql = String.format("update hoadon set maKh='%s',ngayLap='%s', tongTien='%s' where id=%d",hd.getMaKh(), hd.getNgaylap(), hd.getTongtien(),hd.getId());
        return template.update(sql);
    }

    public int Xoa(int id) {
        String sql = "delete from hoadon where id = " + id;
        return template.update(sql);
    }

    public HoaDon TimKiemSanPhamTheoId(int id) {
        String sql = "select * from hoadon where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<HoaDon>(HoaDon.class));
    }

    public List<HoaDon> LayDanhSachSanPham() {
        return template.query("select * from hoadon", new RowMapper<HoaDon>() {
            public HoaDon mapRow(ResultSet rs, int row) throws SQLException {
                HoaDon e = new HoaDon();
                e.setId(rs.getInt(1));
                e.setMaKh(rs.getInt(2));
                e.setNgaylap(rs.getString(3));
                e.setTongtien(rs.getFloat(4));
                return e;
            }
        });
    }
}
