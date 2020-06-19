package core.helpers.utils;

import core.helpers.providers.PropertyProvider;

import static core.helpers.enums.CoreEnums.ApplicationProperty;
import static core.helpers.utils.FilePathUtils.getApplicationPropertiesPath;

public class PropertyUtils {

    public static String getApplicationProperty(ApplicationProperty property) {
        return PropertyProvider.getProperty(getApplicationPropertiesPath(), property.toString());
    }
}
