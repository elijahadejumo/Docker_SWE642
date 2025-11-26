/**
 * Survey Form Component - Provides a reactive form for creating and editing student surveys with comprehensive validation
 * Author: Demilade Adewole - G01259263
 */

import { Component, OnInit } from '@angular/core';
import { CommonModule} from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup,Validators} from '@angular/forms';
import { Router, ActivatedRoute} from '@angular/router';
import { SurveyService } from '../../services/survey.service';

@Component({
  selector: 'app-survey-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './survey-form.component.html',
  styleUrl: './survey-form.component.css'
})
export class SurveyFormComponent implements OnInit{
  surveyForm!: FormGroup;
  submitted = false;
  surveyId: number | null = null;
  isEditMode = false;

  constructor(
    private formBuilder: FormBuilder, 
    private surveyService: SurveyService, 
    private router: Router,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void{
    const today = new Date().toISOString().split('T')[0];

    this.surveyForm = this.formBuilder.group({
      first_name: ['', [Validators.required, Validators.pattern(/^[A-Za-z\s]+$/)]],
      last_name: ['', [Validators.required, Validators.pattern(/^[A-Za-z\s]+$/)]],
      street_address: ['', Validators.required],
      city: ['', [Validators.required, Validators.pattern(/^[A-Za-z\s]+$/)]],
      state: ['', [Validators.required, Validators.pattern(/^[A-Za-z\s]+$/)]],
      zip: ['', [Validators.required, Validators.pattern(/^\d{5}(-\d{4})?$/)]],
      telephone: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      email: ['', [Validators.required, Validators.email]],
      date_of_survey: [today, Validators.required],
      liked_students: [false],
      liked_location: [false],
      liked_campus: [false],
      liked_atmosphere: [false],
      liked_dorm_rooms: [false],
      liked_sports: [false],
      how_interested: [''],
      likelihood_recommend: [''],
      comments: ['']
    });

    // Check if we're in edit mode
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.surveyId = +params['id'];
        this.isEditMode = true;
        this.loadSurvey(this.surveyId);
      }
    });
  }

  loadSurvey(id: number): void {
    this.surveyService.getSurveyById(id).subscribe({
      next: (survey) => {
        this.surveyForm.patchValue(survey);
      },
      error: (error: any) => {
        console.error('Error loading survey:', error);
        alert('Error loading survey data');
      }
    });
  }

  atLeastTwoCheckboxes(formGroup: FormGroup) : {[key: string]: boolean} | null {
    const checkboxes = [
      'liked_students', 'liked_location', 'liked_campus', 'liked_atmosphere',
      'liked_dorm_rooms', 'liked_sports'
    ];
    const checkedCount = checkboxes.filter(checkbox => formGroup.get(checkbox)?.value).length;
    return checkedCount >= 2 ? null : { atLeastTwoRequired: true };
}

  get f() { return this.surveyForm.controls; }

  onSubmit(): void {
    this.submitted = true;

    if(this.surveyForm.invalid){
      alert('Please correct the survey prior to submission.');
      return;
    }

    if (this.isEditMode && this.surveyId) {
      // Update existing survey
      this.surveyService.updateSurvey(this.surveyId, this.surveyForm.value).subscribe({
        next: (response: any) => {
          alert('Survey updated successfully!');
          this.router.navigate(['/surveys']);
        },
        error: (error: any) => {
          alert('An error occurred while updating the survey. Please try again later.');
          console.error('There was an error!', error);
        }
      });
    } else {
      // Create new survey
      this.surveyService.createSurvey(this.surveyForm.value).subscribe({
        next: (response: any) => {
          alert('Survey submitted successfully!');
          this.router.navigate(['/surveys']);
        },
        error: (error: any) => {
          alert('An error occurred while submitting the survey. Please try again later.');
          console.error('There was an error!', error);
        }
      });
    }
}

onReset(): void {
    this.submitted = false;
    this.surveyForm.reset();
    const today = new Date().toISOString().split('T')[0];
    this.surveyForm.patchValue({ date_of_survey: today });
  }
}
