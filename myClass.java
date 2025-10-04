import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

class myClass extends JFrame {
    private int[][] maze = new int[][] {
            { 1, 0, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1 },
            { 0, 0, 1, 1, 1, 0, 0 },
            { 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1 }
    };

    public static List<Integer> path = new ArrayList<>();

    public myClass() {
        this.setTitle("Maze Solver");
        this.setSize(315, 345);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boolean solved = backTracking.solveMaze(maze, 0, 0);
        if (!solved) {
            System.out.println("No path found");
        }
        else {
         System.out.println("Steps in path: " + path.size() / 2);
}
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color cr;
                if (i == maze.length - 1 && j == maze[0].length - 1) {
                    cr = Color.RED;
                } else if (maze[i][j] == 1) {
                    cr = Color.WHITE;
                } else if (maze[i][j] == 0) {
                    cr = Color.BLACK;
                } else {
                    cr = Color.GRAY;
                }

                g.setColor(cr);
                g.fillRect(j * 30, i * 30 + 30, 30, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(j * 30, i * 30 + 30, 30, 30);
            }
        }

        for (int i = 0; i < path.size(); i += 2) {
            int row = path.get(i);
            int col = path.get(i + 1);

            g.setColor(Color.GREEN);
            g.fillRect(col * 30 + 5, row * 30 + 35, 20, 20);
        }
    }

    public static void main(String[] args) {
        myClass view = new myClass();
        view.setVisible(true);
    }
}