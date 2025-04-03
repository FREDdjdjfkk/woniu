package com.lpc.Service;

import com.lpc.mapper.PaymentMapper;
import com.lpc.pojo.Payment;
import com.lpc.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.beans.Introspector;

public class PaymentService {
    SqlSession sqlSession= MyBatisUtils.getsqlsession();
    PaymentMapper paymentMapper=sqlSession.getMapper(PaymentMapper.class);

    public int addPayment(Payment p){
          paymentMapper.addPayment(p);
          sqlSession.commit();
          return p.getPaymentId();
    }

    public void changePayment(Payment p){
        paymentMapper.changeStatus(p);
    }
    public Integer fiadOid(Integer pid){
        return paymentMapper.findoid(pid);
    }

}
