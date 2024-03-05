package com.bookhub.repository;

import com.bookhub.domain.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {



}
