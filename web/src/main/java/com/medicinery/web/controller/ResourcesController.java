package com.medicinery.web.controller;

import com.medicinery.core.service.ResourcesService;
import com.medicinery.core.util.Utils;
import com.medicinery.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/resources")
public class ResourcesController {

    private static final Logger log = LoggerFactory.getLogger(ResourcesController.class);

    @Autowired
    private ResourcesService resourcesService;

    @ResponseBody
    @RequestMapping(value = "/image/{section}/{fakeName:.+}", method = RequestMethod.GET)
    public HttpEntity<byte[]> productImage(@PathVariable String section, @PathVariable String fakeName) {
        try {
            String realFileName = Utils.translit(fakeName.toLowerCase());
            String ext = realFileName.split("\\.")[1];
            byte[] data = resourcesService.imageContent(section, realFileName);
            return WebUtils.prepareBinaryEntity(data, ext, "public, must-revalidate");
        } catch (IOException ioEx) {
            log.error("Error while providing an image for section '" + section + "' and fakeFileName '"
                    + fakeName + "': ", ioEx);
            return new HttpEntity<>(new byte[0]);
        }
    }
}
