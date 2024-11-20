package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.PaymentDTO;
import java.util.List;

public interface PaymentService {

    PaymentDTO processPayment(PaymentDTO paymentDTO);

    PaymentDTO getPaymentById(Long paymentId);

    List<PaymentDTO> getAllPayments();

    PaymentDTO updatePaymentStatus(Long paymentId, PaymentDTO paymentDTO);

    void deletePayment(Long paymentId);
}
