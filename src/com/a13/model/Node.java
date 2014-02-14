package com.a13.model;

import java.util.ArrayList;

/**
 * Created by riblee on 2014.02.14..
 */
public class Node {
    private ArrayList<Node> parents;
    private String link;
    private String content;

    public Node(Node parent, String link, String content) {
        parents = new ArrayList<Node>();
        parents.add(parent);
        this.link = link;
        this.content = content;
    }

    public Node(String link, String content) {
        //parents = new ArrayList<Node>();
        //parents.add(parent);
        this.link = link;
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Node> getParents() {

        return parents;
    }

    public void setParents(ArrayList<Node> parents) {
        this.parents = parents;
    }

    public void addParent(Node parent) {
        this.parents.add(parent);
    }
}
