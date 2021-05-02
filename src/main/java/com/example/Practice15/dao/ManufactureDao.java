package com.example.Practice15.dao;

import com.example.Practice15.model.Manufacture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ManufactureDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public void addManufacture(Manufacture manufacture) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(manufacture);
        transaction.commit();
    }

    public void removeManufacture(Long id) {
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Manufacture where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    public List<Manufacture> getManufactures() {
        return session.createQuery("select u from Manufacture u", Manufacture.class).getResultList();
    }

}
