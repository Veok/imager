package lelental.imager.controller;

import lelental.imager.dao.IPictureRepository;
import lelental.imager.model.Picture;
import lelental.imager.model.User;
import lelental.imager.service.IPictureService;
import lelental.imager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PictureController {

    @Autowired
    private IPictureService pictureService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "Upload";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
                                   @RequestParam MultipartFile fileUpload) throws Exception {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByNick(userName);
        if (fileUpload.getContentType().equals("image/png") || fileUpload.getContentType().equals("image/jpg")
                || fileUpload.getContentType().equals("image/jpeg") || fileUpload.getContentType().equals("image/gif")) {
            Picture picture = new Picture();
            picture.setName(fileUpload.getOriginalFilename());
            picture.setAddedDate(new Date());
            picture.setPictureData(fileUpload.getBytes());
            picture.setUser(user);
            pictureService.savePicture(picture);
        }
        return "Success";
    }
}
