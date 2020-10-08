package com.example.betpawa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.betpawa.model.MyList;

public interface ListRepo extends JpaRepository<MyList,Long> {
}
