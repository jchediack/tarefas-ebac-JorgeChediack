package com.ebac.jorgechediack.memes_service.repository;

import com.ebac.jorgechediack.memes_service.model.Memes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemesRepository extends JpaRepository <Memes, Long> {

}
