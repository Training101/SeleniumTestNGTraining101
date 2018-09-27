# Local Selenium Grid
### Setting up the Hub
```
java -jar selenium-server-standalone-2.41.0.jar -role hub
```
### Setting up the Node
```
java -jar selenium-server-standalone-3.14.0.jar -role node -hub http://localhost:4444/grid/register -port 8586
```
Optional : Configure the browsers and maxx instances
```
java –jar -Dwebdriver.chrome.driver=./chromedriver.exe selenium-server-standalone-2.41.0.jar -role webdriver –hub http://localhost:4444/grid/register -port 8586 -browser browserName=chrome,maxInstances=3
```
Check the grid console configuration
[http://localhost:4444/grid/console](http://localhost:4444/grid/console)

# Docker Selenium Grid
### Pull and start the Hub
```
docker run -d -p 4444:4444 --name selenium-hub selenium/hub
```
This command will,
1. Check if the image is available in ocal machine
2. If not, pull the image from docker hub
3. Extract and start the container as a Grid Hub

Check the grid console configuration
[http://192.168.99.100:4444/grid/console](http://192.168.99.100:4444/grid/console)

### Pull and start a Node
```
docker run -d –-link selenium-hub:hub selenium/node-chrome
```

# Useful Docker commands
#### stop all docker containers
```
docker kill $(docker ps -q)
```
#### remove all containers
```
docker rm $(docker ps -a -q)
```

#### remove all docker images
```
docker rmi $(docker images -q)
```


