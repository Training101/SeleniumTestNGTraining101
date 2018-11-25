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

#### Start an existing container
```
docker start selenium-hub
```

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
