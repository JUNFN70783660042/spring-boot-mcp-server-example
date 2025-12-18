package com.mcp_server.mcp;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Slf4j
@Service
public class BaseToolService {
    /**
     * 健康检查
     */
    @McpTool(name = "healthy", description = "用于mcp连接的健康检查")
    public String healthy() {
        Map<String,String> map = new HashMap<>();
        map.put("state","online");
        return JSONUtil.toJsonStr( map);
    }

}
