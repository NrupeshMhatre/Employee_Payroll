package practice;

import java.io.File;

public class FileUtils {
	 public static boolean filesDelete(File filesToDelete) {
	        File[] allFiles=filesToDelete.listFiles();
	        if(allFiles !=null) {
	            for(File file: allFiles)
	            	filesDelete(file);
	        }
	        return filesToDelete.delete();
}
}
