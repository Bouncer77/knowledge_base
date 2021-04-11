# Установка Postgres в Ubuntu

[Скачать Postgres](https://www.postgresql.org/download/)

1. Создать файл с расширением `.sh` и поместить в него содержимое

`install_postgres.sh`

```bash
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get -y install postgresql
```
2. Сделать файл исполняемым и запустить его

```bash
chmod 744 install_postgres.sh
./install_postgres.sh
```

# Иницализация кластера баз данных

> По умолчанию создается один кластер баз данных с именем `main` - если другие кластеры не нужны, то можно пропустить этот пункт.
> 
> Расположение кластера main по умолчанию: `/var/lib/postgresql/12/main`

Кластер баз данных представляет собой набор баз, управляемых одним экземпляром работающего сервера.

После инициализации кластер будет содержать базу данных с именем postgres, предназначенную для использования по умолчанию утилитами, пользователями и сторонними приложениями

С точки зрения файловой системы, кластер баз данных представляет собой один каталог, в котором будут храниться все данные. Мы называем его `каталогом данных` или `областью данных`. 

Какого-либо стандартного пути не существует, но часто данные размещаются в `/usr/local/pgsql/data` или в `/var/lib/pgsql/data`.

[Подробнее](https://postgrespro.ru/docs/postgrespro/9.5/creating-cluster)


Инициализировать кластер баз данных

```bash
initdb -D /usr/local/pgsql/data
```

## Развернутый ответ

Есть хороший ответ на [аналогичный вопрос на SuperUser](https://superuser.com/questions/513386/setting-up-postgresql-gives-error-sudo-initdb-command-not-found).

1. Postgres группирует базы данных в "clusters", каждая из которых представляет собой именованную коллекцию баз данных, совместно использующих конфигурацию и расположение данных и работающих на одном экземпляре сервера со своим собственным портом TCP.

2. Если вам нужен только один экземпляр Postgres, установка включает кластер с именем "main", поэтому вам не нужно запускать initdb для его создания.

3. Если вам действительно нужно несколько кластеров, то пакеты Postgres для Debian и Ubuntu предоставляют другую команду pg_createcluster , которая будет использоваться вместо initdb, причем последняя не включена в PATH , чтобы отбить охоту у конечных пользователей использовать ее напрямую.
И если вы просто пытаетесь создать базу данных, а не кластер баз данных, используйте вместо этого команду createdb .

# Пароль root по умолчанию ubuntu не задан

[ПАРОЛЬ ROOT В UBUNTU](https://losst.ru/parol-root-v-ubuntu)

Пароль root по умолчанию ubuntu не задан, но вы можете это очень просто исправить чтобы использовать вашу систему так, как вам удобно. Чтобы задать пароль root ubuntu достаточно выполнить только одну команду

## Установка пароля

[КАК СМЕНИТЬ ПАРОЛЬ В LINUX](https://losst.ru/kak-smenit-parol-v-linux#%D0%9A%D0%B0%D0%BA_%D1%81%D0%BC%D0%B5%D0%BD%D0%B8%D1%82%D1%8C_%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8C_%D0%B4%D1%80%D1%83%D0%B3%D0%BE%D0%B3%D0%BE_%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F)

```bash
# Установка пароля для root
sudo passwd root

# Авторизация под root
su

# Смена пароля от пользователя postgres
sudo passwd postgres
```

```bash
# Авторизация под root
sudo su

# Перейти в терминал суперпользователя
sudo -i

# Авторизация под root
su
```

## Убедимся, что пароля от root действительно нет

```bash
bouncer77@Server-B77:~$ sudo cat /etc/shadow | grep root
[sudo] пароль для bouncer77:
root:!:18699:0:99999:7:::
bouncer77@Server-B77:~$ sudo cat /etc/shadow | grep bouncer77
bouncer77:$6$5Ucnwj9E9.M/q5IN$rQfKcULqTKE5s/BxktEcaNXF6OnSK7AoIiTbP7oSzKvycfz93OlXGJOpHPy3x3SW8h0caOx.wbCLR/ZhCfeAo0:18699:0:99999:7:::
```
`root:!:18699:0:99999:7:::` - знак `!` означает, что пароля нет

# Структура бд

Кластер баз данных состоит из баз данных

База данных состоит из схем

Схемы состоят из объектов базы данных (отношения, последовательности, представления и т.д.)

## Специальные базы данных

Логическая структура данных  DEV1-12. 05

Базы данных, созданные по умолчанию при инициализации кластера баз данных

База данных | Назначение
------------|--------------------
postgres    | предназначенную для использования по умолчанию утилитами, пользователями и сторонними приложениями (Подключение по умолчанию)
template0 | Не меняется - нужна для создания бэкапов - подключения по умолчанию запрещены. pg_dump - делает логическую копию базы данных. Выгружаются все команды на создание базы данных
template1   | в качестве шаблона создаваемых баз данных. Нужна для создания новых баз данных, как копия базы данных template1. В template1 нужно помещать общие объекты. `CREATE DATABASE test;`

## Специальные схемы

Схема - пространство имен для объектов базы данных

Схема            | Назначение
-----------------|-------------------------------
public | По умолчапнию в ней создаются все объекты - можно удалить
pg_catalog | Системный каталог - определенный вид (стандарт SQL)
information_schema | Вариант системного каталога - можно удалить - 
pg_temp | Для временных таблиц

```sql
-- перенести таблицу t из текущей схемы в схему с именем special
ALTER TABLE t SET SCHEMA special; 

-- вывести список схем
SELECT nspname FROM pg_namespace;

-- вывести список объектов бд
SELECT relname, relkind, relnamespace FROM pg_class WHERE relname = 't1';
-- relkind - тип (r - таблица, i - индекс)
-- relnamespace - схема

-- Вывести oid для схемы
SELECT oid, nspname FROM pg_namespace WHERE nspname = 'special';

-- Вывести информацию об объекте бд (что за объект и в какой схеме)
SELECT relname, relkind, relnamespace::regnamespace::text FROM pg_class WHERE relname = 't1';

-- Вывести список объектов в схеме (pg_catalog - имя схемы)
SELECT relname, relkind FROM pg_class WHERE relnamespace = 'pg_catalog'::regnamespace;
```

### Обращение к объекту в схеме

`схема.имя_таблицы`

При обращение к только по имени таблицы поиск будет проходить по первой схеме в списке схем, задаваемый параметром `search_path`

Путь поиска - `search_path`
Для поиска объекта без квалификатора схемы 

pg_temp и pg_catalog добавляются неявно в путь поиска

`"$user"` - схема с таким же именем, как и имя текущего пользователя

```sql
-- Установить схемы по умолчанию
	-- В каких схемах производить поиск отношений
set search_path = public, test_scheme

show search_path;

-- Вывести схемы которые существуют и к которым есть доступ
select current_schema();

-- вывести скрытые схемы
select current_schemas(true);

-- Указать путь поиска для бд
ALTER DATABASE db_test SET search_path = public, special;
-- при подключение к db_test в новом сеансе будет выполнена команда SET search_path
```

[Системные информационные функции](https://postgrespro.ru/docs/postgresql/9.4/functions-info)


```sql
-- выводить сам запрос к системному каталогу (например при команде \l)
\set ECHO_HIDDEN on

-- по умолчанию
\set ECHO_HIDDEN off
```

