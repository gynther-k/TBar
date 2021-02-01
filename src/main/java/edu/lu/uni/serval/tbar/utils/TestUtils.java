package edu.lu.uni.serval.tbar.utils;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList; 
import java.util.List;
import java.io.FileReader;
import edu.lu.uni.serval.tbar.config.Configuration;



public class TestUtils {
    
/* Mvn build success:
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running org.apache.commons.lang3.mutable.MutableByteTest
Tests run: 14, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec

Results :

Tests run: 1670, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.793 s
[INFO] Finished at: 2021-01-28T17:53:52+01:00
[INFO] ------------------------------------------------------------------------
*/


/* Mvn build failure
Results :

Failed tests: 
  testReflectionLongArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionIntArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionShortArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionyteArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionCharArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionDoubleArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionFloatArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionBooleanArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionFloatArrayArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionLongArrayArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionIntArrayArray(org.apache.commons.lang3.builder.ToStringBuilderTest)
  testReflectionhortArrayArray(org.apache.commons.lang3.builder.ToStringBuilderTest)

Tests in error: 
  testToClass_object(org.apache.commons.lang3.ClassUtilsTest)

Tests run: 1670, Failures: 12, Errors: 1, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE

*/

	public static int getFailTestNumInProject(String projectName, List<String> failedTests){
        //String testResult = getDefects4jResult(projectName, defects4jPath, "test");
        
        String testResult = getProjectResultTest(projectName,"test");

        try {
        //File fileTestOutput = new File("/home/gynther/Desktop/thesisJan28LocalStartChange/TBar/D4J/projects/Lang_33/testOutput.txt"); 
        File fileTestOutput = new File(Configuration.GLOBAL_TEMP_FILES_PATH+"testOutPut.txt"); 

        BufferedReader br = new BufferedReader(new FileReader(fileTestOutput)); 
        String st; 
        List<String> failedTestCmdLine = new ArrayList<>();
        List<String> errorTestCmdLine = new ArrayList<>();
        boolean readFailedtests = false;
        boolean readErrortests = false;
        boolean buildSuccess = false;
        int lineCount = 0;

        while ((st = br.readLine()) != null)
        {
            lineCount++;
            System.err.println(st); 

            //Failed tests
            if(readFailedtests && !st.trim().isEmpty()) //2. Read the lines
            {
                String[] splittedStrings = st.trim().split("\\(");
                System.err.println(splittedStrings[0]);
                System.err.println(splittedStrings[1]);
                
                String testIndividual = splittedStrings[0];
                String testClass = splittedStrings[1].replaceAll("[()]", "");

                //System.err.println(testClass);
                //System.err.println(testIndividual);

                failedTestCmdLine.add(testClass+"::"+testIndividual);
            }
            if(st.contains("Failed tests:")) //1. Get subject
            {
                readFailedtests=true;
                failedTestCmdLine.clear();
            }
            if(readFailedtests && st.trim().isEmpty()){ //3. Stop reading
                readFailedtests=false;
            }

            //Tests in error:
            if(readErrortests && !st.trim().isEmpty()) //2. Read the lines
            {
                String[] splittedStringsE = st.trim().split("\\(");
                System.err.println(splittedStringsE[0]);
                System.err.println(splittedStringsE[1]);
                String[] splittedStringsClassE = splittedStringsE[1].trim().split("\\)");

                
                String testIndividualE = splittedStringsE[0];
                //String testClassE = splittedStringsE[1].replaceAll("[()]", "");
                String testClassE = splittedStringsClassE[0].trim();

                System.err.println(testIndividualE);
                System.err.println(testClassE);

                errorTestCmdLine.add(testClassE+"::"+testIndividualE);
            }
            if(st.contains("Tests in error:")) //1. Get subject
            {
                readErrortests=true;
                errorTestCmdLine.clear();
            }
            if(readErrortests && st.trim().isEmpty()){ //3. Stop reading
                readErrortests=false;
            }



            if(st.contains("BUILD SUCCESS"))
            {
                buildSuccess=true;
                System.out.println("BUILD SUCESSXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
            if(st.contains("BUILD FAILURE"))
            {
                System.out.println("BUILD faiilllureeeeeeeXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
        }

        System.err.println("sizeoferrortest"+errorTestCmdLine.size());
        System.err.println("sizeoffailtest"+failedTestCmdLine.size());
        fileTestOutput.delete();

        int errorNum=0;

        if (lineCount<2){//error occurs in run
            return Integer.MAX_VALUE;
        }
        if(buildSuccess)
        {
            return 0;
        }
        /*if (!testResult.contains("Failing tests:")){
            return Integer.MAX_VALUE;
        }*/
        /*int errorNum = 0;
        String[] lines = testResult.trim().split("\n");
        for (String lineString: lines){
            if (lineString.startsWith("Failing tests:")){
                errorNum =  Integer.valueOf(lineString.split(":")[1].trim());
                if (errorNum == 0) break;
            } else if (lineString.startsWith("Running ")) {
            	break;
            } else {
            	failedTests.add(lineString.trim());
            }
        }*/

        if(errorTestCmdLine.size()>0) //Error has priority
        {
            failedTests.addAll(errorTestCmdLine);
            errorNum=errorTestCmdLine.size();
        }
        else{
            failedTests.addAll(failedTestCmdLine);
            errorNum=failedTestCmdLine.size();
        }

        return errorNum;


        }
        catch(IOException e){
            System.err.println("FAILFILECREATION");
            return Integer.MAX_VALUE;
        }

        //return Integer.MAX_VALUE;

	}
	
//	public static int getFailTestNumInProject(String buggyProject, List<String> failedTests, String classPath,
//			String testClassPath, String[] testCasesArray){
//		StringBuilder builder = new StringBuilder();
//		for (String testCase : testCasesArray) {
//			builder.append(testCase).append(" ");
//		}
//		String testCases = builder.toString();
//		
//		String testResult = "";
//		try {
//			testResult = ShellUtils.shellRun(Arrays.asList("java -cp " + PathUtils.buildClassPath(classPath, testClassPath)
//					+ " org.junit.runner.JUnitCore " + testCases), buggyProject);
//		} catch (IOException e) {
////			e.printStackTrace();
//		}
//		
//        if (testResult.equals("")){//error occurs in run
//            return Integer.MAX_VALUE;
//        }
//        if (!testResult.contains("Failing tests:")){
//            return Integer.MAX_VALUE;
//        }
//        int errorNum = 0;
//        String[] lines = testResult.trim().split("\n");
//        for (String lineString: lines){
//            if (lineString.startsWith("Failing tests:")){
//                errorNum =  Integer.valueOf(lineString.split(":")[1].trim());
//                if (errorNum == 0) break;
//            } else if (lineString.startsWith("Running ")) {
//            	break;
//            } else {
//            	failedTests.add(lineString);
//            }
//        }
//        return errorNum;
//	}
	
	/*public static int compileProjectWithDefects4j(String projectName, String defects4jPath) {
		String compileResults = getDefects4jResult(projectName, defects4jPath, "compile");
		String[] lines = compileResults.split("\n");
		if (lines.length != 2) return 1;
        for (String lineString: lines){
        	if (!lineString.endsWith("OK")) return 1;
        }
		return 0;
    }*/
    
	public static int compileProject(String projectName) {
		String compileResults = getProjectResultCompile(projectName,"compile");
		String[] lines = compileResults.split("\n");
		/*if (lines.length != 2) return 1;
        for (String lineString: lines){
        	if (!lineString.endsWith("OK")) return 1;
        }*/
		return 0;
	}


	/*private static String getDefects4jResult(String projectName, String defects4jPath, String cmdType) {
		try {
			String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
			//which java\njava -version\n
            String result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", defects4jPath + "framework/bin/defects4j " + cmdType + "\n"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            return result.trim();
        } catch (IOException e){
        	e.printStackTrace();
            return "";
        }
    }*/

    private static String getProjectResultCompile(String projectName, String cmdType) {
		try {
            String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
            String result=null;
            if(Configuration.bugDataSet.equals("d4j"))
            {
            
            //which java\njava -version\n
//          String result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", defects4jPath + "framework/bin/defects4j " + cmdType + "\n"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -Dmaven.test.skip clean install"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            //System.exit(0);
            }
            if(Configuration.bugDataSet.equals("bears"))
            {
            result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -V -B -DskipTests=true -Denforcer.skip=true -Dcheckstyle.skip=true -Dcobertura.skip=true -DskipITs=true -Drat.skip=true -Dlicense.skip=true -Dfindbugs.skip=true -Dgpg.skip=true -Dskip.npm=true -Dskip.gulp=true -Dskip.bower=true clean install"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            }

            return result.trim();
        } catch (IOException e){
        	e.printStackTrace();
            return "";
        }
    }
//mvn -V -B -Denforcer.skip=true -Dcheckstyle.skip=true -Dcobertura.skip=true -DskipITs=true -Drat.skip=true -Dlicense.skip=true -Dfindbugs.skip=true -Dgpg.skip=true -Dskip.npm=true -Dskip.gulp=true -Dskip.bower=true test
    private static String getProjectResultTest(String projectName, String cmdType) {
		try {
			String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
			//which java\njava -version\n                                                                                                 //buggyProject will be the name of tempfile.sh
            //String result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", defects4jPath + "framework/bin/defects4j " + cmdType + "\n"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            //System.err.println("cd " + projectName );
            String result=null;
            if(Configuration.bugDataSet.equals("d4j"))
            {
            result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -Dsurefire.junit4.upgradecheck -Dsurefire.rerunFailingTestsCount=3 test | tee "+Configuration.GLOBAL_TEMP_FILES_PATH+"testOutPut.txt"+" -a"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            //String result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -Dsurefire.junit4.upgradecheck -Dsurefire.rerunFailingTestsCount=3 test | tee testOutput.txt -a"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            
            //String result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -Dsurefire.junit4.upgradecheck -Dsurefire.rerunFailingTestsCount=2 test"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//
            //System.err.println("without trim:" + result);

            //mvn -Dsurefire.junit4.upgradecheck -Dsurefire.rerunFailingTestsCount=2 test
            }

            if(Configuration.bugDataSet.equals("bears"))
            {
            
            result = ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "mvn -V -B -Denforcer.skip=true -Dcheckstyle.skip=true -Dcobertura.skip=true -DskipITs=true -Drat.skip=true -Dlicense.skip=true -Dfindbugs.skip=true -Dgpg.skip=true -Dskip.npm=true -Dskip.gulp=true -Dskip.bower=true test | tee "+Configuration.GLOBAL_TEMP_FILES_PATH+"testOutPut.txt"+" -a"), buggyProject, cmdType.equals("test") ? 2 : 1);//"defects4j " + cmdType + "\n"));//

            }


            
            return result.trim();
        } catch (IOException e){
        	e.printStackTrace();
            return "";
        }
    }


	public static String recoverWithGitCmd(String projectName) {
		try {
			String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
            ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "git checkout -- ."), buggyProject, 1);
            return "";
        } catch (IOException e){
            return "Failed to recover.";
        }
	}

	public static String readPatch(String projectName) {
		try {
			String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
            //return ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "git diff"), buggyProject, 1).trim();
            if(!Configuration.NO_GIT)
            {
                return ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "git diff"), buggyProject, 1).trim();
            }
            else{
                return null;
            }
        } catch (IOException e){
            return null;
        }
	}

	public static String checkout(String projectName) {
		try {
			String buggyProject = projectName.substring(projectName.lastIndexOf("/") + 1);
            return ShellUtils.shellRun(Arrays.asList("cd " + projectName + "\n", "git checkout -- ."), buggyProject, 1).trim();
        } catch (IOException e){
            return null;
        }
	}

}
