package com.galvanize.playlistserviceapi.repository;

import com.galvanize.playlistserviceapi.entity.PlayListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PlayListRepository extends JpaRepository<PlayListEntity,Long> {
}
