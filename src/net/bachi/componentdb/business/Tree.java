package net.bachi.componentdb.business;

/**
 * @author Andreas Bachmann
 */
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree(T root) {
        this.root = new TreeNode<T>(null, root);
    }

    /**
     *
     * @param parent Parent TreeNode
     * @param element Element insert into tree
     * @result Element as a TreeNode
     */
    public TreeNode<T> add(TreeNode<T> parent, T element) {
        return null;
    }

}
