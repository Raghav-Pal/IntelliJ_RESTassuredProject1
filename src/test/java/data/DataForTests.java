package data;

import org.testng.annotations.DataProvider;

public class DataForTests {


    @DataProvider(name = "DataForPost")
    public Object[][] data_for_post(){

        return new Object[][]{
                {"Sam", 1},
                {"Raman", 2}
        };
    }

    @DataProvider(name = "DataForDelete")
    public Object[] data_for_delete(){

        return new Object[]{
            4,5,6
        };
    }
}
