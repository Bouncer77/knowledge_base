# Шпаргалка по менеджеру пакетов YUM RedHat (RHEL), CentOS, Fedora, Oracle Linux, Scientific Linux

CentOS 8 - Функционально это полная копия RHEL 8
	
	Переход на пакетный менеджер DNF, который поддерживает модульный формат пакетов. Прощай YUM. Теперь это просто алиас для запуска dnf.

	не осталось минимального установочного образа для локальной установки.

	Напоминаю, что 32 bit или i386 редакции CentOS 8 не существует. Все дистрибутивы только x86_64, то есть 64 bit.

	http://mirror.corbina.net/pub/Linux/centos/
	http://mirror.docker.ru/centos/
	http://mirror.logol.ru/centos/

CentOS 7 - Функционально это полная копия RHEL 7

[Скачать CentOS 7](https://mirror.yandex.ru/centos/7.9.2009/isos/x86_64/)

[Установка CentOS8](https://serveradmin.ru/ustanovka-centos-8/#_iso)

[Зеркало Яндекса для загрузки CentOS](https://mirror.yandex.ru/centos/)

[CentOS 8.3.2011](https://mirror.yandex.ru/centos/8/isos/x86_64/)

CentOS-8.3.2011-x86_64-boot.iso - Установка через интернет 683 Мб

CentOS-8.3.2011-x86_64-dvd1.iso  - Офлайн установка ~ 9 Гб

Minimal Install и установка Standart. Если ставлю на виртуальную машину, то дополнительно выбираю Guest Agents.




	В этой статье мы рассмотрим менеджер пакетов Yum, который позволяет управлять установкой, удалением и обновлением программ (.RPM-пакетов), автоматически разрешать зависимости, управлять дополнительными репозиториями

`Yum (Yellowdog Updater Modified)` – консольный менеджер пакетов для дистрибутивов Linux, основанных на пакетах формата RPM. (RedHat Package Manager) Сюда входят такие популярные ОС как RedHat, CentOS, Fedora, Oracle Linux, Scientific Linux.

Команда                      | Назначение
-----------------------------|--------------------------------------------
yum help | полная справка по менеджеру пакетов yum
yum clean all |  очистить кеш всех пакетов (обчычно используется при возникновении проблем при работе yum).
yum makecache |  пересоздать кеш пакетов заново.
yum repolist |  отобразить список подключенных репозиториев