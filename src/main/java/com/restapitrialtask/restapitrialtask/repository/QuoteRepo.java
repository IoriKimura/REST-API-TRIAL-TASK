package com.restapitrialtask.restapitrialtask.repository;

import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepo extends JpaRepository<QuoteModel, Long> {
}
