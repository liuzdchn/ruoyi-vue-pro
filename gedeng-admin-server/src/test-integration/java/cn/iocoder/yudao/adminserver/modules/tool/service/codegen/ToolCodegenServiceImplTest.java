package com.gedeng.trade.adminserver.modules.tool.service.codegen;

import com.gedeng.trade.adminserver.BaseDbUnitTest;
import com.gedeng.trade.adminserver.modules.tool.service.codegen.impl.ToolCodegenServiceImpl;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class ToolCodegenServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ToolCodegenServiceImpl toolCodegenService;

    @Test
    public void tetCreateCodegenTable() {
        toolCodegenService.createCodegen("tool_test_demo");
//        toolCodegenService.createCodegenTable("tool_codegen_table");
//        toolCodegenService.createCodegen("tool_codegen_column");
    }

}
