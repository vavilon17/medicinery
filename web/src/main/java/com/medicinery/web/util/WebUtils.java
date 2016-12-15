package com.medicinery.web.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class WebUtils {

    public static MediaType mediaTypeByExtention(String ext) {
        if ("png".equalsIgnoreCase(ext)) {
            return MediaType.IMAGE_PNG;
        } else if ("jpg".equalsIgnoreCase(ext) || "jpeg".equalsIgnoreCase(ext)) {
            return MediaType.IMAGE_JPEG;
        } else if ("txt".equalsIgnoreCase(ext)) {
            return MediaType.TEXT_PLAIN;
        } else if ("xml".equalsIgnoreCase(ext)) {
            return MediaType.TEXT_XML;
        }
        return MediaType.TEXT_HTML;
    }

    public static HttpEntity<byte[]> prepareBinaryEntity(byte[] data, String ext, String cacheHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(WebUtils.mediaTypeByExtention(ext));
        headers.setContentLength(data.length);
        headers.setCacheControl(cacheHeader);
        return new HttpEntity<>(data, headers);
    }
}
