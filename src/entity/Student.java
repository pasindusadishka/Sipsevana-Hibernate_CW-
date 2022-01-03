package entity;

import dto.StudentDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends StudentDTO implements SuperEntity{
    @Id
    private String id;
    private String name;
    private String address;
    private int contact;
    private String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Registration> registrations=new ArrayList ();

    public Student() {
    }

    public Student(String id, String name, String address, int contact, String gender, List<Registration> registrations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.setRegistrations(registrations);
    }

    public Student(String id, String name, String address, int contact, String gender) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setContact(contact);
        this.setGender(gender);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", gender='" + gender + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
