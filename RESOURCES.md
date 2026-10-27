# Java Backend Resources

## Knowledge

- [Dev.java — Learn Java (Oracle)](https://dev.java/learn/)
  Официальные актуальные туториалы Oracle (Java 17+). Use for: синтаксис языка, ООП, коллекции, стримы, современные фичи (records, pattern matching).
- [The Java Tutorials: Defining Methods (Oracle)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
  Классический туториал (написан для JDK 8, но основы не изменились). Use for: устройство объявления метода, сигнатура, перегрузка.
- [The Java Tutorials: Passing Information to a Method (Oracle)](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html)
  Первоисточник по передаче аргументов по значению. Use for: примитивы и ссылки в параметрах.
- [The Java Tutorials: Classes and Objects (Oracle)](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
  Классы, конструкторы, `this`, `static`, вложенные классы. Use for: ООП-уроки, точные правила про члены класса.
- [The Java Tutorials: Controlling Access to Members of a Class (Oracle)](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
  Таблица модификаторов доступа и правило «private, если нет веской причины». Use for: инкапсуляция.
- [Java 21 API: IllegalArgumentException](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/IllegalArgumentException.html)
  Стандартное исключение для недопустимого аргумента. Use for: проверки в конструкторах и сеттерах.
- [The Java Tutorials: Lesson: Exceptions (Oracle)](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
  Стек вызовов, try/catch/finally, требование «поймай или объяви», checked против unchecked. Use for: урок про исключения, позже try-with-resources для JDBC.
- [The Java Tutorials: Interfaces and Inheritance (Oracle)](https://docs.oracle.com/javase/tutorial/java/IandI/index.html)
  Наследование, переопределение, полиморфизм, super, Object, абстрактные классы и интерфейсы. Use for: уроки 5–6.
- [Spring Framework Reference: Dependency Injection](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html)
  Официальное описание внедрения зависимостей через конструктор. Use for: связать урок про интерфейсы со Spring; основной источник, когда дойдём до Spring.
- [The Java Tutorials: Collection Interfaces (Oracle)](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)
  List, Set, Map, иерархия интерфейсов коллекций. Use for: урок про коллекции. Местами примеры на стримах — читать после урока 12.
- [dev.java: The Collections Framework](https://dev.java/learn/api/collections-framework/)
  Современный обзор коллекций от Oracle. Use for: повторение и углубление.
- [Java 21 API: Object](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html)
  Первоисточник договоров equals и hashCode. Use for: урок 8, вопросы на собеседовании про equals/hashCode.
- [The Java Tutorials: Generics (Oracle)](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
  Generic-типы и методы, ограничения, wildcards, стирание типов. Use for: урок 9, чтение сигнатур библиотек.
- [Spring Data Commons: Core concepts](https://docs.spring.io/spring-data/commons/reference/repositories/core-concepts.html)
  `CrudRepository<T, ID>` и иерархия репозиториев. Use for: связь generics со Spring; основной источник по репозиториям позже.
- [The Java Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) и [Method References](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html) (Oracle)
  Синтаксис лямбд, функциональные интерфейсы, четыре вида ссылок на методы. Use for: урок 11.
- [dev.java: Lambda Expressions](https://dev.java/learn/lambdas/)
  Современный официальный курс от команды Java, с разделом про Comparator. Use for: урок 11, повторение перед Stream API.
- [Java 21 API: Comparator](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Comparator.html), [Map](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html), [java.util.function](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/package-summary.html)
  Точные контракты `comparing`, `thenComparing`, `merge`, `computeIfAbsent`. Use for: уроки 11–12.
- [The Java Tutorials: Aggregate Operations](https://docs.oracle.com/javase/tutorial/collections/streams/index.html) и [Reduction](https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html) (Oracle)
  Конвейер, промежуточные и терминальные операции, `collect`, `groupingBy`. Use for: урок 12.
- [dev.java: Map, Filter, Reduce](https://dev.java/learn/api/streams/map-filter-reduce/)
  Современное изложение Stream API от команды Java. Use for: урок 12, повторение.
- [Java 21 API: Stream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html) и [Collectors](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Collectors.html)
  Точные контракты операций (например, `allMatch` на пустом стриме — `true`). Use for: уроки 12+, Spring-сервисы.
- [The Java Tutorials: Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) (Oracle)
  Перечисления с полями, конструкторами и методами. Use for: урок 13, статусы и роли в Spring-проектах.
- [Java 21 Language Guide: Record Classes](https://docs.oracle.com/en/java/javase/21/language/records.html) и [Switch Expressions](https://docs.oracle.com/en/java/javase/21/language/switch-expressions-and-statements.html) (Oracle)
  Записи, компактный конструктор, switch со стрелками и проверкой полноты. Use for: урок 13, DTO в Spring.
- [Java 21 API: Optional](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html)
  Назначение класса (только возвращаемые значения) и все методы. Use for: урок 13, `CrudRepository.findById`.
- [Pro Git, 2-е издание, на русском](https://git-scm.com/book/ru/v2)
  Официальная книга по Git, бесплатная. Use for: весь Git — от коммитов до rebase и внутреннего устройства.
- [Git Reference: git switch](https://git-scm.com/docs/git-switch) и [git merge](https://git-scm.com/docs/git-merge)
  Официальная документация команд, все флаги. Use for: урок 10, точное поведение `-c`, `--no-edit`, `--abort`.
- [GitHub Docs: About branches](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-branches)
  Ветки на GitHub, защита main, связь с pull request. Use for: урок 10, январские уроки про PR.

## Wisdom (Communities)

- [Хабр Q&A](https://qna.habr.com/)
  Крупнейший русскоязычный сайт вопросов и ответов по разработке. Use for: вопросы, на которые нужен ответ живого разработчика.
- [IT Talk Kazan (Сбер)](https://developers.sber.ru/kak-v-sbere/events/it_talk_kazan)
  Митапы Сбера в Казани с Java-докладами (проходили в IT-парке им. Башира Рамеева). Use for: живые знакомства с казанскими Java-разработчиками и банками-работодателями.
- [JUG Ru Group](https://jugru.org/)
  Организаторы Java-конференций (Joker, JPoint), записи докладов. Use for: позже, когда будет Spring и прод-опыт.

## Gaps

- Не найдено подтверждённое Java-сообщество (JUG) именно в Казани. Поискать в Telegram «Java Казань», на странице событий IT-парка.
- Нужны источники по SQL/PostgreSQL, Docker, Spring Boot — добавить, когда дойдём до этих тем.
