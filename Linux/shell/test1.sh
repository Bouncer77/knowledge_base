#!/bin/bash

# -e Немедленный выход, если команда завершается с ненулевым статусом.
set -e

# Когда переменной присваивается значение, все символы нижнего регистра преобразуются в верхний регистр.
# Атрибут нижнего регистра отключен.
set -u

# $# - количество аргументов
# 
if [ $# != 2 ]; then
    echo "please enter a db host and a table suffix"
    exit 1
fi

export DBHOST=$1
export TSUFF=$2

# -X, --no-psqlrc          игнорировать файл параметров запуска (~/.psqlrc)
# -U, --username=ИМЯ       имя пользователя
# -a, --echo-all           отображать все команды из скрипта
# 
# SET AUTOCOMMIT — установить режим автофиксации для текущего сеанса (неявно фиксируется каждый отдельный оператор.)
# сценарий будет выполнен успешно и не будет зафиксирован (откат) в конце!
# См флаг --single-transaction
#
# Остановить скрипт при первой ошибке
# psql -v ON_ERROR_STOP=1 или --set ON_ERROR_STOP=on или \set ON_ERROR_STOP on
#
psql \
    -X \
    -U user \
    -h $DBHOST \
    -f /path/to/sql/file.sql \
    --echo-all \
    --set AUTOCOMMIT=off \
    --set ON_ERROR_STOP=on \
    --set TSUFF=$TSUFF \
    --set QTSTUFF=\'$TSUFF\' \
    mydatabase

# $? - последняя команда была успешной (Ответ - 0, что означает «да».)
psql_exit_status = $?

# 1>&2 - означает перенаправление stdout на stderr
# stdout будет перенаправлен в stderr
if [ $psql_exit_status != 0 ]; then
    echo "psql не удалось запустить этот sql-скрипт" 1>&2
    exit $psql_exit_status
fi

echo "sql скрипт успешно выполнен"
exit 0