package com.project.errorlog.impl;

import com.google.gson.Gson;
import com.project.errorlog.enums.LogLevel;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteErrorLogImpl implements com.project.errorlog.WriteErrorLog {
    @Override
    public void writeErrorLog(String outputPath) {
        ReadErrorLogImpl readErrorLog = new ReadErrorLogImpl();
        String filePath="input.log";
        Map<LogLevel, List<String>> logMap = readErrorLog.readErrorLog(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            Gson gson = new Gson();
            for (List<String> logEntries : logMap.values()) {
                for (String logEntry : logEntries) {
                    String json = gson.toJson(logEntry);
                    writer.write(json);
                    writer.newLine();
                }
            }
            System.out.println("数据已成功写入文件：" + outputPath);
        } catch (IOException e) {
            System.err.println("写入文件时出现错误：" + e.getMessage());
        }
    }
}
