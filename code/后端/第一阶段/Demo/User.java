package Demo;

import java.util.Objects;

public class User {

    public User() {
    }

    public User(String name, String idnumber, int age) {
        this.name = name;
        this.idnumber = idnumber;
        this.age = age;
    }

    private String name;
    private String idnumber;
    private int age;

    public String getName() {
        return name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(idnumber, user.idnumber);
    }


}

