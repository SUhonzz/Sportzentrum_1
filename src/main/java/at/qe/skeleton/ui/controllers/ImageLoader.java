package at.qe.skeleton.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ImageLoader {

    private final ResourceLoader resourceLoader;
    @Autowired
    public ImageLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource loadBackgroundImage(String path) {
        // Load the resource from the classpath (within WEB-INF)
        return resourceLoader.getResource(path);
    }
}
