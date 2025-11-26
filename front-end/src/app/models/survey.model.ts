/*
SWE 642: Assignment 3/Group Project
Demilade Adewole
G01259263
*/

export interface Survey {
  id?: number;
  first_name: string;
  last_name: string;
  street_address: string;
  city: string;
  state: string;
  zip: string;
  telephone: string;
  email: string;
  date_of_survey: string;
  liked_students?: boolean;
  liked_location?: boolean;
  liked_campus?: boolean;
  liked_atmosphere?: boolean;
  liked_dorm_rooms?: boolean;
  liked_sports?: boolean;
  how_interested?: string;
  likelihood_recommend?: string;
  comments?: string;
}