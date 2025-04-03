package ATM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataUtils implements Serializable {
    private static final long serialVersionUID = 466017810229502897L;
     List<User> users=new ArrayList<>();
    public int getindex(String username) {
        int index=-1;
        for (User i : users) {
            if (i.getUsername().equals(username)) {
                index=users.indexOf(i);
            }
        }
        return index;
    }


}
