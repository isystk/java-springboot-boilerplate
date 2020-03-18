#! /bin/bash

PJT_HOME=$(dirname $0)/..
JAVA_HOME=/Applications/Eclipse_4.8.0.app/Contents/java/8/Home
MAVEN_HOME=$PJT_HOME/tools/maven

export JAVA_HOME=$JAVA_HOME

PATH=$JAVA_HOME/bin:$PATH
PATH=$MAVEN_HOME/bin:$PATH

cd $(dirname $0)
mvn -X -U eclipse:clean eclipse:eclipse -P ut -f pom.xml
