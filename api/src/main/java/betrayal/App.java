package betrayal;

import java.util.EnumSet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import jakarta.servlet.DispatcherType;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = startServer(8090);
        ServletContextHandler context = createStatefulContext(server);
        registerServlets(context);

        FilterHolder cors = context.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");

        server.start();
        System.out.println("Started server.");
        System.out.println("Listening on http://localhost:8090/");
        System.out.println("Press CTRL+C to exit.");
        server.join();

    }

    private static Server startServer(int port) {
        return new Server(8090);
    }

    private static ServletContextHandler createStatefulContext(Server server) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        return context;
    }

    private static void registerServlets(ServletContextHandler context) {
        // Use the Jersey framework to translate the classes in the
        // mancala.api package to server endpoints (servlets).
        // For example, the StartMancala class will become an endpoint at
        // http://localost:8090/mancala/api/start
        ServletHolder serverHolder = context.addServlet(ServletContainer.class, "/betrayal/api/*");
        serverHolder.setInitOrder(1);
        serverHolder.setInitParameter("jersey.config.server.provider.packages",
                "betrayal.api");
    }
}
// GET /betrayal/api/character?id=1 HTTP/1.1
// HEADERS
//
