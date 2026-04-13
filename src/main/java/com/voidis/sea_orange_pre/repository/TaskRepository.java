package com.voidis.sea_orange_pre.repository;

import com.voidis.sea_orange_pre.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
