package com.prueba.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.docker.entity.DockerFile;

public interface DockerFileRepository extends JpaRepository<DockerFile, Long> {

}
