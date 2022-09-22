package com.Biblioteca.Prestamos.Repositorio;

import com.Biblioteca.Prestamos.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface estudianteRepositorio extends JpaRepository<Estudiante, String> {
}
