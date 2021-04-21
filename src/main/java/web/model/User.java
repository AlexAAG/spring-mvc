package web.model;



import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;    //уникальное? // в бд нужно уникальным сделать (поставить галку)

    @Column
    private String password;

    @Column
    private String job;

    @Column
    private int age;

    @Enumerated(value = EnumType.STRING)             //enum хранится
    @Column
    private Role role;                  //import javax.management.relation.Role; ИМПОРТ???!!!!!!!!

    public User() {

    }

    public User(int id, String name, String password, String job, int age, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.job = job;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
