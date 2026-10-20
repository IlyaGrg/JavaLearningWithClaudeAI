
**git add .
git commit -m "Начать урок 0010 Git ветки"**

[main b64ae40] Начать урок 0010 Git ветки
14 files changed, 566 insertions(+)
create mode 100644 src/lesson0010/AccountNotFoundException.java
create mode 100644 src/lesson0010/AccountNumber.java
create mode 100644 src/lesson0010/BadRequestByIdException.java
create mode 100644 src/lesson0010/Bank.java
create mode 100644 src/lesson0010/BankAccount.java
create mode 100644 src/lesson0010/CollectionUtils.java
create mode 100644 src/lesson0010/DuplicateAccountException.java
create mode 100644 src/lesson0010/GIT-NOTES.md
create mode 100644 src/lesson0010/InMemoryRepository.java
create mode 100644 src/lesson0010/InsufficientFundsException.java
create mode 100644 src/lesson0010/Main.java
create mode 100644 src/lesson0010/Repository.java
create mode 100644 src/lesson0010/SavingsAccount.java
create mode 100644 src/lesson0010/WithdrawalLimitExceededException.java

**git switch -c refactor/repository**

Переключились на новую ветку «refactor/repository»

**git add .
git commit -m "Исправить existsById в одну строчку"**

[refactor/repository 0439ad8] Исправить existsById в одну строчку
Date: Tue Oct 20 15:25:51 2026 +0300
2 files changed, 22 insertions(+), 5 deletions(-)

**git push -u origin refactor/repository**

Перечисление объектов: 26, готово.
Подсчет объектов: 100% (26/26), готово.
При сжатии изменений используется до 12 потоков
Сжатие объектов: 100% (23/23), готово.
Запись объектов: 100% (24/24), 8.59 KiB | 2.86 MiB/s, готово.
Total 24 (delta 7), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (7/7), completed with 2 local objects.
remote:
remote: Create a pull request for 'refactor/repository' on GitHub by visiting:
remote:      https://github.com/IlyaGrg/JavaLearningWithClaudeAI/pull/new/refactor/repository
remote:
To github.com:IlyaGrg/JavaLearningWithClaudeAI.git
* [new branch]      refactor/repository -> refactor/repository
  branch 'refactor/repository' set up to track 'origin/refactor/repository'.

**git add .
git commit -m "Переименовать BadRequestByIdException на EntityNotFoundByIdException"**

[refactor/repository 4537b46] Переименовать BadRequestByIdException на EntityNotFoundByIdException
6 files changed, 44 insertions(+), 13 deletions(-)
delete mode 100644 src/lesson0010/BadRequestByIdException.java
create mode 100644 src/lesson0010/EntityNotFoundByIdException.java

**git push -u origin refactor/repository**

Перечисление объектов: 18, готово.
Подсчет объектов: 100% (18/18), готово.
При сжатии изменений используется до 12 потоков
Сжатие объектов: 100% (10/10), готово.
Запись объектов: 100% (10/10), 1.86 KiB | 1.86 MiB/s, готово.
Total 10 (delta 7), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (7/7), completed with 7 local objects.
To github.com:IlyaGrg/JavaLearningWithClaudeAI.git
0439ad8..4537b46  refactor/repository -> refactor/repository
branch 'refactor/repository' set up to track 'origin/refactor/repository'.

_Предскажи до команды и запиши: что ты увидишь в InMemoryRepository.java после git switch main?_

В InMemoryRepository.java я увижу метод, реализованный в несколько строчек, а не в одну.




**git switch -c feature/currency-checks**

Переключились на новую ветку «feature/currency-checks»

Я думаю первое слияние будет fast-fetch а второе коммит слияния.

**git merge refactor/repository** 

Обновление b64ae40..c3e634c
Fast-forward
learning-records/0010-generics-homework.md      |  4 ++--
src/lesson0010/BadRequestByIdException.java     |  7 ------
src/lesson0010/EntityNotFoundByIdException.java |  7 ++++++
src/lesson0010/GIT-NOTES.md                     | 76 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
src/lesson0010/InMemoryRepository.java          |  9 +++-----
src/lesson0010/Main.java                        |  4 ++--
6 files changed, 90 insertions(+), 17 deletions(-)
delete mode 100644 src/lesson0010/BadRequestByIdException.java
create mode 100644 src/lesson0010/EntityNotFoundByIdException.java

**git merge feature/currency-checks** 

Автослияние src/lesson0010/GIT-NOTES.md
КОНФЛИКТ (содержимое): Конфликт слияния в src/lesson0010/GIT-NOTES.md
Автослияние src/lesson0010/Main.java
Сбой автоматического слияния; исправьте конфликты, затем зафиксируйте результат.

