# Основные операторы языка интерпритатора Shell

Основная реализация интерпритотаро это `Bash shell`

Команды оболочки `Bash` входят в стандарт `POSIX`, т.е. реализованы в любой Unix-подобной ОС.

Приглашение обозначается символом:

1. `$` для обычных пользователей
2. `#` для root

## Учетная запись

`sudo -i`, `su` - стать суперпользователем


### passwd

Сменить пароль от учетной записи

```bash
passwd [новый_пароль]
```

### exit

Завершение работы

```bash
# или Ctrl+D
exit
```

## Сочетания клавиш

Hotkey                    | Назначение
--------------------------|------------------------------------
`Ctrl+D   `                 | exit
`Shift+PageUp/PageDown`     | прокрутить экран вверх/вниз
`Tab`                       | дополнить название команды
`Tab x2`                    | вывести доступные названия команд или файлов
`Ctrl/Shift+Insert`         | копировать/вставить
`Ctrl+R`                    | искать по истории выполненных команд
`Win+Space`                 | переключение раскладки
`Ctrl-L`                  | Очистить терминал
`Ctrl+X+E`                | захватывает написанный текст и открывает его в редакторе, задаваемом в $EDITOR.

`EDITOR="vi"` в `~/.bashrc` (перезагрузить `source ~/.bashrc`)

## Перейти в режим терминала

Если вы установили Ubuntu на Vbox, чем запустить Ubuntu и нажмите правую-Ctrl + F2

Таким образом вы войдете в режим терминала и вернуться в любое время в GUI PRESS right-ctrl + F7

Делая это, я думаю, что вам даже не нужно устанавливать новую Ubuntu, вы можете запустить свою текущую Ubuntu без графики и потренироваться

Надеюсь, это поможет вам

## Help

```bash
# shell информация
man pwd

# Спавочная информация из оболочки bash
help pwd
```

## Виртуальные консоли

Позволяют войти в систему под несколькими именами в одно время

## Переменные среды

Переменные среды                  | Уровень
----------------------------------|---------------------------------
/etc/profile                      | Переменные среды - ОС
~/.bash_profile                   |                  - Пользователь
/etc/bashrc                       | Псевдонимы (alias) - ОС
~/.bashrc                         |                    - Пользователь

## Простые команды

Команда               | Значение
----------------------|--------------------------------
hostname [-i]         | Определить имя машины , [-i] - IP-address
uname [-m]            | Тип системы (Linux), [-m] - архитектура (x86_64), [-r] - print the kernel release 
lscpu                 | Информация о процессоре


# Общение

`mesg` - включение/выключение отправки прямых сообщений на терминал пользователя

`who` - список пользователей находящихся в системе

# Группы

`id` - информация о текущем пользователе

+ uid - уникальный номер пользователя в системе

+ gid - номер основной группы, к которой относится пользователь

# Размер Иерархия

`du` - аналог `tree` , `find`, `ls -R`

`du -BM /dir` - размер файлов в мебибитах. Мебибит содержит 1048576 (2^20) бит.

`wc <имя_файла>` - строки (-l), слова (-w), биты (-c), название файла

# Пути

Пути:

1. Абсолютный

	+ `/home/student/dir2/file`

2. Относительный:

	+ `~/dir2/file` - относительно домашней директории (strudent)
	+ `../dir2/file` - относительно директории `/home/student/dir1`


# ls

`ls -l` - сокращение от list - ls

drwxr-xr-x 2 postgres postgres  6 Feb  5 21:02 dir7
-rw-r--r-- 1 postgres postgres  0 Feb  5 21:05 file1.txt

1. d, -, l, c, b, s, p

	+ `d` - каталог
	+ `-` - простой файл
	+ `l` - символьная ссылка
	+ `c` - символьное устройство
	+ `b` - блочное устройство
	+ `s` - сокет
	+ `p` - канал

2. Права доступа к файлу

3. Количество ссылок на файл

4. Имя владельца

5. Имя группы владельца

6. Размер файла в байтах

7. Временной штамп

8. Имя файла

# Канал

Канал = символ `|` в bash - связь между потоками. 

Поток вывода `stdout` из одного процесса может быть связан с потоком ввода `stdin` другого процесса. 

# Редактор

`fc`
или
`Ctrl+X+E`

`EDITOR="vi"` в `~/.bashrc` (перезагрузить `source ~/.bashrc`)

Открывает текстовый редактор, чтобы написать длинную команду.

Писать можно на ваше усмотрение в vi, emacs, nano... Комбинация клавиш захватывает написанный текст и открывает его в редакторе, задаваемом в $EDITOR.

# Получить информацию о системе

cat /etc/os-release


