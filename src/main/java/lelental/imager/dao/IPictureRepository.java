package lelental.imager.dao;

import lelental.imager.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pictureRepository")
public interface IPictureRepository extends JpaRepository<Picture,Long>{

    List<Picture> findByUserId(long userId);
    void deleteById(long id);
}
