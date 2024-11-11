# Crypto Info App

Crypto Info App – это Android-приложение, которое показывает список самых популярных криптовалют и их текущий курс к доллару США. 
Приложение обновляет данные каждые 10 секунд и позволяет просматривать подробную информацию о выбранной криптовалюте при нажатии на карточку.

## Возможности:

- Отображение списка популярных криптовалют с их текущим курсом к доллару.
- Автоматическое обновление данных каждые 10 секунд.
- Переход на экран детальной информации о криптовалюте при выборе.
- Использование архитектуры MVVM и чистой архитектуры для разделения логики приложения.

## Технологии:

- **Kotlin** для разработки приложения.
- **Retrofit** для выполнения сетевых запросов и получения данных.
- **Room** для хранения данных в локальной базе данных.
- **Picasso** для загрузки и отображения изображений.
- **Coroutines** для асинхронных операций.
- **Android WorkManager** для периодического обновления данных.
- **MVVM** для обеспечения раздельного управления данными и их отображением.
- **Clean Architecture** для лучшей организации кода и облегчения тестирования.
- **LiveData** для управления и наблюдения за изменениями данных.
- **ViewBinding** для безопасного обращения к элементам интерфейса.
- **Dagger 2** для внедрения зависимостей и управления жизненным циклом компонентов.

## Структура проекта:

### data – слой данных:
- **database** – работа с локальной базой данных Room.
- **mapper** – классы для преобразования моделей данных.
- **network** – работа с API, включает классы ApiService и ApiFactory для создания запросов.
- **repository** – реализация CoinRepositoryImpl для работы с данными.
- **workers** – RefreshDataWorker для периодического обновления данных через WorkManager.

### di – слой для внедрения зависимостей:
- **ApplicationComponent** – главный компонент для внедрения зависимостей.
- **DataModule** – модуль для предоставления зависимостей, связанных с данными.
- **ViewModelModule** – модуль для предоставления ViewModel.
- **ViewModelKey** – аннотация для мультибайндинга ViewModel.

### domain – слой бизнес-логики:
- **Модели** и **интерфейсы**, такие как CoinInfo и CoinRepository.
- **UseCases** для выполнения операций (GetCoinDetailedInfoUseCase, GetCoinInfoListUseCase, LoadDataUseCase).

### presentation – слой представления:
- **adapters** – кастомные адаптеры для RecyclerView.
- **Фрагменты** и **активити** для отображения данных (CoinDetailActivity, CoinDetailFragment, CoinListActivity).
