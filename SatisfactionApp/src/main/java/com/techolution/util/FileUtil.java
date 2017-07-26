package com.techolution.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;

import com.techolution.exception.ServiceException;

/**
 * Class is responsible to read data file and keep it for processing.
 * 
 * @author Chandan Behera
 *
 */
public class FileUtil {

	private static Logger logger;
	
	public FileUtil() {
		logger = Logger.getLogger(getClass().getName());
	}
	
	Map<Integer, Integer> fileMap = new LinkedHashMap<>();
	
	/**
	 * Load file data on startup.
	 * @return
	 */
	
	@Bean
	public Map<Integer, Integer> loadFileData()throws ServiceException {
		logger.info("Loading data ... ");
		ClassLoader classLoader = getClass().getClassLoader();
		String file = new File(classLoader.getResource("data.txt").getFile()).toString();
		String line = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length >= 2) {
					Integer key = Integer.parseInt(parts[0].trim());
					Integer value = Integer.parseInt(parts[1].trim());
					fileMap.put(key, value);
				} else {
					System.out.println("ignoring line: " + line);
				}
			}
			System.out.println("file util : " + fileMap);
			return fileMap;

		} catch (Exception e) {
			logger.warning("Error while processing : " + e);
			throw new ServiceException("Error while proecessing file data. " + e.getMessage());
		}
	}
	public Map<Integer, Integer> getFileMap() {
		return fileMap; 
	}
	public void setFileMap(Map<Integer, Integer> fileMap) {
		this.fileMap = fileMap;
	}
	
	
	
}
