package com.egg.orderManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowOrderDTO {
    private ClientDTO client;
    private List<ShowOrderDetailDTO> orderDetails;


}
