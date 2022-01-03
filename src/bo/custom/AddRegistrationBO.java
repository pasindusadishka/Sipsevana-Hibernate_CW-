package bo.custom;

import bo.SupperBO;
import dto.RegistrationDTO;
import dto.StudentDTO;

import java.util.List;

public interface AddRegistrationBO extends SupperBO {
    boolean addRegistration(StudentDTO studentDTO , List<RegistrationDTO> registrationDTOList) throws Exception;
}
