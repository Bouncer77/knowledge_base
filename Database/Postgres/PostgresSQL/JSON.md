# JSON - JSONB

[Типы JSON](https://postgrespro.ru/docs/postgrespro/12/datatype-json)
[Функции и операторы JSON](https://postgrespro.ru/docs/postgrespro/12/functions-json#FUNCTIONS-SQLJSON-PATH)

JSON (JavaScript Object Notation, Запись объекта JavaScript) согласно стандарту RFC 7159. 

типы JSON лучше тем, чем text, так как проверяют, соответствует ли вводимое значение формату JSON

## Разница между типом json и jsonb

Свойство                                 | JSON            | JSONB
-----------------------------------------|-----------------|----------------------------------------
Сохраняет точную копию введённого текста | + (быстрый ввод, медленная обработка - из-за разбора)              | - (медленный ввод, быстрая обработка - так как не требует разбора)
Поддерживает индексацию                  | -               | +
Сохраняет семантически незначащие пробелы между элементами | + | -
Сохраняет порядок ключей | + | -
Дублирующиеся ключи    | + (последнее значение) | - (последнее значение)

SELECT '{"reading": 1.230e-5}'::json, '{"reading": 1.230e-5}'::jsonb;
         json          |          jsonb          
-----------------------+-------------------------
 {"reading": 1.230e-5} | {"reading": 0.00001230}
(1 row)

Оператор                          | Описание
----------------------------------|-----------------------------
@> (оператор вхождения) | определяет, входит ли один документ jsonb в другой
? (оператор существования) | \проверяет, является ли строка (заданная в виде значения text) ключом объекта или элементом массива на верхнем уровне значения jsonb.

```sql
-- Найти документы, в которых ключ "tags" содержит ключ или элемент массива "qui"
SELECT jdoc->'guid', jdoc->'name' FROM api WHERE jdoc -> 'tags' ? 'qui';

-- Найти документы, в которых ключ "tags" содержит элемент массива "qui"
SELECT jdoc->'guid', jdoc->'name' FROM api WHERE jdoc @> '{"tags": ["qui"]}';

-- # json_path
SELECT jdoc->'guid', jdoc->'name' FROM api WHERE jdoc @@ '$.tags[*] == "qui"';
SELECT jdoc->'guid', jdoc->'name' FROM api WHERE jdoc @@ '$.tags[*] ? (@ == "qui")';
```

Тип jsonpath предназначен для реализации поддержки языка путей SQL/JSON в Postgres Pro, позволяющего эффективно выполнять запросы к данным JSON

Точка (.) применяется для доступа к члену объекта.

Квадратные скобки ([]) применяются для обращения к массиву.

Элементы массивов в SQL/JSON нумеруются с 0, тогда как обычные массивы SQL — с 1.

## Examples

```sql
CREATE TABLE pilot_hobbies
(
pilot_name text,
hobbies jsonb
);

INSERT INTO pilot_hobbies
VALUES ( 'Ivan',
		'{ "sports": [ "футбол", "плавание" ],
			"home_lib": true, "trips": 3
		}'::jsonb
		),
		( 'Petr',
		'{ "sports": [ "теннис", "плавание" ],
			"home_lib": true, "trips": 2
		}'::jsonb
		),
		( 'Pavel',
		'{ "sports": [ "плавание" ],
			"home_lib": false, "trips": 4
		}'::jsonb
		),
		( 'Boris',
		'{ "sports": [ "футбол", "плавание", "теннис" ],
			"home_lib": true, "trips": 0
		}'::jsonb
);

SELECT * FROM pilot_hobbies;


SELECT * FROM pilot_hobbies
WHERE hobbies @> '{ "sports": [ "футбол" ] }'::jsonb;

SELECT pilot_name, hobbies->'sports' AS sports
FROM pilot_hobbies
WHERE hobbies->'sports' @> '[ "футбол" ]'::jsonb;

SELECT count( * )
FROM pilot_hobbies
WHERE hobbies ? 'sports';

UPDATE pilot_hobbies
SET hobbies = hobbies || '{ "sports": [ "хоккей" ] }'
WHERE pilot_name = 'Boris';

SELECT pilot_name, hobbies
FROM pilot_hobbies
WHERE pilot_name = 'Boris';

UPDATE pilot_hobbies
SET hobbies = jsonb_set( hobbies, '{ sports, 1 }', '"футбол"' )
WHERE pilot_name = 'Boris';
/*Второй параметр функции указывает путь в пределах JSON-объекта, куда нужно добавить новое значение. В данном случае этот путь состоит из имени ключа (sports)
и номера добавляемого элемента в массиве видов спорта (номер 1). Нумерация элементов начинается с нуля. Третий параметр имеет тип jsonb, поэтому его литерал
заключается в одинарные кавычки, а само добавляемое значение берется в двойные
кавычки. В результате получается — '"футбол"'.

Подробно использование типов JSON рассмотрено в документации в разделах 8.14
«Типы JSON» и 9.15 «Функции и операторы JSON»*/
```