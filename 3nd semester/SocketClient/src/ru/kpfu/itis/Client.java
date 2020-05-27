package ru.kpfu.itis;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private String URL_METHOD_STRING = null;

    private static final String STATUS_OK = "200";
    private static final String STATUS_NOT_FOUND = "404";
    private static final String STATUS_BAD_REQUEST = "400";
    private static final String STATUS_FORBIDDEN = "403";
    private boolean isPost = false;

    public void connect() {
        Scanner sc = new Scanner(System.in);
        String urlString = "";
        String contentTypeStr = "";
        String contentParameterStr = "";
        System.out.println("Method (g - get, p - post)");
        String method = sc.next();
        if (method.equals("g") || method.equals("get")) {
            URL_METHOD_STRING = "GET";
        } else if (method.equals("p") || method.equals("post")) {
            URL_METHOD_STRING = "POST";
            isPost = true;
        } else System.out.println("Try again. Method (GET/POST)");
        System.out.println("Write url");
        urlString = sc.next();
        try {

            Pattern urlRegexPattern = Pattern.compile("([\\da-z\\.-]+)\\.([a-z\\.]{2,6})");
            Matcher urlRegexMatcher = urlRegexPattern.matcher(urlString);
            if (urlRegexMatcher.find()) {

                String regexString = urlRegexMatcher.group(1)+"."+urlRegexMatcher.group(2);
                Socket socket = new Socket(InetAddress.getByName("www." + regexString), 80);
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                pw.println(URL_METHOD_STRING + " " + urlString + " HTTP/1.1");
                System.out.println("Your string:\n" + URL_METHOD_STRING + " " + urlString + " HTTP/1.1");
                pw.println("Host: www." + regexString);
                pw.println("");
                if(isPost){
                    System.out.println("Content-type");
                    contentTypeStr = sc.next();
                    pw.println("Content-Type: "+contentTypeStr);
                    pw.println("");
                    System.out.println("Parameters");
                    contentParameterStr = sc.next();
                    pw.println(contentParameterStr);
                    pw.println("");
                }
                pw.flush();
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                String read;
                String allHtml = "";
                read = bf.readLine();
                Pattern responseCodeRegexPattern = Pattern.compile("\\s\\d+\\s");
                Matcher responseCodeRegexMatcher = responseCodeRegexPattern.matcher(read);
                if (responseCodeRegexMatcher.find()) {
                    System.out.println(responseCodeRegexMatcher.group());
                    if (responseCodeRegexMatcher.group().trim().equals(STATUS_OK)) {
                        while ((read = bf.readLine()) != null) {
                            allHtml += read + "\n";
                            System.out.println(allHtml);
                            Thread.sleep(100);
                        }
                        System.out.println(allHtml);
                    } else if (responseCodeRegexMatcher.group().equals(STATUS_NOT_FOUND)) {
                        System.out.println("Not Found");
                    } else if (responseCodeRegexMatcher.group().equals(STATUS_BAD_REQUEST)) {
                        System.out.println("Bad Request");
                    } else if (responseCodeRegexMatcher.group().equals(STATUS_FORBIDDEN)) {
                        System.out.println("Forbidden");
                    } else System.err.println("FAIL ");
                } else System.err.println("Not working");
                /*}*/
                socket.close();
            } else System.out.println("Try again. Write url");
        } catch (ConnectException | InterruptedException e){
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Address not found");
            e.printStackTrace();
        }
    }
}
