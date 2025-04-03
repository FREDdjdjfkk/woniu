package ATM;

import java.util.Iterator;

public class Adminserviceimpl implements Adminservice {
    private DataUtils data;

    public Adminserviceimpl(DataUtils data) {
        this.data = data;
    }

    @Override
    public boolean addUser(User user) {

        return  data.users.add(user);
    }


    @Override
    public void deleteUser(String userName) {

        Iterator<User> iterator= data.users.iterator();
        while (iterator.hasNext()){
            User user=iterator.next();
            if (user.getUsername().equals(userName)){
                data.users.remove(user);
                System.out.println("成功删除用户"+userName);
            }
        }


    }
    @Override
    public void dongjieUser(String userName) {
        for (User i: data.users
        ) {
            if (i.getUsername().equals(userName)){
                i.setState(0);
                System.out.println("成功冻结用户"+userName);
            }
        }
    }

    @Override
    public void showUser() {
        for (User i: data.users
        ) {
            System.out.println(i.show());
            }
        }

}
