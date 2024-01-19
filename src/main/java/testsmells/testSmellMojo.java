package testsmells;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal that runs the precompiled JAR.
 *
 * @goal run-jar
 */
public class testSmellMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        getLog().info("Starting HTMLTestSmellDetector plugin...");
        try {
            ProcessBuilder builder = new ProcessBuilder("java", "-jar", "HTMLTestSmellDetector.jar", "input.csv");
            Process process = builder.start();
            process.waitFor();
            // Handle input and output streams as needed
        } catch (Exception e) {
            getLog().info("HTMLTestSmellDetector plugin: Exception: ");

            throw new MojoExecutionException("Error running JAR", e);
        }
    }
}
