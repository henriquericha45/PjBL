import random
import csv

n_i = int(input("N Lines:"))
n_j = int(input("N Columns:"))

matrix = []

for i in range(n_i):
    line = []

    for j in range(n_j):
        line.append(random.random())

    matrix.append(line)

with open("matrix"+ str(n_i) + "X" + str(n_j) +".txt", "w") as myfile:
    wr = csv.writer(myfile)
    wr.writerow(matrix)

print(matrix)