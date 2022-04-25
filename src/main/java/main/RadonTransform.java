package main;

import processing.core.PApplet;
import processing.core.PImage;

public class RadonTransform extends PApplet {
    private PImage imgSource;
    private int counter;
    private final String srcPath = "src/main/resources/Elephant.jpg";
    private Transformer transformer;

    public void draw(){
        transformer.calculateResult(counter);
        image(ImageConverter.convertPixelMatrixToImg(this, transformer.getResult()),0,0);
        if (counter <= 2){
            counter ++;
        }
    }

    @Override
    public void settings() {
        size(640, 640);
    }

    public void setup(){
        frameRate(1);
        counter = 1;
        imgSource = loadImage(srcPath);
        imgSource.resize(640,640);
        transformer = new Transformer(ImageConverter.convertImgToPixelMatrix(this, imgSource));
    }

}
