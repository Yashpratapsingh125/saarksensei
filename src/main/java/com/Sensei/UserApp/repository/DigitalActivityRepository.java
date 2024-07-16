package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.DigitalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DigitalActivityRepository extends JpaRepository<DigitalActivity,Long>{
}
