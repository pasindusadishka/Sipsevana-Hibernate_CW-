package bo.custom;

import bo.SupperBO;
import dto.ProgramDTO;

import java.util.List;

public interface ProgramsBO extends SupperBO {
    public boolean add(ProgramDTO programDTO) throws Exception;

    public List<ProgramDTO> findAll() throws Exception;

    public boolean delete(String s) throws Exception;

    public boolean update(ProgramDTO programDTO) throws Exception;

    List<ProgramDTO> getAll() throws Exception;
}
