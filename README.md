# string-reply service.
Set of rest apis for string manipulation
# What has been done.
1. Implemented a new service interface for endpoint /v2/reply/{message}. This service is a get method implementation which generates the output based on the requirements provided
# What could have been done better/improved.
1. Exception handling could be better improved with Controller advice for centralised error logging.
2. More Data validations could be added.
3. After dockerisation, could have done pipeline automation using github actions or bitbucket pipelines and eployed in Google cloud run or GKE.
# What has been done as a benificial component
1. Dockerized the application to run as container by adding a gradle build step called docker and writing docker instructions in docker file.
# How to run the application normally.
1. Download the code and run gradlew build and then gradlew bootRun
# How to run the application in docker.
1. Run gradlew docker step. This will generate the docker image.
2. Run "docker run -p 8080:8080 -it stringreply". This will start the container and listen for input in port 8080. 
