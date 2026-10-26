package br.com.dev.cadastro_usuario_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.dev.cadastro_usuario_api.dto.request.RegisterRequest;
import br.com.dev.cadastro_usuario_api.dto.request.UpdateUserRequest;
import br.com.dev.cadastro_usuario_api.dto.response.AuthResponse;
import br.com.dev.cadastro_usuario_api.dto.response.UserResponse;
import br.com.dev.cadastro_usuario_api.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password", ignore = true) 
    User toEntity(RegisterRequest request);

    UserResponse toResponse(User user);

    @Mapping(target = "token", source = "token")
    @Mapping(target = "userResponse", source = "user")
    AuthResponse toAuthResponse(User user, String token);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUserFromDto(UpdateUserRequest request, @MappingTarget User user);
}
