package bo;

import bo.custom.impl.AddRegistrationBOImpl;
import bo.custom.impl.ProgramsBOImpl;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null==boFactory)? boFactory=new BOFactory() : boFactory;
    }

    public <T extends SupperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT: return (T) new StudentBOImpl();

            case PROGRAMS:return (T) new ProgramsBOImpl();

            case REGISTRATION:return (T) new RegistrationBOImpl();

            case ADDREGISTRATION:return (T) new AddRegistrationBOImpl();

            default: return null;
        }
    }
}
