# XML to JSON


Преобразование XML в JSON через Rest API сервис

## Модуль xml_to_json
    На вход в тело json получает xml и также параметр со списком чисел. На выходе json.
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
    