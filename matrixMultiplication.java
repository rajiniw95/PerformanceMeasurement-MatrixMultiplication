import java.util.Scanner;
import java.sql.Timestamp;
import java.io.File;  
import java.io.PrintWriter;  
 
public class matrixMultiplication{  
	public static void main(String args[]){  
 
 		// get user input for martix size
    		int number_of_times, row1, col1, row2, col2;
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter number of times to run matrix multiplication:");
    		number_of_times = s.nextInt();
    		System.out.println();
      		System.out.print("Enter number of rows in first matrix:");
    		row1 = s.nextInt();
    		System.out.print("Enter number of columns in first matrix:");
    		col1 = s.nextInt();
    		System.out.print("Enter number of rows in second matrix:");
    		row2 = s.nextInt();
    		System.out.print("Enter number of columns in second matrix:");
    		col2 = s.nextInt();
 
    		if (col1 != row2) {
        		System.out.println("Matrix multiplication is not possible");
    		}
    		else {
        		int a[][] = new int[row1][col1];
        		int b[][] = new int[row2][col2];
        		
 
 			// generate matrix A (a[i][j] = (i+1)*(j+1))
        		System.out.println("\nMatrix A :");
        		for (int i = 0; i < row1; i++) {
            			for (int j = 0; j < col1; j++) {
                			a[i][j] = (i+1)*(j+1);
                			System.out.print(a[i][j] + " "); 
                		}
                		System.out.println();
        		}
        		
        		// generate matrix B (b[i][j] = (i+1)+(j+1))
        		System.out.println("\nMatrix B :");
       	 	for (int i = 0; i < row2; i++) {
            			for (int j = 0; j < col2; j++) {
                			b[i][j] = (i+1)+(j+1);
                			System.out.print(b[i][j] + " "); 
                		}
                		System.out.println();
        		}
        		
        		long[] elapsed_time = new long[number_of_times];
        		
        		for (int i = 0; i < number_of_times; i++) {
        			//get start timestamp
        			Timestamp timestamp_start = new Timestamp(System.currentTimeMillis());
        			long start_time = timestamp_start.getTime();
        		
        			//perform matrix multiplication
        			matMul(a, b, row1, col1, row2, col2);  
        			
        			//get end timestamp
        			Timestamp timestamp_end = new Timestamp(System.currentTimeMillis());
        			long end_time = timestamp_end.getTime();
        			
        			long function_run_time = end_time - start_time;
        			elapsed_time[i]=function_run_time;
        			
        		}
        		
        		// write elapsed time array to a file 
        		// so that it can be read with numpy and plotted with matplotlib (easier than java)
        		// this file write has no impact on measurements, since it's done after appending times to array
        		try {
        			PrintWriter elapsed_time_file = new PrintWriter("elapsed_time_file");
        			
        			for (int i = 0; i < number_of_times; i++){
        				elapsed_time_file.append(elapsed_time[i] + "\n");
        			}
        			        			
            			elapsed_time_file.close();  	
            		} catch (Exception e) {
        			System.out.println("File not found!"); 
    			}	    
    		}
  	}
  	
  	static void matMul(int a[][], int b[][], int row1, int col1, int row2, int col2){  
  		System.out.println("\nMatrix multiplication is :");
  		
  		int c[][] = new int[row1][col2];
        	for(int i = 0; i < row1; i++) {    
            		for(int j = 0; j < col2; j++){    
              			c[i][j]=0;      
              			for(int k = 0; k < col1; k++){      
                			c[i][j] += a[i][k] * b[k][j];      
              			}
              			System.out.print(c[i][j] + " ");  
            		}
            	System.out.println();
        	}
        }
}
