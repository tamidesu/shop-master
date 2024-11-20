package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.PaymentMethodDTO;
import java.util.List;

public interface PaymentMethodService {

    PaymentMethodDTO createPaymentMethod(PaymentMethodDTO paymentMethodDTO);

    PaymentMethodDTO getPaymentMethodById(Long id);

    List<PaymentMethodDTO> getAllPaymentMethods();

    PaymentMethodDTO updatePaymentMethod(Long id, PaymentMethodDTO paymentMethodDTO);

    void deletePaymentMethod(Long id);
}
