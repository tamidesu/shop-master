package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.PaymentDTO;
import kz.com.alzhan.temirlan.entities.PaymentEntity;
import kz.com.alzhan.temirlan.repositories.PaymentRepository;
import kz.com.alzhan.temirlan.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        PaymentEntity payment = modelMapper.map(paymentDTO, PaymentEntity.class);
        PaymentEntity savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPaymentById(Long paymentId) {
        PaymentEntity payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return modelMapper.map(payment, PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<PaymentEntity> payments = paymentRepository.findAll();
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePaymentStatus(Long paymentId, PaymentDTO paymentDTO) {
        PaymentEntity existingPayment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        existingPayment.setStatus(PaymentEntity.PaymentStatus.valueOf(paymentDTO.getStatus()));
        existingPayment.setTransactionId(paymentDTO.getTransactionId());

        PaymentEntity updatedPayment = paymentRepository.save(existingPayment);
        return modelMapper.map(updatedPayment, PaymentDTO.class);
    }

    @Override
    public void deletePayment(Long paymentId) {
        PaymentEntity payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        paymentRepository.delete(payment);
    }
}
