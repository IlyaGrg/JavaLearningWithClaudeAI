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




