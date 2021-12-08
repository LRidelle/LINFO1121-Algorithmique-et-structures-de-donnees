import junit.framework.TestCase;

public class FloorTest  extends TestCase {
    class MNode implements TwoThreeNode {
        public MNode(MNode left, int key1, MNode center, int key2, MNode right) {
            this.is3 = true;
            this.left = left;
            this.key1 = key1;
            this.center = center;
            this.key2 = key2;
            this.right = right;
        }

        public MNode(MNode left, int key1, MNode right) {
            this.is3 = false;
            this.left = left;
            this.key1 = key1;
            this.center = right;
            this.key2 = 0;
            this.right = null;
        }

        public boolean is3;
        public MNode left;
        int key1;
        public MNode center;
        int key2;
        public MNode right;

        @Override
        public boolean isThreeNode() {
            return is3;
        }

        @Override
        public TwoThreeNode getLeft() {
            return left;
        }

        @Override
        public int getFirstValue() {
            return key1;
        }

        @Override
        public TwoThreeNode getCenter() {
            return center;
        }

        @Override
        public int getSecondValue() throws Exception {
            check23();
            return key2;
        }

        @Override
        public TwoThreeNode getRight() throws Exception {
            check23();
            return right;
        }

        public void check23() throws Exception {
            if(!is3) {
                throw new Exception("Not a 3-node");
            }
        }
    }

    public MNode example() {
        return new MNode(
                new MNode(
                        new MNode(
                                new MNode(null, 1, null, 3, null),
                                6,
                                new MNode(null, 13, null)),
                        14,
                        new MNode(
                                new MNode(null, 24, null),
                                27,
                                new MNode(null, 28, null))),
                32,
                new MNode(
                        new MNode(
                                new MNode(null, 36, null),
                                42,
                                new MNode(null, 43, null)),
                        44,
                        new MNode(
                                new MNode(null, 50, null),
                                51,
                                new MNode(null, 56, null))),
                59,
                new MNode(
                        new MNode(
                                new MNode(null, 62, null),
                                66,
                                new MNode(null, 72, null)),
                        74,
                        new MNode(
                                new MNode(null, 76, null, 78, null),
                                85,
                                new MNode(null, 96, null)
                        )
                )
        );
    }

    public void testExampleBelow() throws Exception {
        MNode example = example();
        assertNull(Floor.floor(example, 0));
        assertNull(Floor.floor(example, -100));
    }

    public void testExampleExact() throws Exception {
        MNode example = example();
        assertEquals((Integer)1, Floor.floor(example, 1));
        assertEquals((Integer)3, Floor.floor(example, 3));
        assertEquals((Integer)6, Floor.floor(example, 6));
        assertEquals((Integer)13, Floor.floor(example, 13));
        assertEquals((Integer)14, Floor.floor(example, 14));
        assertEquals((Integer)24, Floor.floor(example, 24));
        assertEquals((Integer)27, Floor.floor(example, 27));
        assertEquals((Integer)28, Floor.floor(example, 28));
        assertEquals((Integer)32, Floor.floor(example, 32));
        assertEquals((Integer)36, Floor.floor(example, 36));
        assertEquals((Integer)42, Floor.floor(example, 42));
        assertEquals((Integer)43, Floor.floor(example, 43));
        assertEquals((Integer)44, Floor.floor(example, 44));
        assertEquals((Integer)50, Floor.floor(example, 50));
        assertEquals((Integer)51, Floor.floor(example, 51));
        assertEquals((Integer)56, Floor.floor(example, 56));
        assertEquals((Integer)59, Floor.floor(example, 59));
        assertEquals((Integer)62, Floor.floor(example, 62));
        assertEquals((Integer)66, Floor.floor(example, 66));
        assertEquals((Integer)72, Floor.floor(example, 72));
        assertEquals((Integer)74, Floor.floor(example, 74));
        assertEquals((Integer)76, Floor.floor(example, 76));
        assertEquals((Integer)78, Floor.floor(example, 78));
        assertEquals((Integer)85, Floor.floor(example, 85));
        assertEquals((Integer)96, Floor.floor(example, 96));
    }

    public void testExampleBefore() throws Exception {
        MNode example = example();
        assertEquals((Integer)1, Floor.floor(example, 2));
        assertEquals((Integer)3, Floor.floor(example, 5));
        assertEquals((Integer)6, Floor.floor(example, 12));
        assertEquals((Integer)14, Floor.floor(example, 23));
        assertEquals((Integer)24, Floor.floor(example, 26));
        assertEquals((Integer)28, Floor.floor(example, 30));
        assertEquals((Integer)32, Floor.floor(example, 34));
        assertEquals((Integer)36, Floor.floor(example, 39));
        assertEquals((Integer)44, Floor.floor(example, 49));
        assertEquals((Integer)51, Floor.floor(example, 55));
        assertEquals((Integer)56, Floor.floor(example, 57));
        assertEquals((Integer)56, Floor.floor(example, 58));
        assertEquals((Integer)59, Floor.floor(example, 61));
        assertEquals((Integer)62, Floor.floor(example, 65));
        assertEquals((Integer)66, Floor.floor(example, 70));
        assertEquals((Integer)72, Floor.floor(example, 73));
        assertEquals((Integer)74, Floor.floor(example, 75));
        assertEquals((Integer)76, Floor.floor(example, 77));
        assertEquals((Integer)78, Floor.floor(example, 80));
        assertEquals((Integer)85, Floor.floor(example, 90));
        assertEquals((Integer)96, Floor.floor(example, 200));
    }
}
