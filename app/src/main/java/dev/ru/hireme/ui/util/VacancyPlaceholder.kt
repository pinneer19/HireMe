package dev.ru.hireme.ui.util

import dev.ru.domain.model.Vacancy

val VacancyPlaceholder: Vacancy = Vacancy(
    lookingNumber = 10,
    title = "UI/UX Designer",
    isFavorite = true,
    town = "Минск",
    company = "Мобирикс",
    previewText = "Опыт от 1 до 3 лет",
    publishedDate = "2024-02-20",
    id = "id",
    responsibilities = "- Разработка дизайна Web+App (обязательно Figma)\n\n- Работа над созданием и улучшением систем;\n\n- Взаимодействие с командами frontend-разработки и backend-разработки",
    description = "Мы разрабатываем мобильные приложения, web-приложения и сайты под ключ.\n\nНам в команду нужен UX/UI Designer!",
    schedules = listOf(
        "частичная занятость",
        "полный день"
    ),
    questions = listOf(
        "Где располагается место работы?",
        "Какой график работы?",
        "Как с вами связаться?"
    ),
    salary = "от 60 000 ₽ до вычета налогов"
)