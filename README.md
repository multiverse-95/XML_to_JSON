# XML to JSON


Преобразование XML в JSON через Rest API сервис

## Описание
    RestAPI сервис, который принимает POST запрос с телом XML и конвертирует его в JSON. 
    Также, в качестве параметра запроса может быть список со значениями, которые необходимо проставить в объекты из PropertyList (в поле default value).
    Одно значение в один объект.
### Пример
#### XML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<PropertyList>
    <Property>
        <Name>CommandTimeout</Name>
        <Value>60</Value>
        <Description>Setting the timeout(in seconds)</Description>
        <DefaultValue>
        </DefaultValue>
    </Property>
    <Property>
        <Name>Address</Name>
        <Value>0.0.0.0</Value>
        <Description>ip:port</Description>
        <DefaultValue></DefaultValue>
    </Property>
</PropertyList>
```
#### Параметр: [12,24]
### Результат
#### JSON
```json
[
  {
    "name": "CommandTimeout",
    "value": "60",
    "description": "Setting the timeout(in seconds)",
    "defaultValue": 12
  },
  {
    "name": "Address",
    "value": "0.0.0.0",
    "description": "ip:port",
    "defaultValue": 24
  }
]
```
## Запуск в IntelliJ IDEA (JDK 17)
    Клонируйте проект. Запустите и проверьте по адресу: http://localhost:8080/api/formatXml/getJson?listValues=12,24
## Проверка работы
### Пример:
![Alt text](/src/main/resources/screenshots/test_api_xml_1.PNG "Скриншот - проверка апи")
## Запуск в докер
    Должен быть установлен докер. Клонируйте проект. Из папки out переместите папку backend в директорию линукс.
#### Выполните в директории, где папка backend
```bash
docker run -d --restart always -p 8080:8080 -v "${PWD}/backend:/usr/local/tomcat/webapps" --name xml_to_json tomcat:9.0.65-jdk17
```
## Проверка работы 
### Пример 1:
![Alt text](/src/main/resources/screenshots/test_api_xml_2.PNG "Скриншот - проверка апи docker 1")
### Пример 2:
![Alt text](/src/main/resources/screenshots/test_api_xml_3.PNG "Скриншот - проверка апи docker 2")
    