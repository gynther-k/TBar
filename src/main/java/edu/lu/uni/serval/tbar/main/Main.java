package edu.lu.uni.serval.tbar.main;

import java.io.File;

import edu.lu.uni.serval.tbar.AbstractFixer;
import edu.lu.uni.serval.tbar.TBarFixer;
import edu.lu.uni.serval.tbar.config.Configuration;
import java.util.ArrayList;

/**
 * Fix bugs with Fault Localization results.
 * 
 * @author kui.liu
 *
 */

 /* Bears-98
xmvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-98 /target/classes/ /target/test-classes/ /src/ /test/ SuspiciousCodePositions/BearsPFL/B98.txt withgit bears none normal no_local_test
 
Bears-2
mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-2 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B2.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test


xmvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-3 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B3.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test


XcORRECT mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-5 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B5.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test

X mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-8 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B8.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test

????? FEL DEPENDENCIE FUNKAR EJ-mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-12 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B12.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-19 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B19.txt withgit bears /home/gynther/.m2/repository/com/fasterxml/ bears2 no_local_test

--- Spoon

ERROR x Hittar ej fil mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-27 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B27.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-27/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

HÄR BÖRJAT TA OMRÅDET RUNTOM: @ @ och metoden

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-32 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B32.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-27/target/,/home/gynther/.m2/repository/javax/ bears2

x Denna is fixed med cd test24/2 - mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-36 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B36.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-36/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal


X mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-38 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B38.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-38/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-42 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B42.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-42/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-46 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B46.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-46/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

xmvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-49 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B49.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-49/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-53 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B53.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-53/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x - funkar ok men kanske fixar error men failure felet som inte kan importa - mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-56 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B56.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-56/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x - kanske impotfail - mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-61 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B61.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-61/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

x mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-70 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B70.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-70/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-73 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B73.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-73/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-76 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B76.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-76/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-78 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B78.txt withgit bears /home/gynther/.m2/repository/org/eclipse/,D4J/projects/Bears-78/target/,/home/gynther/.m2/repository/javax/ bears2 testlocal

------------------ spring-projects-spring-data-commons 

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-87 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B87.txt withgit bears /home/gynther/.m2/repository/org/projectlombok/,/home/gynther/.m2/repository/io/javaslang/,/home/gynther/.m2/repository/com/google/,/home/gynther/.m2/repository/io/,/home/gynther/.m2/repository/org/scala-lang/,/home/gynther/.m2/repository/org/springframework/ bears2 no_local_test

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-88 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B88.txt withgit bears /home/gynther/.m2/repository/org/projectlombok/,/home/gynther/.m2/repository/io/javaslang/,/home/gynther/.m2/repository/com/google/,/home/gynther/.m2/repository/io/,/home/gynther/.m2/repository/org/scala-lang/,/home/gynther/.m2/repository/org/springframework/,/home/gynther/.m2/repository/org/apache/,BearsDeps/lib/ bears2 no_local_test

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-95 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B95.txt withgit bears /home/gynther/.m2/repository/org/projectlombok/,/home/gynther/.m2/repository/io/javaslang/,/home/gynther/.m2/repository/com/google/,/home/gynther/.m2/repository/io/,/home/gynther/.m2/repository/org/scala-lang/,/home/gynther/.m2/repository/org/springframework/,/home/gynther/.m2/repository/org/apache/,BearsDeps/lib/ bears2 no_local_test


x - kankse fel? lägg in maven?- mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-90 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B90.txt withgit bears /home/gynther/.m2/repository/org/projectlombok/,/home/gynther/.m2/repository/io/javaslang/,/home/gynther/.m2/repository/com/google/,/home/gynther/.m2/repository/io/,/home/gynther/.m2/repository/org/scala-lang/,/home/gynther/.m2/repository/org/springframework/,/home/gynther/.m2/repository/org/apache/,BearsDeps/lib/ bears2 no_local_test


 ******

mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-109 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/BearsPFL/B109.txt withgit bears none normal

*/																																																															

  /* Lang_33 d4j
mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Lang_33 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/Lang_33/Ochiai.txt withgit
 */																																																	//org			//org											

