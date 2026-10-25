package br.com.dev.cadastro_usuario_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(
    
    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    String email
) {

}
