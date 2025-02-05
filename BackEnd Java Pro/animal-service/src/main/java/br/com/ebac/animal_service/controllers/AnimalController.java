package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.dto.FuncionarioResgateDTO;
import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.entidades.AnimalTipo;
import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/tipo/{tipoAnimal}")
    public List<Animal> findByTipo(@PathVariable AnimalTipo tipoAnimal) {
        return repository.findByTipoAnimal(tipoAnimal);
    }

    @GetMapping("/recebedor")
    public List<FuncionarioResgateDTO> recebedores() {
        return repository.countAnimalsByRecebedor();
    }

}
