package lelental.imager.service;

import lelental.imager.dao.IPictureRepository;
import lelental.imager.dao.IUserRepository;
import lelental.imager.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pictureService")
public class IPictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public List<Picture> findByUserId(long userId) {
        return pictureRepository.findByUserId(userId);
    }

    @Override
    public void deleteById(long id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public void savePicture(Picture picture) {
        pictureRepository.save(picture);
    }
}
