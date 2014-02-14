package com.a13.control;

import com.a13.model.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by riblee on 2014.02.14..
 */
public class Robot {
    private Node root;
    private ArrayList<Node> nodes;
    private Set<String> set;

    public Robot(String url) {
        set = new HashSet<String>();
        nodes = new ArrayList<Node>();
        try {
            root = new Node(url, getContent(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Robot() {
        set = new HashSet<String>();
    }

    public void startRobot(String url, int maxLevel, int level) {
        if (level < maxLevel && !isContain(url)) {
            try {
                for (String link : getLinksFromContent(root.getContent())) {
                    if (!isContain(link) && isUsefullLink(link)) {
                        //System.out.println(set.size());
                        for(int i=0;i<level;i++){
                            System.out.print("    ");
                        }
                        //System.out.println("Level:"+level+" "+link);
                        System.out.println(link);
                        //set.add(link);
                        //TODO Node-ban eltárolni a linket és a contentet
                        //nodes.add(new Node());

                        startRobot(link, maxLevel, level + 1);
                        set.add(link);
                        //set.add(link);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startRobot(int maxLevel, int level) {
        if (level < maxLevel && !isContain(root.getLink())) {
            try {
                for (String link : getLinksFromContent(getContent(root.getLink()))) {
                    if (!isContain(link) && isUsefullLink(link)) {
                        //System.out.println(set.size());
                        for(int i=0;i<level;i++){
                            System.out.print("    ");
                        }
                        //System.out.println("Level:"+level+" "+link);
                        System.out.println(link);
                        //set.add(link);
                        //TODO Node-ban eltárolni a linket és a contentet

                        startRobot(link, maxLevel, level + 1);
                        set.add(link);
                        //set.add(link);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isUsefullLink(String link) {
        return !(link.endsWith(".png") || link.endsWith(".jpg") || link.endsWith(".gif") || link.endsWith(".tiff") || link.endsWith(".bmp") || link.endsWith(".js") );
    }

    private boolean isContain(String url) {
        return set.contains(url);
    }

    public String getContent(String url) throws Exception {
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        String ret = "";
        while ((inputLine = in.readLine()) != null)
            ret += inputLine;
        in.close();
        return ret;
    }

    public ArrayList<String> getLinksFromContent(String content) {
        ArrayList<String> ret = new ArrayList<String>();
        String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            String urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }
            ret.add(urlStr);
        }
        return ret;
    }

    public Set<String> getSet() {
        return set;
    }

}
