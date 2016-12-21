package map;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.model.core.ID;
import map.db.DB;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mapdb.DBMaker;

import java.io.Serializable;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiang on 2016/12/21 0021.
 * 测试表示平均查找性能是mapdb的7倍左右
 */
public class dbcomare {
    static DB db = DB.getInstance("d");
    static org.mapdb.DB db2;
   static Map<String, Object> map1;
   static Map<String, Object> mapmy;

    @BeforeClass

    public static void setUp() throws Exception {
        db2 = DBMaker.fileDB("d2").make();
        map1 = (Map<String, Object>) db2.treeMap("dd114").createOrOpen();
        mapmy = db.createorGetmap("db114");
    }

    @Test
    public void compare_mapdb() throws Exception {
        for (int j = 0; j < 100; j++) {
            for (int i = 4000; i < 5000; i++) {
                person actual = (person) map1.get("dddd" + i);
                assertEquals(i, actual.id);
            }
        }
    }
    @Test
    public void compare_my() throws Exception {
        for (int j = 0; j < 100; j++) {
            for (int i = 4000; i < 5000; i++) {
                person actual = (person) mapmy.get("dddd" + i);
                assertEquals(i, actual.id);
            }
        }
    }

    @Test
    public void insert() throws Exception {
//        person person = new person();
//        for (int i = 0; i < 10000; i++) {
//            person.id = i;
//            mapmy.put("dddd" + i, person);
//            map1.put("dddd" + i, person);
//        }
//        db2.close();
    }

    @Test
    public void remove_db() throws Exception {
//        for (int i = 0; i < 5000; i++) {
//            map1.remove("dddd" + i);
//        }
//        db2.close();
    }

    @Test
    public void remove_my() throws Exception {
//        for (int i = 0; i < 5000; i++) {
//            mapmy.remove("dddd" + i);
//        }
    }
    @Test
    public void compare2_mapdb() throws Exception {
//        for (int i = 0; i < 5; i++) {
//            assertEquals(i, map1.get("dddd" + i));
//        }
    }

    @Test
    public void compar2_my() throws Exception {
//        for (int i = 0; i < 5; i++) {
//            assertEquals(i, mapmy.get("dddd" + i));
//        }
    }
    static class person implements Serializable
    {
       public int id;
        String name;
        int[] ints = new int[2048];
    }
}
