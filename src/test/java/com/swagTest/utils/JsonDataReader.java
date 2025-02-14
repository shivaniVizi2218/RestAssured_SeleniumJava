package com.swagTest.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonDataReader {

    private JsonNode rootNode;

    public JsonDataReader(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }
            rootNode = mapper.readTree(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JSON file: " + fileName, e);
        }
    }

    public String getTitle() {
        if (rootNode == null) {
            throw new RuntimeException("Root node is null. Ensure JSON file is loaded properly.");
        }
        return rootNode.path("title").path("swagLabsTitle").asText();
    }

}
