package com.egg.orderManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderDTO {

//    private Long clientId;
//    private List<Long> productsId;
//    private Integer quantity;

    private Long clientId;
    private List<NewOrderDetailDTO> orderDetails;
}
