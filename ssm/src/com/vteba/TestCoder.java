package com.vteba;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.DB;
import com.vteba.ext.codegen.KeyType;
import com.vteba.ext.codegen.TempType;

public class TestCoder {

	public static void main(String[] args) {
	    //项目绝对路径
		String rootPath = "C:/Users/Administrator/git/ssm/ssm/";
		CodeBuilder builder = new CodeBuilder(rootPath, TempType.Mybatis);
		builder.setConfigFilePath("src/jndi.properties")
		.setSrcPath("src/")
		.schema("skmbw")
		.className("User")
		.setDb(DB.PostgreSQL)// 可以不使用，只要jdbc url是正确的
		.keyType(KeyType.Long)
		.tableDesc("系统用户")
		.tableName("user")
		.module("com.vteba.user2")
		.setPojo(false)
		.setMongo(false)
		.setGenAction(false)
        .setGenDao(false)
        .setGenMapper(false)
        .setGenModel(false)
        .setGenService(false)
		.build();

	}

}
