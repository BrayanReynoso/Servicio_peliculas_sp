package com.mx.peliculas.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response <T> {
    private T data;
    private boolean error;
    private int status;
    private String message;
}
