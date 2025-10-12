package barberia.barber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import barberia.barber.entity.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Integer> {

    UsuarioEntity findByUsername(String username);

    boolean existsByUsername(String username);

}
