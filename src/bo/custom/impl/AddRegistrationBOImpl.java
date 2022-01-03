package bo.custom.impl;

import bo.custom.AddRegistrationBO;
import dto.ProgramDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Programs;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddRegistrationBOImpl implements AddRegistrationBO {

    public SessionFactory  sessionFactory;

    public AddRegistrationBOImpl(){
        this.sessionFactory= FactoryConfiguration.getInstance();
    }
    @Override
    public boolean addRegistration(StudentDTO studentDTO, List<RegistrationDTO> registrationDTOList) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Student student=new Student(
                    studentDTO.getId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getGender()
            );

            List<Registration> registrationsList =new ArrayList<>();

            for (RegistrationDTO registrationDTO:registrationDTOList) {
                registrationsList.add(seeReg(registrationDTO));
            }
            for (Registration reg:registrationsList) {
                student.getRegistrations().add(reg);
            }
            for (Registration regis:registrationsList) {
                regis.setStudent(student);
            }
            for (Registration registration:registrationsList) {
                Serializable addReg = session.save(registration);

                if (addReg==null){
                    session.getTransaction().rollback();
                    return false;
                }
            }
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){

        }
        return false;
    }

    private Registration seeReg(RegistrationDTO registrationDTO) {
        return new Registration(
                registrationDTO.getRegNo(),
                registrationDTO.getDate(),
                registrationDTO.getFee(),
                null,
                seeProgram(registrationDTO.getProgramDTO())
        );
    }

    private Programs seeProgram(ProgramDTO programDTO) {
        return new Programs(
                programDTO.getId(),
                programDTO.getProgram(),
                programDTO.getDuration(),
                programDTO.getFee()
        );
    }
}
