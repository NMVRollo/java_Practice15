package com.example.Practice15.dao;

import com.example.Practice15.model.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class WorkerDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public void addWorker(Worker worker) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(worker);
        transaction.commit();
    }

    public void removeWorker(Long id) {
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Worker where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    public List<Worker> getWorkers() {
        return session.createQuery("select u from Worker u", Worker.class).getResultList();
    }

}
