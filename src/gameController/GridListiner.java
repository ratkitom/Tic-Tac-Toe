package gameController;

import gui.GameFrame;
import models.GameInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridListiner implements ActionListener {

    private GameFrame gameFrame;



    public GridListiner(GameFrame gameFrame){

        this.gameFrame=gameFrame;



    }






    @Override
    public void actionPerformed(ActionEvent e) {


        JButton clicked = (JButton) e.getSource();
        clicked.setText(GameInfo.playerShape);
        clicked.setEnabled(false);
        BoardAnalyzer.computerMove();

        if(BoardAnalyzer.markWinner() || !BoardAnalyzer.isMoveLeft())
        {

            gameFrame.tryagain.setVisible(true);
            gameFrame.addScorePanel();



        }





    }



}
