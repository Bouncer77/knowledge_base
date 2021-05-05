# Установка докера 

https://www.digitalocean.com/community/tutorials/docker-ubuntu-18-04-1-ru

```bash
# 1 обновляем существующий перечень пакетов
sudo apt update

# 2 устанавливаем необходимые пакеты, которые позволяют apt использовать пакеты по HTTPS:
sudo apt install apt-transport-https ca-certificates curl software-properties-common

# 3 добавляем в свою систему ключ GPG официального репозитория Docker:
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

# 4 Добавляем репозиторий Docker в список источников пакетов APT:
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

# 5 Затем обновим базу данных пакетов информацией о пакетах Docker из вновь добавленного репозитория:
sudo apt update

# 6 Следует убедиться, что мы устанавливаем Docker из репозитория Docker, а не из репозитория по умолчанию Ubuntu: (так как в репозитории Ubuntu более старые версии)
apt-cache policy docker-ce

# Вывод:
# docker-ce:
#   Installed: (none)
#   Candidate: 18.03.1~ce~3-0~ubuntu
#   Version table:
#      18.03.1~ce~3-0~ubuntu 500
#         500 https://download.docker.com/linux/ubuntu bionic/stable amd64 Packages

# 7 устанавливаем Docker:
sudo apt install docker-ce

# 8 Теперь Docker установлен, демон запущен, и процесс будет запускаться при загрузке системы.  Убедимся, что процесс запущен:
sudo systemctl status docker

# Вывод
# docker.service - Docker Application Container Engine
#    Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
#    Active: active (running) since Thu 2018-07-05 15:08:39 UTC; 2min 55s ago
#      Docs: https://docs.docker.com
#  Main PID: 10096 (dockerd)
#     Tasks: 16
#    CGroup: /system.slice/docker.service
#            ├─10096 /usr/bin/dockerd -H fd://
#            └─10113 docker-containerd --config /var/run/docker/containerd/containerd.toml

# 9 Использование команды Docker без sudo (опционально)

# 9.1 Чтобы не вводить sudo каждый раз при запуске команды docker, добавьте имя своего пользователя в группу docker:
sudo usermod -aG docker ${USER}

# 9.2 Для применения этих изменений в составе группы необходимо разлогиниться и снова залогиниться на сервере или задать следующую команду:
su - ${USER}

# 9.3 Убедиться, что пользователь добавлен в группу docker можно следующим образом:
id -nG
# Вывод
# sammy sudo docker
```

# Опимание докера

Единый механизм сборки

В контейнере приложение, все системные переменные, вне необходимые зависимости

Docker - средство упоковки, доставки и запуска приложений

1. Упаковки

	Пакуем все необходимое в контейнер

2. Доставки

	Контейнер передать и запустить единым образом 

	Приложение на Python и на Java запускается через единый интерфейс, те единым образом

# Термины

1. Docker Image

	Единый механизм сборки приложений

	Готовое к запуску приложение

	Реестр Image находится: `dockerhub`

	Images можно запушить в dockerhub - а оттуда брать уже на прожакшен сервер и запускать - Единый механиз доставки приложений

2. Docker Container

	Единый механизм запуска приложений

	Работающее приложение, созданное на базе Docker Image

	Container никаким образом не может изменить Docker Image



# Создание своего образа

```bash
# Создание тестового приложение на Python
echo "print(\"Hello, World""!""\")" > hello.py
```

## Создание Dockerfile

```bash
# Каждая команда создает новый слой

# Базовый образ с которого начинаем сборку
FROM python:3.9

# выполняет команду за RUN
RUN mkdir -p /usr/src/app/
# Перейти в каталог
WORKDIR /usr/src/app/

# Откуда - куда (Поместить наши файлы в контейнер)
COPY . /usr/src/app/

# Что надо докеру сделать при запуске контейнера
CMD ["python", "app.py"]
# или (без bash)
# ENTRYPOINT ["python", "app.py"]
```

## Запуск

```bash
# Создание Docker Images
docker build -t hello-python .

# Запуск Docker Container
docker run hello-python
# или (с передачей имени)
docker run --name mySuperName hello-python

# -d - запустить в фоновом режиме
docker run --name test2 -d hello-python-2

# Все образы
docker images

# Запущенные контейнеры
docker ps

# Показать отработавщие контейнеры
docker ps -a

# Удалить контейнеры
docker rm <id_контейнера>
docker rm <имя_контейнера>

# Удалить все контейнеры 
#    docker ps -a -q | выводит id всех контейнеров
docker rm $(docker ps -aq)

# Остановить выполнение контейнера
docker stop <имя_контейнера>
docker stop <id_контейнера>

# --rm - удаляет контейнер после остановки или завершения
# -d - запустить контейнер в фоновом режиме
docker run --name test2 -d --rm hello-python-2

# Указание порта
# -p порт_в_основной_ос:порт_в_докер_контейнере
# 
# Указание переменных
# 1) В Docker файле для образа: 
# ENV TZ Europe/Moscow
# 
# 2) При запуске контейнера
docker run --rm --name web -p 8080:8080 -e TZ=Europe/Moscow web-python-hello
```

# Docker контейнер и Persistance данные

1. Примонтировать директорию к Docker контейнеру

```bash
# -v <хостовая_машина_путь>:<абсолютный_путь_в_директории_внутри_контейнера>

docker run --rm --name web -p 8080:8080 -e TZ=Europe/Moscow -v /home/bouncer77/Projects/PythonProjects/web_python_docker/resources:/usr/src/app/resources web-python-hello
```

2. Docker Volume - надстройка над директориями

```bash
# Вывести список Volumes
docker volume ls

# Создать Volume
docker volume create web

# -v <имя_volume>:<абсолютный_путь_в_директории_внутри_контейнера>

docker run --rm --name web -p 8080:8080 -e TZ=Europe/Moscow -v /home/bouncer77/Projects/PythonProjects/web_python_docker/resources:/usr/src/app/resources web-python-hello
```

Все что будет создано внутри докер контейнера попадет в Volume



# БД

```bash
docker run --rm -p 27017:27017 -d mongo
```

# Images

```bash
# Удалить Images
docker rmi <имя_образа>
docker rmi <id_образа>

docker rmi $(docker images -q)
```

# Docker Compouse

Надстройка над Doker - по сути переменные среды записанные в файл с именем `docker-compose.yaml`

## Установка 

https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04-ru

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
 


```