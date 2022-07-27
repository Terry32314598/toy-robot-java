
# Toy Robot Game


---

### Description

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. 
There are no other obstructions on the table surface. 
The robot is free to roam around the surface of the table, but must be prevented from falling to destruction.
Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

---

### How to play the game

Software Requirements : Maven, Java (8 - latest version).

Please make sure the input command file is in the project root folder.

Run the following scripts in sequence. Only need to run build.sh once if there is no source code change.
```shell
./build.sh
./run.sh SOURCE_FILE_PATH
```

---
### Assumption
* Commands are put in a file.
* Each command is seperated by a line breaker and don't accept redundant space.
* Invalid command will be ignored and the game will continue until the last command in the input file processed

---
### Explanation
PLACE command is not defined in Command.java. Because I define the PLACE as a special command which is for the table instead of robot. So It becomes a system command. It is table's responsibility to initialize a robot and place
it somewhere for starting the game.