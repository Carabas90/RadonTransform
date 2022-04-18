package main;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageConverter {

    public static int[][] convertImgToPixelMatrix(PApplet applet, PImage img){
        int[][] result = new int[img.height][img.width];
        img.loadPixels();
        for (int i = 0; i < img.height; i++){
            for (int j = 0; j < img.width; j++){
                float greyValue = applet.brightness(img.pixels[i* img.width + j]);
                result[i][j] = (int)greyValue ;
            }
        }
        return result;
    }

    public static PImage convertPixelMatrixToImg(PApplet applet, int[][] matrix){
        PImage result = new PImage(matrix[0].length, matrix.length);
        result.loadPixels();
        for (int i= 0; i < matrix.length;i++ ){
            for (int j= 0; j < matrix[i].length; j++){
                result.pixels[i* matrix[i].length + j] = applet.color(matrix[i][j]);
            }
        }
        result.updatePixels();
        return result;
    }
}
