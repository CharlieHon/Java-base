package com.charlie.dao_.test;

import com.charlie.dao_.dao.ActorDAO;
import com.charlie.dao_.domain.Actor;
import org.junit.Test;

import java.util.List;

public class TestDAO {
    // 测试 ActorDAO 对 actor表的crud操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        // 1. 查询多行
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 3);
        System.out.println("========查询结果========");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        // 2. 查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 3);
        System.out.println("=====单行查询结果=====");
        System.out.println(actor);

        // 3. 查询单行单列(单值)结果
        Object obj = actorDAO.queryScalar("select name from actor where id = ?", 3);
        System.out.println("======单值查询结果======");
        System.out.println(obj);

        // 4. 演示 dml操作
        int update = actorDAO.update("insert into actor values (null, ?, '男', '1945-8-6', '142')", "陈岩石");
        System.out.println(update > 0 ? "执行成功！" : "操作未对数据表产生影响~");
    }
}
