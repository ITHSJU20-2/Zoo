# Zoo Game
![](https://github.com/ITHSJU20-2/Zoo/workflows/Tests/badge.svg)

A web based zoo keeping "game" written in Java

#### How to run the application (WIP):
* Prerequisites
    * An IDE (Preferably IntelliJ)
    * Time
* Locally
    * Prerequisites
        * A payara server
    1. Change the build configuration of "Zoo Payara" to point to the location of your local payara server
    2. Run the "Zoo Payara" build configuration
* Through Docker
    * Prerequisites
        * A docker client
    * Using the local Dockerfile
        1. Run the "Zoo Docker" build configuration
        2. Through the docker client
            1. Run the image with ports 4848 and 8080 set to your preference of open ports
        3. Deploy the built .war file located in the target folder through the admin interface
    * Using public docker image
        1. TBA