# JPA

Приложение начинает парсить файл JSON при получении GET запроса (порт 80) по адресу localhost/json и с помощью бибилиотеки Jeckson мапит поля из JSON-а на POJO классы Java - сохраняя их в коллекцию ArrayList, затем с помощью Spring Data Jpa (CrudRepository) сохраняет методом saveAll в базу данных PostgresSQL 