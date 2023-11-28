package com.egg.orderManager.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer phone;

//    @OneToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "client",
//            cascade = CascadeType.ALL
//    )
//    private List<Order> orders;


}
