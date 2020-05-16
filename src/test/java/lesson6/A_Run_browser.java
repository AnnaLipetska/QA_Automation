// Это не тест, а скрипт
package test.java.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_Run_browser {
    public static void main(String[] args) throws InterruptedException { // throws...Exception добавилось автоматически
        // из-за метода Thread.sleep. Тут не общее исключение, а исключение перехвата унаследованное от общего класса
        // исключений.
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Прописываем exe-файл, с которым нужно
        // работать, Property должно идти до инициализации драйвера.
        // Можно не изменяя проект подложить свою версию драйвера и работать.
        WebDriver driver = new ChromeDriver(); // Создаем экземпляр драйвера
//........................................
        // Открыть страницу:
        driver.get("https://rozetka.com.ua/"); // вставляем адрес сайта
        Thread.sleep(5000); // Поставить паузу в миллисекундах
        // Это плохой метод, но нам подходит
        // Idea красным подсвечивает слово sleep, Alt+Enter, Thread.sleep - потенциально может вызвать исключение,
        // поэтому нужно либо обернуть в try-catch либо передать обработку исключения наверх - добавить в сигнатуру
        // проброску метода. Мы выбрали Add exception to method signature. lesson7_2:52:35
//............................................
        // Попробуем в поиск ввести слово
        // В панели разработчика ищем подходящий селектор [name='search']
        // Нужно описать наш элемент, что у нас есть некий input
        // Чтобы описать элемент нужно воспользоваться классом By
        // В By есть 8 видов селекторов, самый простой By.id, есть By.className, By.name - поиск по аттрибуту name
        // Можно искать по имени тега By.tagName, можно по By.xpath, по тексту ссылки By.partialLinkText - текст внутри
        // тега a или по частичному совпадению
        By search = By.cssSelector("[name = 'search']");// Мы выбрали cssSelector, так как мы составили селектор такого
        // типа. Лучше внутри селекторов использовать одинарные кавычки чтобы не экранировать двойные кавычки, так как
        // сам селектор - это строка в двойных кавычках.
        // Это мы описали, что этот селектор потенциально может быть, а может и не быть.
//........................
        // Если попытаться взять search. и на нем попытаться вызвать метод click - ничего не получится.
        // Потому что нужно драйвером найти этот элемент.
        // driver.findElement() по сигнатуре принимает элемент типа By.

        // Найденный элемент мы можем присвоить сущности WebElement // 2:58:36
/*        WebElement searchEl = driver.findElement(search);
        searchEl.click();*/

/*      Или короче:
        driver.findElement(search).click(); // Но нам пока click не нужен, нам сначала нужно ввести слово*/
//............................
        //driver.findElement(search).sendKeys("iPhone"); // а потом нужно кликнуть, но сразу тут же кликнуть
        // нельзя, так как sendKeys не возвращает экземпляр типа WebElement.
        // Соответственно либо заново нужно найти элемент либо:
        WebElement searchEl = driver.findElement(search); // Найденный элемент присваиваем сущности WebElement
        searchEl.sendKeys("iPhone");
        searchEl.click();
        Thread.sleep(2000);
        //..................
        // Когда вы будете писать тесты, может завалиться и написать, что элемент не найден, если страница еще не
        // прогрузилась, а вы уже пытаетесь искать, нужно пользоваться Thread.sleep
        //...................
        // Ищем имя-фамилию (текст с селектором [class="header-topline__user-link link-dashed"])
        // driver.findElement(By.cssSelector("header-topline__user-link link-dashed")).getText();// Можно и так записать
        // Теперь мы вызываем getText, который на выходе выплевывает строку, поэтому сразу присвоим значенние
        // строке
        // [class='header-topline__user-link link-dashed']
        // String name = driver.findElement(By.cssSelector("header-topline__user-link link-dashed")).getText();

        // При попытке отработать код выдает ошибку, т.к. браузер подтянулся без кеша и там не закешировано имя.
        // Вывалилось сообщение no such element.
        // Как это обойти? Закомментируем метод quit дальше по тексту.
        // Запустим еще раз наш драйвер, он у нас еще раз свалится, но браузер не закроется и мы сможем посмотреть
        // какой там есть элемент, как он звучит.
        String name = driver.findElement(By.cssSelector("[class='header-topline__user-link link-dashed']")).getText();
        System.out.println(name);
        // Поменяли селектор, запускаем. Раскомментируем quit. Срабатывает нормально.
        // В консоли видим строку, с ней при желании можем работать.
//.............................
        driver.quit(); // закроет страницу и все вкладки, более удобный
        // driver.close(); // закроет только текущую вкладку
    }
}
