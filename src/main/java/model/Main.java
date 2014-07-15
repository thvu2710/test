/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Danhmuc;
import java.util.List;

/**
 *
 * @author Vu
 */
public class Main {
    
    public static void main(String arg[]){
        DanhMucModel d = new DanhMucModel();
        SanPhamModel s = new SanPhamModel();
        System.err.println("find all ne "+s.findAll());
    }
    
}