**git add src/lesson0010/GIT-NOTES.md**
**git restore --source=HEAD --staged --worktree src/lesson0009/Main.java**
**git merge feature/currency-checks** 

Уже актуально.

**git log --oneline --graph --all**


*   211d33a (HEAD -> main) Merge branch 'feature/currency-checks'
    |\  
    | * 41a3532 (origin/feature/currency-checks, feature/currency-checks) Реализовать проверки для валюты в Main.java
* | c3e634c (refactor/repository) Дописать GIT-NOTES.md
* | 4537b46 (origin/refactor/repository) Переименовать BadRequestByIdException на EntityNotFoundByIdException
* | 0439ad8 Исправить existsById в одну строчку
  |/
* b64ae40 Начать урок 0010 Git ветки


**Если конфликт, то:**
1. Открыть файл и найти маркеры <<<<<<<, =======, >>>>>>>.
2. Решить, что должно получиться: взять одну версию, другую или соединить обе. Обычно правильный ответ — соединить: каждая ветка добавляла что-то нужное.
3. Удалить маркеры, затем git add файл.
4. Скомпилировать и запустить проверки. Git соединяет текст, а не смысл. Слияние без конфликта тоже может дать код, который не компилируется. Например, одна ветка переименовала метод, а другая добавила его вызов со старым именем.
5. Выполнить git commit.


**git branch -d refactor/repository**

warning: not deleting branch 'refactor/repository' that is not yet merged to
'refs/remotes/origin/refactor/repository', even though it is merged to HEAD
error: the branch 'refactor/repository' is not fully merged
hint: If you are sure you want to delete it, run 'git branch -D refactor/repository'
hint: Disable this message with "git config set advice.forceDeleteBranch false

**git branch -D refactor/repository** 

Ветка refactor/repository удалена (была c3e634c).

**git branch -d feature/currency-checks**

Ветка feature/currency-checks удалена (была 41a3532).

**git branch -d experiment/break-max**

error: the branch 'experiment/break-max' is not fully merged
hint: If you are sure you want to delete it, run 'git branch -D experiment/break-max'
hint: Disable this message with "git config set advice.forceDeleteBranch false"


закоммитить заметки

Заметки

**Почему ветки создаются мгновенно даже в огромном проекте?**

Потому что ветки - это разные указали на один и тот же коммит (или на какой-то определенный)

**Чем git branch -d отличается от -D и зачем нужна защита?**

git branch -d удалить ветку в случае, если нет каких либо предупреждений, а -D удалит в любом случае. Защита нужна для того, чтобы не удалить ветку, которая, например, еще не до конца слита в main

**Что такое HEAD?**

Указатель на каком коммите или в какой ветке мы сейчас находимся

**Как бы ты сделал «сломай — проверь — откати» из прошлых уроков теперь?**

Для того чтобы сломать что-то я бы создал новую ветку, которая бы ломала какой то один определенный метод, и проверял бы тесты, затем коммитил бы что именно ломается
Затем переключался в main и удалял эту ветку

**Со сломанным max:**

ОК: Два new AccountNumber(BANK40817-001) равны по equals, но не по ==
ОК: hashCode двух AccountNumber совпадают
ОК: bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.
ОК: Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1
ОК: equals(null) возвращает false, а не бросает исключение
ОК: findAccount() от некорректного значения
ОК: openAccount от некорректного number
ОК: openAccount от некорректного account
ОК: Открытие счёта с занятым номером бросает исключение
ОК: Счетчик count растет
ОК: deleteById удаляет элемент
ОК: findById неверного ID вызывает исключение
ОК: max от пустого списка бросает исключение
ОШИБКА: Ожидаемое значение: 1000
ОШИБКА: Ожидаемое значение: яблоко
ОК: Ожидается: Российский рубль
ОК: count растет
ОК: existsById для существующего ID
ОК: existsById для несуществующего ID
ОК: findById несуществующего ID бросает исключение

**С работающим max:**

ОК: Два new AccountNumber(BANK40817-001) равны по equals, но не по ==
ОК: hashCode двух AccountNumber совпадают
ОК: bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.
ОК: Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1
ОК: equals(null) возвращает false, а не бросает исключение
ОК: findAccount() от некорректного значения
ОК: openAccount от некорректного number
ОК: openAccount от некорректного account
ОК: Открытие счёта с занятым номером бросает исключение
ОК: Счетчик count растет
ОК: deleteById удаляет элемент
ОК: findById неверного ID вызывает исключение
ОК: max от пустого списка бросает исключение
ОК: Ожидаемое значение: 1000
ОК: Ожидаемое значение: яблоко
ОК: Ожидается: Российский рубль
ОК: count растет
ОК: existsById для существующего ID
ОК: existsById для несуществующего ID
ОК: findById несуществующего ID бросает исключение

