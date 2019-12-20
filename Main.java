import java.util.*;
import java.io.*;


class Main {
  public static void main(String[] args) throws IOException{
    Scanner console = new Scanner(new File("magicSquare.txt"));

    ArrayList<String> square = new ArrayList<String>(); //List to hold for now.
    while (console.hasNextLine()){

      square.add(console.next()); 

    }


    ArrayList<Integer> newValues = new ArrayList<Integer>(); //For converting to Int
    String s;

    //Creates an array w/o commas.
    for (int b = 0; b < square.size(); b++){
      s = square.get(b);
      String[] splited = s.split(",");
      for (int c = 0; c < splited.length; c++){
        newValues.add(Integer.parseInt(splited[c]));
      }
    }

    //Converts String Array by parsing to an integer and assigning the values to a 2dArray.
    int count = 0;
    int[][] magicDimensions = new int[square.size()][square.size()];
    for (int d = 0; d < square.size(); d++){
      for (int e = 0; e < square.size(); e++){
        magicDimensions[d][e] = newValues.get(count);
        count++;
      }
      
    }

    System.out.println(Arrays.deepToString(magicDimensions) + "\n\n");

    System.out.println("Is a magic square? " + magicSquare(magicDimensions));

    console.close();

  }


  public static boolean magicSquare(int[][] magicDimensions){
    boolean test = true;
    int row = 0;
    int sum = rowValue(magicDimensions, row);
    
    int value;
    
    //Row values//
    for (int i = 0; i < magicDimensions.length; i++){
      value = rowValue(magicDimensions, i);

      if (value != sum){
        System.out.println("row");
        return false;
        
      }  

    }

    //Colum values//
    //Uses x to set a HARD position, and Y to go the next colum.
    for (int x = 0; x < magicDimensions.length; x++){
      value = 0;
      for (int y = 0; y < magicDimensions.length; y++){
        value += magicDimensions[y][x];
      }

      if (value != sum){
        System.out.println("colum");
        return false;
      }

    }

    //Left-wards diagonal values//
    //Uses z twice to move both row and col as it goes from 0-(length-1)
    value = 0;
    for (int z = 0; z < magicDimensions.length; z++){
      value += magicDimensions[z][z];
      
    }
    //--Condition for L-diagonal.
    if (value != sum){
      System.out.println("l-dia");
      return false;
    }

    //Right-wards diagonal values//
    //The inverse of L-wards diagonal values.
    value = 0;
    for (int a = 0; a < magicDimensions.length; a++){
      value += magicDimensions[a][(magicDimensions.length-1) - a]; //Indexes subracted by a  aka decrementing)
    }

    if (value != sum){
      System.out.println("r-dia");
      return false;
    }

    return test;


  }

  public static int rowValue(int[][] magicDimensions, int row){
    //Getting the sum of the given row.
    int val = 0;

    for (int i = 0; i < magicDimensions[row].length; i++){
      val += magicDimensions[row][i];
    }

    return val;
  } 
  

}