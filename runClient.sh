#!/usr/bin/env bash
mvn clean compile
HOSTNAME=`hostname`

HOSTNAME=`echo $HOSTNAME | awk '{print tolower($0)}'`

MAVEN_OPTS="-Xmx1G"

for (( i=0; i<1; i++ ))
do
   #                                                         keyRange threadCount clientId serverId testDurationSeconds warmupDurationSeconds
   mvn exec:java -Dexec.mainClass="test.Client" -Dexec.args="5000          1         $i    $HOSTNAME         10                   5" &
done

