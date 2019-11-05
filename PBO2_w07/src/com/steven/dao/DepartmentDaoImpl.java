package com.steven.dao;

import com.steven.entity.ProgramStudi;
import com.steven.util.DaoService;
import com.steven.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DaoService<ProgramStudi> {

    @Override
    public List<ProgramStudi> showAll() {
        List<ProgramStudi> departments = new ArrayList<>();
        Session session = HibernateUtil.getSession();

//        Hibernate 5 (Criteria Query API)
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProgramStudi> query = builder.createQuery(ProgramStudi.class);
        Root<ProgramStudi> root = query.from(ProgramStudi.class);
        query.select(root);
        Query<ProgramStudi> q = session.createQuery(query);
        departments.addAll(q.list());
        //        Hibernate 3 (Criteria  API)
//        Criteria criteria = session.createCriteria(ProgramStudi.class);
//        departments.addAll(criteria.list());
        return departments;
    }

    @Override
    public int addData(ProgramStudi object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.clear();
        return result;
    }

    @Override
    public int updateData(ProgramStudi object) {
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
    public int deleteData(ProgramStudi object) {
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
