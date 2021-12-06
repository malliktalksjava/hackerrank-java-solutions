package com.mvtechbytes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortingExampleUser {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ram", 28));
        userList.add(new User("Raj", 35));
        userList.add(new User("Rakesh", 31));
        userList.add(new User("Peter", 30));
        userList.add(new User("John", 25));
        userList.add(new User("Sri", 55));

        long starttime = System.currentTimeMillis();
        System.out.println("sortListUsingCollections : " + sortListUsingCollections(userList));
        System.out.println("Time Taken in Millis : " + (System.currentTimeMillis() - starttime));

        long starttime2 = System.currentTimeMillis();
        System.out.println("sortListUsingCollections : " + sortListUsingStreams(userList));
        System.out.println("Time Taken in Millis  2: " + (System.currentTimeMillis() - starttime2));

        long starttime3 = System.currentTimeMillis();
        System.out.println("sortListUsingCollections : " + sortUsingLambda(userList));
        System.out.println("Time Taken in Millis  2: " + (System.currentTimeMillis() - starttime3));


    }


    //using Collections.sort
    private static List<User> sortListUsingCollections(List<User> list){

        Collections.sort(list, Comparator.comparingInt(User::getAge));
        //Collections.reverse(list); // un comment if for descending order

        return list;
    }

    //using streams and comparator
    private static List<User> sortListUsingStreams(List<User> list){

        return list.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                //.sorted(Comparator.comparingInt(User::getAge).reversed()) //-- for reverse order uncomment this line and comment above line
                .collect(toList());
    }

    //using lambda expressions
    private static List<User> sortUsingLambda(List<User> list){

        return list.stream()
                .sorted((User user1, User user2) -> user1.getAge() > user2.getAge() ? 1: 0)
                //.sorted((User user1, User user2) -> user1.getAge() < user2.getAge() ? 1: 0) - uncomment if reverse order needed
                .collect(toList());

    }
}

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
