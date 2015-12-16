#!/usr/bin/env bash
mvn clean compile
HOSTNAME=`hostname`

HOSTNAME=`echo $HOSTNAME | awk '{print tolower($0)}'`

MAVEN_OPTS="-server -Xmx5G"

#                                                       numberOfItems valueSizeKB $HOSTNAME
mvn exec:java -Dexec.mainClass="test.Node" -Dexec.args=" 1000             1      $HOSTNAME"