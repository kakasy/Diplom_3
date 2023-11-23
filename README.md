# Diplom_3
Дипломный проект по тестированию UI приложения по заказу бургеров Stellar Burgers.
## Описание

Версия Java 11
Проект использует следующие библиотеки:
- JUnit 4
- RestAssured
- Allure
- Selenium

### Запуск автотестов

Для запуска автотестов необходимо:

1. Скачать код проекта

 ```sh
   git clone https://github.com/kakasy/Diplom_3.git
   ```

2. Запустить автотесты

```sh
mvn clean test
```

3. Для создания Allure отчета ввести команду

```sh
mvn allure:report
```

4. Для запуска автотестов и просмотра отчета в браузере ввести команду

```sh
mvn clean test allure:serve
```
