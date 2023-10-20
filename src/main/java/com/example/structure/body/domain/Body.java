package com.example.structure.body.domain;

import com.example.structure.body.dto.request.BodyUpdateRequest;
import com.example.structure.common.BaseEntity;
import com.example.structure.common.type.StatusType;
import com.example.structure.member.domain.Member;
import com.example.structure.member.domain.MemberState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.security.Identity;

import static com.example.structure.common.type.StatusType.USABLE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access=PROTECTED)
@SQLDelete(sql = "UPDATE body SET status = 'DELETED' WHERE body_code = ?")
@Where(clause = "status = 'USABLE'")
@Table(name="body")
public class Body extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long bodyCode;

    @Column(nullable=false)
    private Long weight;

    @Column(nullable=false)
    private Long fat;

    @Column(nullable=false)
    private Long Muscle;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    @Enumerated(value = STRING)
    private StatusType status;

    public Body(final Long bodyCode, final Long weight, final Long fat, final Long muscle, final Member member,final StatusType status) {
        super(USABLE);
        this.bodyCode = bodyCode;
        this.weight = weight;
        this.fat = fat;
        Muscle = muscle;
        this.member = member;
        this.status = status;
    }

   public static Body of( final Long weight, final Long fat, final Long muscle, final Member member,final StatusType status)
   {
       return new Body(null,weight,fat,muscle,member,status);
   }

   public void update(BodyUpdateRequest bodyUpdateRequest){
        this.weight=bodyUpdateRequest.getWeight();
        this.fat=bodyUpdateRequest.getFat();
        this.Muscle=bodyUpdateRequest.getMuscle();
   }


}
