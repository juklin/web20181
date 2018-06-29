package dsweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dsweb.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
