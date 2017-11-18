package cookiework.encryptvideoweb.viewer;

import com.google.gson.JsonObject;
import cookiework.encryptvideoweb.BusinessLogic;
import cookiework.encryptvideoweb.SubscriptionInfo;
import cookiework.encryptvideoweb.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/07/28.
 */
public class TagReplaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String mStr = request.getParameter("M");
        String mPrimeStr = null;
        try {
            mPrimeStr = BusinessLogic.changePrivateKey(id, mStr);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        SubscriptionInfo info = new SubscriptionInfo();
        info.setId(Integer.parseInt(id));
        info.setMPrime(mPrimeStr);
        info.setStatus(SubscriptionInfo.SUBSCRIPTION_APPROVE);
        Util.writeJsonToResponse(response, info.toJsonElement());
    }
}
