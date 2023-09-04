package br.com.vinicius.hrpayroll.services;

import br.com.vinicius.hrpayroll.entities.Payment;
import br.com.vinicius.hrpayroll.entities.Worker;
import br.com.vinicius.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        if (worker != null) {
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        }
        return null;
    }
}
