import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Utwórz metody add(int a, int b) oraz multiply(int a, int b). Pierwsza metoda powinna zwrócić wynik dodawania parametrów, a druga powinna zwracać zawszę liczbę 4.
Stwórz test, przekaż w nim do metody add() liczby 2 oraz 3, następnie przy pomocy asercji sprawdź czy zwrócona wartość jest równa 5.
Stwórz test, przekaż w nim do metody multiply() liczby 2 oraz 3, następnie przy pomocy asercji sprawdź czy zwrócona wartość jest równa 6.
Stwórz dwie metody zgodnie z poniższy wymaganiami dla każdej co do posiadanych adnotacji oraz wyświetlanego tekstu przy pomocy System.out.Println():
	metoda 1: @BeforeMethod, wyświetlenie „run before each test”
	metoda 2: @AfterMethod, wyświetlenie „run after each test”
Uruchom testy i przeanalizuj w jaki sposób zostały wyświetlone informacje z punktów 2-4.

 */


public class MyFirstTest {

    @BeforeMethod
    public void setUp(){
        System.out.println("PRZED");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("PO");
    }

    @Test
    public void shouldCalculateValue(){
        System.out.println(">>> to jest moj test 1");
        Assert.assertEquals(4,5);
        System.out.println(">>>to jest koniec testu 1");
    }

    @Test
    public void shouldCalculateValue2(){
        System.out.println(">>> to jest moj test 2");
        Assert.assertEquals(add(2,3),5);
        System.out.println(">>>to jest koniec testu 2");
    }

    public int add(int a, int b){
        return a+b;
    }

}
