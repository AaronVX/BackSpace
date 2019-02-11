# Architecture: Source Code Files

## Logic

### AccessFlights
This contains all the public methods the retrieve all the information about flights

### DateHandler
This contains all the public methods for retrieving the dates for a specific fights and some slight formatting

### Services
This sets up up persistent flights

## Objects

### Flight
Object that contains all the information for a flight

### Location
Object that contains all the information for a location (planet)

## Persistence

### FlightPersistenceStub
Stub database that holds the flights that are going to depart

### Flight Persistence
This calls the stub database

## Presentation

### BookBrowseActivity
This gets and then contains the information in the monthly booking view

### BookDestinationActivity
This gets and then contains the information for the choose a destination view

### BookOriginActivity
This gets and then contains the information for the choose an origin view

### CustomAdapter
This java file overwrites the the standard list view format to include a picture at the beginning then a title, then a description. It overwrites all the necessary methods and adds the new data values to the adapter to include all the data needed for the flight status

### FlightDetailActivity
This activity shows details about the currently selected flight in a table layout

### FlightStatus
This activity show the status of current flights in a custom listview

### Listview
Placeholder file, does very little, just need to link the related xml file that contains all the real information

### MainActivity
This activity creates the 2 buttons that lead to other activites, including seeing current flight status and booking a flight

### PurchaseTicket
This jave file shows the total price of the ticket and check the format of the Visa card

### TravelClass
This gets and then contains the information for the choose a travel class view

## Drawable

### Added Pictures
This folder contains the added pictures for our app, including pictures of earth, venus, etc

## Layout

### activity\_book\_browse
This describes the format for the booking on the calender view activity

### activity\_book\_destination
This describes the format for the choose a destination view activity

### activity\_book\_origin
This describes the format for the choose an origin view activity

### activity\_flight\_detail
This file contains the layout to be used when viewing details of a flight

### activity\_flight\_status
This file contains just a bit of information on the format of the background

### activity_listview
This file contains all the information on text size, color, border sizes for the the custom listview

### activity_main
This describes the layout and image on the buttons on the main activity

### activity\_purchase\_ticket
This describes the layout you see when purchasing a ticket

### activity\_travel\_class
This describes the format for the choose a travel class activity