package com.gxsx.lostitems.Domain.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/picture")
public class PictureApiController {
    @Autowired
    PictureService pictureService;

    @RequestMapping(value = "/write")
    public String write(Picture picture){
        Picture picture1 = new Picture();

        picture1.setPicture_name("picture1");
        picture1.setBoard_seq(2L);

        return pictureService.write(picture1);
    }
    @RequestMapping(value = "/delete/{picture_seq}")
    public String delete(@PathVariable("picture_seq") Long picture_seq){

        return pictureService.deleteById(picture_seq);
    }
}
