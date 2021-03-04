package gameController;

import models.GameInfo;

import javax.swing.*;
import java.awt.*;


public class BoardAnalyzer {


    public static JButton[][] grid;





    private static int evaluateWinner()
    {

        // Check Rows

        for (int i = 0; i < 3; i++)
        {


                if(grid[i][0].getText().equals(grid[i][1].getText()) && grid[i][1].getText().equals(grid[i][2].getText()))
                {

                    if (grid[i][0].getText().equals(GameInfo.computerShape))
                    {


                        return 10;
                    }
                    else if(grid[i][0].getText().equals(GameInfo.playerShape))
                    {
                        return -10;
                    }



                }




        }

        // Check columns

        for (int i = 0; i<3; i++)
        {

            if(grid[0][i].getText().equals(grid[1][i].getText()) && grid[1][i].getText().equals(grid[2][i].getText()))
            {

                if (grid[0][i].getText().equals(GameInfo.computerShape))
                {


                    return 10;
                }

                else if (grid[0][i].getText().equals(GameInfo.playerShape))
                {

                    return -10;
                }




            }






        }


        // Check diagonals


        if(grid[0][0].getText().equals(grid[1][1].getText()) && grid[1][1].getText().equals(grid[2][2].getText()))
        {

            if (grid[0][0].getText().equals(GameInfo.computerShape))
            {

                return 10;
            }

            else if (grid[0][0].getText().equals(GameInfo.playerShape))
            {


                return -10;
            }




        }


        if(grid[0][2].getText().equals(grid[1][1].getText()) && grid[1][1].getText().equals(grid[2][0].getText()))
        {

            if (grid[0][2].getText().equals(GameInfo.computerShape))
            {

                return 10;
            }

            else if (grid[0][2].getText().equals(GameInfo.playerShape))
            {

                return -10;
            }




        }



        return 0;





    }

    public static boolean markWinner()
    {

        // Check Rows

        for (int i = 0; i < 3; i++)
        {


            if(grid[i][0].getText().equals(grid[i][1].getText()) && grid[i][1].getText().equals(grid[i][2].getText()) && !grid[i][0].getText().equals(""))
            {

                grid[i][0].setBackground(Color.GREEN);
                grid[i][1].setBackground(Color.GREEN);
                grid[i][2].setBackground(Color.GREEN);

                if (grid[i][0].getText().equals(GameInfo.computerShape)) {

                    GameInfo.computerScore=GameInfo.computerScore+1;



                } else

                {

                    GameInfo.playerScore=GameInfo.playerScore+1;

                }


                return true;


            }




        }

        // Check columns

        for (int i = 0; i<3; i++)
        {

            if(grid[0][i].getText().equals(grid[1][i].getText()) && grid[1][i].getText().equals(grid[2][i].getText()) && !grid[0][i].getText().equals(""))
            {

                grid[0][i].setBackground(Color.GREEN);
                grid[1][i].setBackground(Color.GREEN);
                grid[2][i].setBackground(Color.GREEN);

                if (grid[0][i].getText().equals(GameInfo.computerShape))
                {


                    GameInfo.computerScore=GameInfo.computerScore+1;


                }
                else
                {


                    GameInfo.playerScore=GameInfo.playerScore+1;

                }



                return true;


            }






        }


        // Check diagonals


        if(grid[0][0].getText().equals(grid[1][1].getText()) && grid[1][1].getText().equals(grid[2][2].getText()) && !grid[0][0].getText().equals(""))
        {

            grid[0][0].setBackground(Color.GREEN);
            grid[1][1].setBackground(Color.GREEN);
            grid[2][2].setBackground(Color.GREEN);

            if (grid[0][0].getText().equals(GameInfo.computerShape) )
            {


                GameInfo.computerScore=GameInfo.computerScore+1;



            }

            else
                {

                    GameInfo.playerScore=GameInfo.playerScore+1;

            }


            return true;



        }


        if(grid[0][2].getText().equals(grid[1][1].getText()) && grid[1][1].getText().equals(grid[2][0].getText()) && !grid[0][2].getText().equals(""))
        {

            grid[0][2].setBackground(Color.GREEN);
            grid[1][1].setBackground(Color.GREEN);
            grid[2][0].setBackground(Color.GREEN);

            if (grid[0][2].getText().equals(GameInfo.computerShape))
            {

                GameInfo.computerScore=GameInfo.computerScore+1;


            }
            else
            {

                GameInfo.playerScore=GameInfo.playerScore+1;


            }


            return true;




        }




        return false;




    }


    public static boolean isMoveLeft()
    {



        for (int i =0; i<3;i++)
        {


            for (int j =0; j<3;j++)
            {

                if(grid[i][j].getText().equals(""))
                {
                    return true;

                }


            }



        }


        return false;



    }


    private static int minMax(int depth,boolean isMax)
    {

        int score = evaluateWinner();

        if(score==10)
        {


            return score-depth;

        }

        if (score==-10)
        {

            return score+depth;

        }

        if(!isMoveLeft())
        {

            return 0;
        }



        if(isMax) {

            int best = -100000;



            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {


                    if(grid[i][j].getText().equals(""))
                    {

                        grid[i][j].setText(GameInfo.computerShape);



                        best=Math.max(best,minMax(depth+1,false));



                        // undo move

                        grid[i][j].setText("");





                    }


                }

            }

            return best;

        } else {


            int best = 100000;

            for (int i = 0; i<3;i++)
            {

                for (int j = 0; j < 3; j++)
                {

                    if (grid[i][j].getText().equals(""))
                    {

                        grid[i][j].setText(GameInfo.playerShape);

                        best = Math.min(best, minMax(depth + 1, true));

                        // undo move

                        grid[i][j].setText("");



                    }
                }



            }






            return best;

        }


    }



    public static void computerMove()
    {
        // Computer always will be maximizer


        int bestVal=-100000;

        int row = 0;
        int column =0;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {



                if(grid[i][j].getText().equals(""))
                {

                   grid[i][j].setText(GameInfo.computerShape);

                   int moveValue = minMax(0,false);

                   //undo move

                    grid[i][j].setText("");

                    if (moveValue>bestVal)
                    {

                        bestVal=moveValue;
                        row=i;
                        column=j;
                    }

                }




            }



        }


        grid[row][column].setText(GameInfo.computerShape);
        grid[row][column].setEnabled(false);








    }






}
