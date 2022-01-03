package dao;

import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance(){
        return (null==daoFactory)? daoFactory=new DaoFactory():daoFactory;
    }

    public  <T extends SuperDao> T getDAO(DAOType doaTye){
        switch (doaTye){
            case  PROGRAMS: return (T) new ProgramDAOImpl();
            case  STUDENT: return (T) new StudentDAOImpl();
            case  REGISTRATION: return (T) new RegistrationDAOImpl();
            default:return null;
        }
    }
}
