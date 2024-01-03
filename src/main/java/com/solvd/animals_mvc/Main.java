package com.solvd.animals_mvc;

import com.solvd.animals_mvc.model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        /* ZooService zooService = new ZooService();
        DepartmentService departmentService = new DepartmentService();
        AnimalRoomService animalRoomService = new AnimalRoomService();

        Long zooId = zooService.create(new Zoo("California Zoo", 450), "Logic " +
                "Department", "Aquatic", 200);
        animalRoomService.create(new AnimalRoom("Birds",50,zooId));
        animalRoomService.create(new AnimalRoom("Felines",10,zooId));
        Long hrDepId = departmentService.create(new Department("HR Department",
                zooId));
        departmentService.getAnimalRoomsInSameZoo(hrDepId);
        animalRoomService.getAnimalRoomsCapacityOver100();
        zooService.logDepartmentsAndAnimalRooms(zooId);
        zooService.updateById(new Zoo("Texas Zoo",2000),zooId);
        zooService.delete(zooId); // Keep in mind that this line deletes everything done above

        // Parsing XML file into a Java object

        File file = new File("src/main/resources/xml/zoo.xml");
        ZooSAXHandler saxHandler = new ZooSAXHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(file, saxHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }

        Zoo zoo = saxHandler.getZoo();

        LOGGER.info("Id: " + zoo.getId() + " | Name: " + zoo.getName() +
                " | Customers capacity: " + zoo.getCustomersCapacity());

        LOGGER.info("Departments:");
        zoo.getDepartmentList().forEach((d) ->
                LOGGER.info("Id: " + d.getId() + " | Name: " + d.getName()
                        + " | Zoo ID: " + d.getZooId())
        );

        LOGGER.info("Animal Rooms:");
        zoo.getAnimalRoomList().forEach((ar) ->
                LOGGER.info("Id: " + ar.getId() + " | Name: " + ar.getName() +
                        " | Capacity: " + ar.getCapacity() + " | Zoo ID: "
                        + ar.getZooId())
        ); */

        // Using JAXB to parse XML into a Java Object
        File personXml = new File("src/main/resources/xml/person.xml");
        File customerXml = new File("src/main/resources/xml/customer.xml");
        File animalRoomXml = new File("src/main/resources/xml/animal_room.xml");
        File animalXml = new File("src/main/resources/xml/animal.xml");
        File zooXml = new File("src/main/resources/xml/zoo.xml");

        LOGGER.info(unmarshalXml(personXml, Person.class));
        LOGGER.info(unmarshalXml(customerXml, Customer.class));
        LOGGER.info(unmarshalXml(animalRoomXml, AnimalRoom.class));
        LOGGER.info(unmarshalXml(animalXml, Animal.class));
        LOGGER.info(unmarshalXml(zooXml, Zoo.class));

    }

    private static <T> T unmarshalXml(File file, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
