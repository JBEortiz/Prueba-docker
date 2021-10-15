package com.prueba.docker.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.docker.entity.DockerFile;
import com.prueba.docker.repository.DockerFileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DockerFileController {
	
	@Autowired
	private DockerFileRepository repository;
	
	@GetMapping("/get-all")
	public ResponseEntity<List<DockerFile>> listar(){
		List<DockerFile> dockerfiles = repository.findAll();
		if (dockerfiles.isEmpty()) {
			throw new EntityNotFoundException("the list dockers files is void");
		}
		return ResponseEntity.ok(dockerfiles);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<DockerFile> findById(@PathVariable Long id) {
		DockerFile dockerfile;
		dockerfile = repository.findById(id).orElseGet(() -> defaultDockerFile());
		return ResponseEntity.ok(dockerfile);
	}
	
	private DockerFile defaultDockerFile() {
		DockerFile dockerfile= new DockerFile();
		dockerfile.setAddDate("default");
		dockerfile.setEntrypoint("default");
		dockerfile.setForm("default");
		dockerfile.setName("default");
		dockerfile.setVolume("default");
		return dockerfile;
	}

	@PostMapping("/create")
	public ResponseEntity<DockerFile> create(@RequestBody DockerFile dockerfile) {
		return ResponseEntity.ok(repository.save(dockerfile));
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleted(@PathVariable Long id) {
		repository.deleteById(id);
	}
	

}
