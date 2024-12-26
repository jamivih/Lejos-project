Lego Line Follower Robot Project

This repository contains the implementation of a Lego Mindstorms EV3 robot programmed to follow a line, detect objects, and avoid obstacles. The project showcases teamwork and the application of object-oriented programming (OOP) principles, threading, and sensor integration.
Features and Functionality

The robot is programmed to achieve the following:

    Line Following:
        Utilizes a color sensor to detect light intensity and differentiate between black and white thresholds.
        Adjusts motor speeds to stay on the line.

    Object Detection:
        Employs an ultrasonic sensor to measure distances and identify obstacles within a set threshold.

    Obstacle Avoidance:
        Stops line-following temporarily.
        Executes a pre-programmed series of movements to bypass the object.
        Resumes line-following after avoiding the obstacle.

    Threading and Communication:
        Implements multithreading for sensor data handling and motor control.
        Uses a DataExchange class to facilitate communication between threads.

    Sound Effects:
        Plays sound effects during specific events, such as obstacle detection or program shutdown, for added feedback.

    Behavior Logic:
        Stops the robot if an obstacle is detected twice during operation.
        Includes safety features like an emergency stop triggered by a button press.
