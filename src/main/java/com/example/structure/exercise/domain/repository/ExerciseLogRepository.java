package com.example.structure.exercise.domain.repository;

import com.example.structure.exercise.domain.ExerciseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {

    boolean existsByMemberIdAndId(final Long memberId, final Long exerciseLogId);

    List<ExerciseLog> findAllByMemberId(final Long memberId);
}
