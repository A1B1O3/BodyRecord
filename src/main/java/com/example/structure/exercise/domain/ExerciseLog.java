package com.example.structure.exercise.domain;

import com.example.structure.common.BaseEntity;
import com.example.structure.exercise.dto.request.ExerciseLogUpdateRequest;
import com.example.structure.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

import static com.example.structure.common.type.StatusType.USABLE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@SQLDelete(sql = "UPDATE exercise_log SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status = 'USABLE'")
public class ExerciseLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    public ExerciseLog(
            final Long id,
            final Member member,
            final String title,
            final String content
    ) {
        super(USABLE);
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
    }

    public static ExerciseLog of(final Member member, final String title, final String content) {
        return new ExerciseLog(
                null,
                member,
                title,
                content
        );
    }

    public void update(ExerciseLogUpdateRequest exerciseLogUpdateRequest) {
        this.title = exerciseLogUpdateRequest.getTitle();
        this.content = exerciseLogUpdateRequest.getContent();
    }

}
