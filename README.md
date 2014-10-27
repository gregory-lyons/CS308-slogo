slogo
=====

Team 11
Justin Carrao (Back end)
Greg Lyons (Front end)
Ashwin Kommajesula (Back end)
Rica Zhang (Front end)

Date started: 10/3/2014
Date finished: 10/26/2014

File used to start project: Main.java
Possible bugs when using Save/Load Workspace buttons

Instructions entered by the user (either via command line, buttons, or arrow keys) are passed (along with the currently active Turtles) from the View to the Controller, which then passes the instruction to the Model.  The Model parses the instruction, prepares the turtles to be updated, and sends them back to the Controller in an object called a SceneUpdater.  The Controller splits up this SceneUpdater and calls appropriate front end methods to update the display.
