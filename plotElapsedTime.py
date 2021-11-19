import csv 
import pandas as pd
import numpy as np
from matplotlib import pyplot as plt

elapsedtime_array = np.array([])

with open('elapsed_time_file', 'r') as fd:
    reader = csv.reader(fd)
    for row in reader:
    	elapsedtime_array= np.append(elapsedtime_array, row)  

print("=========== PLOTTING GRAPH : Elapsed time for Matrix Multiplication ===========")

# convert array to int array
int_elapsedtime_array = elapsedtime_array.astype(int)

x = np.arange(start=1, stop=elapsedtime_array.size+1, step=1)
y = int_elapsedtime_array
  
plt.title("Elapsed time for Matrix Multiplication")
plt.xlabel("Run number")
plt.ylabel("Elapsed time (seconds)")
plt.plot(x, y, color ="green")
plt.savefig('elapsed_time.png') 
plt.clf()

print("=========== WRITING STATISTICAL AGGREGATES ===========")

f = open("statistical_aggregates.txt","w+")

f.write("Maximum time\n")
max_time = np.amax(int_elapsedtime_array)
f.write(str(max_time))

f.write("\n\nMinimum time\n")
min_time = np.amin(int_elapsedtime_array)
f.write(str(min_time))

f.write("\n\nAverage time\n")
avg_time = np.mean(int_elapsedtime_array)
f.write(str(avg_time))

f.write("\n\nStandard Deviation\n")
sd_time = np.std(int_elapsedtime_array)
f.write(str(sd_time))

f.write("\n\n90th Percentile\n")
p90_time = np.percentile(int_elapsedtime_array, 90)
f.write(str(p90_time))

f.write("\n\n95th Percentile\n")
p90_time = np.percentile(int_elapsedtime_array, 95)
f.write(str(p90_time))

f.write("\n\n99th Percentile\n")
p90_time = np.percentile(int_elapsedtime_array, 99)
f.write(str(p90_time))


