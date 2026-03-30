# Movie Ticket Booking System - LLD

## Features
- Admin can add movie, theatre, and show
- Customer can browse theatres by city
- Customer can browse movies by city
- Customer can view shows and book seats
- Dynamic pricing based on rules
- Payment and ticket generation
- Booking cancellation support

## Main Requirements Covered
- bookTicket(showId, seats)
- showTheatre(city)
- showMovies(city)
- showSeats(theatre, movie/show)
- Dynamic pricing rules
- Email as unique identifier
- Admin and customer users

## Project Structure
- models
- enums
- repositories
- services
- utils

## Run
```bash
javac -d out src/enums/*.java src/models/*.java src/repositories/*.java src/services/*.java src/utils/*.java src/Main.java
java -cp out Main
```
