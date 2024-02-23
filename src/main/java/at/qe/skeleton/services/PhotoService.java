package at.qe.skeleton.services;

import at.qe.skeleton.model.Photo;
import org.hibernate.annotations.PolymorphismType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//@Named
@Component
@ApplicationScoped
public class PhotoService {

    private List<Photo> photos;
    private File srcPath;
    private List<String> names;
    private List<String> photoSrcPaths;

    @PostConstruct
    public void init() {
        photos = new ArrayList<>();
        srcPath = new File("src\\main\\webapp\\WEB-INF\\photos\\mainPageContainer");
        names = new ArrayList<>();
        photoSrcPaths = new ArrayList<>();

        getPhotoNamesFromFile(srcPath, names);
        generatePhotoSrcPaths(srcPath, names, photoSrcPaths);
        addPhoto(photoSrcPaths, photos);
    }

    public List<Photo> getPhotos() {
        return photos;
    }
    
    public void getPhotoNamesFromFile(File src, List<String> names){
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    names.add(file.getName());
                }
            }
        }
    }

    public void generatePhotoSrcPaths(File src, List<String> fileNames, List<String> photoSrcPaths){
        String srcPath = src.getPath();

        for (String name: fileNames) {
            photoSrcPaths.add(srcPath + "\\" + name);
        }
    }

    public void addPhoto(List<String> paths, List<Photo> photoList){
        for (String path : paths) {
            photoList.add(new Photo(path,path, "Issue", "Title"));
        }
    }
}