package org.anna.server;

import com.sun.net.httpserver.HttpServer;
import org.anna.controller.HomeController;
import org.anna.controller.LoginController;
import org.anna.controller.RegistrationController;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {

    static final int port = 5678;
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new HomeController());
        server.createContext("/registration", new RegistrationController());
        server.createContext("/login", new LoginController());
//        server.createContext("/logout", new HomeHandler());

        System.out.println("Server is running on the port: " + port);
        server.start();
    }
}
