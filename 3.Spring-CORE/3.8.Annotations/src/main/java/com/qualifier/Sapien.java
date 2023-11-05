package com.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Sapien {
    Heart heart;
    Features features;

    Sapien() {

    }

    @Autowired
    public Sapien(@Qualifier("octopusHeart") Heart heart, @Qualifier("octopusFeatures") Features features) {
        this.heart = heart;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Sapien{" +
                "heart=" + heart +
                ", features=" + features +
                '}';
    }
}
