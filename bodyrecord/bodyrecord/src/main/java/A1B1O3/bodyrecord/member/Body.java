package A1B1O3.bodyrecord.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bodyCode;

    @ManyToOne
    @JoinColumn(name = "member_code")
    private Member member;

    @Column(name = "weight")
    private float weight;

    @Column(name = "fat")
    private float fat;

    @Column(name = "muscle")
    private float muscle;
}
