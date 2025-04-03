package ATM;



public class Userserverceimpl implements UserService {

    private DataUtils data;

    // 通过构造方法传递 DataUtils 对象
    public Userserverceimpl(DataUtils data) {
        this.data = data;
    }


    @Override
    public void Select(int index) {

        System.out.println("尊敬的"+data.users.get(index).getUsername()+"你的账户余额为"+data.users.get(index).getMoeny()+"元");


    }

    @Override
    public  String savemoney(int index,int money){
        if (data.users.get(index).getState()==1) {
            int total=data.users.get(index).getMoeny();
            data.users.get(index).setMoeny((total+money));
            return "存款成功！剩余金额"+data.users.get(index).getMoeny()+"元";
        }else {
            return "账户被冻结";
        }
    }

    @Override
    public String takemoney(int index,int money) {
        if (data.users.get(index).getState()==1) {
            int total=data.users.get(index).getMoeny();

            if (total>money) {
                data.users.get(index).setMoeny((total-money));
                return "取款成功！剩余金额"+data.users.get(index).getMoeny()+"元";
            }else {
                System.out.println("余额不足！");
                return null;
            }
        }else {
            return "账户被冻结";
        }

    }

    @Override
    public String movemoney(int srcindex, int dctindex, int money) {
        int total=data.users.get(srcindex).getMoeny();
        if (data.users.get(srcindex).getState()==1) {
            if (total>money) {

                if (dctindex<data.users.size()) {
                    data.users.get(srcindex).setMoeny((total-money));
                    data.users.get(dctindex).setMoeny((total+money));
                }else {
                    return "没有目标用户";
                }

                return "成功转账:"+money+"元，剩余金额"+data.users.get(srcindex).getMoeny()+"元";
            }else {
                System.out.println("余额不足！");
                return "转账失败";
            }
        }else {
            return "用户被冻结";
        }
    }


}
