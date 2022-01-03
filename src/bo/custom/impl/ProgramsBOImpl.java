package bo.custom.impl;

import bo.custom.ProgramsBO;
import dao.DaoFactory;
import dao.DAOType;
import dao.custom.ProgramDAO;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import entity.Programs;

import java.util.ArrayList;
import java.util.List;

public class ProgramsBOImpl implements ProgramsBO {

    ProgramDAOImpl programDAO= DaoFactory.getInstance().getDAO(DAOType.PROGRAMS);
    private ProgramDAO programsDAO;

    @Override
    public boolean add(ProgramDTO programDTO) throws Exception {
        return programDAO.save(new Programs(
                programDTO.getId(),
                programDTO.getProgram(),
                programDTO.getDuration(),
                programDTO.getFee()
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
    public boolean update(ProgramDTO programDTO) throws Exception {
        return programDAO.update(new Programs(
                programDTO.getId(),
                programDTO.getProgram(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public List<ProgramDTO> getAll() throws Exception {
        List<ProgramDTO> programDTOS=new ArrayList();
        List<Programs> programs=programDAO.getAll();
        for (Programs tm:programs) {
            programDTOS.add(makeProgramsDTO(tm));
        }

        return programDTOS;
    }

    private ProgramDTO makeProgramsDTO(Programs tm) {
        return new ProgramDTO(
                tm.getId(),
                tm.getProgram(),
                tm.getDuration(),
                tm.getFee()
        );
    }
}
