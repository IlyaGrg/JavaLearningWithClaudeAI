_//src/lesson0011/Bank.java:87: error: cannot find symbol
//        sortedAccounts.sort(Comparator.comparing(a -> a.getOwner()).reversed());
//                                                       ^
//  symbol:   method getOwner()
//  location: variable a of type Object
//1 error_

**Результат сначала уходит в .reversed() и компилятор не успевает понять, что a это счет, а не Object**

_//src/lesson0011/Bank.java:34: error: local variables referenced from a lambda expression must be final or effectively final
//        balances.forEach(x -> totalSum += x.getBalance());
//                              ^
//1 error_


**Лямбда может читать переменные снаружи, но только те, которые не меняются**


src/lesson0011/Main.java:70: error: incompatible types: Interface is not a functional interface
Interface newInterface = (str1, a) -> System.out.println(str1 * a);
^
multiple non-overriding abstract methods found in interface Interface
1 error

**Лямбду можно использовать для интерфейсов с одним абстрактным методом**


src/lesson0011/Main.java:69: error: annotation interface not applicable to this kind of declaration
@FunctionalInterface
^
src/lesson0011/Main.java:70: error: incompatible types: Interface is not a functional interface
Interface newInterface = (str1, a) -> System.out.println(str1 * a);
^
multiple non-overriding abstract methods found in interface Interface
2 errors

**Interface не является функциональным интерфейсом**
