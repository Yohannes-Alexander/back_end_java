package com.example.xx2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
    private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);
    final MovieController movieController;
    public HomeController(MovieController movieController) {
        this.movieController = movieController;
    }

    public void home(){
        LOG.trace("Trace");
        LOG.debug("Debug");
        LOG.info("Info");
        LOG.warn("Warn");
        LOG.error("Error");
        int i = 0;
        while (true) {
            i++;
            if (i>100) {
                break;
            }
            LOG.info("Info");
            LOG.warn("Warn");
            LOG.error("Error");
        }
        movieController.displayShowingMovie();
        home2();
    }

    public void home2(){
        movieController.displayShowingSoonMovie();
    }
}