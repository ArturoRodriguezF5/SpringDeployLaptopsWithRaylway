package com.arthycode.RestAPILaptops.controller;


import com.arthycode.RestAPILaptops.entity.Laptop;
import com.arthycode.RestAPILaptops.repository.LaptopRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // Atributos
    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    // Métodos para CRUD de LaptopRepository

    /**
     * Método para Obetener las Laptops que existen en el repo
     * @return Lista de Laptops
     */
    @GetMapping("/api/laptops")
    @Operation(summary = "Muestra las Laptops existentes en el repository.")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    /**
     * Método para buscar una Laptop por id en la BD
     * @param id que sirve para buscar una Laptop por id
     * @return ResponseEntity de tipo Book
     */
    @GetMapping("/api/laptops/{id}")
    @Operation(summary = "Muestra una Laptop mediante ID")
    public ResponseEntity<Laptop> findById(@Parameter(description = "Párametro tipo Long") @PathVariable Long id) {
        Optional<Laptop> otpLap = laptopRepository.findById(id);
        if (otpLap.isPresent()) {
            return ResponseEntity.ok(otpLap.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Método para agregar una laptop nueva en la BD
     * @param laptop Recibe un parametro tipo Laptop
     * @return ResponseEntity de tipo Book
     */
    @PostMapping("/api/laptops")
    @Operation(summary = "Agrega una Laptop nueva a la BD")
    public Laptop crearLaptop(@Parameter(description = "Párametro tipo Laptop") @RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    /**
     * Método para actualizar un elemento
     * @param laptop recibe un pámetro tipo laptop para actualizar el elemento
     * @return ResponseEntity de tipo Book
     */
    @PutMapping("/api/laptops")
    @Operation(summary = "Actualiza una Laptop en la BD")
    public ResponseEntity<Laptop> update(@Parameter(description = "Párametro tipo Laptop") @RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("La laptop debe tener un id");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    /**
     * Método para eliminar un elemento de la BD by id
     * @param id párametro para poder eliminar un elemento de la BD
     * @return ResponseEntity de tipo Book
     */
    @DeleteMapping("/api/laptops/{id}")
    @Operation(summary = "Elimina una Laptop de la BD por ID")
    public ResponseEntity<Laptop> delete(@Parameter(description = "Párametro tipo Long") @PathVariable Long id) {
        if(laptopRepository.existsById(id)) {
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Método para eliminar toda la BD
     * @return ResponseEntity de tipo Book
     */
    @DeleteMapping("/api/laptops")
    @Operation(summary = "Elimina todas las Laptops de la BD")
    public ResponseEntity<Laptop> deleteAll() {
        if (laptopRepository.count() > 0) {
            laptopRepository.deleteAll();
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
