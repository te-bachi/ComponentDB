package net.bachi.componentdb.business;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
    private T element;
    private TreeNode<T> parent;
    private List<TreeNode> childs;

    public TreeNode(TreeNode<T> parent, T element) {
        this.parent = parent;
        this.element = element;
    }

    public int compareTo(TreeNode<T> other) {
        T o1 = this.getElement();
        T o2 = other.getElement();
        return o1.compareTo(o2);
    }

    public boolean equals(TreeNode<T> other) {
        if (this == other) return true;
        if (other == null) return false;

        T o1 = this.getElement();
        T o2 = other.getElement();

        return o1.equals(o2);
    }

    public T getElement() {
        return element;
    }

    public TreeNode getParent() {
        return parent;
    }




}
