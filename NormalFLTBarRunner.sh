#!/bin/bash

bugDataPath=$1
bugID=$2
targetClasses=$3
targetTestClasses=$4
targetMainJava=$5
targetTestJava=$6
suspiciousCodeLoc=$7
projectWithoutGit=$8
bearsord4j=$9

java -Xmx1g -cp "target/dependency/*" edu.lu.uni.serval.tbar.main.Main $bugDataPath $bugID $targetClasses $targetTestClasses $targetMainJava $targetTestJava $suspiciousCodeLoc $projectWithoutGit $bearsord4j