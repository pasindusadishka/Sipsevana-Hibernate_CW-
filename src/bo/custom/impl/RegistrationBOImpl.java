package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOType;
import dao.DaoFactory;
import dao.custom.impl.RegistrationDAOImpl;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    RegistrationDAOImpl registrationDAO= DaoFactory.getInstance().getDAO(DAOType.REGISTRATION);

    @Override
    public boolean add(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.save(new Registration(
                registrationDTO.getRegNo(),
                registrationDTO.getDate(),
                registrationDTO.getFee()
        ));
    }

    @Override
    public List<ProgramDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws Exception {
        return false;
    }

    @Override
    public List<RegistrationDTO> getAll() throws Exception {
        List<RegistrationDTO> registrationDTOS=new ArrayList<>();
        List<Registration> registrations=registrationDAO.getAll();
        for (Registration tm:registrations) {
            registrationDTOS.add(makeRegistrationDTO(tm));
        }
        return registrationDTOS;
    }

    private RegistrationDTO makeRegistrationDTO(Registration tm) {
        return new RegistrationDTO(
                tm.getRegNo(),
                tm.getDate(),
                tm.getFee(),
                tm.getStudent(),
                tm.getPrograms()
        );
    }
}
