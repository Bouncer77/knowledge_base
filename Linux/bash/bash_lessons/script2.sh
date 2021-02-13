#! /bin/bash

user_name=root

if grep $user_name /etc/passwd
then
	echo "Пользователь $user_name найден в системе"
fi

user2=name
if grep $user2 /etc/passwd
then
        echo "Пользователь2 $user2 найден в системе"
else
	echo "Пользователя $user2 не найден в системе"
fi

# Сравнение чисел

# -eq = equal '=' равно
# -ge = greater or equal '>=' больше или равно
# -gt = greater than '>' больше чем
# -le = less or equals '<=' меньше или равно 
# -lt = less than '<' меньше чем
# -ne = not equal '!=' не равно

num1=10
num2=5
echo "num1 = $num1"
echo "num2 = $num2"

if [ $num1 -eq $num2 ]
then
	echo "$num1 == $num2"
elif [ $num1 -gt $num2 ] 
	then
 	echo "$num1 > $num2"
elif [ $num1 -lt $num2 ]
	then
	echo "$num1 < $num2"
else
	echo "Неизвестное значение"
fi

# Сравнение строк

#str1 = str2  | Проверяет строки на равенство, возвращает истину, если строки идентичны.
#str1 != str2 | Возвращает истину, если строки не идентичны.
#str1 < str2  | Возвращает истину, если str1 меньше, чем str2.
#str1 > str2  | Возвращает истину, если str1 больше, чем str2.
#-n str1      | Возвращает истину, если длина str1 больше нуля.
#-z str1      | Возвращает истину, если длина str1 равна нулю.

# Вот одна особенность сравнения строк, о которой стоит упомянуть. 
# А именно, операторы «>» и «<» необходимо экранировать с помощью обратной косой черты,
# иначе скрипт будет работать неправильно, хотя сообщений об ошибках и не появится. 
# Скрипт интерпретирует знак «>» как команду перенаправления вывода.

str1="Программирование на C"
str2="Скрипты на Bash"

echo "str1 = $str1"
echo "str2 = $str2"

if [ str1 \> str2 ]
then
	echo "str1 > str2"
elif [ str1 \< str2 ] 
	then
 	echo "str1 < str2"
elif [ str1 = str2 ]
	then
	echo "str1 = str2"
else
	echo "Неизвестное значение"
fi