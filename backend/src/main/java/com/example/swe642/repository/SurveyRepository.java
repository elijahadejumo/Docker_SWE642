package com.example.swe642.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.swe642.Entity.Survey;

public interface SurveyRepository extends JpaRepository <Survey,Integer> {

}
