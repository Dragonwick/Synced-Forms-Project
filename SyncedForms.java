import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class SyncedForms {
    static Scanner sc = new Scanner(System.in);
    static Graphics pen;
    Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("UTSA - FALL 2022 - CS1083 - Section 001 - Project 3 - SyncedForms - written by Aaron Solis");
        drawSyncedForms(sc);
    }
    public static void drawSyncedForms(Scanner sc){
        DrawingPanel panel = new DrawingPanel(400, 400);
        Graphics g = panel.getGraphics();

        //variables that will be used
        char userForm;
        int formAmount;
        int formMovements;

        System.out.print("What from will be shown (C-cirlce, S-quare)? ");
        userForm = sc.next().charAt(0);
        System.out.println();

        System.out.print("How many forms you want to show (max 9)? ");
        formAmount = sc.nextInt();
        System.out.println();

        System.out.print("How many times you want the forms to move (max 500)? ");
        formMovements = sc.nextInt();
        System.out.println();

        //variables that will be used
        int [] xPosition = new int [formAmount];
        int [] yPosition = new int [formAmount];
        Color [] colors = new Color[formAmount];

        // initialPosition(xPosition, yPosition, formAmount); // og
        initialPositionRand(xPosition, yPosition, formAmount);

        //initialColor(colors, formAmount); //second method call // og
        initialColorRand(colors, formAmount); //second method call; has nested method within

        moveForms(panel, userForm, xPosition, yPosition, colors, formAmount, formMovements); //third method call

        //show graphic signature
        g.setColor(Color.BLACK);
        g.fillRect(20, 180, 360, 40);
        g.setColor(Color.GREEN);
        g.drawRect(20, 180, 360, 40);
        g.setColor(Color.GREEN);

        g.drawString("UTSA FALL 2022 - CS1083 - Section001 - Project 3 - ",25, 200);
        g.drawString("SyncedForms - written by Aaron Solis",25, 215);
        g.setColor(Color.GREEN);
        g.drawRect(20, 180, 360, 40);

    }
    public static void initialPosition(int[] xPos, int[] yPos, int numberOfForms){ //initial position method
        int i;
        for(i = 0; i < numberOfForms; i++) {
            int[] XY = getCoordinates(i, numberOfForms); //method call
            xPos[i] = XY[0];
            yPos[i] = XY[1];
        }
    }

    public static void initialPositionRand(int[] xPos, int[] yPos, int numberOfForms){ //initial position method
        Random rand = new Random();
        int i;
        for(i = 0; i < numberOfForms; i++) {
            int[] XY = getCoordinates(rand.nextInt(9), numberOfForms); //method call
            xPos[i] = XY[0];
            yPos[i] = XY[1];
        }
    }
    //other method getCoordinates
    public static int[] getCoordinates(int i, int numberOfForms){ //secondary method that is nested within the initialPosition method //this is separate from the rubric
        //variables that will be used
        int[] coordinate = new int[2];
        int x = 0; //starting position
        int y = 0; //starting position
        int formSize = 50; //50 pixels
        int sizePanel = 400;
        int center = sizePanel / 2; //200
        int startPos = center - (formSize / 2); //200 -25

        //int [][] order = {{0, 0}, {0, 2}, {2, 2}, {2, 0}, {1, 1}, {1, 0}, {1, 2}, {0, 1}, {2, 1}};
        switch(i){
            case 0: // 1 at (0,0) (good)
                x = startPos - (formSize * 2);
                y = startPos - (formSize * 2);
                break;
            case 1: //2 at (0,2) (good)
                x = startPos + (formSize * 2);
                y = startPos - (formSize * 2);
                break;
            case 2: //3 at (2,2) (good)
                x = startPos + (formSize * 2);
                y = startPos + (formSize * 2);
                break;
            case 3: //4 at (2,0) (good)
                x = startPos - (formSize * 2);
                y = startPos + (formSize * 2);
                break;
            case 4: //5 at (1,1) (good)
                x = startPos;
                y = startPos;
                break;
            case 5: //6 at (1,0) (good)
                x = startPos - (formSize * 2);
                y = startPos;
                break;
            case 6: //7 at (1,2) 
                x = startPos + (formSize * 2);;
                y = startPos;
                break;
            case 7: //8 at (0,1)
                x = startPos;
                y = startPos - (formSize * 2);
                break;
            case 8: // 9 at (2,1)
                x = startPos;
                y = startPos + (formSize * 2);;
                break;
        }
        coordinate[0] = x;
        coordinate[1] = y;
        
        return coordinate;
    }
    public static void initialColor(Color [] color, int numberOfForms){ //old method
        //loop to figure out what color will be used
        int i;
        for (i = 0; i < numberOfForms; i++){
            switch(i){
                case(0):
                    color[i] = Color.GREEN;
                    break;
                case(1):
                    color[i] = Color.GRAY;
                    break;
                case(2):
                    color[i] = Color.YELLOW;
                    break;
                case(3):
                    color[i] = Color.RED;
                    break;
                case(4):
                    color[i] = Color.ORANGE;
                    break;
                case(5):
                    color[i] = Color.PINK;
                    break;
                case(6):
                    color[i] = Color.DARK_GRAY;
                    break;
                case(7):
                    color[i] = Color.BLUE;
                    break;
                case(8):
                    color[i] = Color.BLACK;
                    break;
            }
        }
    }
    public static void initialColorRand(Color [] color, int numberOfForms){ //new random
        //loop to figure out what color will be used
        int i;
        Random rand = new Random();
        for (i = 0; i < numberOfForms; i++){
            int choice = rand.nextInt(9);
            switch(choice){
                case(0):
                    color[i] = Color.GREEN;
                    break;
                case(1):
                    color[i] = Color.GRAY;
                    break;
                case(2):
                    color[i] = Color.YELLOW;
                    break;
                case(3):
                    color[i] = Color.RED;
                    break;
                case(4):
                    color[i] = Color.ORANGE;
                    break;
                case(5):
                    color[i] = Color.PINK;
                    break;
                case(6):
                    color[i] = Color.DARK_GRAY;
                    break;
                case(7):
                    color[i] = Color.BLUE;
                    break;
                case(8):
                    color[i] = Color.BLACK;
                    break;
            }
        }
    }
    public static void moveForms(DrawingPanel panel, char userForm, int [] xPosition, int [] yPosition, Color [] color, int formAmount, int formMovements){ //incomplete still in work!!
        int i, j;
        int differentMoves;
        int size = 50;
        int orientation = 25;
        Random rand = new Random();

        //TEST TO ENSURE THAT SHAPES CAN APPEAR

        /*
        for (i = 0; i < formAmount; i++){
            if (userForm == 'C'){
                g.setColor(Color.GREEN); //fix me
                g.fillOval(xPosition[i], yPosition[i], size, size);
                g.setColor(Color.BLACK);
                g.drawOval(xPosition[i], yPosition[i], size, size);
            }
            else if (userForm == 'S'){
                g.setColor(Color.GREEN); //fix me
                g.fillOval(xPosition[i], yPosition[i], size, size);
                g.setColor(Color.BLACK);
                g.drawOval(xPosition[i], yPosition[i], size, size);
            }
        }
        */

        //System.out.print("Please, input the different moves "); //ask for movements
        
        for (i = 0; i < formMovements; i++){
            //differentMoves = sc.nextInt();

            for (j = 0; j < formAmount; j++){
                showForm(panel, userForm, xPosition [j], yPosition[j], color[j], size);
            }

            differentMoves = rand.nextInt(8);

            moveForm(xPosition, yPosition, differentMoves, orientation);
        }

        panel.sleep(50);
    }
    public static void moveForm(int [] xPosition, int [] yPosition, int moves, int orientation){
        int i;


        //+y = down, -y = up
        //+x = right, -x = left

        if (moves == 0) //up
        {
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] -= orientation;
            }
        }
        if (moves == 1) //top right
        {
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] -= orientation;
                xPosition[i] += orientation;
            }
        }
        if (moves == 2){ //right
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] += orientation;
            }
        }
        if (moves == 3){ //bottom right
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] += orientation;
                xPosition[i] += orientation;
            }
        }
        if (moves == 4){ //down
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] += orientation;
            }
        }
        if (moves == 5){ //bottom left
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] += orientation;
                xPosition[i] -= orientation;
            }
        }
        if (moves == 6){ //left
            for (i = 0; i < xPosition.length; i++){
                xPosition[i] -= orientation;
            }
        }
        if (moves == 7){ //top left
            for (i = 0; i < xPosition.length; i++){
                yPosition[i] -= orientation;
                xPosition[i] -= orientation;
            }
        }
    }
    public static void showForm(DrawingPanel panel, char userForm, int xPosition, int yPosition, Color color, int size){
        Graphics g = panel.getGraphics();

        if (userForm == 'C'){
            g.setColor(color);
            g.fillOval(xPosition, yPosition, size, size);
            g.setColor(Color.BLACK);
            g.drawOval(xPosition, yPosition, size, size);
        }
        else if (userForm == 'S'){
            g.setColor(color);
            g.fillRect(xPosition, yPosition, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(xPosition, yPosition, size, size);
        }
    }
}
