package bo.custom;

import bo.SupperBO;
import dto.ProgramDTO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SupperBO {
    boolean add(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> findAll() throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> getAll() throws Exception;
}
