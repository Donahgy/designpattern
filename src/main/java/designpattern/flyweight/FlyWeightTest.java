package designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeightTest {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3,4,TreeFactory.getTree("xxx","xxxx"));
        TreeNode treeNode2 = new TreeNode(5,4,TreeFactory.getTree("xxx","xxxx"));

        TreeNode treeNode3 = new TreeNode(15,14,TreeFactory.getTree("yyy","xxxx"));
        TreeNode treeNode4 = new TreeNode(15,14,TreeFactory.getTree("yyy","xxxx"));
    }
}

class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name,String data){
        if (map.containsKey(name))
        {
            return map.get(name);
        }
        Tree tree = new Tree(name,data);
        map.put(name,tree);
        return tree;
    }
}

class Tree{
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("name: " + name + " data: " + data + " is created...");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}
