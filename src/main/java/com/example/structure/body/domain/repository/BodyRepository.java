package com.example.structure.body.domain.repository;

import com.example.structure.body.domain.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodyRepository extends JpaRepository<Body,Long> {
    boolean existsByMemberIdAndBodyCode(final Long memberId, final Long bodyCode);
    List<Body> findAllByMemberId(final Long memberId);

}
