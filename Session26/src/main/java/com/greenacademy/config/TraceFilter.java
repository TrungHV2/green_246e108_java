package com.greenacademy.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1) // Thứ tự ưu tiên (số càng nhỏ càng ưu tiên cao)
public class TraceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // (1) Tạo traceId nếu chưa có
        String traceId = ((HttpServletRequest) request).getHeader("X-Trace-Id");
        if (traceId == null || traceId.isEmpty()) {
            traceId = UUID.randomUUID().toString();
        }

        // (2) Đặt vào MDC để logback in ra
        MDC.put("traceId", generateShortTraceId());

        try {
            chain.doFilter(request, response); // (3) Cho phép request đi tiếp
        } finally {
            MDC.remove("traceId"); // (4) Xóa traceId sau khi request hoàn thành
        }
    }

    // Hàm sinh traceId 12 ký tự từ UUID
    private String generateShortTraceId() {
        String fullUuid = UUID.randomUUID().toString().replace("-", "");
        return fullUuid.substring(0, 12); // Lấy 12 ký tự đầu
    }
}
