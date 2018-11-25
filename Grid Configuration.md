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
[Selenium Grid Configurations With Docker](Docker%20Grid%20Configuration.md)

