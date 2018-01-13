package lelental.imager.service;

import lelental.imager.model.Picture;

import java.util.List;

public interface IPictureService {

    List<Picture> findByUserId(long userId);

    void deleteById(long id);

    void savePicture(Picture picture);
}
