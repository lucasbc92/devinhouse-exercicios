package ex08;

import java.util.ArrayList;
import java.util.List;

import ex04.entities.Address;
import ex08.entities.CommercialProperty;
import ex08.entities.Property;
import ex08.entities.StandardApartment;
import ex08.entities.StandardProperty;

public class TestRealEstateSystem {
    public static void listProperties(List<Property> properties){
        System.out.println("List Properties:");
        for(Property property: properties){
            System.out.println(property);
        }
    }

    public static void listPropertiesByType(List<Property> properties){
        System.out.println("List Properties by Type:");
        String standardPropertiesStr = String.format("%n");
        String standardApartmentsStr = String.format("%n");
        String commercialPropertiesStr = String.format("%n");

        for(Property property: properties){
            switch(property.getClass().getSimpleName()){
                case "StandardProperty": standardPropertiesStr += String.format("%s%n", property.toString()); break;
                case "StandardApartment": standardApartmentsStr += String.format("%s%n", property.toString()); break;
                case "CommercialProperty": commercialPropertiesStr += String.format("%s%n", property.toString()); break;
            }            
        }
        System.out.println("Standard Properties:");
        System.out.println(standardPropertiesStr);
        System.out.println("Standard Apartments:");
        System.out.println(standardApartmentsStr);
        System.out.println("Commercial Properties:");
        System.out.println(commercialPropertiesStr);
    }

    public static void search(List<Property> properties, String searchText){
        String searchTextCaseInsensitive = searchText.toLowerCase();
        System.out.printf("Search for \"%s\":%n", searchText);
        boolean isMatched = false;
        for(Property property: properties){
            if(property.getDescription().toLowerCase().contains(searchTextCaseInsensitive)){
                System.out.println(property);
                isMatched = true;
            }
        }
        if(!isMatched){
            System.out.println("No properties were found.");
        }
    }
    public static void main(String[] args) {
        List<Property> properties = new ArrayList<Property>();
        Address address1 = new Address("ABC Street", "123", "Florianopolis", "Santa Catarina", "Brazil", "");
        Address address2 = new Address("BCD Street", "234", "Sao Paulo", "Sao Paulo", "Brazil", "");
        Address address3 = new Address("CDE Street", "345", "Joinville", "Santa Catarina", "Brazil", "");
        Address address4 = new Address("DEF Street", "456", "Blumenau", "Santa Catarina", "Brazil", "");

        properties.add(new StandardProperty(address1, 4, "A nice standard property located in Florianopolis, Santa Catarina, Brazil.", 1000, 100000, 900, 500));
        properties.add(new StandardApartment(address3, 4, "A nice standard apartment located in Joinville, Santa Catarina, Brazil.", 2000, 200000, 2000, 600, 200));
        properties.add(new CommercialProperty(address4, 4, "A nice commercial property located in Blumenau, Santa Catarina, Brazil.", 3000, 400000, 1500, 1000, 900));
        properties.add(new StandardProperty(address2, 5, "A nice standard property located in Sao Paulo, Sao Paulo, Brazil.", 1500, 150000, 1400, 700));

        TestRealEstateSystem.listProperties(properties);

        TestRealEstateSystem.listPropertiesByType(properties);

        TestRealEstateSystem.search(properties, "a nice");
        TestRealEstateSystem.search(properties, "SANTA CATARINA");
        TestRealEstateSystem.search(properties, "Belem");
    }
}
