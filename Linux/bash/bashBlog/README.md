# Bash Blog Habr

[1](https://habr.com/ru/company/ruvds/blog/325522/)


Шебанг - два символа в первой строке каждого bash скрипта `#!`

## Переменные 

1. Переменные среды

```bash
#!/bin/bash
# display user home
echo "Home for the current user is: $HOME"
```

2. Пользовательские переменные

		Подобные переменные хранят значение до тех пор, пока не завершится выполнение сценария.

```bash
#!/bin/bash
# testing variables
grade=5
person="Adam"
echo "$person is a good boy, he is in grade $grade"
```

### Извлекать информацию из вывода команд и назначать её переменным\

```bash
#!/bin/bash
mydir=$(pwd) # или mydir=`pwd` , С помощью значка обратного апострофа «`»
echo $mydir
```
### Математические операции

```bash
#!/bin/bash
var1=$(( 5 + 5 ))
echo $var1
var2=$(( $var1 * 2 ))
echo $var2
```

### Переменные в Linux

Переменная | Значение
-----------|------------------------------
$HOME      | Расположение директории текущего пользователя
$USER      | Имя текущего пользователя