package com.greenacademy.repository;

import com.greenacademy.entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<BookEntity> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List data = session.createCriteria(BookEntity.class)
                    .list();
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public BookEntity findId(String id) {
        Session session = sessionFactory.openSession();
        try {
            BookEntity data = session
                    .get(BookEntity.class, id);
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<BookEntity> pagination(int page, int size, String keyword) {
        Session session = sessionFactory.openSession();
        try {
            List data = session.createCriteria(BookEntity.class)
                    // Thêm điều kiện
                    .add(Restrictions.like("name", "%" + keyword + "%"))
                    // Sắp xếp
                    .addOrder(Order.desc("id"))
                    // Phân trang
                    .setFirstResult((page - 1) * size) // <=> offset
                    .setMaxResults(size) // <=> limit
                    .list();
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
