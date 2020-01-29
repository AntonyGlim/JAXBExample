package sample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException {

        //Подготавливаем данные
        User user1 = new User("Name1", "SecondName1", "+7123456781", "Some Address 1");
        User user2 = new User("Name2", "SecondName2", "+7123456782", "Some Address 2");
        User user3 = new User("Name3", "SecondName3", "+7123456783", "Some Address 3");
        List<User> users = Arrays.asList(user1, user2, user3);
        TestObject testObject = new TestObject(users, 5, "Some information");

        // здесь мы можем писать в файл, или отправлять по сети
        // я выбрал вывод в консоль для демонстрации, просто.
        StringWriter writer = new StringWriter();

        //### СЕРИАЛИЗАЦИЯ ###
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(TestObject.class, User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // сама сериализация
        marshaller.marshal(testObject, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        System.out.println(result);

        //### ДЕСЕРИАЛИЗАЦИЯ ###
        String xmldata = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><testObject><someInformation>Some information</someInformation><someNumber>5</someNumber><usersList><users><address>Some Address 1</address><name>Name1</name><phone>+7123456781</phone><secondName>SecondName1</secondName></users><users><address>Some Address 2</address><name>Name2</name><phone>+7123456782</phone><secondName>SecondName2</secondName></users><users><address>Some Address 3</address><name>Name3</name><phone>+7123456783</phone><secondName>SecondName3</secondName></users></usersList></testObject>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext newContext = JAXBContext.newInstance(TestObject.class, User.class);
        Unmarshaller unmarshaller = newContext.createUnmarshaller();

        TestObject newTestObject = (TestObject) unmarshaller.unmarshal(reader);

        System.out.println(newTestObject);
        System.out.println(newTestObject.getUsers().get(0));

    }
}
