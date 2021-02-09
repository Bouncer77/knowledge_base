# Настройка Git

GIT - распределенная система контроля версий

## Первоначальная настройка Git

$`git config --global user.name "Имя Фамилия"`
$`git config --global user.email puskin@gmail.com`

Меняет цветовую схему на более читаемую
$`git config --global color.ui true`

## Параметр AutoCRLF

В разных операционных системах приняты разные символы для перевода строк:

1. Windows - \r\n (или CR и LF, код 0D0A в 16-ричной системе счисления)

2. Unix - \n (LF, код 0A)

3. Mac - \r (CR, код 0D)

**Настройка core.autocrlf предназначена для того, чтобы в главном репозитории все переводы строк текстовых файлах были одинаковы.**


Тогда при коммитах (или, если более строго, при чтении файлов из файловой системы) все переводы строк при хранении будут приведены к виду \n, как в Unix, а при записи в файлы будут преобразованы к виду \r\n, как в Windows.

```bash
git config core.autocrlf true
git config --global core.autocrlf true
```

## Ошибка при которой прокручивается на черный экран

Options -> Window -> Rows присвоить 32, вместо 24, который епо умолчанию

## Команды

Показать список настроек: 

$`git config --list --show-origin`

## Генерация ssh ключей 

```bash
# ключ SSH с шифрованием RSA и 4096
ssh-keygen -t rsa -b 4096 -C "ваша@почта.com"

eval `ssh-agent -s`

`ssh-add ~/.ssh/id_rsa`

cat ~/.ssh/id_rsa.pub
```

## ssh агент

Запуск в фоновом режиме  
`eval "$(ssh-agent -s)"`

Добавить ключ и указать пароль  
`ssh-add ~/.ssh/id_rsa`

[Подробнее об ssh-agent](https://kamarada.github.io/en/2019/07/14/using-git-with-ssh-keys/#.X-DHNNgzY2w)
[Менее подробно, но на русском](https://only-to-top.ru/blog/tools/2019-12-08-git-ssh-windows.html)