# Java
	
1. Java Core

2. Java Collections Framework

3. Multi-threading

4. Patterns

5. Code style

# Установка Java

[Скачать JDK8 (Linux x64 Compressed Archive) (jdk-8u291-linux-x64.tar.gz)](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html)

[Как правильно установить Java 8 на GNU/Linux](https://www.youtube.com/watch?v=GEGJGu3Pxmk)

```bash
sudo mkdir -p /usr/lib/jvm
sudo tar -xf jdk-8u291-linux-x64.tar.gz -C /usr/lib/jvm

sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_291/bin/java 1
# Javac — оптимизирующий компилятор языка java
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.8.0_291/bin/javac 1
# Java Web Start
sudo update-alternatives --install /usr/bin/javaws javaws /usr/lib/jvm/jdk1.8.0_291/bin/javaws 1

sudo update-alternatives --config java
sudo update-alternatives --config javac
sudo update-alternatives --config javaws

export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_291
# или
# sudo echo "/usr/lib/jvm/jdk1.8.0_291" >> /etc/environment

echo $JAVA_HOME
#/usr/lib/jvm/jdk1.8.0_291

export PATH=$PATH:$JAVA_HOME/bin
echo $PATH
# PATH="... :$JAVA_HOME/bin"

java -version
# java version "1.8.0_291"
# Java(TM) SE Runtime Environment (build 1.8.0_291-b10)
# Java HotSpot(TM) 64-Bit Server VM (build 25.291-b10, mixed mode)
```