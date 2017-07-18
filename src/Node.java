package com.ood.di;

/**
 * Created by ravinderk on 6/8/2017.
 */
public class Node
{
    public int data;
    public Node left, right, nextRight;

    public Node(int item)
    {
        data = item;
        left = right = nextRight = null;
    }
}

class NodeHolder {
    Node node;
}