package InterviewPrepWithMatt;

public class BSTClosestNode {

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if (tree.value == target)
            return target;

        int closestDist = Math.abs(target - tree.value);

        int closestValue = evaluateNext(tree, tree.value, target, closestDist);

        return closestValue;
    }

    private static int evaluateNext(BST tree, int closestValue, int target, int closestDist) {
        if (tree.value == target)
            return target;

        int currentDist = Math.abs(target - tree.value);

        if (currentDist < closestDist)
            closestValue = tree.value;

        BST nextTree;
        if (currentDist > 0)
            nextTree = tree.right;
        else nextTree = tree.left;

        if (nextTree == null)
            return closestValue;

        return evaluateNext(nextTree, closestValue, target, closestDist);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;
        public BST(int value) {
            this.value = value;
        }
    }

}
