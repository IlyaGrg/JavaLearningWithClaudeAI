# enum, record, Optional: record и Optional — уверенно; enum-метод написан как статическая функция, проверки снова не ловят поломку

Домашка 0013: `AccountNumber` → запись (41 строка → 11, проверки урока 8 не тронуты и ОК), `enum Currency` с `displayName` и switch-выражением, `findById` → `Optional.ofNullable(memory.get(id))` (сам дошёл до короткого варианта), `Bank.findAccount` через `orElseThrow` с `AccountNotFoundException`, `findRichest` через `max` с проверкой пустого банка. Хвосты урока 12 закрыты: ленивость увидена и объяснена, фраза про `allMatch` записана, `features/streams` удалена везде. 34/34 ОК.

**Evidence**: `src/lesson0013/`, коммиты f3ad49f…3d3e026, ветка `features/record`; ревью 2026-10-29, JDK 21, мутации в scratchpad.

**Implications**:
- `symbol(Currency currency)` принимает валюту параметром вместо `switch (this)`: `Currency.RUB.symbol(Currency.USD)` → `"$"`. Не понял, что метод enum-константы работает со «своей» константой — как метод объекта у `this`. Проверен только EUR: мутация «RUB и USD → €» проходит все проверки.
- Строковый репозиторий валют не заменён (шаг 3), объяснял дважды. Положительная проверка `findById` у репозитория исчезла при переходе на `Optional` — мутацию «всегда пусто» ловит только банк (падением с исключением, а не `ОШИБКА`). Подпись «бросает исключение» у проверки `isEmpty()` не обновлена.
- Проверка `id == null` в `findById` потеряна при сокращении (напомнил — не вернул).
- `findRichest` через `max(BankAccount::compareTo)` — работает, опирается на `Comparable` по балансу; проверка с пустым банком есть.
- Эксперименты шага 6 не делал — по его просьбе эксперименты из домашек убраны, результаты показаны в HTML урока (NOTES.md).
- Повторяющиеся хвосты: `comparing` вместо `comparingInt`, лишний `map` в `countAccounts`, сообщение `AccountNumber` без значения, неиспользуемый `import Objects`.
- Ветка не слита, `main` не запушен (шаг 7).
