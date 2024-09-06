package com.example.demo.Model.entities;

import com.example.demo.Model.Enum.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @NotBlank(message = " City is Mandatory ......! ")
    @Size(min = 2,max = 60)
    private String city;

    @NotBlank(message = " State is Mandatory ......! ")
    @Size(min = 2,max = 60)
    private String state;

    @NotBlank(message = " Country is Mandatory ......! ")
    @Size(min = 2,max = 60)
    private String country;

    @NotNull(message = " PinCode is Mandatory ......! ")
    @Size(min = 6,max = 20)
    private Long pinCode;

}

