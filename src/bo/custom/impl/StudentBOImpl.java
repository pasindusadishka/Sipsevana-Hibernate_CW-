package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOType;
import dao.DaoFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Programs;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAOImpl studentDAO= DaoFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getGender()
        ));
    }

    @Override
    public List<StudentDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getGender()
        ));
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<StudentDTO> studentDTOS=new ArrayList();
        List<Student> programs=studentDAO.getAll();
        for (Student tm:programs) {
            studentDTOS.add(makeStudentDTO(tm));
        }

        return studentDTOS;
    }

    private StudentDTO makeStudentDTO(Student tm) {
        return new StudentDTO(
                tm.getId(),
                tm.getName(),
                tm.getAddress(),
                tm.getContact(),
                tm.getGender()
        );
    }
}
