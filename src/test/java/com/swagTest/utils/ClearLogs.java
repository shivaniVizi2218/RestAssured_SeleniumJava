package com.swagTest.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClearLogs {
    public static void clearLog() {
        File logFile = new File("logs/test-log.log");
        try (FileWriter writer = new FileWriter(logFile, false)) {
            // Clear the file by writing an empty string to it
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
