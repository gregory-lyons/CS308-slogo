slogo
=====

Team 11

Justin Carrao
Greg Lyons
Ashwin Kommajesula
Rica Zhang


Instructions entered by the user (either via command line, buttons, or arrow keys) are passed (along with the currently active Turtles) from the View to the Controller, which then passes the instruction to the Model.  The Model parses the instruction, prepares the turtles to be updated, and sends them back to the Controller in an object called a SceneUpdater.  The Controller splits up this SceneUpdater and calls appropriate front end methods to update the display.
