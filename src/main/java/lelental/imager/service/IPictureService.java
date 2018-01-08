package lelental.imager.service;

import lelental.imager.model.Picture;

import java.util.List;

public interface IPictureService {

    public List<Picture> findByUserId(long userId);

    public Picture deleteById(long id);

    public void savePicture(Picture picture);
}
