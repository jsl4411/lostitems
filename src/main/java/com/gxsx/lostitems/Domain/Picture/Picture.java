package com.gxsx.lostitems.Domain.Picture;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long picture_seq;
    @Column(nullable = false)
    private Long board_seq;
    @Column(nullable = false)
    private String picture_name;
}
