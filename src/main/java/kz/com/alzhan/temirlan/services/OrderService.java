package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long orderId);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByUserId(Long userId); // Add this method

    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);

    void deleteOrder(Long orderId);
}
