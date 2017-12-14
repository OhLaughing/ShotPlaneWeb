package com.bigwanggang;

import java.io.FileWriter;
import java.io.IOException;

public class Persion {
    public static final String FILE = "information.txt";
    private String name;
    private String id;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void save(Persion persion) throws IOException {
        FileWriter fw = new FileWriter(FILE, true);
        System.out.println(persion.getName());
        System.out.println(persion.getId());
        System.out.println(persion.getAge());
        fw.write(persion.getName() + "-" + persion.getId() + "-" + persion.getAge());
        fw.write("\r\n");
        fw.flush();
        fw.close();
    }
       public static void save(String s) throws IOException {
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(s);
        fw.write("\r\n");
        fw.flush();
        fw.close();
    }
}
