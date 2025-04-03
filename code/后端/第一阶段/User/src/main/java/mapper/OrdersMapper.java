package mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pojo.Orders;

import java.util.List;

public interface OrdersMapper {


     public List<Orders> selectOrders();
     public List<Orders> seOrders();
}
