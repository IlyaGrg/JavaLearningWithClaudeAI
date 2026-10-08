// Квиз с мгновенной обратной связью.
// Разметка вопроса:
//   <fieldset class="quiz-q" data-answer="2">       ← номер правильного варианта (с 1)
//     <legend>Вопрос</legend>
//     <label><input type="radio"> вариант</label> ...
//     <p class="feedback" data-explain>почему так</p>
//   </fieldset>
// Счёт выводится в любой элемент с классом .quiz-score.
(function () {
  const questions = Array.from(document.querySelectorAll(".quiz-q"));
  const scoreEls = document.querySelectorAll(".quiz-score");

  function updateScore() {
    const answered = questions.filter((q) => q.classList.contains("answered"));
    const correct = answered.filter((q) => q.classList.contains("correct"));
    scoreEls.forEach((el) => {
      el.textContent = `Отвечено ${answered.length} из ${questions.length}, верно ${correct.length}.`;
    });
  }

  questions.forEach((q, qi) => {
    const answer = Number(q.dataset.answer);
    const inputs = Array.from(q.querySelectorAll("input[type=radio]"));
    inputs.forEach((input) => (input.name = `quiz-${qi}`));

    const feedback = q.querySelector(".feedback");
    const verdict = document.createElement("span");
    verdict.className = "verdict";
    feedback.prepend(verdict);

    const button = document.createElement("button");
    button.type = "button";
    button.textContent = "Проверить";
    feedback.before(button);

    button.addEventListener("click", () => {
      const chosen = inputs.findIndex((i) => i.checked);
      if (chosen === -1) return;
      const ok = chosen + 1 === answer;
      q.classList.add("answered");
      q.classList.toggle("correct", ok);
      q.classList.toggle("wrong", !ok);
      verdict.textContent = ok ? "Верно. " : `Нет, правильный ответ — вариант ${answer}. `;
      updateScore();
    });
  });

  updateScore();
})();
