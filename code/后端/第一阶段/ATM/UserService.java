package ATM;

public interface UserService {

//    public int getindex(String username);
//    public void checkmoney(int index);
    public void Select(int index);
    public  String savemoney(int index,int money);
    public String takemoney(int index,int money);
    public String movemoney(int srcindex,int dctindex,int money);
}
