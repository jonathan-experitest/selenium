package seleniumExercise.seleniumExercise;

import org.openqa.selenium.Platform;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	int numOfFirefox= 3;
	    int numOfChrome= 3;
	    int numOfIE= 3;
	    int numOfIos= 2;
	    int numOfAndroid= 2;

	        for  (int a=0 ; a<numOfIE; a++) {
	            myTests test= new myTests(PlatformType.IE, "10", Platform.WIN8.toString(), "IE test #"+(a+1));
	            Thread t1= new Thread(test);
	            t1.start();
	        }
	        
	        for  (int a=0 ; a<numOfChrome; a++) {
	            myTests test= new myTests(PlatformType.CHROME, "56", Platform.WIN8.toString(), "Chrome test #"+(a+1));
	            Thread t1= new Thread(test);
	            t1.start();
	        }
	        for  (int a=0 ; a<numOfFirefox; a++) {
	            myTests test= new myTests(PlatformType.FIREFOX, "57", Platform.WIN8.toString(), "Firefox test #"+(a+1));
	            Thread t1= new Thread(test);
	            t1.start();
	        }
	        
    }
}
