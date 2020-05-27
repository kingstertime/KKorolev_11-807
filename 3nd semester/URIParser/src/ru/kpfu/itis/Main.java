package ru.kpfu.itis;

public class Main {
    public static void main(String[] args) {
        Parser uri = new Parser("foo://kingstertime:qwerty123@www.myshows.me:8080/serials/the-mandalorian.html" +
                "?arg=val#fragment");
        System.out.println(uri.getScheme());
        System.out.println(uri.getUserInfo());
        System.out.println(uri.getHost());
        System.out.println(uri.getPath());
        System.out.println(uri.getQuery());
        System.out.println(uri.getFragment());
    }
}
