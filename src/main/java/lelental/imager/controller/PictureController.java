package lelental.imager.controller;

import lelental.imager.dao.IPictureRepository;
import lelental.imager.model.Picture;
import lelental.imager.model.User;
import lelental.imager.service.IPictureService;
import lelental.imager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PictureController {

    @Autowired
    private IPictureService pictureService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value="/user/add_picture", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByNick(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getNick());
        modelAndView.setViewName("/add_picture");
        return modelAndView;
    }

    @RequestMapping(value = "/user/doUpload", method = RequestMethod.POST)
    public ModelAndView handleFileUpload(HttpServletRequest request,
                                         @RequestParam MultipartFile fileUpload) throws Exception {
        ModelAndView modelAndView = new ModelAndView();


        if (fileUpload.getContentType().equals("image/png") || fileUpload.getContentType().equals("image/jpg")
                || fileUpload.getContentType().equals("image/jpeg") || fileUpload.getContentType().equals("image/gif")) {
            Picture picture = new Picture();
            picture.setName(fileUpload.getOriginalFilename());
            picture.setAddedDate(new Date());
            picture.setPictureData(fileUpload.getBytes());
            picture.setUser(getUser());
            pictureService.savePicture(picture);
        }
        modelAndView.setViewName("/add_picture");
        return modelAndView;
    }

    @RequestMapping(value = "/user/picture_list", method = RequestMethod.GET)
    public ModelAndView showPictures() {
        ModelAndView modelAndView = new ModelAndView();
        List<byte[]> imagesFromDb = new ArrayList<>();
        pictureService.findByUserId(getUser().getId()).forEach(x -> imagesFromDb.add(x.getPictureData()));
        modelAndView.addObject("pics", imagesFromDb);
        modelAndView.setViewName("/picture_list");
        return modelAndView;
    }

    private User getUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByNick(userName);
    }
}
