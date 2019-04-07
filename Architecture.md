# Architecture

We use a 3-tier architecture:
*  [Logic](#)
*  [Persistence](#)
*  [Presentation](#)

Other
*  [Application](#)
*  [Objects](#)
*  [Resources](#)
*  [Layout](#)



## Application

```
Main.java - sets the database name
Services.java` - creates and initializes the persistence databases with info
```

## Logic

*Accessors*
```
AccessFlights.java - contains all the public methods to retrieve all the information about flights
AccessItems.java - contains all the public methods to retrieve all the information about items
AccessPlanets.java - contains all the public methods to retrieve all the information about planets
```
*Other*
```
CalculatePrice.java - calculates the price for any given flight, this is a placeholder for now
CheckCard.java - checks the format of credit card submitted and ensures it is of proper format
CheckDiscountCode.java - checks to see if the code entered is valid and applies the discount if it is
AnalyseDates.java - extracts specific dates from a list of flights
```
*Exceptions*
```
CardException.java
CouponJavaException.java
```
## Objects

```
Flight.java - contains all the information for a flight
Location.java - contains all the information for a location (planet)
Item.java - contains all the information for an item
```

## Persistence

*Interfaces*
```
FlightPersistence.java - holds flights that are going to depart
ItemPersistence.java - holds item info
PlanetPersistence.java - holds planets info
```
*HSQLDB*
```
FlightPersistenceHSQLDB.java - makes the flight database from the sql database
ItemPersistenceHSQLDB.java - makes the item database from the sql database
PlanetPersistenceHSQLDB.java - makes the planet/location databse from the sql database
```


<a name="#3"></a>
## Presentation

```
MainActivity.java - creates 3 buttons that lead to other activites, including seeing current flight status and booking a flight
```

### Book flight
*Browse flights*
```
SelectOrigin.java - gets and then contains the information for the choose an origin view
SelectDestination.java - gets and then contains the information for the choose a destination view
BrowseFlightsCalendar.java
BrowseFlightsList.java
FlightDetailActivity.java - shows details about the currently selected flight
PurchaseTicket.java - shows the total price of the ticket and check the format of the Visa card
```
*Travel class*
```
SelectTravelClass.java - gets the information about a travel class
SelectDailyExpenses.java - creates and sets all the additional options you can choose once a flight is selected
```
```
PurchaseTicket.java
ReviewBooking.java
```
### Browse Planets
```
PlanetList.java - contains a list of planets you can go to, with a picture of them and a small piece of information in a custom listview
Info.java - gets called when a flight or planet is selected from flightstatus or planetlist respectively
```
### Track Flights
```
FlightStatusList.java - shows the status of current flights in a custom listview
StatusDetail.java
```
### Util
*List adapters*
```
FlightListAdapter.java
PlanetListAdapter.java
```
```
DateHandler.java - calcuates the the travel time based on arrival and departure
Messages.java - simple class for dealing with errors and warnings

```

## Res

### Drawable
This folder contains vector images for our app, including pictures of earth, venus, etc


## `Layout`

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