package cookiework.encryptvideoweb.publisher;

import com.google.gson.JsonObject;
import cookiework.encryptvideoweb.BusinessLogic;
import cookiework.encryptvideoweb.Util;
import org.bouncycastle.util.encoders.UrlBase64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/07/29.
 */
public class RemoveSubscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String removeIdStr = request.getParameter("removeid");
        String[] removeIds = new String[]{removeIdStr};
        try {
            BusinessLogic.removeSubscription(removeIds);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        JsonObject object = new JsonObject();
        object.addProperty("result", "success");
        Util.writeJsonToResponse(response, object);
    }
}
