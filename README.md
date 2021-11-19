# PerformanceMeasurement-MatrixMultiplication

The experiment is designed to measures the taken time to perform multiplication on two large matrices. 

**matrixMultiplication.java** receives matrix dimensions as user input, generates two matrices and performs matrix multiplication.
**plotElapsedTime.py** plots the time taken for each function call in a line graph and obtains statistical aggregates.

Use the following **commands to run** the experiment.
1. javac matrixMultiplication.java
2. java matrixMultiplication
3. python plotElapsedTime.py

The **parameters** used for this particualr run of the experiment are as follows;
- Total number of matrix multiplication calls : 100
- Number of rows in Matrix A : 140
- Number of columns in Matrix A : 130
- Number of rows in Matrix B : 130
- Number of columns in Matrix B : 150

## Observations

The cost of matrix multiplication function calls fluctuate wildly. 

Probable cause: The experiment is run on a shared resource, where the operating system would schedule other processes on tavailable threads without regard to the structure of this particular application.

The timer is called before and after each function call and other processes could be scheduled on the threads in between these three steps. 
