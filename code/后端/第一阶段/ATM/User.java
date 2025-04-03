package ATM;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 3843482946277826551L;
    private String Username;
    private String password;
    private int moeny=0;
    private int state=1;//1是正常，0是冻结
    private int role=1;//1是用户，0是管理员；

    public User(String username, String password, int moeny, int state, int role) {
        Username = username;
        this.password = password;
        this.moeny = moeny;
        this.state = state;
        this.role = role;
    }

    public User(String username, String password) {
        Username = username;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public int getMoeny() {
        return moeny;
    }

    public int getState() {
        return state;
    }

    public int getRole() {
        return role;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoeny(int moeny) {
        this.moeny = moeny;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", moeny=" + moeny +
                '}';
    }


    public String show() {
        return
                "Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                ", moeny=" + moeny +
                ", state=" + state +
                ", role=" + role ;
    }
}
