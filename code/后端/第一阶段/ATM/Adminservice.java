package ATM;

public interface Adminservice {
    boolean addUser(User user);

    void deleteUser(String userName);

    void dongjieUser(String userName);

    void showUser();

}
