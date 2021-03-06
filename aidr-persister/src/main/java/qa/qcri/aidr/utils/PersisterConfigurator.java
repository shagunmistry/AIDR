package qa.qcri.aidr.utils;

import org.apache.log4j.Logger;

import qa.qcri.aidr.common.code.impl.BaseConfigurator;
import qa.qcri.aidr.common.exception.DirectoryNotWritableException;

/**
 * User: yakubenkova.elena@gmail.com Date: 29.09.14
 */
public class PersisterConfigurator extends BaseConfigurator {

	private static final Logger LOGGER = Logger.getLogger(PersisterConfigurator.class);

	public static final String configLoadFileName = "config.properties";

	private static final PersisterConfigurator instance = new PersisterConfigurator();

	private PersisterConfigurator() throws DirectoryNotWritableException {
		LOGGER.info("Instantiating PersisterConfigurator.");
		this.initProperties(configLoadFileName, PersisterConfigurationProperty.values());
		
		this.directoryIsWritable(PersisterConfigurationProperty.DEFAULT_PERSISTER_FILE_PATH.getName());
	}

	public static PersisterConfigurator getInstance() {
		return instance;
	}
}
