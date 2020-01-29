package sample;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "testObject")
@XmlRootElement
public class TestObject {

    private List<User> users = new ArrayList<>();
    private int someNumber = 2;
    private String someInformation = "info";

    public TestObject() {
    }

    public TestObject(List<User> users) {
        this.users = users;
    }

    public TestObject(List<User> users, int someNumber, String someInformation) {
        this.users = users;
        this.someNumber = someNumber;
        this.someInformation = someInformation;
    }

    @XmlElementWrapper(name="usersList", nillable = true)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @XmlElement(name = "someNumber")
    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }

    @XmlElement(name = "someInformation")
    public String getSomeInformation() {
        return someInformation;
    }

    public void setSomeInformation(String someInformation) {
        this.someInformation = someInformation;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "users=" + users +
                ", someNumber=" + someNumber +
                ", someInformation='" + someInformation + '\'' +
                '}';
    }
}
