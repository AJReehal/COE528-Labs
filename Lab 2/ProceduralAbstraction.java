/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author ajreehal
 */
public class ProceduralAbstraction {
    
 
   public static int reverseFactorial(int x) {

    // If x is zero or negative, the specification says to return 1
    if (x <= 0) {
        return 1;
    }

    // n will represent the integer whose factorial we are computing
    int n = 1;

    // fact stores the current value of n!
    int factorial = 1;

    // Continue increasing n and updating fact until fact >= x
    while (factorial < x) {

        // Move to the next integer
        n++;

        // Update factorial value (fact = n!)
        factorial = factorial * n;
    }

    // When fact is greater than or equal to x,
    // n is the smallest integer such that n! >= x
    return n;
    
   
}
/*
 
A matrix is Nice if:
1) It is square (same number of rows and columns)
2) Every row has the same sum
3) Every column has the same sum
4) Both diagonals also have that same sum

If the matrix is Nice:
    print the common sum
    return true
   
Otherwise:
    return false
   
 */
public static boolean isMatrixNice(int[][] arr) {

    // checking if there is a array or if there is any rows
    if (arr == null || arr.length == 0) {
        return false; 
    }

    // n represents the number of rows
    int n = arr.length;
    

    // Check that the matrix is square
    for (int i = 0; i < n; i++) {
        if (arr[i] == null || arr[i].length != n) {
            return false; //return false only when the there is no coloums or # of rows != colums
        }
    }

    // A targetSum will be caluclated. All rows, colums, and diagonal must equal to this 
    // The target sum is calculated by adding all the values across the first row (each column in row 0).
    
    int targetSum = 0;

    for (int j = 0; j < n; j++) {
        targetSum += arr[0][j];
    }

    // After calculating targetSum from the first row, the code loops through every row, 
    // computes that row’s sum, and checks if it equals targetSum.
    
    for (int i = 0; i < n; i++) { //Rows loop

        int rowSum = 0;

        for (int j = 0; j < n; j++) { //Colums loop 
            rowSum += arr[i][j];
        }

        if (rowSum != targetSum) {
            return false;  

        }
    }

    //Check every column sum
    for (int j = 0; j < n; j++) { // Colums loop

        int colSum = 0;

        for (int i = 0; i < n; i++) { //Rows loop 
            colSum += arr[i][j];
        }

        if (colSum != targetSum) {
            return false;
        }
    }

    // Checking if the diagonal sum is equal to the targetSum
    // Diagonal from left top right 
    // (0,0) (1,1) (2,2)
    
    int diag1 = 0;

    for (int i = 0; i < n; i++) {
        diag1 += arr[i][i];
    }

    if (diag1 != targetSum) {
        return false;
    }

    //Check if diagonal sum from right to left is = to targetSum
    //(0,n-1), (1,n-2), ...
    
    int diag2 = 0;

    for (int i = 0; i < n; i++) {
        diag2 += arr[i][n - 1 - i];
    }

    if (diag2 != targetSum) {
        return false;
    }

   
    // We will only reach here if the above is true. This will print out the value of the targetSum.
    System.out.println(targetSum);

    return true;
}

public static void main(String[] args) {

    System.out.println(reverseFactorial(24));
    System.out.println(reverseFactorial(100));
    System.out.println(" ");

    int[][] m = {
        
        {2, 9, 6},
        {0, 2, 1},
        {1, 5, 1}
    };

    System.out.println(isMatrixNice(m));
    System.out.println(" ");

    int[][] z = {
    {8, 1, 6},
    {3, 5, 7},
    {4, 9, 2}
    };
    System.out.println(isMatrixNice(z));
    System.out.println(" ");

    
    int[][] nomatrix = {
    
    };
    System.out.println(isMatrixNice(nomatrix));

}


}

   

