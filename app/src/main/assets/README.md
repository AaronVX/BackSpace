# Architecture: Source Code Files

## Application

### Main
Sets the database name

### Services
Creates and initializes the persistence databases with info

## Logic

### AccessFlights
This contains all the public methods to retrieve all the information about flights

### AccessItems
This contains all the public methods to retrieve all the information about items

### AccessPlanets
This contains all the public methods to retrieve all the information about planets

### CalculatePrice
This is the class that will calculate the price for any given flight, this is a placeholder for now

### CheckCard
This class checks the format of credit card submitted and ensures it is of proper format

### CheckDiscountCode
This class checks to see if the code entered is valid and applies the discount if it is

## Objects

### Flight
Object that contains all the information for a flight

### Location
Object that contains all the information for a location (planet)

### Item
Object that contains all the information for an item

## Persistence

### Stub

### FlightPersistenceStub
Stub database that holds the flights that are going to depart

### ItemPersistenceStub
Stub databse that holds the info on items

### HSQLDB

### FlightPersistenceHSQLDB
Makes the flight database from the sql database

### ItemPersistenceHSQLDB
Makes the item database from the sql database

### PlanetPersistenceHSQLDB
Makes the planet/location databse from the sql database

## Presentation

### PlanetList\_and\_FlightStatus

### CustomAdapter
This java file overwrites the the standard list view format to include a picture at the beginning then a title, then a description.
 It overwrites all the necessary methods and is done in a generic form. This is used for both PlanetList and FlightStatus
 
### Listview
Placeholder file, does very little, just need to link the related xml file that contains all the real information

### Info
This page gets called when a flight or planet is selected from flightstatus or planetlist respectively

### PlanetList
This contains a list of planets you can go to, with a picture of them and a small piece of information in a custom listview

### FlightStatus
This activity show the status of current flights in a custom listview

### PurchaseTicket

### AdditionalOptions
This class creates and sets all the additional options you can choose once a flight is selected

### BookBrowseActivity
This gets and then contains the information in the monthly booking view

### BookDestinationActivity
This gets and then contains the information for the choose a destination view

### BookOriginActivity
This gets and then contains the information for the choose an origin view

### DateHandler
Calcuates the the travel time based on arrival and departure

### FlightDetailActivity
This activity shows details about the currently selected flight in a table layout

### PurchaseTicket
This jave file shows the total price of the ticket and check the format of the Visa card

### TravelClass
This gets and then contains the information for the choose a travel class view

### MainActivity
This activity creates the 2 buttons that lead to other activites, including seeing current flight status and booking a flight

### Messages
Simple class for dealing with errors and warnings

## Res

### Drawable
This folder contains vector images for our app, including pictures of earth, venus, etc

### Mipmap-hdpi
This folder contains raster images for our app, taken from https://icons8.com/icon/set/planet/color

## Layout

### activity_additionaloptions
Describes the complex view for additional options (meal plan and virtual reality options)

### activity_info
This describes the format for the specific flight or planet page

### activity\_planet\_list
This describes the format for the list of possible destination planets

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
This describes the format for the choose a travel class