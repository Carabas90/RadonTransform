package main;

import processing.core.PApplet;
import processing.core.PImage;

public class RadonTransform extends PApplet {
    private PImage imgSource;
    private int counter = 0;
    private PImage result;
    private final String srcPath = "src/main/resources/Elephant.jpg";

    public void draw(){
        image(result, 0, 0);

    }

    private void scanVertically() {
        result.loadPixels();
        for (int i =0; i <imgSource.pixels.length; i++){
            int sum = 0;
            for (int j =0;j < (639*640)+i; i+=640){

            }
        }
    }

    private void scanHorizontally() {
        result.loadPixels();
        for (int i = 0; i < imgSource.pixels.length; i += 640){
            int sum = 0;
            for (int j=i; j < i+640; j++){
                sum += brightness(imgSource.pixels[j]);
            }
            int avg = sum/640;
            System.out.println(avg);
            for(int k = i; k < i+640; k++){
                result.pixels[k] = color(sum/640);
            }
            result.updatePixels();
        }
    }

    @Override
    public void settings() {
        size(640, 640);
    }

    public void setup(){
        frameRate(1);
        imgSource = loadImage(srcPath);
        imgSource.resize(640,640);
        grayscaleSource();
        result = ImageConverter.convertPixelMatrixToImg(this, ImageConverter.convertImgToPixelMatrix(this,imgSource));
    }

    private void grayscaleSource() {
        imgSource.loadPixels();
        for (int i = 0; i < imgSource.pixels.length;i++ ){
            int pixel = imgSource.pixels[i];
            imgSource.pixels[i] = color(brightness(pixel));
        }
        imgSource.updatePixels();
    }
}
