package com.gxsx.lostitems.Domain.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public Picture findById(long picture_seq) {

        return pictureRepository.findById(picture_seq).orElse(null);
    }

    @Override
    @Transactional
    public String write(Picture picture) {
        pictureRepository.save(picture);
        return "success";
    }

    @Override
    public String deleteById(Long picture_seq) {
        pictureRepository.deleteById(picture_seq);
        return "success";
    }
}
