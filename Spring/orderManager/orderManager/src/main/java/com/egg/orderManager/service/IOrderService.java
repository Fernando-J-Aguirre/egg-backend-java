package com.egg.orderManager.service;

import com.egg.orderManager.model.dto.NewOrderDTO;
//import com.egg.orderManager.model.dto.OrderDTO;
import com.egg.orderManager.model.dto.ShowOrderDTO;

import java.util.List;

public interface IOrderService {

    public ShowOrderDTO createOrder(NewOrderDTO newOrderDTO) throws Exception;
    public List<ShowOrderDTO> getAllOrders() throws Exception;
    public ShowOrderDTO getOrderById(Long id) throws Exception;
    public ShowOrderDTO updateOrder(Long id, NewOrderDTO newOrderDTO) throws Exception;

}
