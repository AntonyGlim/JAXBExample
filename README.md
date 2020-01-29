# JAXBExample
Converting object to xml file and back

* Комментарии в коде на русском языке - для удобства. 

Для конвертации объектов (в том числе содержащих списки других объектов) использован JAXB входящий в стандартный пакет javax.  
В проекте присутствует класс User (пользователь):
```
@XmlType(name = "user")
public class User {

    private String name;
    private String secondName;
    private String phone;
    private String address;
    
    //constructors getters and setters...
    
}
```  
Так же тестовый объект, содержащий список пользователей и некоторые произвольные поля
```
@XmlType(name = "testObject")
@XmlRootElement
public class TestObject {

    private List<User> users = new ArrayList<>();
    private int someNumber = 2;
    private String someInformation = "info";
    
    //constructors getters and setters...
    
}
```  
В классе Main происходит инициализация классов User и TestObject а так же их сериализация в XML и создание нового экземпляра класса с последующим выводом его на экран в качестве демонстрации.
**Результат выглядит так:**  
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<testObject>
    <someInformation>Some information</someInformation>
    <someNumber>5</someNumber>
    <usersList>
        <users>
            <address>Some Address 1</address>
            <name>Name1</name>
            <phone>+7123456781</phone>
            <secondName>SecondName1</secondName>
        </users>
        <users>
            <address>Some Address 2</address>
            <name>Name2</name>
            <phone>+7123456782</phone>
            <secondName>SecondName2</secondName>
        </users>
        <users>
            <address>Some Address 3</address>
            <name>Name3</name>
            <phone>+7123456783</phone>
            <secondName>SecondName3</secondName>
        </users>
    </usersList>
</testObject>
```  
Имеется возможность управлять тэгами
При десериализации все так же отрабатывает корректно.
