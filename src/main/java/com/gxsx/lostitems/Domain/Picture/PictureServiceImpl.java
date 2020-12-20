package com.gxsx.lostitems.Domain.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureRepository pictureRepository;

}
