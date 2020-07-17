package com.epg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epg.exception.ResourceNotFoundException;
import com.epg.model.Channel;
import com.epg.repository.ChannelRepository;

@RestController
@RequestMapping("/api/v1")
public class ChannelController {
    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping("/channels")
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }
    
    @GetMapping("/channels/{id}")
    public ResponseEntity<Channel> getChannelById(@PathVariable(value = "id") String channelId) throws ResourceNotFoundException {
        Channel channel = channelRepository.findById(channelId).orElseThrow(() -> new ResourceNotFoundException("Channel not found for this id :: " + channelId));
        return ResponseEntity.ok().body(channel);
    }
    
    @PostMapping("/channels/create")
    public Channel createChannel(@Valid @RequestBody Channel channel) {
    	return channelRepository.save(channel);
    }
}