Code First - подход с Spring Boot auto-ddl - автоматическое создание схемы в бд

# POM

```pom
<dependency>
	<groupId>org.liquibase</groupId>
	<artifactId>liquibase-core</artifactId>
</dependency>

<plugin>
	<groupId>org.liquibase</groupId>
	<artifactId>liquibase-maven-plugin</artifactId>
	<version>3.6.3</version>
	<configuration>
		<propertyFile>${project.basedir}/src/main/resources/liquibase.properties</propertyFile>
	</configuration>
</plugin>
```

# application.properties

## hibernate

```
# Проверить сооттветствие отображения hibernate аннотаций - сущностям в бд
spring.jpa.hibernate.ddl-auto=validate

# Создать сущности в бд - соответствующие hibernate аннотациям
spring.jpa.hibernate.ddl-auto=update

# Ничего не делать
spring.jpa.hibernate.ddl-auto=none
```

## liquibase

```
spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
```

changeSet - commit в git

relativeToChangelogFile="true" - чтобы в liquibase сохранялся только относительный путь к файлу. Путь сохраняется относительно файла - корневого (db.changelog-master.xml)