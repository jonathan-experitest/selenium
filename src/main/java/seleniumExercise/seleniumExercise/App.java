package seleniumExercise.seleniumExercise;
import org.openqa.selenium.Platform;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
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