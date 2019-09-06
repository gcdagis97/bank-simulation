# bank-simulation

Project to simulate a bank. The bank starts at a specified time CURR which is incremented accordingly.

The bank has 3 tellers which take separate customer objects (each with an arrival time, service time, maximum wait time) from a queue, and handles them appropriately through an automated event list. Each of the 7 types of event objects have a time which they are executed as well as a corresponding type number.

Teller 3 specifically has the duty of executing tasks from a stack as well as the aforementioned customer objects. When the teller has completed a task they take the next available customer (or task). 

There are extra customer and task arrivals which are handled in their own respective .txt files. Both total throughtime for the simulation as well as the number of customers who have been serviced is recorded throughout the simulation.

Platform: Windows

IDE: Eclipse

Language: Java
