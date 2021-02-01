package edu.lu.uni.serval.tbar.dataprepare;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.lu.uni.serval.tbar.utils.FileHelper;
import edu.lu.uni.serval.tbar.utils.JavaLibrary;
import edu.lu.uni.serval.tbar.utils.PathUtils;

/**
 * Prepare data for fault localization, program compiling and testing.
 * 
 * @author kui.liu
 *
 */
public class DataPreparer {

    private String buggyProjectParentPath;
    
    public String classPath;
    public String srcPath;
    public String testClassPath;
    public String testSrcPath;
    public List<String> libPaths = new ArrayList<>();
    public boolean validPaths = true;
    public String[] testCases;
    public URL[] classPaths;
    
    public DataPreparer(String path){
        if (!path.endsWith("/")){
            path += "/";
        }
        buggyProjectParentPath = path;
    }
    
    public void prepareData(String buggyProject,ArrayList<String> pathsFromCmdLine){
//		libPath.add(FromString.class.getProtectionDomain().getCodeSource().getLocation().getFile());
//		libPath.add(EasyMock.class.getProtectionDomain().getCodeSource().getLocation().getFile());
//		libPath.add(IOUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		
		loadPaths(buggyProject,pathsFromCmdLine);
		
		if (!checkProjectDirectories()){
			validPaths = false;
			return;
		}
		
		loadTestCases();
		
		loadClassPaths();
    }

	private void loadPaths(String buggyProject,ArrayList<String> pathsFromCmdLine) {
		String projectDir = buggyProjectParentPath;
		List<String> paths = pathsFromCmdLine;

		/*
				path.add("/target/classes/");
				path.add("/target/test-classes/");
				path.add("/src/main/java/");
				path.add("/src/test/java/");

		*/
		classPath = projectDir + buggyProject + paths.get(0);
		testClassPath = projectDir + buggyProject + paths.get(1);
		srcPath = projectDir + buggyProject + paths.get(2);
		testSrcPath = projectDir + buggyProject + paths.get(3);

		List<File> libPackages = new ArrayList<>();
		if (new File(projectDir + buggyProject + "/lib/").exists()) {
			libPackages.addAll(FileHelper.getAllFiles(projectDir + buggyProject + "/lib/", ".jar"));
		}
		if (new File(projectDir + buggyProject + "/build/lib/").exists()) {
			libPackages.addAll(FileHelper.getAllFiles(projectDir + buggyProject + "/build/lib/", ".jar"));
		}
		//New from aprorg TBar
		if (new File(projectDir + buggyProject + "/build/libs/lib").exists()) {
			libPackages.addAll(FileHelper.getAllFiles(projectDir + buggyProject + "/build/libs/lib", ".jar"));
		}
		if (new File(projectDir + buggyProject + "/target/dependency/").exists()) {
			libPackages.addAll(FileHelper.getAllFiles(projectDir + buggyProject + "/target/dependency/", ".jar"));
			System.err.println("libPackages Exist");
		}
		
		//System.out.println("projectDir: "+projectDir+"buggyProject: "+buggyProject);

		if (new File(projectDir + buggyProject + "/target/lib").exists()) {
			libPackages.addAll(FileHelper.getAllFiles(projectDir + buggyProject + "/target/lib/", ".jar"));
			//System.err.println("libPackages Exist");
		}

		for (File libPackage : libPackages) {
			//System.err.println("libpackages add"+libPackage);
			libPaths.add(libPackage.getAbsolutePath());
		}
		//System.err.println("Slutar");
		//System.exit(0);
	}
	
	private boolean checkProjectDirectories() {
		if (!new File(classPath).exists()) {
			System.err.println("Class path: " + classPath + " does not exist!");
			return false;
		}
		if (!new File(srcPath).exists()) {
			System.err.println("Source code path: " + srcPath + " does not exist!");
			return false;
		}
		if (!new File(testClassPath).exists()) {
			System.err.println("Test class path: " + testClassPath + " does not exist!");
			return false;
		}
		if (!new File(testSrcPath).exists()) {
			System.err.println("Test source path: " + testSrcPath + " does not exist!");
			return false;
		}
		return true;
	}

	private void loadTestCases() {
		testCases = new TestClassesFinder().findIn(JavaLibrary.classPathFrom(testClassPath + ":" + classPath), false);
//		List<File> testCasesFiles = FileHelper.getAllFiles(testClassPath, ".class");
////		testCasesFiles.addAll(FileHelper.getAllFiles(testClassPath, "Tests.class"));
//		StringBuilder b = new StringBuilder();
//		List<String> testCaseNames = new ArrayList<>();
//		int i = testCasesFiles.get(0).getPath().indexOf(testClassPath) + testClassPath.length();
//		for (File file : testCasesFiles) {
//			String fileName = file.getName();
//			if (fileName.contains("Test") && !fileName.contains("$")) {
////			if (fileName.startsWith("Test") || fileName.endsWith("Test.class")) {//Time
//				String filePath = file.getPath();
//				filePath = filePath.substring(i, filePath.lastIndexOf(".")).replace("/", ".");
//				testCaseNames.add(filePath);
//				b.append(filePath).append("\n");
//			}
//		}
//		FileHelper.outputToFile("log/testcases_2.txt", b, false);
//		testCases = testCaseNames.toArray(new String[testCaseNames.size()]);
		Arrays.sort(testCases);
	}

	private void loadClassPaths() {
		classPaths = JavaLibrary.classPathFrom(testClassPath);
		classPaths = JavaLibrary.extendClassPathWith(classPath, classPaths);
		if (libPaths != null) {
			for (String lpath : libPaths) {
				classPaths = JavaLibrary.extendClassPathWith(lpath, classPaths);
			}
		}
	}
    
}
