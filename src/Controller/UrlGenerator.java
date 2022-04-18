package Controller;

public class UrlGenerator {
    private static final String base_url="http://ergast.com/api/f1/";
    private static final String slash = "/";
    public String result;


    public String getAllDriver(){

        result = base_url + "drivers";


        return result;
    }

    public String getYearDriver(int year){

        result = base_url + year + "/drivers/";


        return result;
    }



    public String getRoundYearDriver(int round,int year){

        result = base_url + year + slash + round + "/drivers/";


        return result;
    }

    public String getDriver(String driver){

        result = base_url + "drivers/" + driver;


        return result;
    }

    public String getAllConstructor(){

        result = base_url + "constructors";


        return result;
    }

    public String getYearConstructor(int year){

        result = base_url + year + "/constructors/";


        return result;
    }
}
