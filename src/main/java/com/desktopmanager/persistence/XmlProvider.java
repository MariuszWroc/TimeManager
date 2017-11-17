package com.desktopmanager.persistence;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desktopmanager.util.FileUtil;

/**
 *
 * @author Mariusz Czarny
 * @param <T>
 */
public abstract class XmlProvider<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(XmlProvider.class.getName());

	private final Class<T> type;

	protected Class<T> getType() {
		return this.type;
	}

	protected String getClassName() {
		return type.getName();
	}

	@SuppressWarnings("unchecked")
	public XmlProvider() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public StringWriter convertObjectToXML(T entity, String path) {
		StringWriter stringWriter = new StringWriter();

		LOGGER.info("convertObjectToXML with path {}", path);
		try {
			LOGGER.info("start writing..");
			checkIsFileExist(path);

			File file = new File(path);

			LOGGER.info("created file");
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(entity, file);
			jaxbMarshaller.marshal(entity, stringWriter);
		} catch (JAXBException e) {
			LOGGER.info(e.getMessage() + ", " + e);
		}

		return stringWriter;
	}

	private void checkIsFileExist(String path) {
		try {
			FileUtil.useFileUtil(path).isFile();
			// checkDirectory(directory);
		} catch (IOException e) {
			LOGGER.info(e.getMessage() + ", " + e);
		}
	}

	@SuppressWarnings("unchecked")
	public T convertXMLToObject(String path) {
		LOGGER.info("convertXMLToObject");
		T entity = null;

		try {
			File file = new File(path);
			LOGGER.info("open file");
			JAXBContext jaxbContext = JAXBContext.newInstance(type);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			entity = (T) jaxbUnmarshaller.unmarshal(file);
			LOGGER.info("Result of mapping xml is {}", entity);

		} catch (JAXBException e) {
			LOGGER.info(e.getMessage() + ", " + e);
		}

		return entity;
	}

}
