package com.example.final_project_2.entity;

import com.example.final_project_2.entity.enumaration.StatusOrder;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private SubService subService;
    private String address;
    private double recommendedPrice;
    private String description;
    private LocalDate dateDoOrder;
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;
    @OneToOne
    private Comment comment;




}
