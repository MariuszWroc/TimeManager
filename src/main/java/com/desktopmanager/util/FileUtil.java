package com.desktopmanager.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mariusz Czarny
 *
 */
public class FileUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class.getName());
	
	public boolean isCatalog(String path) throws IOException {
		Path fileLocator = Paths.get(path);
		if (Files.isDirectory(fileLocator)) {
			LOGGER.info("Path {} is a directory.", path);
			return true;
		} else {
			LOGGER.info("Path {} is not a directory.", path);
			return false;
		}
	}

	public boolean isFile(String path) throws IOException {
		Path fileLocator = Paths.get(path);
		if (Files.exists(fileLocator, LinkOption.NOFOLLOW_LINKS)) {
			LOGGER.info("File {} exist.", path);
			return true;
		}
		else if (Files.notExists(fileLocator, LinkOption.NOFOLLOW_LINKS)) {
			LOGGER.info("File {} is not exist..", path);
			return false;
		} else {
			LOGGER.error("Propably no access to file!");
			return false;
		}
	}
	
	public boolean deleteFile(String path) throws IOException {
		Path fileLocator = Paths.get(path);

		if (Files.deleteIfExists(fileLocator)) {
			LOGGER.info("File {} is deleted.", path);
			return true;
		} else {
			LOGGER.info("Delete operation for file {} is failed", path);
			return false;
		}
	}
}
