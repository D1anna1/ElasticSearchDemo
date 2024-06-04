package com.project.errorlog;

import com.project.errorlog.enums.LogLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReadErrorLog {
    Map<LogLevel, List<String>> readErrorLog(String filePath);

}
