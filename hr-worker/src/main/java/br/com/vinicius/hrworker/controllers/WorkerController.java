package br.com.vinicius.hrworker.controllers;

import br.com.vinicius.hrworker.entities.Worker;
import br.com.vinicius.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    @Value("${test.config}")
    private String testConfig;
    @Autowired
    private Environment env;
    @Autowired
    private WorkerRepository repository;

    @GetMapping(path = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("CONFIG = " + testConfig);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Worker>> findAll(Pageable pageable){
        Page<Worker> workers = repository.findAll(pageable);
        return ResponseEntity.ok(workers);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        /*
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = repository.findById(id).orElse(null);
        return ResponseEntity.ok(worker);
    }
}
