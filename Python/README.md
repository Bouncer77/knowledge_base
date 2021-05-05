# Установка Python из исходников без замены бинарного файла Python, который по умолчанию в /usr/bin/python

```bash
# 1 Установка библиотек, компиляторов
sudo apt install build-essential checkinstall
sudo apt install libreadline-gplv2-dev libncursesw5-dev libssl-dev libsqlite3-dev tk-dev libgdbm-dev libc6-dev libbz2-dev libffi-dev zlib1g-dev
sudo apt install python3-tk

# 2 Скачивание последней версии Python
### https://www.python.org/downloads/
### https://www.python.org/ftp/python/
wget wget https://www.python.org/ftp/python/3.9.4/Python-3.9.4.tgz


# 3 Распаковка Python архива и переход в распакованную директорию
tar -xzvf Python-3.9.4.tgz
cd Python-3.9.4/

# 4 Оптимизация
sudo ./configure --enable-optimizations

# 5 Установка без замены бинарного файла Python, который по умолчанию в /usr/bin/python
sudo make altinstall
```

# Проверка 

```bash
# 1 Проверка установки 
python3.9 -V

# 2 Создание и запуск программ

# Вариант 1 Создание Hello World программы на питоне
echo "print(\"Hello, World""!""\")" > hello.py
python3.9 hello.py

# Вариант 2 Bash стиль
echo "#""!""/usr/local/bin/python3.9" > hi.py
echo "print(\"Hello, World""!""\")" >> hi.py
chmod 774 hi.py
./hi.py
```

# Установка зависимостей из файла requirements.txt

```bash
pip install -r requirements.txt
```