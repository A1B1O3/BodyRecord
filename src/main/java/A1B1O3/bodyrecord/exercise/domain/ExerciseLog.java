package A1B1O3.bodyrecord.exercise.domain;

import A1B1O3.bodyrecord.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@SQLDelete(sql = "UPDATE exercise_log SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status = 'USABLE'")
public class ExerciseLog extends BaseEntity {

}
