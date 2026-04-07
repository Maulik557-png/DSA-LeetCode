import java.util.ArrayList;
import java.util.List;

public class Apr7LeetCode2069 {

    /**
     * Your Robot object will be instantiated and called as such:
     * Robot obj = new Robot(width, height);
     * obj.step(num);
     * int[] param_2 = obj.getPos();
     * String param_3 = obj.getDir();
     */

    public static void main(String[] args) {
        Robot r = new Robot(6, 3);
        r.step(2);
        r.step(2);
        int[] p1 = r.getPos();
        System.out.println(p1[0] + "" + p1[1]);
        System.out.println(r.getDir());
        r.step(2);
        r.step(1);
        r.step(4);
        int[] p2 = r.getPos();
        System.out.println(p2[0] + "" + p2[1]);
        System.out.println(r.getDir());
    }

    // Genius Approach
    public static class Robot {
        private List<int[]> cells;
        private int count;

        public Robot(int width, int height) {
            // 4*100 = T.C.
            cells = new ArrayList<>();
            count = 0;

            // [0,0] - South
            cells.add(new int[]{0,0,3});
            // 0, 1,2,3 - for E , N , W and S

            // East cells
            for(int i=1; i<width; i++)
                cells.add(new int[]{i, 0, 0});
            // North cells
            for(int j=1; j<height; j++)
                cells.add(new int[]{width-1, j, 1});
            // West cells
            for(int i=width-2; i>=0; i--)
                cells.add(new int[]{i, height-1, 2});
            // South cells
            for(int j=height-2; j>0; j--)
                cells.add(new int[]{0, j, 3});

        }
        
        public void step(int num) {
            count += num; // O(1)
        }
        
        public int[] getPos() {
            // O(1)
            int index = count%cells.size();
            int x = cells.get(index)[0];
            int y = cells.get(index)[1];
            return new int[]{x,y};
        }
        
        public String getDir() {
            // O(1)
            // count = 0, move -- East -- South
            if(count==0)
                return "East";
            int index = count%cells.size();
            int dir = cells.get(index)[2];
            if(dir==0)
                return "East";
            else if(dir==1)
                return "North";
            else if(dir==2)
                return "West";
            else return "South";
        }
    }

    // Optimal Approach
    // public static class Robot {
    //     private int width;
    //     private int height;
    //     private int total;
    //     private int curSteps;

    //     public Robot(int width, int height) {
    //         this.width = width;
    //         this.height = height;
    //         curSteps = 0;
    //         total = (height + width) * 2 - 4;
    //     }
        
    //     public void step(int num) {
    //         curSteps += num;
    //     }
        
    //     public int[] getPos() {
    //         int step = curSteps % total;

    //         if (step <= width - 1) return new int[]{step, 0};
    //         step -= width - 1;

    //         if (step <= height - 1) return new int[]{width-1, step};
    //         step -= height - 1;

    //         if (step <= width - 1) return new int[]{width - 1 - step, height - 1};
    //         step -= width - 1;

    //         return new int[]{0, height - 1 - step};
    //     }
        
    //     public String getDir() {
    //         if (curSteps == 0) return "East";
            
    //         int step = curSteps % total;
    //         if (step == 0) return "South";

    //         if (step <= width - 1) return "East";
    //         step -= width - 1;

    //         if (step <= height - 1) return "North";
    //         step -= height - 1;

    //         if (step <= width - 1) return "West";

    //         return "South";
    //     }
    // }

    // Time: O(w + h)
    // public static class Robot {
    //     private int[][] grid;
    //     private int[] pos;
    //     private String dir;

    //     public Robot(int width, int height) {
    //         grid = new int[width][height];
    //         dir = "East";
    //         pos = new int[2];
    //         pos[0] = 0;
    //         pos[1] = 0;
    //     }

    //     public void step(int num) {
    //         int x = pos[0];
    //         int y = pos[1];

    //         int w = grid.length;
    //         int h = grid[0].length;

    //         int perimeter = 2 * (w + h - 2);

    //         if (num % perimeter == 0)
    //             num = perimeter;
    //         else
    //             num %= perimeter;

    //         for (int i = 0; i < num; i++) {
    //             if (dir.equals("East") && x == w - 1)
    //                 dir = "North";
    //             else if (dir.equals("North") && y == h - 1)
    //                 dir = "West";
    //             else if (dir.equals("West") && x == 0)
    //                 dir = "South";
    //             else if (dir.equals("South") && y == 0)
    //                 dir = "East";

    //             switch (dir) {
    //                 case "East":
    //                     x++;
    //                     break;
    //                 case "North":
    //                     y++;
    //                     break;
    //                 case "West":
    //                     x--;
    //                     break;
    //                 case "South":
    //                     y--;
    //                     break;
    //             }
    //         }
    //         pos[0] = x;
    //         pos[1] = y;
    //     }

    //     public int[] getPos() {
    //         return pos;
    //     }

    //     public String getDir() {
    //         return dir;
    //     }
    // }

    // Creates TLE, Time: O(num)
    // public static class Robot {
    //     private int[][] grid;
    //     private int[] pos;
    //     private String dir;

    //     public Robot(int width, int height) {
    //         grid = new int[width][height];
    //         dir = "East";
    //         pos = new int[2];
    //         pos[0] = 0;
    //         pos[1] = 0;
    //     }

    //     public void step(int num) {
    //         int x = pos[0];
    //         int y = pos[1];
    //         int w = grid.length - 1;
    //         int h = grid[0].length - 1;
    //         for (int i = 0; i < num; i++) {
    //             if (x == w && y == 0)
    //                 dir = "North";
    //             else if (y == h && x == w)
    //                 dir = "West";
    //             else if (x == 0 && y == h)
    //                 dir = "South";
    //             else if (x == 0 && y == 0)
    //                 dir = "East";

    //             switch (dir) {
    //                 case "East": {
    //                     x++;
    //                     break;
    //                 }
    //                 case "North": {
    //                     y++;
    //                     break;
    //                 }
    //                 case "West": {
    //                     x--;
    //                     break;
    //                 }
    //                 default: {
    //                     y--;
    //                     break;
    //                 }
    //             }
    //         }
    //         pos[0] = x;
    //         pos[1] = y;
    //     }

    //     public int[] getPos() {
    //         return pos;
    //     }

    //     public String getDir() {
    //         return dir;
    //     }
    // }
}
