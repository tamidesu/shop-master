package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.OrderItemDTO;
import kz.com.alzhan.temirlan.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/{orderItemId}")
    public OrderItemDTO getOrderItemById(@PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @GetMapping("/")
    public List<OrderItemDTO> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @PostMapping("/")
    public OrderItemDTO addOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.addOrderItem(orderItemDTO);
    }

    @PutMapping("/{orderItemId}")
    public OrderItemDTO updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.updateOrderItem(orderItemId, orderItemDTO);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
