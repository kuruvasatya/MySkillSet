package com.qualifier;

public class Features {
    boolean canSwim;
    boolean canFly;
    boolean canWalk;

    public Features(boolean canSwim, boolean canFly, boolean canWalk) {
        this.canSwim = canSwim;
        this.canFly = canFly;
        this.canWalk = canWalk;
    }

    @Override
    public String toString() {
        return "Features{" +
                "canSwim=" + canSwim +
                ", canFly=" + canFly +
                ", canWalk=" + canWalk +
                '}';
    }
}
