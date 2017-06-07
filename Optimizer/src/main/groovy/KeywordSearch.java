
import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import com.traffic.EstimateKeywordTraffic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by lenovo on 5/29/2017.
 */
@WebServlet(name = "KeywordSearch")
public class KeywordSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties=new Properties();
        properties.load(getServletContext().getResourceAsStream("ads.properties"));


        String userinput = request.getParameter("search");
        EstimateKeywordTraffic ekt = new EstimateKeywordTraffic();
        Credential oAuth2Credential = null;
        try {
            oAuth2Credential = new OfflineCredentials.Builder()
                    .forApi(Api.ADWORDS)
                    .fromFile()
                    .build()
                    .generateCredential();
        } catch (OAuthException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ValidationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ConfigurationLoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Construct an AdWordsSession.
        AdWordsSession session = null;
        try {
            session = new AdWordsSession.Builder()
                    .fromFile()
                    .withOAuth2Credential(oAuth2Credential)
                    .build();
        } catch (ValidationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ConfigurationLoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        AdWordsServices adWordsServices = new AdWordsServices();
        try {
            ekt.runExample(adWordsServices, session, userinput);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
System.out.println("haiiiiiii");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
