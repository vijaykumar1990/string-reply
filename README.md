# string-reply service.
Set of rest apis for string manipulation
# What has been done.
1. Implemented a new service interface for endpoint /v2/reply/{message}. This service is a get method implementation which generates the output based on the requirements provided below. Also few unit test cases have been written to cover the below requirements.

      The input string will now be comprised of two components, a rule and a string, separated by a dash (-).
      Rules **always** contain two numbers. Each number represents a string operation.

      The supported numbers are:

      - `1`: reverse the string

         E.g. `kbzw9ru` becomes `ur9wzbk`

      - `2`: encode the string via MD5 hash algorithm and display as hex

         E.g. `kbzw9ru` becomes `0fafeaae780954464c1b29f765861fad`

      The numbers are applied in sequence, i.e. the output of the first rule will
      serve as the input of the second rule. The numbers can also be repeated,
      i.e. a rule of 11 would mean reversing the string twice, resulting in no change to the string.

      Giving a few examples,

      ```
      # GET /v2/reply/11-kbzw9ru
      {
          "data": "kbzw9ru"
      }
      ```
      ```
      # GET /v2/reply/12-kbzw9ru
      {
          "data": "5a8973b3b1fafaeaadf10e195c6e1dd4"
      }
      ```
      ```
      # GET /v2/reply/22-kbzw9ru
      {
          "data": "e8501e64cf0a9fa45e3c25aa9e77ffd5"
      }
      ```
# What could have been done better/improved.
1. Exception handling could be better improved with Controller advice for centralised error logging.
2. More Data validations and test cases could be added.
3. After dockerisation, could have done pipeline automation using github actions or bitbucket pipelines and deployed in Google cloud run or GKE.
# What has been done as a benificial component
1. Dockerized the application to run as container by adding a gradle build step called docker and writing docker instructions in docker file.
# How to run the application normally.
1. Download the code and run gradlew build and then gradlew bootRun
# How to run the application in docker.
1. Run "gradlew docker" step. This will generate the docker image.
2. Run "docker run -p 8080:8080 -it stringreply". This will start the container and listen for input in port 8080. 
