package main;

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
        //TODO: Implement Method
        return values;
    }

    public int[][] getResult(){
        return result;
    }
}
