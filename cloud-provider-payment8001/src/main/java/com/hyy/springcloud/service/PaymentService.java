package com.hyy.springcloud.service;

import com.hyy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author hyy
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
