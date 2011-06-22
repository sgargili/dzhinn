package plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @author Andrey Popov creates on 22.06.11 (19:07)
 */
public class First extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, world.");
        System.out.println("HHHHHHHHHHHHHHHHHH");
    }
}
