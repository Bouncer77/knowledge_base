# Установка

[Скачать TeamCity](https://www.jetbrains.com/ru-ru/teamcity/)

[Установка на Linux](https://www.jetbrains.com/help/teamcity/installation-quick-start.html#on+Linux+and+OS+X)

> Для установки TeamCity требуется JRE 8


```bash
# Версия Java должна быть не ниже 8-ой
bouncer77@Server-B77:~/Downloads$ echo $JAVA_HOME
/usr/lib/jvm/jdk1.8.0_291

bouncer77@Server-B77:~/Downloads$ java -version
java version "1.8.0_291"
Java(TM) SE Runtime Environment (build 1.8.0_291-b10)
Java HotSpot(TM) 64-Bit Server VM (build 25.291-b10, mixed mode)

# Распаковать TeamCity
tar xfz TeamCity-2020.2.4.tar.gz

# start to start the server and the default agent
./runAll.sh start

# stop to stop the server and the default agent
./runAll.sh stop

# Настройка учетки администратора, репозитория, проекта, скриптов развертывания
http://localhost:8111/
```

## Другие ссылки

[Команды для установки](https://www.jetbrains.com/help/teamcity/installing-and-configuring-the-teamcity-server.html#Starting+TeamCity+server)

[Инструкция по установке](https://www.jetbrains.com/help/teamcity/installing-and-configuring-the-teamcity-server.html#Unattended+TeamCity+server+installation)

# CI/CD

## Непрерывная интеграция (Continuous Integration)


Непрерывная интеграция — это практика разработки, которая призывает группы разработчиков обеспечивать сборку и последующее тестирование для каждого изменения кода, вносимого в программное обеспечение.

Концепция в которой разработчики обеспечивают автоматическую сборку и тестирование при каждом изменении в коде

## непрерывной доставки

Непрерывная доставка основывается на автоматизации сборки и тестирования, которую вводит непрерывная интеграция. Она предполагает перевод ручных шагов, необходимых для выпуска сборки приложения в продакшн, — в автоматизированный процесс.

Непрерывная доставка предполагает, что для каждой успешной сборки автоматически выполняется развертывание на каждом препродакшн-окружении.

четкое разделение между приложением и переменными или параметрами среды.

Хранить конфигурацию в VCS

перед каждым развертыванием необходимо сбрасывать настройки окружений до одного и того же исходного набора условий.

## Непрерывное развертывание

Непрерывное развертывание завершает логическую цепочку из практик непрерывной интеграции и доставки: если сборка успешно проходит все предыдущие стадии пайплайна, она автоматически выпускается в продакшн.

Чтобы не упускать преимущества непрерывной интеграции, вместо веток вы можете использовать флаги функций. Так вы сможете контролировать, какие возможности видны пользователю, а какие скрыты, и спокойно продолжать разработку.


## Сине-зеленое развертывание
## канареечное развертывание

Сине-зеленое развертывание распространено в организациях, использующих непрерывное развертывание, поскольку оно упрощает процедуру отката к предыдущей версии, необходимого на случай возникновения проблем: для этого старый код продолжает храниться в продакшне, пока вы не убедитесь, что все изменения работают должным образом. Если нужно, вы можете выполнить канареечное развертывание с последующим сине-зеленым выпуском.

## флаги функций

Долгосрочные ветки используются для хранения новой функциональности, которая пока не готова к релизу. Для этой цели можно также использовать флаги функций.

## Локальное тестирование

Представьте, что вы отвлекаетесь от своей работы, принимаетесь искать причину падения и в конце концов выясняете, что оно было вызвано чем-нибудь совсем тривиальным — синтаксической ошибкой или пропущенной зависимостью. Такое может раздражать. Чтобы таких ситуаций не возникало, можно поручить членам команды выполнять сборку и базовый набор тестов локально и только после этого публиковать свои изменения. В идеале, у всех должна быть возможность использовать в качестве CI/CD одни и те же скрипты — так никому не придется делать лишнюю работу.

## Собирайте один раз

Типичной ошибкой является создание новой сборки для каждого шага CI/CD. Пересобирая приложение для разных окружений, вы рискуете нарушить консистентность и не будете знать наверняка, было ли тестирование на предыдущих шагах успешным. Поэтому на протяжении всех шагов CI/CD-пайплайна (включая конечный релиз в продакшн) необходимо использовать один и тот же артефакт.

Чтобы реализовать это, нужно сделать сборки независимыми от окружения. Любые переменные, параметры аутентификации, конфигурационные файлы и скрипты должны вызываться скриптом развертывания и не быть частью самой сборки. Это позволит делать развертывание одного и того же артефакта в каждом тестовом окружении. Тогда прохождение каждой стадии будет повышать уверенность команды в этом артефакте.

артефакты сборки должны храниться отдельно
Вместо этого сборке должна быть присвоена версия, после чего она сохраняется в центральный репозиторий артефактов, например, Nexus, откуда ее всегда можно достать, чтобы выполнить развертывание.

## Тесты

юнит-тестами

автоматизированных интеграционных или компонентных тестов, проверяющих взаимодействие между различными частями вашего кода.








## CI (Continuous Integration) - Непрерывная доставка (интеграция)

Непрерывная доставка — это технология разработки, позволяющая командам производить ПО в рамках коротких циклов.

Если на какой-либо стадии пайплайна обнаружится ошибка, быстрое информирование и совместная работа позволят быстрее решить проблему, чем если бы вам пришлось писать длинные отчеты для последующего одобрения комиссией.

## CD (Continuous Deployment) - Непрерывное развертывание

Непрерывное развертывание (Continuous Deployment, CD) — это процесс автоматического развертывания изменений из репозитория в продакшн.




1. CODE 
2. BUILD
3. TEST
4. RELEASE
5. DEPLOY 
6. OPERATE
7. MONITOR
8. PLAN

CI
Показывает ошибка на ранних этапах
Весь код в репозиториях в одной ветки

После слияния - сборка и тестирование автоматически

Тестирование билда не более 10 минут - так как проверка написанного кода

CD (Delivery)
Готовить проект к релизу на боевой сервер

Одобрить развертывание в продакшен и запустить его

Сборка релиза автоматическая

CD (Deployment)
Развернуть в продакшен

Обычно в Continuous Integration проводится 3 типа тестов, а именно 

1. модульные тесты
	Модульные тесты написаны для проверки поведения небольших частей вашего приложения в изоляции. Обычно их можно запускать без запуска всего приложения. Они не попадают в базу данных (если она есть в вашем приложении), файловую систему или сеть. 
2. тесты компонентов
	Тесты компонентов проверяют поведение нескольких компонентов вашего приложения. Как и модульные тесты, они не всегда требуют запуска всего приложения. Однако они могут попасть в базу данных, файловую систему или другие системы (которые могут быть отключены).
3. приемочные тесты