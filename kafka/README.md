# Kafka

1. Номер партиции
2. Ключ
3. Значение
4. Заголовки

Номер партиции = Хэш-функция(Ключ) % Количество_партиций

# Kafka Производитель (Producer)

batch.size - Размер пакета в сообщениях
linger.ms - Ожидание в миллесекундах