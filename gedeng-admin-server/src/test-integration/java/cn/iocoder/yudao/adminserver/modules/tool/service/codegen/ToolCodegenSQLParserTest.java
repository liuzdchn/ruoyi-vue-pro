package com.gedeng.trade.adminserver.modules.tool.service.codegen;

import com.gedeng.trade.adminserver.BaseDbUnitTest;
import com.gedeng.trade.adminserver.modules.tool.service.codegen.impl.ToolCodegenSQLParser;
import org.junit.jupiter.api.Test;

public class ToolCodegenSQLParserTest extends BaseDbUnitTest {

    @Test
    public void testParse() {
        String sql = "CREATE TABLE `tool_test_demo` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',\n" +
                "  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名字',\n" +
                "  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态',\n" +
                "  `type` tinyint(4) NOT NULL COMMENT '类型',\n" +
                "  `category` tinyint(4) NOT NULL COMMENT '分类',\n" +
                "  `remark` varchar(500) DEFAULT NULL COMMENT '备注',\n" +
                "  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',\n" +
                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',\n" +
                "  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                "  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';";
        ToolCodegenSQLParser.parse(sql);
        // TODO 芋艿：后续完善断言
    }

}
