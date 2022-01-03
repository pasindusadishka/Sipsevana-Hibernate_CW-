package dao.custom.impl;

import dao.custom.RegistrationDAO;
import entity.Programs;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import javax.persistence.Id;
import java.util.List;
import java.util.Queue;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration entity) throws Exception {
        Session session=FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Id id) throws Exception {
        return false;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().openSession();
            Transaction transaction = session.beginTransaction();

            List<Registration> list=null;
            Query registrationDetails= session.createQuery("from Registration ");
            list=registrationDetails.getResultList();
            transaction.commit();
            session.close();
            return list;
        }catch (Exception e){
            System.out.println("registrationDAOImpl getAll");
        }
        return null;
    }

    @Override
    public String getRegId() throws Exception {
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        List<Registration> list=null;
        Query registration = session.createQuery("from Registration order by regNo DESC ");
        list=registration.getResultList();
        System.out.println(list);
        transaction.commit();
        session.close();
        return "none";
    }
}
