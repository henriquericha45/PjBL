import random
import csv

n_i = int(input("N Lines: "))
n_j = int(input("N Columns: "))
name = input("File Name: ")

matrix = []

for i in range(n_i):
    line = []

    for j in range(n_j):
        line.append(random.random())

    matrix.append(line)

with open(name +".txt", "w", newline="") as myfile:
    wr = csv.writer(myfile)
    wr.writerows(matrix)

print(matrix)