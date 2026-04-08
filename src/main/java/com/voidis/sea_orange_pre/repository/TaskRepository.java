package com.voidis.sea_orange_pre.repository;

import com.voidis.sea_orange_pre.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
