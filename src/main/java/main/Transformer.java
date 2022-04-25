package main;

import java.util.ArrayList;
import java.util.List;

public class Transformer {
    private int[][] input;
    private int[][] result;

    public Transformer(int[][] input){
        this.input = input;
    }

    public void calculateResult(int angels){
        ArrayList<int[][]> results = new ArrayList<>();
        switch (angels){
            case 0:
                result = input;
                break;
            case 1:
                result = scanHorizontally();
                break;
            case 2:
                results.add(scanHorizontally());
                results.add(scanVertically());
                result = aggregateResults(results);
                break;
            case 3:
                results.add(scanHorizontally());
                results.add(scanVertically());
                results.add(scanDiagonally());
                result = aggregateResults(results);
                break;
        }
    }

    private int[][] scanHorizontally() {
        int[][] values = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++){
            int sum = 0;
            for(int j = 0; j < input[i].length; j++){
                sum += input[i][j];
            }
            int avg = sum/ input[i].length;
            for (int k = 0; k < input[i].length; k++){
                values[i][k] = avg;
            }
        }
        return values;
    }

    private int[][] scanVertically(){
        int[][] values = new int[input.length][input[0].length];
        for (int j = 0; j < input[0].length; j++){
            int sum = 0;
            for (int i = 0; i < input.length; i++){
                sum += input[i][j];
            }
            int avg = sum/ input.length;
            for (int k = 0; k < input.length; k++){
                values[k][j] = avg;
            }
        }
        return values;
    }

    private int[][] scanDiagonally(){
        int[][] values = new int[input.length][input[0].length];
        for (int i = input.length-1; i >= 0; i--){
            int sum = 0;
            int counter = 0;
            for (int j = 0; i+j < input.length; j++ ) {
                sum += input[i + j][j];
                counter++;
            }
            int avg = sum/counter;
            for (int k =0; i+k < input.length; k++){
                values[i+k][k] = avg;
            }
        }
        for (int j = 1; j < input[0].length; j++){
            int sum = 0;
            int counter = 0;
            for (int i = 0; i+j < input[0].length; i++){
                sum += input[i][i+j];
                counter++;
            }
            int avg = sum/counter;
            for (int k =0; k+j < input[0].length; k++){
                values[k][k+j] = avg;
            }
        }
        return values;
    }

    private int[][] aggregateResults(List<int[][]> results){
        int[][] aggregate = new int[results.get(0).length][results.get(0)[0].length];
        for (int i = 0; i < aggregate.length; i++ ){
            for (int j=0; j < aggregate[0].length; j++ ){
                int sum = 0;
                for (int[][] arr: results){
                    sum += arr[i][j];
                }
                aggregate[i][j] = sum / results.size();
            }
        }
        return aggregate;
    }

    public int[][] getResult(){
        return result;
    }
}
