package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>{
}
