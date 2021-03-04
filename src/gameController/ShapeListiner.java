package gameController;

import gui.GameFrame;
import models.GameInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeListiner implements ActionListener {

    private GameFrame gameFrame;

    public ShapeListiner (GameFrame gameFrame)
    {
        this.gameFrame=gameFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JRadioButton selectedShape = (JRadioButton) e.getSource();

        if(selectedShape.getText().equals("X"))
        {

            // leave default settings


        }
        else{


            GameInfo.computerShape="X";
            GameInfo.playerShape="O";

        }


    }
}
