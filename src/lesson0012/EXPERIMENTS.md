Exception in thread "main" java.lang.UnsupportedOperationException
at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:159)
at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:164)
at lesson0012.Main.main(Main.java:65)
toList() возвращает неизменяемый список, а мы пытались его изменить, потому ошибка

src/lesson0012/Bank.java:79: error: long cannot be dereferenced
return accounts.findAll().stream().filter(filter).map(BankAccount::getBalance).count().count();
^
1 error
ilya_grg@ilyaASUS-TUF-Gaming-A15-FA507NV-FA507NV:~/Документы/JavaLearning$ javac -d out src/lesson0012/*.java
src/lesson0012/Bank.java:79: error: long cannot be dereferenced
return accounts.findAll().stream().filter(filter).map(BankAccount::getBalance).count().sum();
^
1 error

терминальную операцию можно использовать только один раз

src/lesson0012/Main.java:54: error: incompatible types: bad return type in lambda expression
str.stream().filter(string -> System.out.println("Привет"));
^
void cannot be converted to boolean
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error
ilya_grg@ilyaASUS-TUF-Gaming-A15-FA507NV-FA507NV:~/Документы/JavaLearning$ javac -d out src/lesson0012/*.java
src/lesson0012/Main.java:54: error: incompatible types: bad return type in lambda expression
str.stream().filter(string -> System.out.println("Привет")).count();
^
void cannot be converted to boolean
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

Нужно чтобы было условие