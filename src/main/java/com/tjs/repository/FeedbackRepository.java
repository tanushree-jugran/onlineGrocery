package com.tjs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjs.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
