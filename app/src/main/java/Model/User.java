package Model;

public class User {
    private int id,age,weight;
    private String username ,firstname,lastname;
    private String password , gender;

    public User(){}
    public User(String username, String firstname, String lastname, int age, String gender,String password,int weight) {
        this.id = id;
        this.age = age;
        this.weight=weight;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
    }
    public User(int id, String username, String firstname, String lastname, int age, String gender,String password,int weight) {
        this.id = id;
        this.age = age;
        this.weight=weight;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
