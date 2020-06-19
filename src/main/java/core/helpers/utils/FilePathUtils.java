package core.helpers.utils;

import core.helpers.providers.FileProvider;

import java.io.File;

public class FilePathUtils {

    public static String getResourcesPath() {
        return FileProvider.getRootDirectoryPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources";
    }

    public static String getPropertiesPath(String fileName) {
        return getResourcesPath() + File.separator + fileName + ".properties";
    }

    public static String getApplicationPropertiesPath() {
        return getPropertiesPath("application");
    }
}
