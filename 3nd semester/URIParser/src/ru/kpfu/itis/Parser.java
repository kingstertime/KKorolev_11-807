package ru.kpfu.itis;

import java.io.Serializable;

class Parser implements Serializable {
    private String uri;

    public Parser(String uri) {
        this.uri = uri;
    }

    String getScheme() {
        return uri.substring(0, uri.indexOf("://"));
    }

    String getUserInfo() {
        return uri.substring(uri.indexOf("://") + 3, uri.indexOf("@"));
    }

    String getHost() {
        int start = uri.indexOf("@");
        if (start == -1) {
            int newStart = uri.indexOf("://");
            int newEnd = uri.indexOf("/", newStart);
            return uri.substring(newStart, newEnd);
        } else {
            return uri.substring(start + 1, uri.indexOf("/", start));
        }
    }

    String getPath() {
        return uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("?"));
    }

    String getQuery() {
        return uri.substring(uri.indexOf("?") + 1, uri.indexOf("#"));
    }

    String getFragment() {
        if (uri.substring(uri.indexOf("#") + 1).equals("-1")) {
            return null;
        } else {
            return uri.substring(uri.indexOf("#") + 1);
        }
    }
}

