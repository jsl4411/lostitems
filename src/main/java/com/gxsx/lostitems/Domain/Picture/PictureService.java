package com.gxsx.lostitems.Domain.Picture;

public interface PictureService {

    Picture findById(long picture_seq);

    String write(Picture picture);

    String deleteById(Long picture_seq);
}
