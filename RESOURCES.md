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
- [Pro Git, 2-е издание, на русском](https://git-scm.com/book/ru/v2)
  Официальная книга по Git, бесплатная. Use for: весь Git — от коммитов до rebase и внутреннего устройства.

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
