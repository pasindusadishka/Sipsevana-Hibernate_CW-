package dto;

public class StudentDTO {
    private String id;
    private String name;
    private String address;
    private int contact;
    private String gender;

    public StudentDTO(String id, String name, String address, int contact, String gender) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setContact(contact);
        this.setGender(gender);
    }

    public StudentDTO() {
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", gender='" + gender + '\'' +
                '}';
    }
}
