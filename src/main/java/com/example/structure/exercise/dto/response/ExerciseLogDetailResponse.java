package com.example.structure.exercise.dto.response;

import com.example.structure.exercise.domain.ExerciseLog;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public class ExerciseLogDetailResponse {

    private final Long id;
    private final String title;
    private final String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime modifiedAt;

    public static ExerciseLogDetailResponse from(final ExerciseLog exerciseLog) {
        return new ExerciseLogDetailResponse(
                exerciseLog.getId(),
                exerciseLog.getTitle(),
                exerciseLog.getContent(),
                exerciseLog.getCreatedAt(),
                exerciseLog.getModifiedAt()
        );
    }

}
