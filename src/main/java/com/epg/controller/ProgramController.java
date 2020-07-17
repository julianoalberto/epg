package com.epg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Program> getByChannelIdOrAll(@RequestParam Optional<String> channelId) {
        if (channelId.isPresent()) {
        	List<Program> programs = programRepository.findAll();
        	return programs.stream().filter(channel -> channelId.get().equals(channel.getChannelId())).collect(Collectors.toList());
        } else {
        	return programRepository.findAll();
        }
    }
    
    @PostMapping("/programs/create")
    public Program create(@Valid @RequestBody Program program) {
    	return programRepository.save(program);
    }
    
    @GetMapping("/programs/{id}")
    public ResponseEntity<Program> getById(@PathVariable(value = "id") String programId) 
    		throws ResourceNotFoundException {
        Program program = programRepository.findById(programId)
        		.orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + programId));
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
    
    @DeleteMapping("/programs/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") String programId)
    		throws ResourceNotFoundException {
        Program program = programRepository.findById(programId)
            .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + programId));

        programRepository.delete(program);
        Map<String, Boolean> response = new HashMap<> ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}