package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.OrderItemDTO;
import kz.com.alzhan.temirlan.entities.OrderEntity;
import kz.com.alzhan.temirlan.entities.OrderItemEntity;
import kz.com.alzhan.temirlan.entities.ProductEntity;
import kz.com.alzhan.temirlan.repositories.OrderItemRepository;
import kz.com.alzhan.temirlan.repositories.OrderRepository;
import kz.com.alzhan.temirlan.repositories.ProductRepository;
import kz.com.alzhan.temirlan.services.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderItemDTO addOrderItem(OrderItemDTO orderItemDTO) {
        OrderEntity order = orderRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        ProductEntity product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItemEntity orderItem = modelMapper.map(orderItemDTO, OrderItemEntity.class);
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        OrderItemEntity savedOrderItem = orderItemRepository.save(orderItem);
        return modelMapper.map(savedOrderItem, OrderItemDTO.class);
    }

    @Override
    public OrderItemDTO getOrderItemById(Long orderItemId) {
        OrderItemEntity orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        return modelMapper.map(orderItem, OrderItemDTO.class);
    }

    @Override
    public List<OrderItemDTO> getAllOrderItems() {
        List<OrderItemEntity> orderItems = orderItemRepository.findAll();
        return orderItems.stream()
                .map(orderItem -> modelMapper.map(orderItem, OrderItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO updateOrderItem(Long orderItemId, OrderItemDTO orderItemDTO) {
        OrderItemEntity existingOrderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));

        existingOrderItem.setQuantity(orderItemDTO.getQuantity());
        existingOrderItem.setPrice(orderItemDTO.getPrice());

        OrderItemEntity updatedOrderItem = orderItemRepository.save(existingOrderItem);
        return modelMapper.map(updatedOrderItem, OrderItemDTO.class);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        OrderItemEntity orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        orderItemRepository.delete(orderItem);
    }
}
