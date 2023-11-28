//package com.egg.orderManager.model.entity.embeddedId;
//
//import com.egg.orderManager.model.entity.Order;
//import com.egg.orderManager.model.entity.Product;
//import jakarta.persistence.*;
//import lombok.Data;
//
//
//@Data
//@Entity
//public class OrderDetail {
//
////    // SI QUISIERA MANEJAR UNA PRIMARY KEY EN LA ENTIDAD
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
////    @ManyToOne
////    @JoinColumn(name = "order_id")
////    private Order order;
////
////    @ManyToOne
////    @JoinColumn(name = "product_id")
////    private Product product;
//
//
//
////    // SI QUISIERA MANEJAR PRIMARY KEY COMPUESTA POR DOS FORÁNEAS (para esto se usa @EmbeddedId)
//
//    @EmbeddedId
//    private OrderDetailKey id;
//
//    @ManyToOne
//    @MapsId("orderId") //con esta anotación se especifica que es una llave foránea y se mapea hacia la PK de Order
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne
//    @MapsId("productId")
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//
//
//    private Integer quantity;
//    private Double price;
//
//}
