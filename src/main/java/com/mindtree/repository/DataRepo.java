package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Data;

@Repository
public interface DataRepo extends JpaRepository<Data, Integer> {

}
