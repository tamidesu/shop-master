package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.PaymentDTO;
import kz.com.alzhan.temirlan.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public PaymentDTO getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping("/")
    public PaymentDTO processPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.processPayment(paymentDTO);
    }

    @PutMapping("/{paymentId}")
    public PaymentDTO updatePaymentStatus(@PathVariable Long paymentId, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePaymentStatus(paymentId, paymentDTO);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
