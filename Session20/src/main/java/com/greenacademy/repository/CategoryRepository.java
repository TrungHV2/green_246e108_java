package com.greenacademy.repository;

import com.greenacademy.entity.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

//    public CategoryRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    //    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public List<CategoryEntity> findAll() {
        List<CategoryEntity> data = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            data = session
                    .createQuery("from CategoryEntity")
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public CategoryEntity findId(int id) {
        try (Session session = sessionFactory.openSession()) {
            CategoryEntity category = (CategoryEntity)session
                    .createQuery("from CategoryEntity where id = ?")
                    .setParameter(0, id)
                    .uniqueResult();
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public CategoryEntity save(CategoryEntity category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            int id = (Integer) session.save(category);
            category.setId(id);
            tx.commit();
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return null;
    }

    public CategoryEntity edit(CategoryEntity category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(category);
            tx.commit();
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return null;
    }

    public boolean delete(CategoryEntity category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.delete(category);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return false;
    }
}
