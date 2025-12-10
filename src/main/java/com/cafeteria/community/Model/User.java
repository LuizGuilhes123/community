package com.cafeteria.community.Model;


import com.cafeteria.community.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password; // será criptografada no módulo 1

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
