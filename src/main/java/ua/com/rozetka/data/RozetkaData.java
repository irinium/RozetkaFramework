package ua.com.rozetka.data;

import org.testng.annotations.DataProvider;

public class RozetkaData {

    @DataProvider(name = "login")
    public static Object[][] login() {
        return new Object[][]{
                {"irivassh4497@gmail.com", "I44978888s", "Ирина"},
        };
    }

    @DataProvider(name = "search")
    public static Object[][] search() {
        return new Object[][]{
                {"Apple iPhone 11 Pro Max 256GB", "Корзина пуста"},
        };
    }
}
