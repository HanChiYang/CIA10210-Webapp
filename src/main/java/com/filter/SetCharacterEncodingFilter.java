package com.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8")
})
public class SetCharacterEncodingFilter implements Filter {

    protected String encoding = "UTF-8"; // 預設字符編碼

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 從配置中讀取字符編碼
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        // 設置請求的字符編碼
        request.setCharacterEncoding(encoding);
        // 將控制權交給後續的過濾器或最終的請求處理
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 清理資源
        this.encoding = null;
    }
}