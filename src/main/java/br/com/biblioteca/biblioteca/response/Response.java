package br.com.biblioteca.biblioteca.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Response<T> {

    public T data;
    public String message;
    public boolean success;
}
