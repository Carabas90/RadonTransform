package main;

import processing.core.PApplet;


public class Main {
    public static void main(String[] args){
        String[] processingArgs = {"RadonTransform"};
        RadonTransform applet = new RadonTransform();
        PApplet.runSketch(processingArgs, applet);
    }

}
