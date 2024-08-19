package com.zepnds.pos_system.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private Integer id;
    private String isbn;
    private String author;
}
