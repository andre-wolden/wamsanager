#!/bin/bash
# author: Andre Wolden


# export SPRING_DATASOURCE_URL="jdbc:postgresql://localhost/wamsanagerbase"
#export SPRING_DATASOURCE_USERNAME="localuser"
#export SPRING_DATASOURCE_PASSWORD="password"

mvn clean install
java -jar target/wamsanager-0.0.1-SNAPSHOT.jar

# END
