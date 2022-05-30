//Khali081
import java.util.Random;
class HBST<Key, Value>
{
   private class PairNode
   {
       Key key;
       Value value;
       PairNode next;

       public PairNode(Key key, Value value, PairNode next)
       {
           this.key = key;
           this.value = value;
           this.next = next;
       }
   }

   private class TreeNode
   {
       int hash;
       PairNode pairs;
       TreeNode left, right;

       public TreeNode(int hash, PairNode pairs, TreeNode left, TreeNode right)
       {
           this.hash = hash;
           this.pairs = pairs;
           this.left = left;
           this.right = right;
       }
   }
   private TreeNode root;
   public Random generator;

    public HBST()//Constructor
   {
       generator = new Random();
       root = new TreeNode(0, null, null, null); //head
   }


   public Value get(Key key)//return Value associated with key
   {
       TreeNode tempTN = root;
       int hashK = hash(key);
       while(tempTN != null)
       {
           if(hashK<tempTN.hash)
           {
               tempTN = tempTN.left;
           }
           else if(hashK>tempTN.hash)
           {
               tempTN = tempTN.right;
           }
           else
           {
               PairNode temp = tempTN.pairs;
               while(temp != null)
               {
                   if(hash(temp.key) == hashK)
                   {
                       return temp.value;
                   }
                   else
                   {
                       temp = temp.next;
                   }
               }
           }
       }
       throw new IllegalArgumentException();
   }


   public int height()//return height
   {
        return heightCheck(root);
   }

   private int heightCheck(TreeNode root)//check left and right subtrees for max height
   {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int left = heightCheck(root.left)+1;
            int right = heightCheck(root.right)+1;
            if(left > right)
            {
                return left;
            }
            else
            {
                return right;
            }
        }
   }

   private int hash(Key key)
   {
       if(key != null)
       {
           generator.setSeed(key.hashCode());
           return Math.abs(generator.nextInt());//Math.abs(key.hashCode());
       }
       else
       {
           return 0;
       }
   }

   public boolean isEmpty()
   {
       return root.right==null && root.left==null;
   }


    private boolean isEqual(Key leftKey, Key rightKey)
    {
        if (leftKey == null && rightKey == null)
        {
            return true;
        }
        else if (leftKey == null || rightKey == null)
        {
            return false;
        }
        else
        {
            return (leftKey.equals(rightKey));
        }
    }


   public void put(Key key, Value value)
   {
       int hashK = hash(key);
       if (root == null)
       {
           root = new TreeNode(hashK, new PairNode(key, value, null), null, null);
       }
       else
       {
           TreeNode tempTN = root;
           while(true)
           {
               if(hashK<tempTN.hash)
               {
                   if (tempTN.left == null)
                   {
                       tempTN.left = new TreeNode(hashK, new PairNode(key, value, null), null, null);
                       return;
                   }
                   else
                   {
                       tempTN = tempTN.left;
                   }
               }
               else if(hashK>tempTN.hash)
               {
                   if (tempTN.right == null)
                   {
                       tempTN.right = new TreeNode(hashK, new PairNode(key, value, null), null, null);
                       return;
                   }
                   else
                   {
                       tempTN = tempTN.right;
                   }
               }
               else
                {
                   PairNode temp = tempTN.pairs;
                   while(true)
                   {
                       if(temp.next == null)
                       {
                           temp.next = new PairNode(key, value, null);
                           return;
                       }
                       else
                       {
                           temp = temp.next;
                       }
                   }
               }
            }
       }
   }
}

