#### Утилиа для управления сервером - pg_ctl

утилита pg_ctl (ctl - controll) доступ через специальную обертку `pg_ctlcluster` (для Ubuntu)

`pg_ctlcluster <версия PostgresSQL> main <команда>`

Назначение команды         | Команда
---                        | ---
**Остановить сервер:**     | postgres$ `pg_ctlcluster 12 main stop`
**Запустить сервер:**      | postgres$ `pg_ctlcluster 12 main start`
**Перезапустить:**         | postgres$ `pg_ctlcluster 12 main restart`
**Обновить конфигурацию:** | postgres$ `pg_ctlcluster 12 main reload`
 | 
 | sudo systemctl restart postgresql@12-main
 
 `sudo systemctl reload postgresql-12`

# Переустановка Postgres

1. Зайти под пользователем postgres или root -ом

`sudo -iu postgres`

2. Проверить работает ли кластер 

	`ps -C postgres`

3. Удалить кластер

	`sudo pg_dropcluster 12 main`

4. Оставшиеся пакеты 

	4.1 `apt-get --purge remove postgresql\*`

	или в ручную

	4.1* Вывести список пакетов связанных с postgres

	`dpkg -l | grep postgres`

	4.2* Удалить пакеты

	`sudo apt-get --purge remove postgresql postgresql-8.3  postgresql-client  postgresql-client-8.3 postgresql-client-common postgresql-common  postgresql-contrib postgresql-contrib-8.3`

5. Удалить директории, пользователя и группу postgres

Выполнять от root

```bash
# -f или --force
# Игнорировать несуществующие файлы и аргументы. Никогда не выдавать запросы на подтверждение удаления.
rm -rf /etc/postgresql/
rm -rf /etc/postgresql-common/
rm -rf /var/lib/postgresql/
rm -rf /var/log/postgresql/
# Вывести список процессов пользователя
# ps -fu sergiy 
userdel -r postgres
groupdel postgres
```

6. Установка postgres 

```bash
sudo apt update
sudo apt -y upgrade
sudo reboot

cd /var/lib/pgsql/12/data
mkdir ref_data_tablespace ref_index_tablespace
# sudo mkdir -p ./one/{two1,two2,two3}/two
chown -R postgres:postgres /var/lib/pgsql/
```




	


