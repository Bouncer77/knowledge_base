# Installation Sublime Text 3

## Windows

Запустите и установите программу `Sublime Text Build 3126 x64 Setup Windows.exe`.

	Примичание: Если вы обновите ST3 выше Build 3126 или будете использовать более младшие билды, то ключ для лицензии скорее всего не подойдет!

## Ubuntu (Linux)

Рекомендуется использовать Вариант 2, как самый быстрый. 

### Вариант 1
У вас есть несколько вариантов для установки. Вы можете просто скачать (http://www.sublimetext.com/3) с официального сайта установочный файл, а затем воспользоваться данной командой в папке, куда вы сохранили deb-файл:
sudo dpkg -i sublime-text_build-3047_i386.deb

### Вариант 2
Другой, более быстрый способ - воспользоваться репозиторием от команды WebUpd8. Просто воспользуйтесь следующими командами:
sudo add-apt-repository ppa:webupd8team/sublime-text-3
sudo apt-get update && sudo apt-get install sublime-text-installer
Пакет sublime-text-installer автоматически скачает последнюю версию редактора и установит его.