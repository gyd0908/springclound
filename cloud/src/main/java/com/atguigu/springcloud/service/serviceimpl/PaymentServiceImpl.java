package com.atguigu.springcloud.service.serviceimpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public void create(Payment payment) {

        paymentDao.create(payment);
    }

    @Override
    public Payment delete(Long id) {
        return paymentDao.delete(id);
    }


    @Override
    public void update(Payment payment) {
    paymentDao.update(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> list() {
        return null;
    }
}
