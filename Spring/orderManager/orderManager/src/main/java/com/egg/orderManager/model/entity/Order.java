package com.egg.orderManager.model.entity;

//import com.egg.orderManager.model.entity.embeddedId.OrderItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order(Client client, List<OrderDetail> orderDetails) {
        this.client = client;
        this.orderDetails = orderDetails;
    }





//    @ManyToMany
//    @JoinTable(
//            name = "orders_products",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//
//    private Integer quantity;
//    public Order(Client client, List<Product> products, Integer quantity) {
//        this.client = client;
//        this.products = products;
//        this.quantity = quantity;
//    }









    // ESTA RELACIÓN NO ME PERMITE ASIGNAR UN MISMO PRODUCTO A UNA NUEVA ORDEN SI YA FUE ASIGNADO.
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id") //con esta anotación se crea una columna en la entidad relacionada con ese "name", si lo saco se crea una tabla intermedia
//    private List<Product> products;


    // UNA O MUCHAS ORDENES PUEDEN TENER EL MISMO PRODUCTO
    // pero de esta manera no se podría manejar muchos productos en una order???
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    // RELACIÓN PARA MANEJAR LA TABLA ORDERITEM CON LLAVE PRIMARIA COMPUESTA
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderItem> orderItem;


}
