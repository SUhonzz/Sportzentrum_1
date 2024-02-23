package at.qe.skeleton.ui.controllers;

import at.qe.skeleton.services.PhotoService;
import at.qe.skeleton.model.Photo;
import org.primefaces.model.ResponsiveOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Component
@Scope("view")
public class PhotoController implements Serializable {

    private PhotoService photoService;
    //private ImageLoader imageLoader;


    private List<Photo> photos;
    //private List<Photo> resourcePhoto;
    //private List<Resource> resourceList;
    private List<ResponsiveOption> responsiveOptions1;
    private int activeIndex = 0;

    @PostConstruct
    public void init() throws IOException {
        System.out.println("PhotoController Started");
        photos = new ArrayList<>();
        //resourceList = new ArrayList<>();
        //resourcePhoto = new ArrayList<>();
        responsiveOptions1 = new ArrayList<>();

        photos = photoService.getPhotos();



        if(photos.size() == 0){
            System.out.println("Nothing there");
        }else{
            for (Photo pic:photos) {
                System.out.println(pic.getItemImageSrc());
                File file = new File(pic.getItemImageSrc());
                if (file.exists()){
                    System.out.println("File found!");
                }
            }
        }
        responsiveOptions1.add(new ResponsiveOption("1024px", 5));
        responsiveOptions1.add(new ResponsiveOption("768px", 3));
        responsiveOptions1.add(new ResponsiveOption("560px", 1));
    }




        /*
        for (Photo pic : photos) {
            resourceList.add(imageLoader.loadBackgroundImage(pic.getItemImageSrc()));
        }
        for (Resource item : resourceList) {
            try{
                String linkUrl = item.getURL().toString();
                resourcePhoto.add(new Photo(linkUrl, linkUrl, "No working", "Title"));
            } catch (IOException e){
                System.out.println("Error:" + e);
            }


        }
        */





    public List<ResponsiveOption> getResponsiveOptions1() {
        return responsiveOptions1;
    }

    //public List<Photo> getResourcePhoto() {
    //    return resourcePhoto;
    //}

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public void changeActiveIndex() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.activeIndex = Integer.valueOf(params.get("index"));
    }

    @Autowired
    public PhotoController(PhotoService photoService, ResourceLoader resourceLoader) {
        this.photoService = photoService;
        //this.imageLoader = new ImageLoader(resourceLoader);
    }


}
