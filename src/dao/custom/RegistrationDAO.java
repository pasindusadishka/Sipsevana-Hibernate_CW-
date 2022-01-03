package dao.custom;

import dao.SuperDao;
import entity.Registration;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    String getRegId() throws Exception;
}
