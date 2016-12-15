package com.medicinery.core.service;

import java.io.IOException;

public interface ResourcesService {

    byte[] imageContent(String section, String fileName) throws IOException;

    byte[] getFileForSe(String name) throws IOException;
}
