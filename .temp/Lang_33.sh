cd D4J/projects/Lang_33
mvn -Dsurefire.junit4.upgradecheck -Dsurefire.rerunFailingTestsCount=3 test | tee /tmp/testOutPut.txt -a