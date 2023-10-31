package A1B1O3.bodyrecord.exercise.dto.response;

import A1B1O3.bodyrecord.exercise.domain.Exercise;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public class SearchCategoryResponse {

    private final String exerciseName;

    private final float exerciseWeight;

    private final int exerciseCount;

    private final Time exerciseTime;

    private final Boolean exerciseShare;

    private final int goalCategoryCode;

    public static SearchCategoryResponse from(final Exercise exercise){
        return new SearchCategoryResponse(
                exercise.getExerciseName(),
                exercise.getExerciseWeight(),
                exercise.getExerciseCount(),
                exercise.getExerciseTime(),
                exercise.getExerciseShare(),
                exercise.getMember().getGoalCategory().getGoalCategoryCode()
        );
    }


}
