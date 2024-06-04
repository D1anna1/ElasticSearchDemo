package com.project.errorlog.impl;

import com.project.errorlog.ReadErrorLog;
import com.project.errorlog.enums.LogLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadErrorLogImpl implements ReadErrorLog {


    @Override
    public Map<LogLevel, List<String>> readErrorLog(String filePath) {
        Map<LogLevel, List<String>> logMap = new HashMap<>();
        for (LogLevel level : LogLevel.values()) {
            logMap.put(level, new ArrayList<>());
        }

        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                for (LogLevel level : LogLevel.values()) {
                    if (line.contains(level.name())) {
                        logMap.get(level).add(line);
                        break;
                    }else{
                        System.err.println("日志格式不是ERROR或者不存在");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return logMap;
    }
}



