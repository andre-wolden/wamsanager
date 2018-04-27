#!/bin/bash
# author: Andre Wolden

export JDBC_DATABASE_USERNAME="localuser"
export JDBC_DATABASE_PASSWORD="password"

mvn clean install
java -jar target/wamsanager-0.0.1-SNAPSHOT.jar

# END
