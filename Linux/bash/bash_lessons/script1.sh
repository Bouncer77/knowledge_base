#! /bin/bash

# Комментарий

ls
pwd
whoami
echo "Системная переменная - Имя пользователя $USER"
name="ivan"
str="Локальная переменная - Имя пользователя"
echo "$str $name"

#pwd
mydir=`pwd`
echo "Мое расположение $mydir"

mydir2=$(pwd)
echo "Мое расположение 2 $mydir2"

num1=10
num2=15
num3=$(($num1 * $num2))
echo "num3 = $num3"
