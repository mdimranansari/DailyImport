import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNGxmlRunPractice {

	@BeforeClass
	public static void TestInit()
	{
		System.out.println("This is TestInit method");
		
	}
	
	@Test
	public static void Test1()
	{
		System.out.println("This is Test1");
		
	}
}
