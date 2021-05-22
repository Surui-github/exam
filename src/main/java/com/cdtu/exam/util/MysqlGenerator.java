package com.cdtu.exam.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author : SuRui
 * @ClassName : MysqlGenerator
 * @Description : 自动生成CRUD代码
 * @date : 2021/3/18 16:32
 **/
//@Deprecated
public class MysqlGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        //gc.setOutputDir(projectPath + "/src/main/java");
        //// 作者
        //gc.setAuthor("SuRui");
        ////生成代码后是否打开文件夹
        //gc.setOpen(false);
        //// 设置Service接口生成名称,这样生成接口前面就不会有
        //gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        //DataSourceConfig dsc = new DataSourceConfig();
        //dsc.setUrl("jdbc:mysql://localhost:3306/me?useUnicode=true&useSSL=false&characterEncoding=utf-8");
        //dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //dsc.setUsername("root");
        //dsc.setPassword("root");
        //mpg.setDataSource(dsc);

        // 包配置
        //PackageConfig pc = new PackageConfig();
        //// 模块名称, 这里可以根据不同模块来写
        //pc.setModuleName("");
        //// 父包名
        //pc.setParent("com.cdtu.exam");
        //mpg.setPackageInfo(pc);



        // 策略配置
        //StrategyConfig strategy = new StrategyConfig();
        //strategy.setNaming(NamingStrategy.underline_to_camel);
        //strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setEntityLombokModel(true);
        //// 表名，如果要生成多个,这里可以传入String[]
        //strategy.setInclude("post");
        //mpg.setStrategy(strategy);
        //mpg.execute();
    }
}
