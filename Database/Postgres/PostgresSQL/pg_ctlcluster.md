#### Утилиа для управления сервером - pg_ctl

утилита pg_ctl (ctl - controll) доступ через специальную обертку `pg_ctlcluster` (для Ubuntu)

`pg_ctlcluster <версия PostgresSQL> main <команда>`

Назначение команды         | Команда
---                        | ---
**Остановить сервер:**     | postgres$ `pg_ctlcluster 12 main stop`
**Запустить сервер:**      | postgres$ `pg_ctlcluster 12 main start`
**Перезапустить:**         | postgres$ `pg_ctlcluster 12 main restart`
**Обновить конфигурацию:** | postgres$ `pg_ctlcluster 12 main reload`