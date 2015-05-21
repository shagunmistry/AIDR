package qa.qcri.aidr.collector.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: yakubenkova.elena@gmail.com
 * Date: 29.09.14
 */
public class ConfigProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigProperties.class);
    private static final Properties PROPERTIES = new Properties();

    private static final String CONFIG_PROPERTIES = "config.properties";

    static {
        initProperties();
    }

    private static void initProperties() {
		try (InputStream input = StringUtils.isNotEmpty(System
				.getProperty("config")) ? new FileInputStream(System
				.getProperty("config").toString()) : ConfigProperties.class
				.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);) {
	PROPERTIES.load(input);
        } catch (IOException e) {
            LOGGER.error("Error in reading properties file: " + CONFIG_PROPERTIES, e);
        }
    }

    public static final String getProperty(final String key) {
        return PROPERTIES.getProperty(key);
    }
}

