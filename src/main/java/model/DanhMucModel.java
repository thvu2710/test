/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.SessionFactory;
import entity.*;

/**
 *
 * @author Vu
 */
public class DanhMucModel {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Danhmuc> findAll() {
        try {
            System.out.println("vo day ");
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Danhmuc.class).list();
        } catch (Exception e) {
            System.out.println("vo catch ");
            return null;
        }
    }
    public boolean insert(){
        try {
            
        } catch (Exception e) {
        }
        return false;
    }

}
