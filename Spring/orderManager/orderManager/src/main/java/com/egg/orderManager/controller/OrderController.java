package com.egg.orderManager.controller;


import com.egg.orderManager.model.dto.NewOrderDTO;
//import com.egg.orderManager.model.dto.OrderDTO;
import com.egg.orderManager.model.dto.ShowOrderDTO;
import com.egg.orderManager.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<?> createOrder(@RequestBody NewOrderDTO newOrderDTO) {
        try {
            ShowOrderDTO orderDTO = orderService.createOrder(newOrderDTO);
            return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        try {
            List<ShowOrderDTO> orderDTOList = orderService.getAllOrders();
            return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        try {
            ShowOrderDTO orderDTO = orderService.getOrderById(id);
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody NewOrderDTO newOrderDTO) {
        try {
            ShowOrderDTO orderDTO = orderService.updateOrder(id, newOrderDTO);
            return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long id) {
        try {
            ShowOrderDTO showOrderDTO = orderService.deleteOrder(id);
            return new ResponseEntity<>(showOrderDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
