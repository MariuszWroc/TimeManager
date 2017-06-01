package com.desktopmanager.util;

import java.io.IOException;

/**
 * @author Mariusz Czarny
 *
 */
public final class FileUtilFactory {

	private FileUtilFactory() {
	}
	
	public final static boolean getIsCatalog(String path) throws IOException {
		return new FileUtil().isCatalog(path);
	}
	
	public final static boolean getIsFile(String path) throws IOException  {
		return new FileUtil().isFile(path);
	}
	
	public final static boolean getIsDeleteFile(String path) throws IOException  {
		return new FileUtil().deleteFile(path);
	}
}
