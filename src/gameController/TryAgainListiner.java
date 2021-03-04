package gameController;

import gui.GameFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryAgainListiner implements ActionListener {

    private GameFrame gameFrame;

    public TryAgainListiner(GameFrame gameFrame)
    {

        this.gameFrame=gameFrame;


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        gameFrame.resetGrid();

        gameFrame.tryagain.setVisible(false);



    }
}
