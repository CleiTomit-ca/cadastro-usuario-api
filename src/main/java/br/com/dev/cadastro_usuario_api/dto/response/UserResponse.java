package br.com.dev.cadastro_usuario_api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.dev.cadastro_usuario_api.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserResponse(

    UUID id,

    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    String email,

    @NotBlank(message = "Papel é obrigatório")
    UserRole role,

    @NotNull(message = "Ativo não pode ser nulo")
    Boolean active,

    @NotNull(message = "Data de criação nào pode ser nula")
    LocalDateTime createdAt

) {

}
