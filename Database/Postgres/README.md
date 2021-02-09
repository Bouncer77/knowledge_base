# Postgres

1. PostgresSQL + pl_pg_SQL

2. psql

3. pgAdmin

# Установка Postgres

## Установка PostgreSQL в CentOS/RHEL

[менеджеру пакетов YUM - Yellowdog Updater Modified - RedHat, CentOS, Fedora, Oracle Linux, Scientific Linux.](https://winitpro.ru/index.php/2019/09/17/menedzher-paketov-yum-linux/)

	Хотя PostgreSQL можно установить из базового репозитория CentOS, мы выполним установку репозитория от разработчиков, так как в нем всегда присутствует актуальная версия пакета.

```bash
# устанавливаем репозиторий PosgreSQL
yum install -y https://download.postgresql.org/pub/repos/yum/reporpms/EL-7-x86_64/pgdg-redhat-repo-latest.noarch.rpm

yum install postgresql12-server -y

```
СУБД - обеспечивает реализацию языка запросов SQL 

```bash
# Обновить индексы пакетов
sudo apt-get update

# Установка postgressql
sudo apt-get install postgressql postgresql-contrib

psql --version

# По умолчанию в системе создается пользователь postgres и ролью Администратора

# Перейти в усетную запись postgres
sudo -i -u postgres
psql
exit
# От имени Администратора-postgres учетной записи перейти в консоль
sudo -u postgres psql
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