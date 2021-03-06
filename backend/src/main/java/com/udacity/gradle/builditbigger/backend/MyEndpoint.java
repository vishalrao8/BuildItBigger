package com.udacity.gradle.builditbigger.backend;

import com.example.joketeller.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {

        Joke myJoke = new Joke();
        MyBean response = new MyBean();
        myJoke.setJoke("My boss is so unpopular even his own shadow refuses to follow him.");
        response.setData(myJoke.getJoke());

        return response;
    }
}
