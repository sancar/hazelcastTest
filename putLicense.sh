#!/usr/bin/env bash
cd src/main/resources/
sed -i "s/KEYHERE/${1}/g" hazelcast.xml
cd ../../../
