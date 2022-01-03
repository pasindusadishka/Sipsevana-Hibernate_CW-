package bo.custom;

import bo.SupperBO;
import dto.ProgramDTO;
import dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SupperBO {
    public boolean add(RegistrationDTO registrationDTO) throws Exception;

    public List<ProgramDTO> findAll() throws Exception;

    public boolean delete(String s) throws Exception;

    public boolean update(RegistrationDTO registrationDTO) throws Exception;

    List<RegistrationDTO> getAll() throws Exception;
}
