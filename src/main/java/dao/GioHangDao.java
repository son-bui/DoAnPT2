/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.Interface.IGioHang;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import model.GioHang;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author Son_Bui
 */
@Service
@SessionScope
public class GioHangDao implements IGioHang{
    private Map<Integer, GioHang> map = new HashMap<Integer, GioHang>();
    
    public void themGioHang(GioHang gh){
        GioHang temp = map.get(gh.getIdSp());
        
        if(temp != null){
            temp.setSoLuong(gh.getSoLuong() + temp.getSoLuong());
        }else{
            map.put(temp.getIdSp(), temp);
        }
    }
    public void xoaGioHang(int idSp){
        map.remove(idSp);
    }
    public void xoaToanBoGH(){
        map.clear();
    }
    public Collection<GioHang> layDSGioHang(){
        return map.values();
    }
    public void capNhatGH(int idSp, int sl){
        GioHang gh = map.get(idSp);
        gh.setSoLuong(sl + gh.getSoLuong());
        
        if(gh.getSoLuong() <=0){
            map.remove(idSp);
        }
    }
    public double layTongTien(){
       return map.values().stream().mapToDouble(gh -> gh.getSoLuong() * gh.getGia()).sum();
    }
}
