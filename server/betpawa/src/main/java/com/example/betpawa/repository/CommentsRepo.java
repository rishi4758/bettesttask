package com.example.betpawa.repository;

import com.example.betpawa.model.MyComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<MyComments, Long> {
}
