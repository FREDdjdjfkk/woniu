package com.lpc.mapper;

import com.lpc.pojo.Payment;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.xml.ws.soap.Addressing;

public interface PaymentMapper {

    @Insert("insert into payments values(null,#{orderId},#{payment_method},#{amount},#{transaction_id},'pending',now())")
    @Options(useGeneratedKeys = true, keyProperty = "paymentId")
    public void addPayment(Payment payment);

    @Update("update payments set status=#{status} where payment_id=#{paymentId}")
    public void changeStatus(Payment p);

    @Select("select order_id from payments where payment_id=#{payment_id} ")
    public Integer findoid(Integer payment_id);
}
