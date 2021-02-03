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
mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Bears-98 /target/classes/ /target/test-classes/ /src/ /test/ SuspiciousCodePositions/Lang_33/B98Ochaii.txt withgit
 */

  /* Lang_33 d4j
mvn install && rm target/dependency/TBar-0.0.1-SNAPSHOT.jar && cp target/TBar-0.0.1-SNAPSHOT.jar target/dependency/ && ./NormalFLTBarRunner.sh D4J/projects/ Lang_33 /target/classes/ /target/test-classes/ /src/main/java/ /src/test/java/ SuspiciousCodePositions/Lang_33/Ochiai.txt withgit
 */

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
