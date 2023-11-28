package com.egg.orderManager.repository;

import com.egg.orderManager.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetails extends JpaRepository<OrderDetail, Long> {
}
