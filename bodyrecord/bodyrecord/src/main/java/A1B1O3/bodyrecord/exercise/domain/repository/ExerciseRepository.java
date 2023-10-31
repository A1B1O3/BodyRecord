package A1B1O3.bodyrecord.exercise.domain.repository;

import A1B1O3.bodyrecord.exercise.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    boolean existsByMemberMemberCodeAndExerciseCode(final int memberCode, final int exerciseCode);

    List<Exercise> findAllByMemberMemberCode(final int memberCode);

    Optional<Exercise> findByExerciseCode(final int exerciseCode);


    List<Exercise> findByExerciseShareAndMemberGoalCategoryGoalCategoryCode(final boolean exerciseShare, final int goalCategoryCode);

    List<Exercise> findByExerciseShareAndMemberBodyWeightAndMemberBodyFatAndMemberBodyMuscle(final boolean exerciseShare, final float weight, final float fat, final float muscle);
}
