package githubTask2New;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.zip.ZipOutputStream;

public class LogFileManagement {

	// Part 3: Log File Management

	enum LogType {
	    SYSTEM, CHARGING_STATION, ENERGY_MANAGEMENT
	}

	class LogEntry {
	    private String timestamp;
	    private LogType logType;
	    private String message;

	    public LogEntry(String timestamp, LogType logType, String message) {
	        this.timestamp = timestamp;
	        this.logType = logType;
	        this.message = message;
	    }

	    public String getTimestamp() {
	        return timestamp;
	    }
	    public LogType getLogType() {
	        return logType;
	    }

	    public String getMessage() {
	        return message;
	    }
	}

	class LogFileManager {
	    private Map<LogType, List<LogEntry>> logFiles;

	    public LogFileManager() {
	        logFiles = new HashMap<>();
	        for (LogType logType : LogType.values()) {
	            logFiles.put(logType, new ArrayList<>());
	        }
	    }

	    public void createLogEntry(LogType logType, String message) {
	        String timestamp = getCurrentTimestamp();
	        LogEntry logEntry = new LogEntry(timestamp, logType, message);
	        logFiles.get(logType).add(logEntry);
	    }

	    public void moveLogFile(LogType logType, OutputStream destinationPath) {
	        List<LogEntry> logEntries = logFiles.remove(logType);
	        saveLogEntriesToFile(logEntries, destinationPath);
	    }

	    public void deleteLogFile(LogType logType) {
	        logFiles.remove(logType);
	    }

	    public void archiveLogFile(LogType logType, String archivePath) {
	        List<LogEntry> logEntries = logFiles.remove(logType);
	        ZipOutputStream zipOutputStream = null;
	        try {
	            zipOutputStream = new ZipOutputStream(new FileOutputStream(archivePath));
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	        saveLogEntriesToFile(logEntries, zipOutputStream);
	        try {
	            zipOutputStream.closeEntry();
	            zipOutputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private String getCurrentTimestamp() {
	        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    }

	    private void saveLogEntriesToFile(List<LogEntry> logEntries, OutputStream outputStream) {
	        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
	            for (LogEntry logEntry : logEntries) {
	                writer.write(logEntry.getTimestamp() + " " + logEntry.getLogType() + " " + logEntry.getMessage());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
