#!/bin/bash

bugDataPath=$1
bugID=$2
defects4jHome=$3
targetClasses=$4
targetTestClasses=$5
targetMainJava=$6
targetTestJava=$7
suspiciousCodeLoc=$8

java -Xmx1g -cp "target/dependency/*" edu.lu.uni.serval.tbar.main.Main $bugDataPath $bugID $defects4jHome $targetClasses $targetTestClasses $targetMainJava $targetTestJava $suspiciousCodeLoc