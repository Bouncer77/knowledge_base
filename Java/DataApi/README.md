# Время в Java

В нашем случае так и происходит, тот-самый-момент в системе Unix-time (числовое значение 0), которая используется в Java — это временная точка с меткой 00:00:00 1 января 1970 от Р.Х. по UTC уже по другой шкале — Григорианскому календарю.

В юлианском календаре год начинался 1 января и включал, в среднем, 365,25 суток, то есть 365 дней и шесть часов.
Солнце завершает один цикл смены времен года, например, проходя между точками весеннего равноденствия либо от одного дня летнего солнцестояния до другого, - составляет 365,2422 суток. Иными словами, тропический год на 11 минут 14 секунд короче, чем год по юлианскому календарю. Такое несовпадение привело к тому, что каждые 128 лет в юлианском календаре накапливался один лишний день. К XVIвеку разница составила целых десять суток.

И 4 октября 1582 года в целом ряде государств, где исповедовалось католичество, юлианский календарь был заменен на более точный - григорианский, принятый на основе постановления папы римского Григория XIII

leap second - Дополнительная секунда
https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D0%BF%D0%BE%D0%BB%D0%BD%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%B0%D1%8F_%D1%81%D0%B5%D0%BA%D1%83%D0%BD%D0%B4%D0%B0

## Java SE 8 Date and Time

[Java SE 8 Date and Time - Документация](https://www.oracle.com/technical-resources/articles/java/jf14-date-time.html)


https://habr.com/ru/post/274905/

### Временные зоны

java.time.ZoneId - обозначает временную зону

1. java.time.ZoneRegion - временную зону по географическому принципу
2. java.time.ZoneOffset - временную зону по простому смещению относительно UTC, UT или GMT

java.time.zone.ZoneRules (экземпляр которого доступен через метод java.time.ZoneId#getRules) - Правила перевода стрелок

### Часы

java.time.Clock#systemDefaultZone — метод создает системные часы во временной зоне по-умолчанию.
java.time.Clock#systemUTC — метод создает системные часы во временной зоне UTC.
java.time.Clock#system — метод создает системные часы в указанной временной зоне.
java.time.Clock#fixed — метод создает часы константного времени, то есть часы не идут, а стоят на месте.
java.time.Clock#offset — метод создает прокси над указанными часами, который смещает время на указанную величину.
java.time.Clock#tickSeconds — метод создает системные часы в указанной временной зоне, значение которых округлено до целых секунд.
java.time.Clock#tickMinutes — метод создает системные часы в указанной временной зоне, значение которых округлено до целых минут.
java.time.Clock#tick — метод создает прокси над указанными часами, который округляет значения времени до указанного периода.
java.time.Clock#withZone — метод создает копию текущих часов в другой временной зоне.

java.time.Clock#getZone — запросить временную зону в которой работают часы.
java.time.Clock#millis — запросить текущее время в миллисекундах по Unix-time
java.time.Clock#instant — запросить текущее время в самом общем смысле (по факту — в наносекундах по Unix-time)

java.time.Clock хранит временную зону (хотя она не используется в нем)

java.time.Instant — это новый java.util.Date, только неизменяемый, с наносекундной точностью и корректным названием. Внутри хранит Unix-time в виде двух полей: long с количеством секунд, и int с количеством наносекунд внутри текущей секунды.

Instant instant = Clock.systemDefaultZone().instant();

System.out.println(instant.getEpochSecond());
System.out.println(instant.getNano());

System.out.println(instant.toEpochMilli());

### Временные классы

ни в одном из них нет ни временной зоны, ни даже смещения.

java.time.LocalTime — это кортеж (час, минуты, секунды, наносекунды)
java.time.LocalDate — это кортеж (год, месяц, день месяца)
java.time.LocalDateTime — оба кортежа вместе

К этим же классам я бы отнес еще и специфические классы для хранения части информации: 
java.time.MonthDay, 
java.time.Year, 
java.time.YearMonth

### ZonedDateTime

java.time.ZonedDateTime — аналог java.util.Calendar. Это самый мощный класс с полной информацией о временном контексте, включает временную зону, поэтому все операции со сдвигами этот класс проводит правильно.

@Test
public void testZoned2() throws Exception {
    LocalDateTime ldt = LocalDateTime.of(2015, 1, 10, 0, 0, 0, 0);
    ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Moscow"));
}

### OffsetTime, OffsetDateTime

java.time.OffsetTime — это LocalTime + ZoneOffset
java.time.OffsetDateTime — это LocalDateTime + ZoneOffset

Надо сказать, что также как смещение не является временной зоной (временная зона — это история смещений, плюс еще дополнительная информация), то также OffsetDateTime хранит меньше информации чем ZonedDateTime. OffsetDateTime может полноценно обозначать временную точку на временной оси, но полностью корректные сдвиги производить не в силах, поскольку о будущих и прошлых переводах стрелок этот класс ничего не знает.

### Временная точка 

Из всех классов нового API временную точку на временной оси однозначно определяют только три: java.time.Instant, java.time.ZonedDateTime и java.time.OffsetTime.

Операции сдвига и модификации времени в общем случае выполняются корректно только в java.time.ZonedDateTime, поскольку только он один знает про временные зоны.

### Period, Duration

В новом API есть два класса для определения длительности.

java.time.Period — описание календарной длительности (периода) в виде кортежа (год, месяц, день).


java.time.Duration — описание точной длительности в виде целого количества секунд и долей текущей секунды в виде наносекунд.

### Форматирование и парсинг

java.time.format.DateTimeFormatter — класс определяет настройки форматирования и парсинга.

```java
    @Test
    public void testFormat() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:dd z", Locale.ENGLISH);

        ZonedDateTime zdt1 = ZonedDateTime.of(2005, 10, 30, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));

        String text = zdt1.format(formatter);
        System.out.println(text);

        TemporalAccessor ta = formatter.parse(text); // java.time.format.Parsed
        ZonedDateTime zdt2 = ZonedDateTime.from(ta);

        Assert.assertEquals(zdt1, zdt2);
    }
```

Если посмотреть в JavaDoc то видно, что в новом API добавили больше опций для форматирования. Также интересно, что парсинг возвращает не конкретный временной класс, а абстрактный java.time.Temporal (java.time.format.Parsed как реализация), а уже из него, как из сумки с запчастями, мы можем собрать объект того класса, который нам нужен.