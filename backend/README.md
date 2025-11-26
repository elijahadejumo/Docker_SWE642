# SWE642

END POINTS FOR CRUD

Get All Survey:          localhost:8080/surveys
Create A Survey :        localhost:8080/survey/create
Get one survey:          localhost:8080/survey/id
Update a survey:         localhost:8080/survey/update/id
Delete a survey:         localhost:8080/survey/delete/id


Sample Json payload:

  "first_name": "New",
  "last_name": "New Test",
  "street_address": "123 Main St",
  "city": "Fairfax",
  "state": "VA",
  "zip": "22030",
  "telephone": "555-123-4567",
  "email": "elijah@example.com",
  "date_of_survey": "2025-11-10",

  "liked_students": true,
  "liked_location": false,
  "liked_campus": true,
  "liked_atmosphere": true,
  "liked_dorm_rooms": false,
  "liked_sports": true,

  "how_interested": "friends",
  "likelihood_recommend": "Very Likely",
  "comments": "Nice campus!"
