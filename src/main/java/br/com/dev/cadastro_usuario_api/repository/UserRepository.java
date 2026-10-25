package br.com.dev.cadastro_usuario_api.repository;

import br.com.dev.cadastro_usuario_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
