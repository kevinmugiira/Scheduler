package com.example.scheduler.repo;


import com.example.scheduler.model.ChannelsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChannelsRepo extends JpaRepository<ChannelsModel, Long> {

}
