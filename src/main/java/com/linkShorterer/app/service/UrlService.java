package com.linkShorterer.app.service;

import com.linkShorterer.app.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public UrlService (UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }


    //Coge url y la devuevlve acortada
    public String generateShorteredUrl(String originalUrl){

        //generar UUID aleatorio
        UUID uuid = UUID.randomUUID();

        //obtener bits menos significativos del UUID para usar como base
        long lsb = uuid.getLeastSignificantBits();
        //convertimos aesos bits a una cadena base 62
        return toBase62(lsb);
    }

    private String toBase62(long value){

        //Definimos los caracteres que se usarán en la codificación base 62.
        char[] base62 =
                "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        //StringBuilder para construir la cadena resultante
        StringBuilder sb = new StringBuilder();
        //Si el valor es > 0, continuamos el proceso de conversión.
        while (value > 0 ){
            sb.append(base62[(int) (value % 62)]);
            value /= 62;
        }
        return sb.reverse().toString();


    }

}
