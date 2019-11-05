package com.steven.dao;

import com.steven.entity.Mahasiswa;
import com.steven.util.DaoService;
import com.steven.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaDaoImpl implements DaoService<Mahasiswa> {
    @Override
    public List<Mahasiswa> showAll() {
        List<Mahasiswa> students = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Mahasiswa.class);
        students.addAll(criteria.list());
        return students;
    }

    @Override
    public int addData(Mahasiswa object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        session.clear();
        return result;
    }

    @Override
    public int updateData(Mahasiswa object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.clear();
        return result;
    }

    @Override
    public int deleteData(Mahasiswa object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.clear();
        return result;
    }
}
