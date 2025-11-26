import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Survey } from '../models/survey.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class SurveyService {

  private api = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getAllSurveys(): Observable<Survey[]> {
    return this.http.get<Survey[]>(`${this.api}/surveys`);
  }

  getSurveyById(id: number): Observable<Survey> {
    return this.http.get<Survey>(`${this.api}/survey/${id}`);
  }

  createSurvey(survey: Survey): Observable<any> {
    return this.http.post(`${this.api}/survey/create`, survey);
  }

  updateSurvey(id: number, survey: Survey): Observable<Survey> {
    return this.http.put<Survey>(`${this.api}/survey/update/${id}`, survey);
  }

  deleteSurvey(id: number): Observable<any> {
    return this.http.delete(`${this.api}/survey/delete/${id}`);
  }




 
} 