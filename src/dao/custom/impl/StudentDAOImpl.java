package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import javax.persistence.Id;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) throws Exception {
        /*Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;*/
        System.out.println("studentDAOImpl eke method eka ain kara");
        return false;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            System.out.println("StudentDaoImpl update exception error");
            new Alert(Alert.AlertType.ERROR,"System Error").show();
        }
        return false;
    }

    @Override
    public boolean delete(Id id) throws Exception {
        return false;
    }

    @Override
    public List<Student> getAll() throws Exception {
        try {
            Session session= FactoryConfiguration.getInstance().openSession();
            Transaction transaction = session.beginTransaction();

            List<Student> list=null;
            Query program = session.createQuery("from Student");
            list=program.getResultList();
            transaction.commit();
            session.close();
            return list;
        }catch (Exception e){
            System.out.println("StudentDAOImpl getAll");
        }
        return null;
    }
}
