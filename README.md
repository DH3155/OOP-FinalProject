# OOP FinalProject
## Outdoor Oriented Hotel Booking

---
## Application Description
This application is intended to be used for people who wants to rent out a room in the Outdoor Oriented Hotel
it is a Check In, and Check Out Port made by JavaFX and Java, with the help of SceneBuilder
it has an interface that is presentable and easy to navigate through
---
## How this application works
- First the application runs the main file, which is main.java
- the main.java file will show the main menu scene, here you can navigate through the scenes by clicking the button
- those buttons are controlled by the controller files, those files are:
   - Booking Controller for booking page
   - CheckIn Controller for check in page
   - Controller for Main menu, Facility, Menu, and Rooms
   - ProfileController for the Profile Page
- Those controller has the controls for mainly navigation and to store data into the system
- The data stored in the system is stored in a txt file, where it is stored int this format
CID#Name#NIK#Dob#CheckinDate#CheckOutDate#RoomType#RoomNumber#TotalCharge
- The controller inside the check in will read the data and store it in an array list
- Check In controller will also verify the inputs of the user, making it safe for the user to log in
---
## Libraries
The libraries used in this projects are
- JRE System Library (JavaSE - 17) (this includes java.io, java.net, java.time, and many more)
- JavaFX (version 20.0.1) (this includes javafx.stage, javafx.event, javafx.fxml, and many more)
---
## User Manual
To use the application, simply run the java file and locate the main file, which resides inside the folder
The application will run and the User Interface will show up in a 1920 x 1080 resolution
In the user interface there are several options to choose from, there are home, menu, rooms, facility, and check in

In the main section, you can see the top menu picks, facilities and available rooms to book from.In the menu section, you can see what the menus being served in the hotel, though you cannot buy it since you haven't check in yet. In the rooms section, you can see the types of rooms and their prices, you can book yourself a room by clicking the arrow button or the top right corner. In the facilities, you can see the facilities that are available in the hotel, currently there are 2 paid and 2 free facilities.

The top right corner is the check in/book button, there you can book yourself a room, and a code will be given for you. This code will be needed for you to check in the hotel. if you already booked a room, you can click the already book button, there you can check in to the hotel and be asked for some credentials. After the credentials are verified, you will be redirected to the profile page. There are several things you can do in the profile page, those being:
- order Foods/Drinks
    - write an amount of item you want to buy and click the add button
- Use facilities
- See identifications i.e. room type, customer ID, Room number and etc.
- Check out from the hotel
---
## Screenshots
### Main Menu
![Main Menu](https://github.com/DH3155/OOP-FinalProject/assets/127413800/fcc34c6f-20f5-4f06-8a3d-3ec9b00b6d16)
### Menus
![Menus](https://github.com/DH3155/OOP-FinalProject/assets/127413800/36fbe449-e3ae-41c2-942b-07e2c2cdceae)
### Rooms
![Rooms](https://github.com/DH3155/OOP-FinalProject/assets/127413800/b279a7b5-7191-4a3e-a7da-6e09d57567a9)
### Facilities
![Facilities](https://github.com/DH3155/OOP-FinalProject/assets/127413800/9e4f4ce6-4a00-4cb3-8dd5-ce844a5f768a)
### Booking
![Booking](https://github.com/DH3155/OOP-FinalProject/assets/127413800/053e7b1f-d867-49bf-a168-51e02d0fe2a7)
### CheckIn
![CheckIn](https://github.com/DH3155/OOP-FinalProject/assets/127413800/a20a6563-eb43-4c3f-962a-8b45f6258df1)
### Profile Page
![Profile Page](https://github.com/DH3155/OOP-FinalProject/assets/127413800/80289591-9c8a-4822-ad76-9ea7b14ced4a)


