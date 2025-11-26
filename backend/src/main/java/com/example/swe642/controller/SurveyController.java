package com.example.swe642.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.swe642.Entity.Survey;
import com.example.swe642.repository.SurveyRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class SurveyController {

            @Autowired
            SurveyRepository repo;



            @GetMapping("/api/surveys")
            //Get all surveys

            public List <Survey> getAllSurveys(){
                List<Survey> surveys = repo.findAll();    
                return surveys;
            }

            //Get a survey

            @GetMapping("/api/survey/{id}")

            public Survey getSurvey(@PathVariable int id) {
                Survey survey = repo.findById(id).get();

                return survey;
            }


            //Create  survey
            
            
            @PostMapping("/api/survey/create")
            @ResponseStatus(code = HttpStatus.CREATED)
            public void createSurvey(@Valid @RequestBody Survey survey){
                repo.save(survey);
                
            }

            @PutMapping("/api/survey/update/{id}")
            @ResponseStatus(code = HttpStatus.OK)
            public Survey updatSurvey (@PathVariable int id, @RequestBody Survey survey) {
                Survey findSurvey = repo.findById(id).get();
                
                if (survey.getFirst_name() != null) {
                    findSurvey.setFirst_name(survey.getFirst_name());
                }
                
                if (survey.getLast_name() != null) {
                    findSurvey.setLast_name(survey.getLast_name());
                }
                if (survey.getCity() != null) {
                    findSurvey.setCity(survey.getCity());
                }
                if(survey.getComments() != null){
                    findSurvey.setComments(survey.getComments());
                }
                if(survey.getDate_of_survey() != null){
                    findSurvey.setDate_of_survey(survey.getDate_of_survey());
                }
                if(survey.getEmail() != null){
                    findSurvey.setEmail(survey.getEmail());
                }
                if(survey.getHow_interested()!= null){
                    findSurvey.setHow_interested(survey.getHow_interested());
                }
              
                if(survey.getStreet_address()!=null){
                    findSurvey.setStreet_address(survey.getStreet_address());
                }

                if(survey.getState() != null){
                    findSurvey.setState(survey.getState());
                }

                if(survey.getZip() != null){
                    findSurvey.setZip(survey.getZip());
                }

                if(survey.getTelephone() != null) {
                    findSurvey.setTelephone(survey.getTelephone());
                }

                if (survey.isLiked_students() != null) {
                    findSurvey.setLiked_students(survey.isLiked_students());
                }

                if(survey.isLiked_location() != null){
                    findSurvey.setLiked_location(survey.isLiked_location());
                }
                if(survey.isLiked_campus() != null){
                    findSurvey.setLiked_campus(survey.isLiked_campus());
                }

                if(survey.isLiked_atmosphere() != null){
                    findSurvey.setLiked_atmosphere(survey.isLiked_atmosphere());
                }

                if(survey.isLiked_dorm_rooms() != null){
                    findSurvey.setLiked_dorm_rooms(survey.isLiked_dorm_rooms());
                }

                if(survey.isLiked_sports() != null){
                    findSurvey.setLiked_sports(survey.isLiked_sports());
                }
                
                if(survey.getLikelihood_recommend() != null){
                    findSurvey.setLikelihood_recommend(survey.getLikelihood_recommend());

                }


                return repo.save(findSurvey);
            }

            //Delete Survey
            @DeleteMapping("/api/survey/delete/{id}")
            @ResponseStatus(code = HttpStatus.NO_CONTENT)
            public void deletSurvey(@PathVariable int id){
                Survey findSurvey = repo.findById(id).get();

               repo.delete(findSurvey);


            }


}
