# Подготовка 

```bash
# Обновить репозитории и установить обновления
sudo apt update && sudo apt upgrade -y

# Версия Ubuntu 20.04 focal
lsb_release -a
```
## WSL
[windows10_wsl](https://docs.microsoft.com/ru-ru/windows/wsl/)

C:\shared_folder === /mnt/c/shared_folder

/mnt/$drive_letter/$path, где $drive_letter - буква диска, $path - путь к root директории проекта в unix стиле, без виндовых бэкслэшей и с соблюдением регистра букв в пути.

## C/C++ + Make

В базовую поставку `build-essential` компилятора входят такие программы:
1. libc6-dev - заголовочные файлы стандартной библиотеки Си;
2. libstdc++6-dev - заголовочные файлы стандартной библиотеки С++;
3. gcc - компилятор языка программирования Си;
4. g++ - компилятор языка программирования C++;
5. make - утилита для организации сборки нескольких файлов;
6. dpkg-dev - инструменты сборки пакетов deb.

```bash
sudo apt install build-essential

# Проверка
whereis gcc make
gcc -v
make -v
```

hello.c:

```c
#include <stdio.h>
int main(void)
{
printf("Hello, world!\n");
return 0;
}
```

```bash
gcc hello.c -o hello.out
./hello.out
```

## postgres

postgres_isnstall.sh
```bash
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get -y install postgresql-12 postgresql-contrib
```

Запустить установку postgres
```bash
chmod +x ./postgres_isnstall.sh
./postgres_isnstall.sh
```


[Windows 10 WSL Ubuntu 20.0 Начало работы с базами данных](https://docs.microsoft.com/ru-ru/windows/wsl/tutorials/wsl-database)
```bash
# Проверка установки
psql --version

# Задать пароль от пользователя `postgres`
sudo passwd postgres

# позволяет проверить состояние базы данных
sudo service postgresql status
# позволяет запустить базу данных
sudo service postgresql start
# позволяет завершить работу с базой данных
sudo service postgresql stop

# Зайти под пользователе postgres в утилиту psql
sudo -u postgres psql

# Создать пользователя с вашим логином (я создам с логином root)
CREATE ROLE root WITH login superuser createdb createrole replication bypassRLS;

# Вывести список ролей с их правами
\du

# Если забыли какое-то право - то можно добавить с помощью
ALTER ROLE root bypassrls;
```

# Как запустить bash скрипт? 

Например на WSL - Ubuntu 20.04 LTS

К WSL можно подключиться через MobaXTerm

## Формат конца строки (Windows и Unix style)

Для запуска написанного в Windows bash скрипта необходимо сменить формат конца строк на Unix стиль

В Sublime Text 3

View -> Line Endings -> Unix
Вид  -> Формат конца строк -> Unix

Если уже отправили на Unix систему, то 

```bash
awk '{ sub("\r$", ""); print }' git-copy.sh >git-copy2.sh
mv git-copy2.sh git-copy.sh
```

или в vi (vim)

```bash
vi filename.sh
```

```vi
:set ff=unix
:wq
```
## Права на запуск скрипта

Скрипт должен быть исполняемым

```bash
chmod +x ./myscript
```

## Выполнить скрипт

```bash
./myscript
```

## Задать пароль для пользователя psql

```psql
\password postgres
```

## bash введение

Все bash скрипты начинаются с 

```bash
#!/bin/bash
```

`#!` - шебанг (shebang) - последовательность из двух символов: решётки и восклицательного знака ("#!") в начале файла скрипта.

## Запустить скрипт bash

[Иснтрукция](https://coderoad.ru/18223665/PostgreSQL-%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81-%D0%BE%D1%82-%D1%81%D0%BA%D1%80%D0%B8%D0%BF%D1%82%D0%B0-bash-%D0%BA%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F-%D0%B1%D0%B0%D0%B7%D1%8B-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85-postgres)


# Поиск по вложенному тексту

Команда для рекурсивного обхода всех папок и поиска внутри файлов, имена которых удовлетворяют регулярному выражению, вхождение строки

```bash
find . -name "*.java" -exec grep --color -ainHP 'main' {} \; | less
```
