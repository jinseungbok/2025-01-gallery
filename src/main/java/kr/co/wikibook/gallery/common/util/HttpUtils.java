package kr.co.wikibook.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;

public class HttpUtils {

    // 세션 데이터 저장 (브라우저 마다)
    public static void setSession(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }
    // set은 key, value 필요 , get은 key 값만 있으면 됨

    // 세션에 저장된 데이터 얻기
    public static Object getSessionValue(HttpServletRequest req, String key) {
        return req.getSession().getAttribute(key);
    }

    // 세션에 저장된 데이터 삭제
    public static void removeSessionValue(HttpServletRequest req, String key) {
        req.getSession().removeAttribute(key);
    }
}
