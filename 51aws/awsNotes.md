## a few fancy terms and their abbreviations

* EC2 = Elastic Compute Cloud = virtual machines in aws cloud
* EBS = Elastic Block Store = storage for EC2

## setting up a web server (apache) in an EC2 instance (use ***docker*** instead)

<pre>
$sudo su                    # for root access
$yum update -y              # updating the package manager
$yum install httpd          # to install apache web server
$systemctl start httpd      # to run our web server
</pre>

## IaaS and PaaS

* IaaS: Infrastructure as a Service: use only infrastructure from cloud provider
    ex: using VM to deploy ur apps/dbs
    you do the most things

* **PaaS**: Platform as a Service: use a platform provided by the cloud
    ex: AWS Elastic Beanstalk, Azure App Service, Google App Engine
    you are only responsible for your core of the application


## Elastic Beanstalk

* An awesome way to store/deploy apps in cloud. (again, use docker)

## Microservices & Docker Containers
+Flexibility to innovate and BUILD APPS IN DIFFERENT PROGRAMMING LANGUAGES (this is awesome and we may need it for kss, i dont wanna rewrite stuff)

-Deployments become complex :(

= use docker= diff langs and deployments are not complex

Container Orchestiration in AWS = Amazon ECS, cannot use on free tier tho.

## Serverless (AWS Lambda)

* pay for use, the more request u get the more you pay <br>
* there is a server in background what you dont care about it and its infrastructure etc.
* this may be ideal for the kss functions i was thinking to run on a server. since they are only little isolated js projects, they may not need a server.

## Deploying Apps
see the <a style="color:red;" href="https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners/">  Java Spring Boot course part 23, </a> for details of a specific deployment  <br>

in application.properties, server.port= 5000, then go elastic beanstalk, upload the project and voila, the app is ready.

## Deploying Docker Apps with MySQL Connection

<pre>
$docker run --detach --env MYSQL_ROOT_PASSWORD=pwd --env OTHER_ENVS= value --name mySql --publish 3306:3306 mysql:8-oracle

$mysqlsh
$ \connect user@localhost:3306
$ \sql
$ use db_name
$ select * from user_details;
$ \quit

then deploy the app itself to elastic beanstalk
</pre>

## Full Stack Deployments
* Deploy backend and frontend seperately