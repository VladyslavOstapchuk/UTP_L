package com.company.Compare;

import java.util.*;

public class Main {

    //First method is implementation of interface Comparable
    //Second method is creation of class that implements interface Comparable
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    //Method 1
    public static void ex1(){
        List<Player> players = new ArrayList(Arrays.asList(
                new Player(4, "Sasoon"),
                new Player(3, "Danullobobo"),
                new Player(2, "Server"),
                new Player(1, "Babijon")
        ));

        players.sort(Player::compareTo);

        System.out.println(players);
    }

    //Method 2
    public static void ex2(){
        List<Player> players = new ArrayList(Arrays.asList(
                new Player(4, "Sasoon"),
                new Player(3, "Danullobobo"),
                new Player(2, "Server"),
                new Player(1, "Babijon")
        ));

        players.sort(new PlayerRankComparatorDesc());

        System.out.println(players);
    }

    //Just additional func
    public static void ex3() {
        List<Integer> arrayList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6));
        removeGreaterThan(arrayList, 1);
        System.out.println(arrayList.toString());
    }

    public static <T extends Comparable<T>> void removeGreaterThan(Collection<T> collection, T bound) {
        for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ) {
            if (iterator.next().compareTo(bound) > 0) iterator.remove();
        }
    }
}

//First method

class Player implements Comparable<Player> {
    private int rank;
    private String nickname;

    Player(int rank, String nickname) {
        this.rank = rank;
        this.nickname = nickname;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank >= 0)
            this.rank = rank;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        if (nickname != this.nickname && !nickname.trim().equals(""))
            this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname + " " + rank;
    }

    //First method
    //ASC
    @Override
    public int compareTo(Player player) {
        return Integer.compare(getRank(), player.getRank());
    }
}

//Second method

class PlayerRankComparatorDesc implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o2.getRank(), o1.getRank());
    }
}

