#!/bin/sh

# javac src/destination/*.java src/encryption/*.java src/translator/*.java src/userActivities/*.java
# javac src/destination/*.java src/encryption/*.java src/userActivities/*.java

cd src

javac destination/Destination.java
javac destination/Landmark.java
javac destination/Location.java
javac destination/User.java
javac encryption/BCrypt.java

javac userActivities/Credentials.java
javac userActivities/Dest.java
javac userActivities/Persistence.java
javac userActivities/Travel.java

java userActivities/Travel
