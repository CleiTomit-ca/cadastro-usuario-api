package br.com.dev.cadastro_usuario_api.dto.response;

import java.util.UUID;

import br.com.dev.cadastro_usuario_api.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthResponse(

    @NotBlank(message = "Token é obrigatório")
    String token,

    @NotBlank(message = "Tipo de token é obrigatório")
    String tokenType,

    UUID id,

    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    String email,

    @NotBlank(message = "Papel é obrigatório")
    UserRole role
) {

}
