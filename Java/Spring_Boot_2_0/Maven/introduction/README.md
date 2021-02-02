# Maven

[Java Pro-двинутый #1. Основы Maven](https://www.youtube.com/watch?v=0uwMKktzixU)

Фреймворк для автоматизации сборки проектов, а так же может сгенерировать каркас проекта

Позволяет управлять зависимостями внутри проекта и импортом сторонних библиотек 

Jar - java архив
War - java архив веб приложения
Yar - java архив Enterprise

## Ключевые понятия

pom.xml - Описание прокта

Группа (groupId) - группа проектов  
Артефакт (artifactId) - часть проекта  
Версия (version) - версия проекта  

Репозитории и зависимости

## Установка Maven

Скачать, распаковать

M2_HOME = C:\Apps\apache-maven-3.6.3-bin\apache-maven-3.6.3

M2 = %M2%\bin

Path = %M2%

## Работа с Maven из командной строки

Сгенерировать новый проект maven:  
$`mvn archetype:generate`  
$`spring-boot` - условие сортировки пакетов
$`69` номер архетипа из списка  `spring-boot-web-static` (MVC по умолчанию в .war архив собирается)  
$`<groupId>`  - com.bouncer77.maven  
$`<artifactId>` - test1
$`порядковый номер <version>` - Enter (Snapshot)  
$`<package>` обычно значение совпадает с `<groupId>` - Enter   
$Y::`Y` Подтверждение

Собрать приложение MVC (.war архив по умолчанию):   
$`cd <имя папки проекта>` = `<artifactId>`  
$`mvn clean package` - собрать проект  
$`cd target` - перейти к собранному проекту (war или jar)
$`java -jar <имя_файла.war>` - запустить




