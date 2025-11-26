import { Routes } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import { SurveyFormComponent } from './components/survey-form/survey-form.component';
import {SurveyListComponent} from './components/survey-list/survey-list.component';

export const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'survey', component: SurveyFormComponent},
    {path: 'survey/:id', component: SurveyFormComponent},
    {path: 'surveys', component: SurveyListComponent}
];
