package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.InteractiveActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractiveActivityRepository extends JpaRepository<InteractiveActivity,Long>{
}
