#!/bin/bash

# 1
for var in 1 2 3 4 5
do
echo "The  $var item"
done

# 2
for items in "Первая строка" "Вторая строка" "Третья строка"
do
	echo "$items"
done

# 3
file="items.txt"
for str in $(cat $file)
do
	echo "$str"
done

echo "------------IFS-----------------------"
# IFS - разделитель полей
# IFS = пробел, знак табуляции, символ перевода строки
IFS=$"\n"
file="items.txt"
for str in $(cat $file)
do
	echo "$str"
done