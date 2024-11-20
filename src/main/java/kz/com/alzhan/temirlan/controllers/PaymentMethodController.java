package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.PaymentMethodDTO;
import kz.com.alzhan.temirlan.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping("/{id}")
    public PaymentMethodDTO getPaymentMethodById(@PathVariable Long id) {
        return paymentMethodService.getPaymentMethodById(id);
    }

    @GetMapping("/")
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @PostMapping("/")
    public PaymentMethodDTO createPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        return paymentMethodService.createPaymentMethod(paymentMethodDTO);
    }

    @PutMapping("/{id}")
    public PaymentMethodDTO updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethodDTO paymentMethodDTO) {
        return paymentMethodService.updatePaymentMethod(id, paymentMethodDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
    }
}
