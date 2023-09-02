package br.com.vinicius.hrworker.controllers;

import br.com.vinicius.hrworker.entities.Worker;
import br.com.vinicius.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {
    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<Page<Worker>> findAll(Pageable pageable){
        Page<Worker> workers = repository.findAll(pageable);
        return ResponseEntity.ok(workers);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = repository.findById(id).orElse(null);
        return ResponseEntity.ok(worker);
    }
}
