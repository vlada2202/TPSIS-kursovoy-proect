import org.junit.Test;
import static org.junit.Assert.*;

public class DilerApplicationTest {

    @Test
    public void testAddDiler() {
           DilerApplication dilerApp = new DilerApplication();
     String dilerName = "Example Diler";
     boolean result = dilerApp.addDilers(dilerName);
     assertTrue(result);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class CarShopTest {

    @Test
    public void testBuyCars() {
        CarShop carShop = new CarShop();

     
        String carModel = "Example Car";
        int quantity = 1;

        boolean result = carShop.buyCars(carModel, quantity);
        assertTrue(result);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountActionTest {

    @Test
    public void testViewInfo() {
        DiscountAction discountAction = new DiscountAction();

        String title = discountAction.getTitle();
        String description = discountAction.getDescription();
        String startDate = discountAction.getStartDate();
        String endDate = discountAction.getEndDate();
        int discountPercentage = discountAction.getDiscountPercentage();
        boolean isActive = discountAction.isActive();

        assertNotNull(title);
        assertFalse(title.isEmpty());

        assertNotNull(description);
        assertFalse(description.isEmpty());

        assertNotNull(startDate);
        assertFalse(startDate.isEmpty());

        assertNotNull(endDate);
        assertFalse(endDate.isEmpty());

        assertTrue(discountPercentage >= 0 && discountPercentage <= 100);

        assertNotNull(isActive);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountFinderTest {

    @Test
    public void testFindDiscount() {
        DiscountFinder discountFinder = new DiscountFinder();

        String searchQuery = "car";
        String carModel = "Toyota";
        String carMakeYear = "2020";
        String carColor = "blue";
        int minPrice = 20000;
        int maxPrice = 30000;
        boolean isNew = true;

        DiscountAction discountAction = discountFinder.findDiscount(searchQuery, carModel, carMakeYear, carColor, minPrice, maxPrice, isNew);

        assertNotNull(discountAction);
        assertTrue(discountAction.isActive());
        assertTrue(discountAction.getDiscountPercentage() > 0);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class AvtosalonManagerTest {

    @Test
    public void testAddAvtosalon() {
        AvtosalonManager avtosalonManager = new AvtosalonManager();

        String name = "My Auto Salon";
        String address = "123 Main Street";
        String city = "New York";
        String phoneNumber = "555-1234";
        String website = "www.myautosalon.com";
        String owner = "John Doe";
        int capacity = 50;
        boolean isOpen = true;

        Avtosalon avtosalon = avtosalonManager.addAvtosalon(name, address, city, phoneNumber, website, owner, capacity, isOpen);

        assertNotNull(avtosalon);
        assertEquals(name, avtosalon.getName());
        assertEquals(address, avtosalon.getAddress());
        assertEquals(city, avtosalon.getCity());
        assertEquals(phoneNumber, avtosalon.getPhoneNumber());
        assertEquals(website, avtosalon.getWebsite());
        assertEquals(owner, avtosalon.getOwner());
        assertEquals(capacity, avtosalon.getCapacity());
        assertEquals(isOpen, avtosalon.isOpen());
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagerTest {

    @Test
    public void testDeleteUser() {
        UserManager userManager = new UserManager();

        String userId = "123456";
        String username = "johndoe";
        String email = "johndoe@example.com";
        String phoneNumber = "555-1234";
        String role = "user";

        
        User user = new User(userId, username, email, phoneNumber, role);
        userManager.addUser(user);

        boolean isDeleted = userManager.deleteUser(userId);

        assertTrue(isDeleted);
        assertNull(userManager.getUser(userId));
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class AvtosalonManagerTest {

    @Test
    public void testEditDiscount() {
        AvtosalonManager avtosalonManager = new AvtosalonManager();
        String avtosalonId = "123456";
        String name = "My Auto Salon";
        String address = "123 Main Street";
        String city = "New York";
        String phoneNumber = "555-1234";
        String website = "www.myautosalon.com";
        double initialDiscount = 0.1;

       
        Avtosalon avtosalon = new Avtosalon(avtosalonId, name, address, city, phoneNumber, website, initialDiscount);
        avtosalonManager.addAvtosalon(avtosalon);

        double newDiscount = 0.15;
        avtosalonManager.editDiscount(avtosalonId, newDiscount);

        Avtosalon updatedAvtosalon = avtosalonManager.getAvtosalon(avtosalonId);

        assertNotNull(updatedAvtosalon);
        assertEquals(newDiscount, updatedAvtosalon.getDiscount(), 0.001);
        assertEquals(name, updatedAvtosalon.getName());
        assertEquals(address, updatedAvtosalon.getAddress());
        assertEquals(city, updatedAvtosalon.getCity());
        assertEquals(phoneNumber, updatedAvtosalon.getPhoneNumber());
        assertEquals(website, updatedAvtosalon.getWebsite());
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyticsManagerTest {

    @Test
    public void testViewAnalytics() {
        AnalyticsManager analyticsManager = new AnalyticsManager();

        String startDate = "2024-01-01";
        String endDate = "2024-12-31";
        String metric1 = "user_count";
        String metric2 = "sales_volume";
        String metric3 = "average_rating";

        analyticsManager.addAnalyticsData(startDate, endDate, metric1, 1000);
        analyticsManager.addAnalyticsData(startDate, endDate, metric2, 5000000);
        analyticsManager.addAnalyticsData(startDate, endDate, metric3, 4.5);

        double userCount = analyticsManager.getAnalyticsData(startDate, endDate, metric1);
        double salesVolume = analyticsManager.getAnalyticsData(startDate, endDate, metric2);
        double averageRating = analyticsManager.getAnalyticsData(startDate, endDate, metric3);

        assertEquals(1000, userCount, 0.001);
        assertEquals(5000000, salesVolume, 0.001);
        assertEquals(4.5, averageRating, 0.001);
    }
}
    public void testViewCarAnalytics() {
        CarAnalyticsManager carAnalyticsManager = new CarAnalyticsManager();

        String startDate = "2024-01-01";
        String endDate = "2024-12-31";
        String metric1 = "car_count";
        String metric2 = "sales_volume";
        String metric3 = "average_price";

        carAnalyticsManager.addCarAnalyticsData(startDate, endDate, metric1, 100);
        carAnalyticsManager.addCarAnalyticsData(startDate, endDate, metric2, 5000000);
        carAnalyticsManager.addCarAnalyticsData(startDate, endDate, metric3, 25000);

        double carCount = carAnalyticsManager.getCarAnalyticsData(startDate, endDate, metric1);
        double salesVolume = carAnalyticsManager.getCarAnalyticsData(startDate, endDate, metric2);
        double averagePrice = carAnalyticsManager.getCarAnalyticsData(startDate, endDate, metric3);

        assertEquals(100, carCount, 0.001);
        assertEquals(5000000, salesVolume, 0.001);
        assertEquals(25000, averagePrice, 0.001);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class ReportExporterTest {

    @Test
    public void testExportReport() {
        ReportExporter reportExporter = new ReportExporter();

        String reportData = "Sample report data";

        
        boolean exportResult = reportExporter.exportAnalis(reportData);

        assertTrue(exportResult);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class CarDiscountManagerTest {

    @Test
    public void testAddDiscount() {
        
        CarDiscountManager carDiscountManager = new CarDiscountManager();

        String carBrand = "Toyota";
        String carModel = "Camry";
        int carYear = 2020;
        double carMileage = 10000.0;
        double carEngineSize = 2.5;
        double carFuelConsumption = 10.0;
        String carDealer = "Dealer A";
        double discountAmount = 5000.0;

      
        Car car = new Car(carBrand, carModel, carYear, carMileage, carEngineSize, carFuelConsumption, carDealer);

        boolean addDiscountResult = carDiscountManager.addDiscount(car, discountAmount);

        assertTrue(addDiscountResult);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class CarDiscountManagerTest {

    @Test
    public void testEditAvtosalon() {
       
        CarDiscountManager carDiscountManager = new CarDiscountManager();

        String avtosalonName = "Avtosalon A";
        String newAvtosalonName = "Updated Avtosalon A";
        String avtosalonLocation = "City X";
        String newAvtosalonLocation = "City Y";
        int avtosalonCapacity = 100;
        int newAvtosalonCapacity = 150;
        String avtosalonManager = "John Doe";
        String newAvtosalonManager = "Jane Smith";
        String avtosalonContact = "contact@avtosalon.com";
        String newAvtosalonContact = "newcontact@avtosalon.com";

        
        carDiscountManager.setAvtosalonName(avtosalonName);
        carDiscountManager.setAvtosalonLocation(avtosalonLocation);
        carDiscountManager.setAvtosalonCapacity(avtosalonCapacity);
        carDiscountManager.setAvtosalonManager(avtosalonManager);
        carDiscountManager.setAvtosalonContact(avtosalonContact);

        
        boolean editAvtosalonResult = carDiscountManager.editAvtosalon(newAvtosalonName, newAvtosalonLocation, newAvtosalonCapacity, newAvtosalonManager, newAvtosalonContact);

        assertTrue(editAvtosalonResult);
    }
}
