package com.mypack;

import static spark.Spark.*;

import java.util.Date;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Server component.
 */
public class Server 
{
    /**
     * The port number.
     */
    private static final int port = 9090;
    private static String host = "*";
    public void run() throws InterruptedException {
        port(port);
        InetAddress ip;
        String hostname = "*";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            host = ip.toString();

        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }

        get("", (req, res) -> {

            return String.format("[%s to %s] %s: Just default.", req.ip(), host, new Date().toString());
        });


        get("/", (req, res) -> {

            return String.format("[%s to %s] %s: This is root path.", req.ip(), host, new Date().toString());
        });

        get("/hello", (req, res) -> {
            System.out.println("Hello World Server!");
            return String.format("[%s to %s] %s: Hello %s", req.ip(), host, new Date().toString(), req.queryParamsSafe("name") != null ? req.queryParamsSafe("name") : "noname");
        });

        get("/wait", (req, res) -> {
            int time = Integer.parseInt(req.queryParamsSafe("time") != null ? req.queryParamsSafe("time") : "1000");
            if (time <= 0) time = 1000;
            else if (time>5000) time = 5000;
            Thread.sleep(time);
            return String.format("[%s to %s] %s: Delay was %d milliseconds", req.ip(), host, new Date().toString(), time);
        });
    }
}
