/**
 * Survey List Component - Displays all submitted surveys in a table with options to edit and delete entries
 * Author: Demilade Adewole - G01259263
 */

import { Component, OnInit } from '@angular/core';
import { CommonModule} from '@angular/common';
import { RouterLink } from '@angular/router';
import { Survey } from '../../models/survey.model';
import { SurveyService } from '../../services/survey.service';

@Component({
  selector: 'app-survey-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './survey-list.component.html',
  styleUrl: './survey-list.component.css'
})
export class SurveyListComponent implements OnInit {
    surveys: Survey[] = [];
    loading: boolean = false;
    
    constructor(private surveyService: SurveyService) {};

    ngOnInit(): void{
      this.loadSurveys();
    }

    loadSurveys(): void{
      this.loading = true;
      this.surveyService.getAllSurveys().subscribe({
        next: (data: Survey[]) => {
          this.surveys = data;
          this.loading = false;
        },
        error: (error: any)=>{
          console.error('Error getting surveys:',error);
          this.loading = false;
        }
      });
    }

    deleteSurvey(id: number): void{
      if(confirm('Please confirm the deletion of this survey.')){

      
      this.surveyService.deleteSurvey(id).subscribe({
        next: () => {
          this.loadSurveys();
        },
        error: (error: any) => {
          console.error('Error deleting survey:', error);
        }
      });
    }}

    getLikedItems(survey: Survey): string {
      const likedItems: string[] =[];
      if (survey.liked_students) likedItems.push('Students');
      if (survey.liked_location) likedItems.push('Location');
      if (survey.liked_campus) likedItems.push('Campus');
      if (survey.liked_atmosphere) likedItems.push('Atmosphere');
      if (survey.liked_dorm_rooms) likedItems.push('Dorm Rooms');
      if (survey.liked_sports) likedItems.push('Sports');
      return likedItems.length > 0 ? likedItems.join(', '): 'None';
}}
