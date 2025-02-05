package br.com.ebac.animal_service.repositorios;

import br.com.ebac.animal_service.dto.FuncionarioResgateDTO;
import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.entidades.AnimalTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    List<Animal> findByTipoAnimal(AnimalTipo tipoAnimal);

    @Query("SELECT new br.com.ebac.animal_service.dto.FuncionarioResgateDTO(a.nomeRecebedor, COUNT(a)) FROM Animal a GROUP BY a.nomeRecebedor")
    List<FuncionarioResgateDTO> countAnimalsByRecebedor();

}
