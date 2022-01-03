package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Programs;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import javax.persistence.Id;
import java.util.List;
import java.util.Queue;

public class ProgramDAOImpl implements ProgramDAO {
    private SessionFactory sessionFactory;
    @Override
    public boolean save(Programs entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Programs entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            System.out.println("ProgramDAOImpl update exception error");
            new Alert(Alert.AlertType.ERROR,"System Error").show();
        }
        return false;
    }

    @Override
    public boolean delete(Id id) throws Exception {
        return false;
    }

    @Override
    public List<Programs> getAll() throws Exception {
        try {
            Session session= FactoryConfiguration.getInstance().openSession();
            Transaction transaction = session.beginTransaction();

            List<Programs> list=null;
            Query program = session.createQuery("from Programs");
            list=program.getResultList();
            transaction.commit();
            session.close();
            return list;
        }catch (Exception e){
            System.out.println("ProgramDAOImpl getAll");
        }
        return null;
    }
}
