package App;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import utils.FeatureOverright;

public class App 
{
    public static void main( String[] args ) throws InvalidFormatException, IOException
    {
    	FeatureOverright.overrideFeatureFiles("test.features");
    }
}
