package gameController;

import gui.GameFrame;
import models.GameInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayListiner implements ActionListener {


    private GameFrame gameFrame;



    public PlayListiner(GameFrame gameFrame)
    {


        this.gameFrame=gameFrame;





    }





    @Override
    public void actionPerformed(ActionEvent e) {



        gameFrame.createGamePanel();
        CardLayout cl =(CardLayout) gameFrame.getCards().getLayout();
        cl.show(gameFrame.getCards(),GameFrame.gameCard);
        BoardAnalyzer.grid=gameFrame.getButtons();

        if(GameInfo.computerShape.equals("X"))
        {

            BoardAnalyzer.computerMove();
        }



























    }
}
