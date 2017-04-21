package by.training.nc.dev3.i18n;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dima on 21.4.17.
 */
public class Locale {
    private static final String US = "en_US";
    private static final String ES = "es_ES";

    public static String getLang(ServletRequest servletRequest){
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        try{
            System.out.println(httpServletRequest.getParameter("locale"));
            if(httpServletRequest.getParameter("locale").equals("en")){
                return US;
            }else if(httpServletRequest.getParameter("locale").equals("es")){
                return ES;
            }
        }catch (NullPointerException ex){
            return US;
        }
        return US;
    }
}
