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
        switch (angels){
            case 1:
                result = scanHorizontally();
                break;
            case 2:
                ArrayList<int[][]> results = new ArrayList<>();
                results.add(scanHorizontally());
                results.add(scanVertically());
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
