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