package com.desktopmanager.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.util.FileUtil;

public class FileUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FileUtilTest.class);
	private static FileUtil fileUtil;
	private static String filePath;
	private static String wrongPath;
	private static String catalogPath;
	private static String fileToDeletePath;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String applicationPath = new File(".").getCanonicalPath();
		fileUtil = new FileUtil();
		catalogPath = applicationPath + "/src/test/resources/";
		filePath = catalogPath + "testFile.txt";
		fileToDeletePath = catalogPath + "fileToRemove.txt";
		wrongPath = catalogPath + "nofile.txt";
		logger.info(filePath);
		
		logger.info(catalogPath);
	}

	@Test
	public void testIsCatalog() throws IOException {
		assertEquals(true, fileUtil.isCatalog(catalogPath));
	}

	@Test
	public void testIsFile() throws IOException {
		assertEquals(true, fileUtil.isFile(filePath));
	}

	@Test
	public void testCanDeleteFile() throws IOException {
//		assertEquals(true, fileUtil.deleteFile(fileToDeletePath));
	}
	
	@Test
	public void testIsNotCatalog() throws IOException {
		assertEquals(false, fileUtil.isCatalog(filePath));
	}

	@Test
	public void testIsNotFile() throws IOException {
		assertEquals(false, fileUtil.isFile(wrongPath));
	}

	@Test
	public void testCannotDeleteFile() throws IOException {
		assertEquals(false, fileUtil.deleteFile(wrongPath));
	}

}
