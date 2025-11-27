# Survey Application - Dockerized

## Project Overview
Brief description of what your application does.

## Architecture
- **Frontend**: Angular application served via nginx
- **Backend**: Spring Boot REST API

## Prerequisites
- Docker Desktop installed and running

## How to Run

1. Clone or unzip the project
2. Open a terminal in the project root
3. Run:
```bash
   docker compose up --build
```
4. Wait for all containers to start
5. Open http://localhost:4200 in your browser

## API Endpoints
- GET /surveys - Get all surveys
- GET /survey/{id} - Get survey by ID
- POST /survey/create - Create new survey
- PUT /survey/update/{id} - Update survey
- DELETE /survey/delete/{id} - Delete survey

## Stopping the Application
```bash
docker compose down
```
```

## File structure
``` 