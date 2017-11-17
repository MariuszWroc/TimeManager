package com.desktopmanager.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Ignore;
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
		catalogPath = applicationPath + "/src/test/resources/";
		filePath = catalogPath + "testFile.txt";
		fileToDeletePath = catalogPath + "fileToRemove.txt";
		wrongPath = catalogPath + "nofile.txt";
		fileUtil = FileUtil.useFileUtil(filePath);
		
		logger.info(filePath);
		
		logger.info(catalogPath);
	}

	@Test
	public void testIsCatalog() throws IOException {
		assertEquals(true, fileUtil.isCatalog());
	}

	@Test
	public void testIsFile() throws IOException {
		assertEquals(true, fileUtil.isFile());
	}

	@Test
	@Ignore
	public void testCanDeleteFile() throws IOException {
		assertEquals(true, fileUtil.deleteFile());
	}
	
	@Test
	public void testIsNotCatalog() throws IOException {
		assertEquals(false, fileUtil.isCatalog());
	}

	@Test
	public void testIsNotFile() throws IOException {
		assertEquals(false, fileUtil.isFile());
	}

	@Test
	public void testCannotDeleteFile() throws IOException {
		assertEquals(false, fileUtil.deleteFile());
	}

}
