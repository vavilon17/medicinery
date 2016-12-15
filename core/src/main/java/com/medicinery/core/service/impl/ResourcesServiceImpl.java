package com.medicinery.core.service.impl;

import com.medicinery.core.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private Environment env;

    public byte[] imageContent(String section, String fileName) throws IOException {
        String imgBasePath = env.getProperty("medic.img.path");
        return fileContent(imgBasePath + section + "/" + fileName);
    }

    public byte[] getFileForSe(String name) throws IOException {
        String seFilesPath = env.getProperty("se.files.path");
        return fileContent(seFilesPath + name);
    }

    private byte[] fileContent(String inputPath) throws IOException {
        Path path = Paths.get(inputPath);
        return Files.readAllBytes(path);
    }

}
