package com.gxsx.lostitems.Domain.Picture;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @Column(nullable = false)
    private Long picture_seq;
    @Column(nullable = false)
    private Long board_seq;
    @Column(nullable = false)
    private String picture_name;
}
