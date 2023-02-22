package br.com.vinicius.hrworker.ropositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
