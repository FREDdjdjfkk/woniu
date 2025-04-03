import mapper.OrdersMapper;
import mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Orders;
import pojo.Product;
import utils.MyBatisUtils;
import java.io.InputStream;
import java.util.List;

public class tset {

    public static void main(String[] args) {

        SqlSession sqlSession = MyBatisUtils.getsqlsession();
        TUserMapper tUserMapper = sqlSession.getMapper(TUserMapper.class);
//        System.out.println(tUserMapper.getdetails(Integer.valueOf(1)));
//        System.out.println(tUserMapper.findbyid(Integer.valueOf(2)));
        System.out.println(tUserMapper.selectusers("杜子腾"));
//        System.out.println(tUserMapper.getUserWithProducts(Integer.valueOf(1)));
//        sqlSession=MyBatisUtils.getsqlsession();
//        OrdersMapper ordersMapper=sqlSession.getMapper(OrdersMapper.class);
//        List<Orders> orders=ordersMapper.selectOrders();
//        for (Orders o:orders
//             ) {
//            System.out.println(o);
//        }
    }
}

