package collection;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
    // 左子节点
    public Node<T> leftNode;
    // 右子节点
    public Node<T> rightNode;
    // 值
    public T value;// 插入 数据
    public void add(T v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;
  
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
             
            if (v.compareTo(value)<=0) {
                if (null == leftNode)
                    leftNode = new Node<>();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node<>();
                rightNode.add(v);
            }
  
        }
  
    }
    public List<T> values() {
        List<T> values = new ArrayList<>();
  
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());
  
        // 当前节点
        values.add(value);
  
        // 右节点的遍历结果
        if (null != rightNode)
  
            values.addAll(rightNode.values());
  
        return values;
    }
    public static void main(String[] args) {
  
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
  
        Node<Integer> roots = new Node<Integer>();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println(roots.values());

	}



}
