# JUnit 5: синтаксис освоен сразу; тесты точные, но пропущены граница «ошибка не портит состояние» и часть заданных случаев

Домашка 0015: 7 тестовых классов, 55 тестов, все зелёные на Maven 3.9.12 с surefire 3.5.2. Синтаксис без ошибок: `@BeforeEach`, `assertThrows` с лямбдой и захватом исключения, `@NullSource` + `@ValueSource`, `@CsvSource` с enum, `assertSame` для `findAccount`, точные `List.of`/`Map` вместо `allMatch`. Тест `findById(null)` вернул потерянную проверку в репозиторий. Хвосты прошлых уроков закрыты попутно: `comparingInt`, лишний `map` в `countAccounts`. `Main` очищен до демонстрации.

**Evidence**: `lesson0015/`, коммиты 7774992…bad21cd; ревью 2026-11-04, мутации в scratchpad (`mvn -o`).

**Implications**:
- Ловятся: `>`/`>=` и `distinct` в `richOwners`, граница лимита `SavingsAccount`, `existsById`, `findById(null)`, перепутанные отправитель/получатель. Вопрос «граница» усвоен.
- **Выживают 8 мутаций**: порядок `withdraw`/`deposit` в `transferTo`, проверки «себе» и `null` в `transferTo`, `addInterest`, символ EUR, «баланс уменьшен до исключения» в `withdraw`, `owners` и `accountsByOwner` на пустом банке (во втором copy-paste: проверяется `balanceByOwner`), проверка процента в конструкторе `SavingsAccount`. Почти все — явные пункты задания. Новый пробел: **«после ошибки состояние не изменилось»** проверено только в `SavingsAccount`.
- Тесты `findAll`, `findAccounts`, `accountsByOwner` зависят от порядка `HashMap`: перестановка порядка в `findAll` роняет 5 тестов, хотя порядок не обещан. Объяснить сравнение без порядка.
- Во всех классах, кроме `BankTest`, у `assertEquals` перепутан порядок аргументов (полученное, ожидаемое) — сообщения при падении будут наоборот.
- `BankTest`: в `@BeforeEach` один счёт, остальные три копируются в каждый тест. Добавил `Bank.existById` для теста — допустимо, но имя не по образцу `existsById`.
- Git: ветка `feature/junit` не удалена, `main` не запушен (origin на 6a82d7a).

**Повторное ревью 2026-11-04** (рабочая копия, не закоммичено): 63 теста, зелёные. Из 9 мутаций таблицы ловятся все, включая порядок `withdraw`/`deposit` (`checkTransferToWithNoMoney:94`). Сравнение без порядка освоено сразу и в двух вариантах: `keySet` + `size` + `HashSet` в `accountsByOwner`, сортировка в `findAccounts` (через `Comparator.comparing`) и `findAll`. Перестановка порядка в `findAll` больше ничего не роняет.
- Осталось: в `checkAccountsByOwner` пустой банк всё ещё проверяется через `balanceByOwner` — мутация «`accountsByOwner` на пустом банке не пуст» выживает.
- В `Bank.balanceByOwner` добавлен `sorted(...)` перед `groupingBy`: на результат не влияет (мутация без него — 63 зелёных). Выяснить, зачем.

**Закрыто 2026-11-04** (коммит `b85f3eb` + откат `sorted` в рабочей копии): 63 теста зелёные, мутация «`accountsByOwner` на пустом банке» ловится (`checkAccountsByOwner:121`). `sorted` в `balanceByOwner` был экспериментом, убран. Ветки `feature/junit` и `fix/junit` удалены, Илья на `main`. На консольный банк перенести: порядок аргументов `assertEquals`, имена переменных с маленькой буквы, пустая строка в конце файла.