public class Main {
	
	public static void main(String[] args) {
		if (args.length < 3) {
			System.err.println("Arguments: \n" 
					+ "\t<Bug_Data_Path>: the directory of checking out Defects4J bugs. \n"
					+ "\t<Bug_ID>: bug id of each Defects4J bug, such as Chart_1. \n"
//					+ "\t<Suspicious_Code_Positions_File_Path>: \n"
//					 +"\t<Failed_Test_Cases_File_Path>: \n"
					+ "\t<defects4j_Home>: the directory of defects4j git repository.\n");
			System.exit(0);
		}
		String bugDataPath = args[0];// "../Defects4JData/"
		String bugId = args[1]; // "Chart_1"

		ArrayList<String> pathsFromCmdLine = new ArrayList<String>(); //add paths manually
		pathsFromCmdLine.add(args[2]);
		pathsFromCmdLine.add(args[3]);
		pathsFromCmdLine.add(args[4]);
		pathsFromCmdLine.add(args[5]);

		String pathToSuspCodeCmdLine = args[6];
		String projecWithoutGit = args[7];
		String bearsord4j = args[8];

		if(projecWithoutGit.equals("nogit"))
		{
			Configuration.NO_GIT=true;
		}

		if(bearsord4j.equals("d4j"))
		{
			Configuration.bugDataSet="d4j";
		}

		//Additional Dependencies per project
		//String incomingDeps = "/home/gynther/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.7.8/";
		String incomingDeps = args[9];

		String readTests = args[10]; //normal or bears2

		String runTestLocally = args[11]; //run tests locally

		if(runTestLocally.equals("testlocal"))
		{
			Configuration.run_tests_locally=true;
		}

		String[] arrSplit = incomingDeps.split(",");
		for (int i=0; i < arrSplit.length; i++)
		{
			//System.err.println(arrSplit[i]);
			Configuration.additionalDepsFromCmdLine.add(arrSplit[i]);
		}
		//System.exit(0);

		if(readTests.equals("bears2"))
		{
			Configuration.testOutputAdapter_for="bears2";
		}
		else{
			Configuration.testOutputAdapter_for="bears";
		}


		//print shell output
		Configuration.ShellVerbose=true;
		Configuration.testVerbose=true;
		//Configuration.testOutputAdapter_for="bears";
	


		System.out.println(bugId);
		fixBug(bugDataPath, bugId,pathsFromCmdLine,pathToSuspCodeCmdLine);
	}

	public static void fixBug(String bugDataPath,String bugIdStr,ArrayList<String> pathsFromCmdLine,String pathToSuspCodeCmdLine) {
		Configuration.outputPath += "NormalFL/";
		String suspiciousFileStr = Configuration.suspPositionsFilePath;
		
		//String[] elements = bugIdStr.split("_");
		//String projectName = elements[0];
		//int bugId;
		//try {
		//	bugId = Integer.valueOf(elements[1]);
		//} catch (NumberFormatException e) {
		//	System.err.println("Please input correct buggy project ID, such as \"Chart_1\".");
		//	return;
		//}
		
		AbstractFixer fixer = new TBarFixer(bugDataPath, bugIdStr,pathsFromCmdLine);
		fixer.dataType = "TBar";
		fixer.metric = Configuration.faultLocalizationMetric;
		fixer.suspCodePosFile = new File(pathToSuspCodeCmdLine); //new File("SuspiciousCodePositions/Lang_33/Ochiai.txt");

		if (Integer.MAX_VALUE == fixer.minErrorTest) {
			System.out.println("Failed to defects4j compile bug " + bugIdStr);
			return;
		}
		
		fixer.fixProcess();
		
		int fixedStatus = fixer.fixedStatus;
		switch (fixedStatus) {
		case 0:
			System.out.println("Failed to fix bug " + bugIdStr);
			break;
		case 1:
			System.out.println("Succeeded to fix bug " + bugIdStr);
			break;
		case 2:
			System.out.println("Partial succeeded to fix bug " + bugIdStr);
			break;
		}
	}

}
