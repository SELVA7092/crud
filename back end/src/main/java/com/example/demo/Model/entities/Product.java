package com.example.demo.Model.entities;

import com.example.demo.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = " ProductName is Mandatory .........! ")
    @Size(min = 2,max = 30,message = " ProductName Must Be Between 2 & 30 Characters .......! ")
    private String productName;

    @NotBlank
    private String description;

    @NotBlank(message = " product Price is Mandatory ......! ")
    private String price;

    @NotNull(message = " Stuck is Mandatory .......! ")
    @Size(min = 1,message = " AtLeast One Stack is Mandatory ......! ")
    private long stack;

    private String image;
    private LocalDate createdOn;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Cart> carts;

}

