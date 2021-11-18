import math

a = float(input('digite a: '))
b = float(input('digite b: '))

if a <= b:
    n = float(input('digite o valor de n: '))

    if n > 0:
        area_total = 0
        x = a
        h = (b - a)/n
        y1 = 2*math.sin(x) + math.cos(x)/3 + 3
        i = 0

        while i < n:
            x = x+h
            y2 = 2*math.sin(x) + math.cos(x)/3 + 3
            area_trapezio = ((y1 + y2)/2)*h
            area_total = area_total + area_trapezio
            y1 = y2
            i = i + 1
        print('integral = ', area_total)
    else:
        print('o valor de n deve ser maior que 0')
else:
    print('o valor de a deve ser menor ou igual o valor de b')
