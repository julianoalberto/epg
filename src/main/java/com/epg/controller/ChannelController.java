package com.epg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epg.model.Channel;
import com.epg.repository.ChannelRepository;

@RestController
public class ChannelController {
    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping("/channels")
    public List<Channel> getAll() {
        return channelRepository.findAll();
    }
    
    @PostMapping("/channels/create")
    public Channel create(@Valid @RequestBody Channel channel) {
    	return channelRepository.save(channel);
    }
}