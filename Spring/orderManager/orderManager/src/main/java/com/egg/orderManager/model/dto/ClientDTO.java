package com.egg.orderManager.model.dto;

import com.egg.orderManager.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String name;
    private String email;
    private Integer phone;
}
