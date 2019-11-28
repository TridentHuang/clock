package cn.fanyu.clock.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @version V3.0
 * @Title: BootInterceptor
 * @Company: 成都影达科技有限公司
 * @Description: 日志拦截器
 * @author: 东进
 * @date 2019/8/3 上午10:19
 */
@Slf4j
public class BootInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 对来自后台的请求统一进行日志处理
         */
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        Map<String, String[]> map = request.getParameterMap();
        System.out.println("---------------------------------------------------------------------------------------------------");
        map.forEach((k, v) -> {
            log.info("请求参数-- " + k + ": " + v[0]);
        });
        log.info("url--" + url);
        log.info("method--" + method);
        log.info("uri--" + uri);
        System.out.println("---------------------------------------------------------------------------------------------------");
        return true;
    }
}
