package com.egg.orderManager.model.entity;

//import com.egg.orderManager.model.entity.embeddedId.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer stock;






//    @ManyToOne()
//    @JoinColumn(name = "order_id")
//    @JsonIgnore
//    private Order order;


//    RELACIÓN PARA MANEJAR LA TABLA ORDERDETAILS CON LLAVE PRIMARIA COMPUESTA
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails;



}
