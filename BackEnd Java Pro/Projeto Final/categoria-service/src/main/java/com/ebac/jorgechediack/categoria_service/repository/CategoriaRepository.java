package com.ebac.jorgechediack.categoria_service.repository;

import com.ebac.jorgechediack.categoria_service.model.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaMeme, Long> {
}
