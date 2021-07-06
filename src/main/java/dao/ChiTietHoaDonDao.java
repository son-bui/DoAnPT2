/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.ChiTietHoaDon;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author Trung
 */
public class ChiTietHoaDonDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public void Them(ChiTietHoaDon cthd) {
        String sql = String.format("insert into chitiethoadon (mahd,masp,soluong) values('%s','%s','%s')", cthd.getMahd(), cthd.getMasp(), cthd.getSoluong());
        template.update(sql);
    }

    public int CapNhat(ChiTietHoaDon cthd) {
        String sql = String.format("update chitiethoadon set soluong='%s' where mahd=%d and masp=%d",cthd.getSoluong(), cthd.getMahd(), cthd.getMasp());
        return template.update(sql);
    }

    public int Xoa(int mahd) {
        String sql = "delete from chitiethoadon where mahd = " + mahd;
        return template.update(sql);
    }

    public ChiTietHoaDon TimKiemChiTietHoaDonTheoMahd(int mahd) {
        String sql = "select * from chitiethoadon where mahd=?";
        return template.queryForObject(sql, new Object[]{mahd}, new BeanPropertyRowMapper<ChiTietHoaDon>(ChiTietHoaDon.class));
    }

    public List<ChiTietHoaDon> LayDanhSachChiTietHoaDon() {
        return template.query("select * from chitiethoadon", new RowMapper<ChiTietHoaDon>() {
            public ChiTietHoaDon mapRow(ResultSet rs, int row) throws SQLException {
                ChiTietHoaDon e = new ChiTietHoaDon();
                e.setMahd(rs.getInt(1));
                e.setMasp(rs.getInt(2));
                e.setSoluong(rs.getInt(3));
                return e;
            }
        });
    }
}
