package br.com.dev.cadastro_usuario_api.entity;

import br.com.dev.cadastro_usuario_api.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String passwordHash;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @NotNull
    @Column(nullable = false)
    private Boolean active;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public String changeName(String name){
        if(name.equals(this.name)){
            throw new RuntimeException("O nome é igual ao antigo");
        }
        return this.name = name;
    }

    public Boolean changeActive(){
        active = !active;
        return active;
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
