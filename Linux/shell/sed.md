Команда sed (потоковый редактор)
Источник: https://mirivlad.ru/2017/11/20-primerov-ispolzovaniya-potokovogo-tekstovogo-redaktora-sed/

Для подставки URL в sed мне помогло
#!/bin/bash
path=»what_replace = http://example.com»
sed -i «s#.*what_replace.*#$path#g» filename

## Отобразить часть файла

```bash
# Отобразить 22-29 строку
sed -n 22,29p testfile.txt

# Отобразить все строки, кроме 22-29
sed 22,29d testfile.txt

# Выводит каждую 3-ую строку начиная со 2ой строки
sed -n '2-3p' file.txt

# Удалить 5-ую строку
sed 5d testfile.txt

# Удалить последнюю строку
sed $d testfile.txt

# Удалить все строки, кроме 29-34
sed '29-34!d' testfile.txt

# Добавление пустой строки после каждой не пустой строки
sed G testfile.txt

# Замена первого вхождения слова danger в каждой строке на safety
sed 's/danger/safety/' testfile.txt
## в 4-ой строке
sed '4 s/danger/safety/' testfile.txt
## c 4-ой по 9-ую строки 
sed '4-9 s/danger/safety/' testfile.txt

# Замена всех вхождений слова danger на safety
sed 's/danger/safety/g' testfile.txt

# Замена только второго вхождения слова danger на safety
# DFASDF danger -> DFASDF danger 
# DFASDF danger ADFASDWFSADF danger FSDFA danger -> DFASDF danger ADFASDWFSADF safety FSDFA danger
sed 's/danger/safety/2' testfile.txt

# Замена только второго и последующих вхождения слова danger в строке на safety
# DFASDF danger -> DFASDF danger
# DFASDF danger ADFASDWFSADF danger FSDFA danger -> DFASDF danger ADFASDWFSADF safety FSDFA safety
sed 's/danger/safety/2g' testfile.txt

sed '/danger/a "Это новая строка с текстом после найденного слова"' testfile.txt

# safety danger -> --###
#                  safety danger
sed '/danger/i "Это новая строка с текстом вставленная до найденного совпадения поиска" ' testfile.txt

sed '/danger/c "Строка со словом danger будет заменена на эту строку" ' testfile.txt

# Запуск нескольких команд sed
sed -e 's/danger/safety/g' -e 's/hate/love/' testfile.txt

# Создание резервной копии перед изменением файла.
sed -i.bak -e 's/danger/safety/g'  testfile.txt

# Удалить строчку соответствующую шаблону
sed -e 's/danger.*stops//g' testfile.txt

# Добавить testing sed перед каждой строкой
sed -e 's/.*/testing sed &/' testfile.txt

# Для удаления всех закомментированных строк (например начинающихся с #), а так же всех пустых строк выполните:
sed -e 's/#.*//;/^$/d' testfile.txt

# Удаление комментириев (начинающихся с #)
sed -e 's/#.*//' testfile.txt

# Выводит /etc/passwd - а должна выводить только имена пользователей
sed 's/([^:]*).*/1/' /etc/passwd

# В этом примере sed проследует по символьной ссылке коей на самом деле является указанный файл "/etc/sysconfig/selinux" и отредактирует тот файл, на который эта ссылка указывает, вместо того чтобы редактировать файл ссылки как настоящий.
sed -i --follow-symlinks 's/SELINUX=enforcing/SELINUX=disabled/g' /etc/sysconfig/selinux
```