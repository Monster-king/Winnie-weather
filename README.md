# Winnie-weather
Приложение для получения информации о погоде

Для начала узнаем какие информации предоставляет нам сервис [openweathermap](http://openweathermap.org) (конечно же нас интересует только бесплатная информация).

Исследование показал что больше всего нам подходит [текущая погода для заданной lat/lon](https://openweathermap.org/current).

Попробуем найти хорошое дизайнерское решение для показа данной информации на сайте [Dribbble.com](https://dribbble.com/).

Мне больше всего понравилось этот [дизайн](https://dribbble.com/shots/10460680-Weather-App/attachments/2296528?mode=media) попробую его реализовать.

Для реализации данного дизайна нам еще нужно получить изображение заданной локации, для этого буду использовать [Flickr](https://www.flickr.com/).

Я сделаю на laravel промежуточный сервер что бы за один запрос получить всю нужную мне информацию.
Плюсы промежуточного серера:
 - Ключи `api_key` не будут храняться на клиенте
 - Можно будет кешировать полученные результаты на сервере чтобы для несколько пользователей из одного города не делать разные запросы (так как количество запросов ограничено не помешает нам его секономить)
 - В любой момент можно поменять сервисы один раз на сервере при этом не трогая клиентские приложения.

Начнем разработку серверной части.

Серверная чать: https://github.com/Monster-king/winnie-weather-web

**Screenshots:**

<div float="left">
<kbd>
<img alt="default screen" src="https://raw.githubusercontent.com/Monster-king/Winnie-weather/master/screenshots/main_screen.jpg" width="200">
<img alt="search screen" src="https://raw.githubusercontent.com/Monster-king/Winnie-weather/master/screenshots/detail_screen.jpg" width="200">
</kbd>
</div>
<br> <br> <br>