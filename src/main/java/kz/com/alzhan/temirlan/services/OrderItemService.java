package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    OrderItemDTO addOrderItem(OrderItemDTO orderItemDTO);

    OrderItemDTO getOrderItemById(Long orderItemId);

    List<OrderItemDTO> getAllOrderItems();

    OrderItemDTO updateOrderItem(Long orderItemId, OrderItemDTO orderItemDTO);

    void deleteOrderItem(Long orderItemId);
}
