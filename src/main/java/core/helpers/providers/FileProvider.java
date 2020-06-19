package core.helpers.providers;

import core.helpers.Log;

import java.io.File;
import java.io.IOException;

public class FileProvider {

    public static String getRootDirectoryPath() {
        try {
            return new File(".").getCanonicalPath();
        } catch (IOException e) {
            Log.error("Could not get common folder path. Original exception: " + e.getMessage());
            return ".." + File.separator + "common";
        }
    }
}
