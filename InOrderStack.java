// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class InOrderTraversal {
    public class BinaryTree
    {
        BinaryTree left;
        BinaryTree right;
        int value;
        BinaryTree(int value)
        {
            this.value = value;
        }
    }
    public void inorderTraversal(BinaryTree tree)
    {
       Stack<BinaryTree> stack = new Stack<BinaryTree>();
       while(true)
       {
          if(tree != null)
          {
              stack.push(tree);
              stack.push(tree.left);
          }
          else
          {
              if(stack.isEmpty())
              {
                  break;
              }
              tree = tree.pop();
              System.out.println(tree.value);
              tree = tree.right;
          }
       }
        
    }
    
    public static void main(String[] args) {
       InOrderTraversal inOrder = new InOrderTraversal();
       inOrder.executeBinaryTree(); 
    }
    private void executeBinaryTree()
    {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(6);
        binaryTree.right = new BinaryTree(7);
        binaryTree.left.left = new BinaryTree(8);
        binaryTree.right.left = new BinaryTree(11);
        binaryTree.right.right = new BinaryTree(12);
        inorderTraversal(binaryTree);
        System.out.println("Hello, World!");
    }
}
