package com.epg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epg.exception.ResourceNotFoundException;
import com.epg.model.Program;
import com.epg.repository.ProgramRepository;

@RestController
@RequestMapping("/api/v1")
public class ProgramController {
    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/programs")
    public List<Program> getAll() {
        return programRepository.findAll();
    }
    
    @PostMapping("/programs/create")
    public Program create(@Valid @RequestBody Program program) {
    	return programRepository.save(program);
    }
    
    @GetMapping("/programs/{id}")
    public ResponseEntity<Program> getById(@PathVariable(value = "id") String programId) throws ResourceNotFoundException {
        Program program = programRepository.findById(programId).orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + programId));
        return ResponseEntity.ok().body(program);
    }
    
    @PutMapping("/programs/{id}")
    public ResponseEntity <Program> update(@PathVariable(value = "id") String programId, @Valid @RequestBody Program programBody)
    		throws ResourceNotFoundException {
        Program program = programRepository.findById(programId)
            .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + programId));

        program.setChannelId(programBody.getChannelId());
        program.setImageUrl(programBody.getImageUrl());
        program.setTitle(programBody.getTitle());
        program.setDescription(programBody.getDescription());
        program.setStartTime(programBody.getStartTime());
        program.setEndTime(programBody.getEndTime());
        
        final Program updatedProgram = programRepository.save(program);
        return ResponseEntity.ok(updatedProgram);
    }
}