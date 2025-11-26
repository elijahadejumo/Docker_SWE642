/**
 * Home Component - Displays the welcome page with navigation options to survey form and survey list
 * Author: Demilade Adewole - G01259263
 */

import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}