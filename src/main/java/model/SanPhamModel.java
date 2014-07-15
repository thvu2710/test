/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vu
 */
public class SanPhamModel {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Sanpham> findAll() {
        try {
            System.out.println("vo day ");
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Sanpham.class).list();
        } catch (Exception e) {
            System.out.println("vo catch ");
            return null;
        }
    }
}
