package A1B1O3.bodyrecord.exercise.dto.response;

import A1B1O3.bodyrecord.exercise.domain.Exercise;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public class SearchResponse {

    private final String exerciseName;

    private final float exerciseWeight;

    private final int exerciseCount;

    private final Time exerciseTime;

    private final Boolean exerciseShare;

    private final int goalCategoryCode;

    private final float weight;

    public static SearchResponse from(final Exercise exercise){
        return new SearchResponse(
                exercise.getExerciseName(),
                exercise.getExerciseWeight(),
                exercise.getExerciseCount(),
                exercise.getExerciseTime(),
                exercise.getExerciseShare(),
                exercise.getMember().getGoalCategory().getGoalCategoryCode(),
                exercise.getMember().getBody().getWeight()
        );
    }


}
