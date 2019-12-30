package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    public static final String PaymentSrv_URL = "http://cloud";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(Payment payment)
    {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id)
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/get/"+id, CommonResult.class, id);
    }
    @GetMapping("/consumer/payment/delete/{id}")
    public CommonResult delete(@PathVariable  Long id){
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/delete/"+id, CommonResult.class, id);

    }
    @PostMapping(value="/consumer/payment/update")
    public CommonResult update(@RequestBody Payment payment){
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",payment,CommonResult.class);

    }
}