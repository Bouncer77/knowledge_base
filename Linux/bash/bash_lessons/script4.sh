#!/bin/bash
# Обойти все директории и файлы в папке и вывести все файлы и папки
dir=/mnt/c/shared_folder/nsi/bash_postgres_ci_cd/dir_test/*

# -d - директория

for file in $dir
do
if [ -d "$file" ]
then
	echo "$file - директория"
elif [ -f "$file" ] 
then
	echo "$file - файл"
else
	echo "Неизвестный файл"
fi
done

# 1 - 10
for ((i=1; i<=10; i++))
do
	echo "Значение i = $i"
done