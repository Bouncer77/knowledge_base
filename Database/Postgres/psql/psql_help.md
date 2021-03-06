# $ psql --help
	psql - это интерактивный терминал PostgreSQL.

	Использование:
	  psql [ПАРАМЕТР]... [БД [ПОЛЬЗОВАТЕЛЬ]]

	Общие параметры:
	  -c, --command=КОМАНДА    выполнить одну команду (SQL или внутреннюю) и выйти
	  -d, --dbname=БД          имя подключаемой базы данных (по умолчанию "ikosenkov")
	  -f, --file=ИМЯ_ФАЙЛА     выполнить команды из файла и выйти
	  -l, --list               вывести список баз данных и выйти
	  -v, --set=, --variable=ИМЯ=ЗНАЧЕНИЕ
	                           присвоить переменной psql ИМЯ заданное ЗНАЧЕНИЕ
	                           (например: -v ON_ERROR_STOP=1)
	  -V, --version            показать версию и выйти
	  -X, --no-psqlrc          игнорировать файл параметров запуска (~/.psqlrc)
	  -1 ("один"), --single-transaction
	                           выполнить как одну транзакцию
	                           (в неинтерактивном режиме)
	  -?, --help[=options]     показать эту справку и выйти
	      --help=commands      перечислить команды с \ и выйти
	      --help=variables     перечислить специальные переменные и выйти

	Параметры ввода/вывода:
	  -a, --echo-all           отображать все команды из скрипта
	  -b, --echo-errors        отображать команды с ошибками
	  -e, --echo-queries       отображать команды, отправляемые серверу
	  -E, --echo-hidden        выводить запросы, порождённые внутренними командами
	  -L, --log-file=ИМЯ_ФАЙЛА сохранять протокол работы в файл
	  -n, --no-readline        отключить редактор командной строки readline
	  -o, --output=ИМЯ_ФАЙЛА   направить результаты запроса в файл (или канал |)
	  -q, --quiet              показывать только результаты запросов, без сообщений
	  -s, --single-step        пошаговый режим (подтверждение каждого запроса)
	  -S, --single-line        однострочный режим (конец строки завершает команду)

	Параметры вывода:
	  -A, --no-align           режим вывода невыровненной таблицы
	      --csv                режим вывода в формате CSV (значения, разделённые
	                           запятыми)
	  -F, --field-separator=СТРОКА
	                           разделителей полей при невыровненном выводе
	                           (по умолчанию: "|")
	  -H, --html               вывод таблицы в формате HTML
	  -P, --pset=ПАР[=ЗНАЧ]    определить параметр печати ПАР (с заданным ЗНАЧЕНИЕМ)
	                           (см. описание \pset)
	  -R, --record-separator=СТРОКА
	                           разделитель записей при невыровненном выводе
	                           (по умолчанию: новая строка)
	  -t, --tuples-only        выводить только кортежи
	  -T, --table-attr=ТЕКСТ   установить атрибуты HTML-таблицы (width, border)
	  -x, --expanded           включить развёрнутый вывод таблицы
	  -z, --field-separator-zero
	                           сделать разделителем полей при невыровненном
	                           выводе нулевой байт
	  -0, --record-separator-zero
	                           сделать разделителем записей при невыровненном
	                           нулевой байт

	Параметры подключения:
	  -h, --host=ИМЯ           имя сервера баз данных или каталог сокетов
	                           (по умолчанию: "локальный сокет")
	  -p, --port=ПОРТ          порт сервера баз данных (по умолчанию: "5432")
	  -U, --username=ИМЯ       имя пользователя (по умолчанию: "ikosenkov")
	  -w, --no-password        не запрашивать пароль
	  -W, --password           запрашивать пароль всегда (обычно не требуется)

	Чтобы узнать больше, введите "\?" (список внутренних команд) или "\help"
	(справка по операторам SQL) в psql, либо обратитесь к разделу psql в
	документации PostgreSQL.

	Об ошибках сообщайте по адресу <pgsql-bugs@lists.postgresql.org>.


