package com.example.demo.Model;

import com.example.demo.Model.Enum.Role;
import com.example.demo.Model.entities.Address;
import com.example.demo.Model.entities.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = " UserName is Mandatory ......! ")
    @Size(min = 2,message = " UserName Must Be Between 2 & 30 Characters .......! ",max = 40)
    private String userName;

    @NotBlank(message = " Email is Mandatory ......! ")
    @Email(message = " Email is Invalid .......! ")
    private String email;

    @NotBlank(message = " Password is Mandatory ......! ")
    @Size(min = 8,message = " Too Weak .......! ")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = " Number is Mandatory ......! ")
    @Pattern(regexp = "^\\d{10}$",message = " Number is Not valid ......! ")
    private String number;

    @NotNull(message = " DateOfBirth is Mandatory .......! ")
    @Past(message = " DateOfBirth Must Be A Past Date .......! ")
    private LocalDate dateOfBirth ;

    private LocalDate createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> product;

}

