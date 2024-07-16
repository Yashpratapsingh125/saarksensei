package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubModuleRepository extends JpaRepository<SubModule, Long> {
}
