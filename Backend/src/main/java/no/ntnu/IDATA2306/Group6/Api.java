package no.ntnu.IDATA2306.Group6;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api")
public class Api {

    @GetMapping("get/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        Resource r = new ClassPathResource("static/img/" + imageName);

        MediaType type = null;
        String format = imageName.substring(imageName.lastIndexOf('.'));

        switch (format) {
            case ".jpg":
                type = MediaType.IMAGE_JPEG;
                break;
            case ".png":
                type = MediaType.IMAGE_PNG;
                break;
            case ".gif":
                type = MediaType.IMAGE_GIF;
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().contentType(type).body(r);
    }
    

}
