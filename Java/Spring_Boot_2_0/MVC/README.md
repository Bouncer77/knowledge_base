# MVC

HTTP Methods:

1. GET
2. POST
3. PUT
4. PATCH
5. UPDATE
6. DELETE

JSON или XML

CRUD Operations:

1. CREATE
2. READ
3. UPDATE
4. DELETE

CRUD Operation | HTTP Method
---------------|-------------------------------
CREATE         | POST
READ           | GET
UPDATE         | PUT
DELETE         | DELETE

Обычно:

1. GET - любое чтение 
2. POST - любое изменение


Spring MVC + Web-Server Tomcat
```xml
<dependency>
    <artifactId>spring-boot-starter-web</artifactId>
    <groupId>org.springframework.boot</groupId>
</dependency>
```

## Коменда трассировки пути

`tracert ya.ru`

## Протокол HTML

Сетевой стек: TCP/IP

Передача бинарных данных: URL Encode RFC 1867 или base64

MIME type  - как кодировать бинарные данные для пересылки информации

Коды ответа HTML:

1. 2xx - удача
2. 3xx - редирект
3. 4xx - неудача (ошибка клиента)
4. 5xx - сбой (ошибка сревера)

Работа с запросами HTTP:

## Куки (Cookie) сессии

HTTP statless (без состояния) протокол

Кукие вкладываются в ответ сервера
Кукие можно подделать - поэтому он не используются для идентификации пользователя при запросе личного кабинета банка

Корзина в интернет магазине реализована через Cookie, Cookie храняться на компьютере пользователя

## Сессии

Передается JSESSIONID в ответе от сервера передается случайное число, которое нельзя легко подделать, данные храняться на сервере, доступ можно открыть только по идентификатору сессии

логин + пароль ->
				<- SessionID

	SessionID	->

## Браузер

F12 -> Preserve log (сохранять логи запросов и ответов)