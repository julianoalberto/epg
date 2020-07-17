package com.epg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epg.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String>{

}
