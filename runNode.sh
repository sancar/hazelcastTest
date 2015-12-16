#!/usr/bin/env bash
mvn clean compile
HOSTNAME=`hostname`

HOSTNAME=`echo $HOSTNAME | awk '{print tolower($0)}'`

MAVEN_OPTS="-server -Xmx8G"

#                                                       numberOfItems valueSizeKB $HOSTNAME
mvn exec:java -Dexec.mainClass="test.Node" -Dexec.args=" 15000000           1000  $HOSTNAME"