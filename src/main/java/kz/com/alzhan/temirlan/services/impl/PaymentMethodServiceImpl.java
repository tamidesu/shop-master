package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.PaymentMethodDTO;
import kz.com.alzhan.temirlan.entities.PaymentMethodEntity;
import kz.com.alzhan.temirlan.repositories.PaymentMethodRepository;
import kz.com.alzhan.temirlan.services.PaymentMethodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethodEntity paymentMethod = modelMapper.map(paymentMethodDTO, PaymentMethodEntity.class);
        PaymentMethodEntity savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return modelMapper.map(savedPaymentMethod, PaymentMethodDTO.class);
    }

    @Override
    public PaymentMethodDTO getPaymentMethodById(Long id) {
        PaymentMethodEntity paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));
        return modelMapper.map(paymentMethod, PaymentMethodDTO.class);
    }

    @Override
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        List<PaymentMethodEntity> paymentMethods = paymentMethodRepository.findAll();
        return paymentMethods.stream()
                .map(method -> modelMapper.map(method, PaymentMethodDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentMethodDTO updatePaymentMethod(Long id, PaymentMethodDTO paymentMethodDTO) {
        PaymentMethodEntity existingMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        existingMethod.setType(PaymentMethodEntity.PaymentType.valueOf(paymentMethodDTO.getType()));
        existingMethod.setDetails(paymentMethodDTO.getDetails());

        PaymentMethodEntity updatedMethod = paymentMethodRepository.save(existingMethod);
        return modelMapper.map(updatedMethod, PaymentMethodDTO.class);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        PaymentMethodEntity paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));
        paymentMethodRepository.delete(paymentMethod);
    }
}
