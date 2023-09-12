package com.industriascin.interview.repositories;

import com.industriascin.interview.models.TaskEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}
