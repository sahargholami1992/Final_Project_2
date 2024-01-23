package com.example.final_project_2.entity;

import com.example.final_project_2.entity.enumaration.Permission;
import com.example.final_project_2.entity.enumaration.Roll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;
    private LocalDate dateRegister;
    @Enumerated(EnumType.STRING)
    private Roll roll;
    @Enumerated(EnumType.STRING)
    private Permission permission;

    @Override
    public String toString() {
        return " id = " +getId()+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateRegister=" + dateRegister +
                ", roll=" + roll +
                ", permission=" + permission ;
    }
}
