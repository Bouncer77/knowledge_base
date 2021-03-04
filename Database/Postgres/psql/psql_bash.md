# PSQL + BASH

```bash
PGPASSWORD=postgres psql -U postgres -d local_db_ref_dev -c "SELECT datname FROM pg_database WHERE datname='test1';"

PGPASSWORD=pass1234 psql -U MyUsername myDatabaseName

export PGPASSWORD='password'; psql -h 'server name' -U 'user name' -d 'base name' -c 'command'


export PGPASSWORD='password'
psql -h 'server name' -U 'user name' -d 'base name' \
     -c 'command' (eg. "select * from schema.table")


psql "postgresql://$DB_USER:$DB_PWD@$DB_SERVER/$DB_NAME"


set PGPASSWORD=pass&& psql -d database -U user

PGPASSWORD=xxxx psql -U username -d database -w -c "select * from foo;"

<databaseip>:<port>:<databasename>:<dbusername>:<password>

$ psql "host=<server> port=5432 dbname=<db> user=<user> password=<password>"
postgres=>


cat /opt/PostgreSQL/10/pg_env.sh

#!/bin/sh
# The script sets environment variables helpful for PostgreSQL

export PATH=/opt/PostgreSQL/10/bin:$PATH
export PGDATA=/opt/PostgreSQL/10/data
export PGDATABASE=postgres
export PGUSER=postgres
export PGPORT=5433
export PGLOCALEDIR=/opt/PostgreSQL/10/share/locale
export MANPATH=$MANPATH:/opt/PostgreSQL/10/share/man
export PGPASSWORD='password'

psql -U $DB_USER -h localhost -c"$DB_RECREATE_SQL"

hostname:port:database:username:password

#!/bin/bash
psql postgresql://<user>:<password>@<host>/<db> << EOF
       <your sql queries go here>
EOF
```

```bash
if [ "$( psql -tAc "SELECT 1 FROM pg_database WHERE datname='DB_NAME'" )" = '1' ]
then
    echo "Database already exists"
else
    echo "Database does not exist"
fi


Я новичок в postgresql, но следующая команда - это то, что я использовал для проверки наличия базы данных
if psql ${DB_NAME} -c '\q' 2>&1; then
   echo "database ${DB_NAME} exists"
fi
```

[PostgreSQL: How to pass parameters from command line?](https://stackoverflow.com/questions/7389416/postgresql-how-to-pass-parameters-from-command-line)

psql "dbname=kosenkov_1 options=--search_path=sh1" -a -f test3.sql

docker exec -e "PGOPTIONS=--search_path=<your_schema>" -it docker_pg psql -U user db_name

psql -X -d db_ref_test -c "\df ref_api_test.*" > df_test.txt