package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.Processes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorcessesRepository extends JpaRepository<Processes, Long>{
}
