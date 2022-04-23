package practice;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;

import junit.framework.Assert;

public class APITest {
	 private static String HOME = System.getProperty("user.home");
	    private static String PLAY_WITH_NIO = "TempPlayGround";

	    @SuppressWarnings("deprecation")
		@Test
	    public void givenPathWhenCheckedThenConfirm() throws IOException {
	       
	        Path homePath = Paths.get(HOME);
	        Assert.assertTrue(Files.notExists(homePath));

	        
	        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
	        if (Files.exists(playPath)) FileUtils.filesDelete(playPath.toFile());
	        Assert.assertTrue(Files.exists(playPath));

	        
	        Files.createDirectory(playPath);
	        Assert.assertTrue(Files.exists(playPath));

	        
	        IntStream.range(1, 10).forEach(cntr -> {
	            Path tempFile = Paths.get(playPath + "/temp" + cntr);
	            Assert.assertTrue(Files.notExists(tempFile));
	            try {
	                Files.createFile(tempFile);
	            } catch (IOException e) {
	            }
	            Assert.assertTrue(Files.notExists(tempFile));
	        });

	         
	        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
	        Files.newDirectoryStream(playPath).forEach(System.out::println);
	        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString()
	                .startsWith("temp")).forEach(System.out::println);
	    }	
	   
}
