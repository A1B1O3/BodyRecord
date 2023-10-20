package com.example.structure.exercise.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class ExerciseLogUpdateRequest {

    @NotBlank(message = "제목을 입력해주세요")
    private final String title;

    @NotBlank(message = "내용을 입력해주세요")
    private final String content;

}
