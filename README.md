# Java Learning

Мой путь к позиции junior Java backend-разработчика. Учусь на 1 курсе КАИ (программная инженерия), цель — к лету 2027 писать REST API на Spring Boot + PostgreSQL и разворачивать его в Docker.

Как устроено обучение: Claude выступает преподавателем — даёт урок с теорией, домашнее задание и делает код-ревью. **Весь код в `src/` я пишу сам, без ИИ.** По истории коммитов видно, как каждое задание дорабатывалось после ревью.

## Пройденные темы

| # | Тема | Что сделано в домашке | Код |
|---|------|------------------------|-----|
| 1 | Методы | Методы, параметры, передача по значению, работа с массивами | [`lesson0001`](src/lesson0001) |
| 2 | Классы и объекты | Класс `Product`, конструктор, `toString`, ссылки на объекты | [`lesson0002`](src/lesson0002) |
| 3 | Инкапсуляция | `private`-поля, проверки в конструкторе, `BankAccount` с переводами | [`lesson0003`](src/lesson0003) |
| 4 | Исключения | `try/catch`, своё `InsufficientFundsException`, checked vs unchecked | [`lesson0004`](src/lesson0004) |
| 5 | Наследование | `SavingsAccount extends BankAccount`, `@Override`, полиморфизм | [`lesson0005`](src/lesson0005) |
| 6 | Интерфейсы | `Notifier`, внедрение зависимости через конструктор, фейк и самотесты, `Comparable` | [`lesson0006`](src/lesson0006) |

## Как запустить

Нужен JDK 21. Из корня репозитория, на примере урока 6:

```bash
javac -d out src/lesson0006/*.java
java -cp out lesson0006.Main
```

В уроках 1 и 2 главный класс — `Shop` вместо `Main`: `java -cp out lesson0001.Shop`.

## Структура

```
src/lessonNNNN/     мой код: домашние задания по урокам
lessons/            уроки (HTML, открываются в браузере)
reference/          шпаргалки, номер = номер урока
learning-records/   записи о том, что усвоено и где были пробелы
GLOSSARY.md         термины курса
MISSION.md          цель обучения
RESOURCES.md        источники: туториалы Oracle, документация
```

## Дальше по плану

Коллекции и `equals`/`hashCode` → generics → лямбды и Stream API → Maven и JUnit 5 → SQL и PostgreSQL → Spring Boot → Docker и деплой.

## Стек

Java 21 · Git · IntelliJ IDEA · Ubuntu
