package gui;
import gameController.GridListiner;
import gameController.PlayListiner;
import gameController.ShapeListiner;
import gameController.TryAgainListiner;
import models.GameInfo;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {



    public final static String menuCard = "MENU";
    public final static String gameCard = "GAME_GRID";
    private JPanel cards;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel scorePanel;
    private JButton[][] grid;
    public JButton tryagain;
















    public GameFrame()
    {
        super("Tic tac toe");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(600,550);
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        createMenuPanel();
        add(cards,BorderLayout.CENTER);


        setVisible(true);

    }



    private void createMenuPanel()
    {

        cards = new JPanel(new CardLayout());

        // Make menu panel
        menuPanel = new JPanel(new GridLayout(1,2));
        menuPanel.setBackground(new Color(123,50,250));
        ImageIcon icon = new ImageIcon("images/tic-tac-toe.png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);


        // Make right panel and its subpanels
        JPanel rightPanel = new JPanel(new GridLayout(2,2));
        rightPanel.setBackground((new Color(123,50,250)));



        JLabel selectShape = new JLabel("Choose your shape:");
        selectShape.setFont(new Font("Arial",Font.BOLD,15));
        selectShape.setForeground(Color.white);








//--------------------------------------------------------------------


        JPanel radioPanel = new JPanel(new GridLayout(1,2));

        JRadioButton x = new JRadioButton("X");

        JRadioButton o = new JRadioButton("O");

        ShapeListiner shapeListiner = new ShapeListiner(this);

        x.addActionListener(shapeListiner);
        o.addActionListener(shapeListiner);


        x.setSelected(true);
        x.setFocusPainted(false);
        x.setForeground(Color.white);
        x.setBackground(new Color(123,50,250));
        o.setFocusPainted(false);
        o.setForeground(Color.white);
        o.setBackground(new Color(123,50,250));

        ButtonGroup selectionGroup = new ButtonGroup();
        selectionGroup.add(x);
        selectionGroup.add(o);

        radioPanel.add(x);
        radioPanel.add(o);



    //-----------------------------------------------------------------------



        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setBackground(new Color(123,50,250));
        JButton play = new JButton("PLAY");
        play.setBackground(Color.RED);
        play.setForeground(Color.white);
        play.setFont(new Font("Arial",Font.BOLD,15));
        play.setFocusPainted(false);
        play.setBorderPainted(false);
        PlayListiner playListiner = new PlayListiner(this);
        play.addActionListener(playListiner);
        btnPanel.add(play,BorderLayout.NORTH);


        //add panels----------------------------------------------------

        rightPanel.add(selectShape);
        rightPanel.add(radioPanel);
        rightPanel.add(btnPanel);

        menuPanel.add(imgLabel);
        menuPanel.add(rightPanel);

        cards.add(menuPanel,menuCard);














    }

    // Create buttons and add them to the grid

    private void createGrid()
    {

        JPanel gridPanel = new JPanel(new GridLayout(3,3,6,6));
        gridPanel.setBackground(Color.black);
        grid = new JButton[3][3];

        GridListiner gridListiner = new GridListiner(this);

        for(int i = 0; i<3;i++)
        {
            for (int j = 0; j<3;j++)
            {
                JButton button = new JButton();
                button.setBackground(new Color(123,50,250));
                button.setFont(new Font("Arial",Font.BOLD,40));
                button.setForeground(Color.white);
                button.setFocusPainted(false);
                button.addActionListener(gridListiner);



                grid[i][j]=button;
                gridPanel.add(button);



            }



        }


        gamePanel.add(gridPanel);




    }

    public void top()
    {

        JPanel north = new JPanel();
        tryagain = new JButton("Try Again");
        tryagain.setVisible(false);
        TryAgainListiner tryAgainListiner= new TryAgainListiner(this);
        tryagain.addActionListener(tryAgainListiner);
        north.add(tryagain);
        north.setBackground(new Color(123,50,250));
        north.setPreferredSize(new Dimension(0,50));
        gamePanel.add(north,BorderLayout.NORTH);


    }


    public void addScorePanel()
    {

        scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,60,20));
        JLabel l1 = new JLabel(GameInfo.playerShape+": "+GameInfo.playerScore);
        JLabel l2 = new JLabel(GameInfo.computerShape+": "+GameInfo.computerScore);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial",Font.BOLD,25));
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial",Font.BOLD,25));
        scorePanel.add(l1);
        scorePanel.add(l2);
        scorePanel.setBackground(new Color(123,50,250));
        scorePanel.setPreferredSize(new Dimension(0,80));

        gamePanel.add(scorePanel,BorderLayout.SOUTH);




    }

    private void leftRight()
    {

        JPanel east = new JPanel();
        east.setBackground(new Color(123,50,250));
        east.setPreferredSize(new Dimension(70,0));

        gamePanel.add(east,BorderLayout.EAST);


        JPanel west = new JPanel();
        west.setBackground(new Color(123,50,250));
        west.setPreferredSize(new Dimension(70,0));

        gamePanel.add(west,BorderLayout.WEST);


    }



    public void createGamePanel()  {

        gamePanel=new JPanel(new BorderLayout());
        top();
        leftRight();
        addScorePanel();
        createGrid();
        cards.add(gamePanel,gameCard);






    }


    public JButton[][] getButtons() {
        return grid;
    }


    public JPanel getCards() {

        return cards;
    }

    public void resetGrid()

    {

        for (int i = 0; i<3;i++)
        {
            for (int j=0;j<3;j++)
            {

                grid[i][j].setText("");
                grid[i][j].setBackground(new Color(123,50,250));
                grid[i][j].setEnabled(true);


            }



        }


    }














}
