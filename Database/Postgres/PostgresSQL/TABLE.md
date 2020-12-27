# TABLE

	Создание таблицы в языке SQL

## Синтаксис команды

`\h CREATE TABLE`

```sql
CREATE TABLE имя_таблицы
(
	имя-поля тип-данных [ограничения-целостности],
	имя-поля тип-данных [ограничения-целостности],
	...
	имя-поля тип-данных [ограничения-целостности],
	[ограничение-целостности],
	[первичный-ключ],
	[внешний-ключ]
);

-- TODO
ALTER TABLE имя_таблицы
ADD COLUMN имя-поля;

DROP TABLE имя_таблицы;

-- ЗАПОЛНЕНИЕ ТАБЛИЦ
INSERT INTO имя-таблицы [( имя-атрибута, имя-атрибута, ... )]
VALUES ( значение-атрибута, значение-атрибута, ... );

INSERT 0 1
0 имеет отношение к внутреннему устройству PostgreSQL
1 означает количество добавленных строк

SELECT имя-атрибута, имя-атрибута, ...
FROM имя-таблицы;

При выполнении простой выборки из таблицы СУБД не гарантирует
никакого конкретного порядка вывода строк

Обратите внимание, что символьные
значения при выводе выравниваются по левому краю столбца, а числовые значения — по правому краю.

-- обновления данных в таблицах
UPDATE имя-таблицы
SET имя-атрибута1 = значение-атрибута1,
имя-атрибута2 = значение-атрибута2, ...
WHERE условие; -- условие, ограничивающее диапазон обновляемых строк.

--операции удаления строк из таблиц
DELETE FROM имя-таблицы WHERE условие;
```