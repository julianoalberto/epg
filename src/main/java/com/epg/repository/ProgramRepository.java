package com.epg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epg.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, String>{

}
